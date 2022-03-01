// generated with ast extension for cup
// version 0.8
// 17/1/2022 10:3:45


package rs.ac.bg.etf.pp1.ast;

public class MultipleConstDecl extends MultipleConstDeclaration {

    private MultipleConstDeclaration MultipleConstDeclaration;
    private SingleConstDeclaration SingleConstDeclaration;

    public MultipleConstDecl (MultipleConstDeclaration MultipleConstDeclaration, SingleConstDeclaration SingleConstDeclaration) {
        this.MultipleConstDeclaration=MultipleConstDeclaration;
        if(MultipleConstDeclaration!=null) MultipleConstDeclaration.setParent(this);
        this.SingleConstDeclaration=SingleConstDeclaration;
        if(SingleConstDeclaration!=null) SingleConstDeclaration.setParent(this);
    }

    public MultipleConstDeclaration getMultipleConstDeclaration() {
        return MultipleConstDeclaration;
    }

    public void setMultipleConstDeclaration(MultipleConstDeclaration MultipleConstDeclaration) {
        this.MultipleConstDeclaration=MultipleConstDeclaration;
    }

    public SingleConstDeclaration getSingleConstDeclaration() {
        return SingleConstDeclaration;
    }

    public void setSingleConstDeclaration(SingleConstDeclaration SingleConstDeclaration) {
        this.SingleConstDeclaration=SingleConstDeclaration;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MultipleConstDeclaration!=null) MultipleConstDeclaration.accept(visitor);
        if(SingleConstDeclaration!=null) SingleConstDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MultipleConstDeclaration!=null) MultipleConstDeclaration.traverseTopDown(visitor);
        if(SingleConstDeclaration!=null) SingleConstDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MultipleConstDeclaration!=null) MultipleConstDeclaration.traverseBottomUp(visitor);
        if(SingleConstDeclaration!=null) SingleConstDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultipleConstDecl(\n");

        if(MultipleConstDeclaration!=null)
            buffer.append(MultipleConstDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(SingleConstDeclaration!=null)
            buffer.append(SingleConstDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultipleConstDecl]");
        return buffer.toString();
    }
}
