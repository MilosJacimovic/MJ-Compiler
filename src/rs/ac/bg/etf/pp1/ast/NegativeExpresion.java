// generated with ast extension for cup
// version 0.8
// 17/1/2022 10:3:45


package rs.ac.bg.etf.pp1.ast;

public class NegativeExpresion extends Expr {

    private Term Term;
    private Addition Addition;

    public NegativeExpresion (Term Term, Addition Addition) {
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
        this.Addition=Addition;
        if(Addition!=null) Addition.setParent(this);
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public Addition getAddition() {
        return Addition;
    }

    public void setAddition(Addition Addition) {
        this.Addition=Addition;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Term!=null) Term.accept(visitor);
        if(Addition!=null) Addition.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
        if(Addition!=null) Addition.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Term!=null) Term.traverseBottomUp(visitor);
        if(Addition!=null) Addition.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NegativeExpresion(\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Addition!=null)
            buffer.append(Addition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NegativeExpresion]");
        return buffer.toString();
    }
}
