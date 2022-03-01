// generated with ast extension for cup
// version 0.8
// 17/1/2022 10:3:45


package rs.ac.bg.etf.pp1.ast;

public class MainMethodDecl extends MainMethodDeclaration {

    private MethodName MethodName;
    private LocalVarDeclarations LocalVarDeclarations;
    private StatementList StatementList;
    private MethodRBrace MethodRBrace;

    public MainMethodDecl (MethodName MethodName, LocalVarDeclarations LocalVarDeclarations, StatementList StatementList, MethodRBrace MethodRBrace) {
        this.MethodName=MethodName;
        if(MethodName!=null) MethodName.setParent(this);
        this.LocalVarDeclarations=LocalVarDeclarations;
        if(LocalVarDeclarations!=null) LocalVarDeclarations.setParent(this);
        this.StatementList=StatementList;
        if(StatementList!=null) StatementList.setParent(this);
        this.MethodRBrace=MethodRBrace;
        if(MethodRBrace!=null) MethodRBrace.setParent(this);
    }

    public MethodName getMethodName() {
        return MethodName;
    }

    public void setMethodName(MethodName MethodName) {
        this.MethodName=MethodName;
    }

    public LocalVarDeclarations getLocalVarDeclarations() {
        return LocalVarDeclarations;
    }

    public void setLocalVarDeclarations(LocalVarDeclarations LocalVarDeclarations) {
        this.LocalVarDeclarations=LocalVarDeclarations;
    }

    public StatementList getStatementList() {
        return StatementList;
    }

    public void setStatementList(StatementList StatementList) {
        this.StatementList=StatementList;
    }

    public MethodRBrace getMethodRBrace() {
        return MethodRBrace;
    }

    public void setMethodRBrace(MethodRBrace MethodRBrace) {
        this.MethodRBrace=MethodRBrace;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodName!=null) MethodName.accept(visitor);
        if(LocalVarDeclarations!=null) LocalVarDeclarations.accept(visitor);
        if(StatementList!=null) StatementList.accept(visitor);
        if(MethodRBrace!=null) MethodRBrace.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodName!=null) MethodName.traverseTopDown(visitor);
        if(LocalVarDeclarations!=null) LocalVarDeclarations.traverseTopDown(visitor);
        if(StatementList!=null) StatementList.traverseTopDown(visitor);
        if(MethodRBrace!=null) MethodRBrace.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodName!=null) MethodName.traverseBottomUp(visitor);
        if(LocalVarDeclarations!=null) LocalVarDeclarations.traverseBottomUp(visitor);
        if(StatementList!=null) StatementList.traverseBottomUp(visitor);
        if(MethodRBrace!=null) MethodRBrace.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MainMethodDecl(\n");

        if(MethodName!=null)
            buffer.append(MethodName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(LocalVarDeclarations!=null)
            buffer.append(LocalVarDeclarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StatementList!=null)
            buffer.append(StatementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodRBrace!=null)
            buffer.append(MethodRBrace.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MainMethodDecl]");
        return buffer.toString();
    }
}
