package rs.ac.bg.etf.pp1;

public class Labels {

	private String name;
	private int address;
	
	Labels(String name, int address)
	{
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAddress() {
		return address;
	}

	public void setAddress(int address) {
		this.address = address;
	}
	
	
}
