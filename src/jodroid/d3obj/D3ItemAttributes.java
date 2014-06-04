package jodroid.d3obj;

public class D3ItemAttributes extends D3Obj {

	private static final long serialVersionUID = 20140505L;
	
	public D3ItemAttribute [] primary;
	public D3ItemAttribute [] secondary;
	public D3ItemAttribute [] passive;
	
	public int NbAttributes() {
		int ret = 0;
		if (primary != null) ret += primary.length;
		if (secondary != null) ret += secondary.length;
		if (passive != null) ret += passive.length;
		return ret;
	}
	
	@Override
	public String toString() {
		String ret = new String();
		ret += "\nprimary:";
		for (D3ItemAttribute s : primary) ret+="\n  "+s.toString();
		ret += "\nsecondary:";
		for (D3ItemAttribute s : secondary) ret+="\n  "+s.toString();
		ret += "\npassive:";
		for (D3ItemAttribute s : passive) ret+="\n  "+s.toString();
		return ret;
	}
}
