package rs.ac.bg.etf.pp1;

import java.util.Vector;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticAnalyzer extends VisitorAdaptor {
	
	Struct currentType = null;
	int nVars = 0;
	
	boolean errorDetected = false;
	boolean passed = false;
	Vector<LabelDecl> labels = new Vector<>();
	
	
	public SemanticAnalyzer() {
		Tab.insert(Obj.Type, "bool", new Struct(Struct.Bool));
		Tab.insert(Obj.Type, "label", new Struct(Struct.None));
	}
	
	Logger log = Logger.getLogger(getClass());
	
	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.info(msg.toString());
	}
	
	public void visit(ProgName progName)
	{
		progName.obj = Tab.insert(Obj.Prog , progName.getProgName(), Tab.noType);
		Tab.openScope();
	}
	
	public void visit(Program program)
	{
		nVars = Tab.currentScope.getnVars();
		Tab.chainLocalSymbols(program.getProgName().obj);
		Tab.closeScope();
	}
	
	public boolean passed()
	{
		return !errorDetected;
	}
	
	
	public void visit(Type type)
	{
		Obj typeNode = Tab.find(type.getTypeName());
		if(typeNode == Tab.noObj)
		{
			report_error("Greska! Tip: " + type.getTypeName() + " ne postoji!", type);
			type.struct = Tab.noType;
		}
		else
		{
			if(Obj.Type != typeNode.getKind())
			{
				report_error("Greska! Tip: " + type.getTypeName() + " ne postoji!", type);
				type.struct = Tab.noType;
			}
			else
			{
				type.struct = typeNode.getType();
				currentType = typeNode.getType();
			}
		}
	}
	
	public void visit(NumberConst numberConst)
	{
		numberConst.obj = new Obj(Obj.Con , "val", new Struct(Struct.Int), numberConst.getNumValue(), 0);
	}
	
	public void visit(CharConst charConst)
	{
		charConst.obj = new Obj(Obj.Con, "val", new Struct(Struct.Char), charConst.getCharValue(), 0);
	}
	
	public void visit(BoolConst boolConst)
	{
		int boolValue;
		if(boolConst.getBoolValue().equals("true")) boolValue = 1;
		else boolValue = 0;
		
		boolConst.obj = new Obj(Obj.Con, "val", new Struct(Struct.Bool), boolValue, 0);
	}
	
	public String TypeToString(int type)
	{
		String kinds[] = {"NoType" , "Int", "Char", "Array", "Class", "Bool"};
		return kinds[type];
	}
	
	public void visit(SingleConstDecl singleConstDecl)
	{
		if(currentType.getKind() != singleConstDecl.getConstValue().obj.getType().getKind())
		{
			String goodType = TypeToString(currentType.getKind());
			String badType = TypeToString(singleConstDecl.getConstValue().obj.getType().getKind());
			report_error("Konstanti: " + singleConstDecl.getConstName() + " ne odgovara tip " + badType + " vec " + goodType, singleConstDecl);
		}
		
		else if(Tab.currentScope.findSymbol(singleConstDecl.getConstName()) != null)
		{
			report_error("Konstanta: " + singleConstDecl.getConstName() + " je vec deklarisana", singleConstDecl);
		}
		else
		{
			report_info("Deklarisana konstanta " + singleConstDecl.getConstName() + " tipa " + TypeToString(currentType.getKind()), singleConstDecl);
			Obj varNode = Tab.insert(Obj.Con, singleConstDecl.getConstName(), currentType);
			varNode.setAdr(singleConstDecl.getConstValue().obj.getAdr());
			varNode.setLevel(0);
		}
	}
	
	public void visit(GlobalSimpleVarDecl globalSimpleVarDecl)
	{
		if(Tab.currentScope.findSymbol(globalSimpleVarDecl.getSmplVarName()) != null)
		{
			report_error("Globalna promenljiva: " + globalSimpleVarDecl.getSmplVarName() + " je vec deklarisana", globalSimpleVarDecl);
		}
		else
		{
			report_info("Deklarisana globalna promenljiva " + globalSimpleVarDecl.getSmplVarName() + " tipa " + TypeToString(currentType.getKind()), globalSimpleVarDecl);
			Tab.insert(Obj.Var, globalSimpleVarDecl.getSmplVarName(), currentType);
		}
	}

	public void visit(GlobalArrayVarDecl globalArrayVarDecl)
	{
		if(Tab.currentScope.findSymbol(globalArrayVarDecl.getArryValName()) != null)
		{
			report_error("Globalna promenljiva: " + globalArrayVarDecl.getArryValName() + " je vec deklarisana", globalArrayVarDecl);
		}
		else
		{
			report_info("Deklarisana globalna promenljiva " + globalArrayVarDecl.getArryValName() + " tipa " + TypeToString(currentType.getKind()) + "[]", globalArrayVarDecl);
			Tab.insert(Obj.Var, globalArrayVarDecl.getArryValName(), new Struct(Struct.Array, currentType));
		}
	}
	
	public void visit(MethodName methodName)
	{
		if(Tab.find(methodName.getMethodName()) != Tab.noObj && Tab.currentScope.findSymbol(methodName.getMethodName()).getKind() == Obj.Meth)
		{
			report_error("Main metoda je vec deklarisana", methodName);
		}
		else if(Tab.find(methodName.getMethodName()) != Tab.noObj)
		{
			report_error("Kljucna rec 'main' je rezervisana za main metodu!", methodName);
		}
		else if(!methodName.getMethodName().equals("main"))
		{
			report_error("Main metoda mora imate ime 'main'", methodName);
		}
		else
		{
			methodName.obj = Tab.insert(Obj.Meth, methodName.getMethodName(), new Struct(Struct.None));
			Tab.openScope();
			methodName.obj.setLevel(0);
		}
	}
	
	public void visit(MainMethodDecl mainMethodDecl)
	{
		Tab.chainLocalSymbols(mainMethodDecl.getMethodName().obj);
		Tab.closeScope();
	}
	
	public void visit(SimpleLocalVarDecl simpleLocalVarDecl)
	{
		if(Tab.currentScope.findSymbol(simpleLocalVarDecl.getSmplLocalVarName()) != null)
		{
			report_error("Lokalna promenljiva: " + simpleLocalVarDecl.getSmplLocalVarName() + " je vec deklarisana", simpleLocalVarDecl);
		}
		else
		{
			report_info("Deklarisana lokalna promenljiva " + simpleLocalVarDecl.getSmplLocalVarName() + " tipa " + TypeToString(currentType.getKind()), simpleLocalVarDecl);
			Tab.insert(Obj.Var, simpleLocalVarDecl.getSmplLocalVarName(), currentType);
		}
	}
	
	public void visit(ArrayLocalVarDecl arrayLocalVarDecl)
	{
		if(Tab.currentScope.findSymbol(arrayLocalVarDecl.getArryLocalVarName()) != null)
		{
			report_error("Lokalna promenljiva: " + arrayLocalVarDecl.getArryLocalVarName() + " je vec deklarisana", arrayLocalVarDecl);
		}
		else
		{
			report_info("Deklarisana globalna promenljiva " + arrayLocalVarDecl.getArryLocalVarName() + " tipa " + TypeToString(currentType.getKind()) + "[]", arrayLocalVarDecl);
			Tab.insert(Obj.Var, arrayLocalVarDecl.getArryLocalVarName(), new Struct(Struct.Array, currentType));
		}
	}
	
	
	public void visit(ArrayName arrayName)
	{
		Obj obj = Tab.find(arrayName.getArrName());
		
		if(obj == Tab.noObj)
		{
			report_error("Promenljiva " + arrayName.getArrName() + " nije deklarisana", arrayName);
		}
		else if (obj.getKind() != Obj.Var)
		{
			report_error("Promenljiva ne moze biti konstanta", arrayName);
		}
		else if(obj.getType().getKind() != Struct.Array)
		{
			report_error("Promenljiva " + arrayName.getArrName() + " je tipa niz a ne tipa " + TypeToString(obj.getType().getKind()) , arrayName);
		}
		else
		{
			arrayName.obj = obj;
		}
	}
	
	public void visit(VarDesignator varDesignator)
	{
		Obj obj = Tab.find(varDesignator.getDesignatorName());
		if(obj != Tab.noObj)
		{
			varDesignator.obj = obj;
			if(obj.getKind() == Obj.Var && !TypeToString(obj.getType().getKind()).equals("Array")) 
			{
				report_info("Pretraga " + varDesignator.getDesignatorName() + " tipa " + TypeToString(obj.getType().getKind()), varDesignator);
			}
		}
		else
		{
			report_error("Promenljiva " + varDesignator.getDesignatorName() + " nije deklarisana", varDesignator);
		}
	}
	
	public void visit(DesignatorFactor designatorFactor)
	{
		designatorFactor.obj = designatorFactor.getDesignator().obj;
	}
	

public void visit(ArrayDesignator arrayDesignator)
	{
		Obj obj = arrayDesignator.getArrayName().obj;
		
		if(arrayDesignator.getExpr().obj.getType().getKind() != Struct.Int)
		{
			report_error("Za indeksiranje niza mora se koristiti int", arrayDesignator);
		}
		else
		{
			report_info("Pretraga " + arrayDesignator.getArrayName().getArrName()+ " tipa " + TypeToString(obj.getType().getKind()), arrayDesignator);
			arrayDesignator.obj = new Obj(Obj.Elem, obj.getName(), obj.getType().getElemType());
		}
	}
	
	public void visit(ConstFactor constFactor)
	{
		constFactor.obj = constFactor.getConstValue().obj;
	}
	
	public void visit(MullopList mullopList)
	{
		if(mullopList.getFactor().obj.getType().getKind() != Struct.Int)
		{
			report_error("Tip promenljivih izraza mora biti int!", mullopList);
		}
	}
	
	public void visit(ExprFactor exprFactor)
	{
		exprFactor.obj = exprFactor.getExpr().obj;
	}
	
	public void visit(NewArrayFactor newArrayFactor)
	{
		if(newArrayFactor.getExpr().obj.getType().getKind() != Struct.Int)
		{
			report_error("Velicina niza mora biti tipa int", newArrayFactor);
		}
		else
		{
			//System.out.println( newArrayFactor.getType().struct.getKind());
			newArrayFactor.obj = new Obj(Obj.Var, "niz", new Struct(Struct.Array, newArrayFactor.getType().struct));
		}
	}
	
	public void visit(MultipleFactorTerm multipleFactorTerm)
	{
		multipleFactorTerm.obj = multipleFactorTerm.getFactor().obj;
	}
	
	public void visit(AdditionList additionList)
	{
		if(additionList.getTerm().obj.getType().getKind() != Struct.Int)
		{
			report_error("Tip promenljivih izraza mora biti int!", additionList);
		}
	}

	public void visit(ExprAdditionList exprAdditionList)
	{
		exprAdditionList.obj = exprAdditionList.getTerm().obj;
	}
	
	public void visit(NegativeExpresion negativeExpresion)
	{
		if(negativeExpresion.getTerm().obj.getType().getKind() != Struct.Int)
		{
			report_error("Tip promenljivih izraza mora biti int!", negativeExpresion);
		}
		negativeExpresion.obj = negativeExpresion.getTerm().obj;
	}
	

	public void visit(Assignment assignment)
	{
		Obj assignDesignator = assignment.getDesignator().obj;
			
		varOrElemErrorCheck(assignDesignator, assignment);
	}
	
	private void varOrElemErrorCheck(Obj obj, SyntaxNode node)
	{
		if(obj.getKind() != Obj.Var && obj.getKind() != Obj.Elem)
		{
			report_error(obj.getName() + " mora biti promenljiva ili element niza", node);
		}
	}
	
	public void visit(AssignDesignator assignDesignator)
	{
		Obj obj = assignDesignator.getAssignment().getDesignator().obj;
		Struct designatorExpr = assignDesignator.getAssignment().getExpr().obj.getType();
		
		if (!((obj.getType().getKind() == designatorExpr.getKind()) && (obj.getType().getElemType() == designatorExpr.getElemType()))) {
			report_error("Promenljivoj nije dodeljiv tip "+ TypeToString(designatorExpr.getKind()),assignDesignator);
		}
	}
	
	public void visit(IncrementDesignator incrementDesignator)
	{
		Obj obj = incrementDesignator.getDesignator().obj;
		
		if(obj.getType().getKind() != Struct.Int && obj.getType().getKind() != Struct.Array)
		{
			report_error(obj.getName() + " mora biti tipa int", incrementDesignator);
		}
		
		varOrElemErrorCheck(obj, incrementDesignator);
	}
	
	public void visit(DecrementDesignator decrementDesignator)
	{
		Obj obj = decrementDesignator.getDesignator().obj;
		
		if(obj.getType().getKind() != Struct.Int && obj.getType().getKind() != Struct.Array)
		{
			report_error(obj.getName() + " mora biti tipa int!", decrementDesignator);
		}
		
		varOrElemErrorCheck(obj, decrementDesignator);
	}
	
	public void visit(ReadStmt readStmt)
	{
		Obj obj = readStmt.getDesignator().obj;
		
		varOrElemErrorCheck(obj, readStmt);
		
		if(obj.getType().getKind() != Struct.Int && obj.getType().getKind() != Struct.Bool && obj.getType().getKind() != Struct.Char && obj.getType().getKind() != Struct.Array)
		{
			report_error(readStmt.getDesignator().obj.getName() + " mora biti char, int ili bool tipa !", readStmt);
		}
	}
	
	public void visit(PrintStmt printStmt)
	{
		int kind = printStmt.getExpr().obj.getType().getKind();
		
		if(kind != Struct.Int && kind != Struct.Bool && kind != Struct.Char)
		{
			report_error("Izraz mora biti char, int ili bool tipa !", printStmt);
		}
	}
	
	public void visit(HasPrintOption hasPrintOption)
	{
		hasPrintOption.obj = new Obj(Obj.Con , "prntopt", new Struct(Struct.Int), hasPrintOption.getPrintValue(), 1);
	
	}
	
	public void visit(LabelStatement labelStatement)
	{
		if(Tab.currentScope.findSymbol(labelStatement.getLabel().getLabelName()) == null)
		{
			Tab.insert(Obj.Var, labelStatement.getLabel().getLabelName(), Tab.find("label").getType());
		}
		else
		{
			report_error("Labela se sme samo jednom naci u kodu" , labelStatement);
		}
	}
	
		public void visit(GotoStmt gotoStmt)
	{
		
		Obj obj = Tab.find(gotoStmt.getLabel().getLabelName());
		
		if(obj == Tab.noObj)
		{
			labels.add(new LabelDecl(gotoStmt, gotoStmt.getLabel().getLabelName()));
		}
	}
	
	public void visit(MethodRBrace endofmain)
	{
		for(int i = 0; i < labels.size(); i++)
		{
			Obj obj = Tab.find(labels.get(i).labelName);
			if(obj == Tab.noObj)
			{
				report_error("Labela: " + labels.get(i).labelName + " ne postoji", labels.get(i).info);
			}
		}
	}
	
	

	
}
