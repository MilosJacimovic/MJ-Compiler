// generated with ast extension for cup
// version 0.8
// 17/1/2022 10:3:45


package rs.ac.bg.etf.pp1.ast;

public class ArrayLocalVarDecl extends SingleLocalVarDecl {

    private String arryLocalVarName;

    public ArrayLocalVarDecl (String arryLocalVarName) {
        this.arryLocalVarName=arryLocalVarName;
    }

    public String getArryLocalVarName() {
        return arryLocalVarName;
    }

    public void setArryLocalVarName(String arryLocalVarName) {
        this.arryLocalVarName=arryLocalVarName;
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
        buffer.append("ArrayLocalVarDecl(\n");

        buffer.append(" "+tab+arryLocalVarName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ArrayLocalVarDecl]");
        return buffer.toString();
    }
}
