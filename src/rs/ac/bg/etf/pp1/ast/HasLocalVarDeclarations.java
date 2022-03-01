// generated with ast extension for cup
// version 0.8
// 17/1/2022 10:3:45


package rs.ac.bg.etf.pp1.ast;

public class HasLocalVarDeclarations extends LocalVarDeclarations {

    private LocalVarDeclarations LocalVarDeclarations;
    private Type Type;
    private MultipleLocalVarDecl MultipleLocalVarDecl;

    public HasLocalVarDeclarations (LocalVarDeclarations LocalVarDeclarations, Type Type, MultipleLocalVarDecl MultipleLocalVarDecl) {
        this.LocalVarDeclarations=LocalVarDeclarations;
        if(LocalVarDeclarations!=null) LocalVarDeclarations.setParent(this);
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.MultipleLocalVarDecl=MultipleLocalVarDecl;
        if(MultipleLocalVarDecl!=null) MultipleLocalVarDecl.setParent(this);
    }

    public LocalVarDeclarations getLocalVarDeclarations() {
        return LocalVarDeclarations;
    }

    public void setLocalVarDeclarations(LocalVarDeclarations LocalVarDeclarations) {
        this.LocalVarDeclarations=LocalVarDeclarations;
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public MultipleLocalVarDecl getMultipleLocalVarDecl() {
        return MultipleLocalVarDecl;
    }

    public void setMultipleLocalVarDecl(MultipleLocalVarDecl MultipleLocalVarDecl) {
        this.MultipleLocalVarDecl=MultipleLocalVarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(LocalVarDeclarations!=null) LocalVarDeclarations.accept(visitor);
        if(Type!=null) Type.accept(visitor);
        if(MultipleLocalVarDecl!=null) MultipleLocalVarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(LocalVarDeclarations!=null) LocalVarDeclarations.traverseTopDown(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(MultipleLocalVarDecl!=null) MultipleLocalVarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(LocalVarDeclarations!=null) LocalVarDeclarations.traverseBottomUp(visitor);
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(MultipleLocalVarDecl!=null) MultipleLocalVarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("HasLocalVarDeclarations(\n");

        if(LocalVarDeclarations!=null)
            buffer.append(LocalVarDeclarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MultipleLocalVarDecl!=null)
            buffer.append(MultipleLocalVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [HasLocalVarDeclarations]");
        return buffer.toString();
    }
}
