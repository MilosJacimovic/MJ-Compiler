// generated with ast extension for cup
// version 0.8
// 17/1/2022 10:3:45


package rs.ac.bg.etf.pp1.ast;

public class StmtList extends StatementList {

    private StatementList StatementList;
    private StatementLabelOption StatementLabelOption;

    public StmtList (StatementList StatementList, StatementLabelOption StatementLabelOption) {
        this.StatementList=StatementList;
        if(StatementList!=null) StatementList.setParent(this);
        this.StatementLabelOption=StatementLabelOption;
        if(StatementLabelOption!=null) StatementLabelOption.setParent(this);
    }

    public StatementList getStatementList() {
        return StatementList;
    }

    public void setStatementList(StatementList StatementList) {
        this.StatementList=StatementList;
    }

    public StatementLabelOption getStatementLabelOption() {
        return StatementLabelOption;
    }

    public void setStatementLabelOption(StatementLabelOption StatementLabelOption) {
        this.StatementLabelOption=StatementLabelOption;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(StatementList!=null) StatementList.accept(visitor);
        if(StatementLabelOption!=null) StatementLabelOption.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StatementList!=null) StatementList.traverseTopDown(visitor);
        if(StatementLabelOption!=null) StatementLabelOption.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StatementList!=null) StatementList.traverseBottomUp(visitor);
        if(StatementLabelOption!=null) StatementLabelOption.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StmtList(\n");

        if(StatementList!=null)
            buffer.append(StatementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StatementLabelOption!=null)
            buffer.append(StatementLabelOption.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StmtList]");
        return buffer.toString();
    }
}
