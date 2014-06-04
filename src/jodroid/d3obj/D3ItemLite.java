package jodroid.d3obj;

public class D3ItemLite extends D3Obj {
	private static final long serialVersionUID = 20121214L;
	
	public String id;
	public String name;
	@D3FieldAnnotation(image=true, method="getIcon")
	public String icon;
	public String displayColor;
	public String tooltipParams;
	@D3FieldAnnotation(notInJson=true)
	transient public D3Icon iconSmall = null;
	@D3FieldAnnotation(notInJson=true)
	transient public D3Icon iconLarge = null;
//	transient protected Bitmap itemIcon = null;
	transient public String itemSlot = null;
	
	public D3ItemLite () {}
	public D3ItemLite (D3ItemLite item) {
		id = item.id;
		name = item.name;
		icon = item.icon;
		displayColor = item.displayColor;
		tooltipParams = item.tooltipParams;
		iconSmall = item.iconSmall;
		iconLarge = item.iconLarge;
		itemSlot = item.itemSlot;
	}
	
	@Override
	public String toString() {
		return id+" / "+name+" / slot="+this.itemSlot;
	}
}
