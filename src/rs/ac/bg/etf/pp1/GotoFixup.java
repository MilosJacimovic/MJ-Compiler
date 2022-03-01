package rs.ac.bg.etf.pp1;

public class GotoFixup {
	
	private String labelname;
	private int whereToFix;
	
	public GotoFixup(String labelname, int whereToFix) {
		this.labelname = labelname;
		this.whereToFix = whereToFix;
	}

	public String getLabelname() {
		return labelname;
	}

	public void setLabelname(String labelname) {
		this.labelname = labelname;
	}

	public int getWhereToFix() {
		return whereToFix;
	}

	public void setWhereToFix(int whereToFix) {
		this.whereToFix = whereToFix;
	}

	
}
