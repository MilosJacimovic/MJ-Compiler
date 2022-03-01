// generated with ast extension for cup
// version 0.8
// 17/1/2022 10:3:45


package rs.ac.bg.etf.pp1.ast;

public class SingleLocalVarDeclaration extends MultipleLocalVarDecl {

    private SingleLocalVarDecl SingleLocalVarDecl;

    public SingleLocalVarDeclaration (SingleLocalVarDecl SingleLocalVarDecl) {
        this.SingleLocalVarDecl=SingleLocalVarDecl;
        if(SingleLocalVarDecl!=null) SingleLocalVarDecl.setParent(this);
    }

    public SingleLocalVarDecl getSingleLocalVarDecl() {
        return SingleLocalVarDecl;
    }

    public void setSingleLocalVarDecl(SingleLocalVarDecl SingleLocalVarDecl) {
        this.SingleLocalVarDecl=SingleLocalVarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(SingleLocalVarDecl!=null) SingleLocalVarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SingleLocalVarDecl!=null) SingleLocalVarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SingleLocalVarDecl!=null) SingleLocalVarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleLocalVarDeclaration(\n");

        if(SingleLocalVarDecl!=null)
            buffer.append(SingleLocalVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleLocalVarDeclaration]");
        return buffer.toString();
    }
}
