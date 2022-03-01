// generated with ast extension for cup
// version 0.8
// 17/1/2022 10:3:45


package rs.ac.bg.etf.pp1.ast;

public class SimpleLocalVarDecl extends SingleLocalVarDecl {

    private String smplLocalVarName;

    public SimpleLocalVarDecl (String smplLocalVarName) {
        this.smplLocalVarName=smplLocalVarName;
    }

    public String getSmplLocalVarName() {
        return smplLocalVarName;
    }

    public void setSmplLocalVarName(String smplLocalVarName) {
        this.smplLocalVarName=smplLocalVarName;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SimpleLocalVarDecl(\n");

        buffer.append(" "+tab+smplLocalVarName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SimpleLocalVarDecl]");
        return buffer.toString();
    }
}
