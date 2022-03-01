// generated with ast extension for cup
// version 0.8
// 17/1/2022 10:3:45


package rs.ac.bg.etf.pp1.ast;

public class MultipleConstDeclarations extends ConstDeclaration {

    private Type Type;
    private MultipleConstDeclaration MultipleConstDeclaration;

    public MultipleConstDeclarations (Type Type, MultipleConstDeclaration MultipleConstDeclaration) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.MultipleConstDeclaration=MultipleConstDeclaration;
        if(MultipleConstDeclaration!=null) MultipleConstDeclaration.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public MultipleConstDeclaration getMultipleConstDeclaration() {
        return MultipleConstDeclaration;
    }

    public void setMultipleConstDeclaration(MultipleConstDeclaration MultipleConstDeclaration) {
        this.MultipleConstDeclaration=MultipleConstDeclaration;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(MultipleConstDeclaration!=null) MultipleConstDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(MultipleConstDeclaration!=null) MultipleConstDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(MultipleConstDeclaration!=null) MultipleConstDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultipleConstDeclarations(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MultipleConstDeclaration!=null)
            buffer.append(MultipleConstDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultipleConstDeclarations]");
        return buffer.toString();
    }
}
