// generated with ast extension for cup
// version 0.8
// 17/1/2022 10:3:45


package rs.ac.bg.etf.pp1.ast;

public class MultipleFactorTerm extends Term {

    private Factor Factor;
    private Multiplication Multiplication;

    public MultipleFactorTerm (Factor Factor, Multiplication Multiplication) {
        this.Factor=Factor;
        if(Factor!=null) Factor.setParent(this);
        this.Multiplication=Multiplication;
        if(Multiplication!=null) Multiplication.setParent(this);
    }

    public Factor getFactor() {
        return Factor;
    }

    public void setFactor(Factor Factor) {
        this.Factor=Factor;
    }

    public Multiplication getMultiplication() {
        return Multiplication;
    }

    public void setMultiplication(Multiplication Multiplication) {
        this.Multiplication=Multiplication;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Factor!=null) Factor.accept(visitor);
        if(Multiplication!=null) Multiplication.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Factor!=null) Factor.traverseTopDown(visitor);
        if(Multiplication!=null) Multiplication.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Factor!=null) Factor.traverseBottomUp(visitor);
        if(Multiplication!=null) Multiplication.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultipleFactorTerm(\n");

        if(Factor!=null)
            buffer.append(Factor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Multiplication!=null)
            buffer.append(Multiplication.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultipleFactorTerm]");
        return buffer.toString();
    }
}
