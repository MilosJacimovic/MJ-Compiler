// generated with ast extension for cup
// version 0.8
// 17/1/2022 10:3:45


package rs.ac.bg.etf.pp1.ast;

public class HasPrintOption extends PrintOptions {

    private Integer printValue;

    public HasPrintOption (Integer printValue) {
        this.printValue=printValue;
    }

    public Integer getPrintValue() {
        return printValue;
    }

    public void setPrintValue(Integer printValue) {
        this.printValue=printValue;
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
        buffer.append("HasPrintOption(\n");

        buffer.append(" "+tab+printValue);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [HasPrintOption]");
        return buffer.toString();
    }
}
