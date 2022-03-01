// generated with ast extension for cup
// version 0.8
// 17/1/2022 10:3:45


package rs.ac.bg.etf.pp1.ast;

public class MultipleVarDeclList extends MultipleVarDeclarationList {

    private MultipleVarDeclarationList MultipleVarDeclarationList;
    private SingleVarDeclaration SingleVarDeclaration;

    public MultipleVarDeclList (MultipleVarDeclarationList MultipleVarDeclarationList, SingleVarDeclaration SingleVarDeclaration) {
        this.MultipleVarDeclarationList=MultipleVarDeclarationList;
        if(MultipleVarDeclarationList!=null) MultipleVarDeclarationList.setParent(this);
        this.SingleVarDeclaration=SingleVarDeclaration;
        if(SingleVarDeclaration!=null) SingleVarDeclaration.setParent(this);
    }

    public MultipleVarDeclarationList getMultipleVarDeclarationList() {
        return MultipleVarDeclarationList;
    }

    public void setMultipleVarDeclarationList(MultipleVarDeclarationList MultipleVarDeclarationList) {
        this.MultipleVarDeclarationList=MultipleVarDeclarationList;
    }

    public SingleVarDeclaration getSingleVarDeclaration() {
        return SingleVarDeclaration;
    }

    public void setSingleVarDeclaration(SingleVarDeclaration SingleVarDeclaration) {
        this.SingleVarDeclaration=SingleVarDeclaration;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MultipleVarDeclarationList!=null) MultipleVarDeclarationList.accept(visitor);
        if(SingleVarDeclaration!=null) SingleVarDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MultipleVarDeclarationList!=null) MultipleVarDeclarationList.traverseTopDown(visitor);
        if(SingleVarDeclaration!=null) SingleVarDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MultipleVarDeclarationList!=null) MultipleVarDeclarationList.traverseBottomUp(visitor);
        if(SingleVarDeclaration!=null) SingleVarDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultipleVarDeclList(\n");

        if(MultipleVarDeclarationList!=null)
            buffer.append(MultipleVarDeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(SingleVarDeclaration!=null)
            buffer.append(SingleVarDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultipleVarDeclList]");
        return buffer.toString();
    }
}
