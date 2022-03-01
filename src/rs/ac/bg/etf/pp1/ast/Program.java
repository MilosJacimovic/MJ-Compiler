// generated with ast extension for cup
// version 0.8
// 17/1/2022 10:3:45


package rs.ac.bg.etf.pp1.ast;

public class Program implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private ProgName ProgName;
    private GlobalDeclarationList GlobalDeclarationList;
    private MainMethodDeclaration MainMethodDeclaration;

    public Program (ProgName ProgName, GlobalDeclarationList GlobalDeclarationList, MainMethodDeclaration MainMethodDeclaration) {
        this.ProgName=ProgName;
        if(ProgName!=null) ProgName.setParent(this);
        this.GlobalDeclarationList=GlobalDeclarationList;
        if(GlobalDeclarationList!=null) GlobalDeclarationList.setParent(this);
        this.MainMethodDeclaration=MainMethodDeclaration;
        if(MainMethodDeclaration!=null) MainMethodDeclaration.setParent(this);
    }

    public ProgName getProgName() {
        return ProgName;
    }

    public void setProgName(ProgName ProgName) {
        this.ProgName=ProgName;
    }

    public GlobalDeclarationList getGlobalDeclarationList() {
        return GlobalDeclarationList;
    }

    public void setGlobalDeclarationList(GlobalDeclarationList GlobalDeclarationList) {
        this.GlobalDeclarationList=GlobalDeclarationList;
    }

    public MainMethodDeclaration getMainMethodDeclaration() {
        return MainMethodDeclaration;
    }

    public void setMainMethodDeclaration(MainMethodDeclaration MainMethodDeclaration) {
        this.MainMethodDeclaration=MainMethodDeclaration;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ProgName!=null) ProgName.accept(visitor);
        if(GlobalDeclarationList!=null) GlobalDeclarationList.accept(visitor);
        if(MainMethodDeclaration!=null) MainMethodDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgName!=null) ProgName.traverseTopDown(visitor);
        if(GlobalDeclarationList!=null) GlobalDeclarationList.traverseTopDown(visitor);
        if(MainMethodDeclaration!=null) MainMethodDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgName!=null) ProgName.traverseBottomUp(visitor);
        if(GlobalDeclarationList!=null) GlobalDeclarationList.traverseBottomUp(visitor);
        if(MainMethodDeclaration!=null) MainMethodDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Program(\n");

        if(ProgName!=null)
            buffer.append(ProgName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(GlobalDeclarationList!=null)
            buffer.append(GlobalDeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MainMethodDeclaration!=null)
            buffer.append(MainMethodDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Program]");
        return buffer.toString();
    }
}
