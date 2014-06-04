package jodroid.d3obj;


public class D3ItemAttribute extends D3Obj {

	private static final long serialVersionUID = 20140504L;

	public String text;
	public String affixType;
	public String color;
	
	@Override
	public String toString() {
		return color + ": "+text;
	}
}
