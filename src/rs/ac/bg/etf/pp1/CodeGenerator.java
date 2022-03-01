package rs.ac.bg.etf.pp1;

import java.util.Vector;
import rs.ac.bg.etf.pp1.CounterVisitor.VarCounter;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {
	
	private int mainPc;
	Vector<Labels> progLabels = new Vector<>();
	Vector<GotoFixup> gotofix = new Vector<>();
	
	public int getMainPc()
	{
		return mainPc;
	}
	
	public void visit(MethodName methodName)
	{
		mainPc = Code.pc;
		methodName.obj.setAdr(Code.pc);
		
		// Collect arguments and local variables
		SyntaxNode mainMethod = methodName.getParent();
		
		VarCounter varCnt = new VarCounter();
		mainMethod.traverseTopDown(varCnt);
		
		// Generate the entry
		Code.put(Code.enter);
		Code.put(methodName.obj.getLevel());
		Code.put(varCnt.getCount());
		
	}
	
	public void visit(MainMethodDecl mainMethodDecl)
	{
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	
	public void visit(PrintStmt printStmt)
	{
		int val = -1;
		if(printStmt.getPrintOptions().obj != null) val = printStmt.getPrintOptions().obj.getAdr();
		
		if(val != -1)
		{
			Code.loadConst(val);
		}
	
			if(printStmt.getExpr().obj.getType().getKind() == Struct.Int || printStmt.getExpr().obj.getType().getKind() == Struct.Bool)
			{
				Code.loadConst(5);
				Code.put(Code.print);
			}
			else
			{
				Code.loadConst(2);
				Code.put(Code.bprint);
			}
	
	}

	public void visit(ConstFactor constFactor)
	{
		Code.load(constFactor.getConstValue().obj);
		//System.out.println(constFactor.getConstValue().obj.getAdr());
	}
	
	public void visit(AssignDesignator assignDesignator)
	{
		Code.store(assignDesignator.getAssignment().getDesignator().obj);
	}
	
	public void visit(VarDesignator varDesignator)
	{
		SyntaxNode parent = varDesignator.getParent();
		
		if(Assignment.class != parent.getClass())
		{
			Code.load(varDesignator.obj);
		
		}
	}
	
	public void visit(ArrayName arrayName) {
		Code.load(arrayName.obj);
	}

	public void visit(NewArrayFactor newArrayFactor) {
		int structKind = newArrayFactor.obj.getType().getKind();
		if (structKind == Struct.Array) {
			Code.put(Code.newarray);

			if (newArrayFactor.obj.getType().getElemType().getKind() == Struct.Int || newArrayFactor.obj.getType().getElemType().getKind() == Struct.Bool) {
				Code.put(1);
			} else {
				Code.put(0);
			}
		}
	}
	
	public void visit(ArrayDesignator arrayDesignator)
	{
		SyntaxNode parent = arrayDesignator.getParent();
		
		if (Assignment.class != parent.getClass()
				&& IncrementDesignator.class != parent.getClass()
				&& DecrementDesignator.class != parent.getClass()) {
			Code.load(arrayDesignator.obj);
		}
	}
	
	synchronized void ispis(String sta)
	{
		System.out.println(sta);
	}
	
	public void visit(IncrementDesignator incrementDesignator)
	{
		if(incrementDesignator.getDesignator().obj.getKind() == Obj.Elem)
		{
			Code.put(Code.dup2);
			Code.load(incrementDesignator.getDesignator().obj);
		}

		Code.put(Code.const_1);
		Code.put(Code.add);
		Code.store(incrementDesignator.getDesignator().obj);
	}
	
	public void visit(DecrementDesignator decrementDesignator)
	{
		if(decrementDesignator.getDesignator().obj.getKind() == Obj.Elem)
		{
			Code.put(Code.dup2);
			Code.load(decrementDesignator.getDesignator().obj);
		}

		Code.put(Code.const_1);
		Code.put(Code.sub);
		Code.store(decrementDesignator.getDesignator().obj);
	}
	
	public void visit(AdditionList additionList)
	{
		if(additionList.getAddop().getClass().getName().contains("Plus"))
		{
			Code.put(Code.add);
		}
		else if(additionList.getAddop().getClass().getName().contains("Minus"))
		{
			Code.put(Code.sub);
		}
	}
	
	public void visit(MullopList mullopList)
	{
		String op = mullopList.getMullop().getClass().getName();
		
		if(op.contains("Mul")) { Code.put(Code.mul);}
		if(op.contains("Div")) { Code.put(Code.div);}
		if(op.contains("Mod")) { Code.put(Code.rem);}
	}
	
	public void visit(NegativeExpresion negativeExpresion)
	{
		Code.put(Code.const_m1);
		Code.put(Code.mul);
	}
	
	public void visit(ReadStmt readStmt)
	{
		Obj obj = readStmt.getDesignator().obj;

		if(obj.getType().getKind() == Struct.Char)
		{
			Code.put(Code.bread);
		}
		else
		{
			Code.put(Code.read);
		}
		Code.store(obj);
	}
	

	public void visit(Label label)
	{
		Labels newlabel = new Labels(label.getLabelName(), Code.pc);
		progLabels.add(newlabel);
		
		for (int i = 0; i < gotofix.size(); i++) 
		{
			if(label.getLabelName().equals(gotofix.get(i).getLabelname()))
			{
				Code.fixup(gotofix.get(i).getWhereToFix());
				gotofix.remove(i);
				break;
			}
		}
	}
	
	public void visit(GotoStmt gotoStmt)
	{
		boolean addAddressLater = true;
		String labelname = gotoStmt.getLabel().getLabelName();
		for (int i = 0; i < progLabels.size(); i++) 
		{
			if(progLabels.get(i).getAddress() == Code.pc)
			{
				progLabels.remove(i);
			}
		}
		
		for(int i = 0; i < progLabels.size(); i++)
		{
			if(progLabels.get(i).getName().equals(labelname))
			{
				addAddressLater = false;
				int offset = progLabels.get(i).getAddress() - Code.pc + 1;
				Code.put(Code.jmp);
				Code.put2(offset);
				break;
			}
		}
		
		if(addAddressLater)
		{
			Code.put(Code.jmp);
			GotoFixup labelfix = new GotoFixup(labelname, Code.pc);
			Code.put2(Code.const_m1);
			gotofix.add(labelfix);
		}
	}
	
	public void visit(MethodRBrace methodRBrace)
	{
		
	}
}
