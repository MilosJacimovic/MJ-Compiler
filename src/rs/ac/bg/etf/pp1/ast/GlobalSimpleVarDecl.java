// generated with ast extension for cup
// version 0.8
// 17/1/2022 10:3:45


package rs.ac.bg.etf.pp1.ast;

public class GlobalSimpleVarDecl extends SingleVarDeclaration {

    private String smplVarName;

    public GlobalSimpleVarDecl (String smplVarName) {
        this.smplVarName=smplVarName;
    }

    public String getSmplVarName() {
        return smplVarName;
    }

    public void setSmplVarName(String smplVarName) {
        this.smplVarName=smplVarName;
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
        buffer.append("GlobalSimpleVarDecl(\n");

        buffer.append(" "+tab+smplVarName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalSimpleVarDecl]");
        return buffer.toString();
    }
}
