// generated with ast extension for cup
// version 0.8
// 17/1/2022 10:3:45


package rs.ac.bg.etf.pp1.ast;

public class MultipleVarDecls extends VarDeclaration {

    private Type Type;
    private MultipleVarDeclarationList MultipleVarDeclarationList;

    public MultipleVarDecls (Type Type, MultipleVarDeclarationList MultipleVarDeclarationList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.MultipleVarDeclarationList=MultipleVarDeclarationList;
        if(MultipleVarDeclarationList!=null) MultipleVarDeclarationList.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public MultipleVarDeclarationList getMultipleVarDeclarationList() {
        return MultipleVarDeclarationList;
    }

    public void setMultipleVarDeclarationList(MultipleVarDeclarationList MultipleVarDeclarationList) {
        this.MultipleVarDeclarationList=MultipleVarDeclarationList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(MultipleVarDeclarationList!=null) MultipleVarDeclarationList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(MultipleVarDeclarationList!=null) MultipleVarDeclarationList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(MultipleVarDeclarationList!=null) MultipleVarDeclarationList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultipleVarDecls(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MultipleVarDeclarationList!=null)
            buffer.append(MultipleVarDeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultipleVarDecls]");
        return buffer.toString();
    }
}
