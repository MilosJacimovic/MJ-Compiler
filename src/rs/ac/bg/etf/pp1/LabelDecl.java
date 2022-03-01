package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.SyntaxNode;

public class LabelDecl {

	SyntaxNode info;
	String labelName;
	
	public LabelDecl(SyntaxNode info, String labelName) {
		this.info = info;
		this.labelName = labelName;
	}
}
