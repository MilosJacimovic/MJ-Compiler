// generated with ast extension for cup
// version 0.8
// 17/1/2022 10:3:45


package rs.ac.bg.etf.pp1.ast;

public class MullopList extends Multiplication {

    private Multiplication Multiplication;
    private Mullop Mullop;
    private Factor Factor;

    public MullopList (Multiplication Multiplication, Mullop Mullop, Factor Factor) {
        this.Multiplication=Multiplication;
        if(Multiplication!=null) Multiplication.setParent(this);
        this.Mullop=Mullop;
        if(Mullop!=null) Mullop.setParent(this);
        this.Factor=Factor;
        if(Factor!=null) Factor.setParent(this);
    }

    public Multiplication getMultiplication() {
        return Multiplication;
    }

    public void setMultiplication(Multiplication Multiplication) {
        this.Multiplication=Multiplication;
    }

    public Mullop getMullop() {
        return Mullop;
    }

    public void setMullop(Mullop Mullop) {
        this.Mullop=Mullop;
    }

    public Factor getFactor() {
        return Factor;
    }

    public void setFactor(Factor Factor) {
        this.Factor=Factor;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Multiplication!=null) Multiplication.accept(visitor);
        if(Mullop!=null) Mullop.accept(visitor);
        if(Factor!=null) Factor.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Multiplication!=null) Multiplication.traverseTopDown(visitor);
        if(Mullop!=null) Mullop.traverseTopDown(visitor);
        if(Factor!=null) Factor.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Multiplication!=null) Multiplication.traverseBottomUp(visitor);
        if(Mullop!=null) Mullop.traverseBottomUp(visitor);
        if(Factor!=null) Factor.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MullopList(\n");

        if(Multiplication!=null)
            buffer.append(Multiplication.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Mullop!=null)
            buffer.append(Mullop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Factor!=null)
            buffer.append(Factor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MullopList]");
        return buffer.toString();
    }
}
