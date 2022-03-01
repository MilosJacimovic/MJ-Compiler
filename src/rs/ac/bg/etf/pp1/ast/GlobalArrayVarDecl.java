// generated with ast extension for cup
// version 0.8
// 17/1/2022 10:3:45


package rs.ac.bg.etf.pp1.ast;

public class GlobalArrayVarDecl extends SingleVarDeclaration {

    private String arryValName;

    public GlobalArrayVarDecl (String arryValName) {
        this.arryValName=arryValName;
    }

    public String getArryValName() {
        return arryValName;
    }

    public void setArryValName(String arryValName) {
        this.arryValName=arryValName;
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
        buffer.append("GlobalArrayVarDecl(\n");

        buffer.append(" "+tab+arryValName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalArrayVarDecl]");
        return buffer.toString();
    }
}
