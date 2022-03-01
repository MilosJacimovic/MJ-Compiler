// generated with ast extension for cup
// version 0.8
// 17/1/2022 10:3:45


package rs.ac.bg.etf.pp1.ast;

public class AssignDesignator extends DesignatorStatement {

    private Assignment Assignment;

    public AssignDesignator (Assignment Assignment) {
        this.Assignment=Assignment;
        if(Assignment!=null) Assignment.setParent(this);
    }

    public Assignment getAssignment() {
        return Assignment;
    }

    public void setAssignment(Assignment Assignment) {
        this.Assignment=Assignment;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Assignment!=null) Assignment.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Assignment!=null) Assignment.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Assignment!=null) Assignment.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AssignDesignator(\n");

        if(Assignment!=null)
            buffer.append(Assignment.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AssignDesignator]");
        return buffer.toString();
    }
}
