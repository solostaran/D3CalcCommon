package jodroid.d3obj;


public class D3Skill extends D3Obj {

	private static final long serialVersionUID = 20121219L;

//	public String slug;
	public String name;
	public String icon;
//	public String tooltipUrl;
	public String description;
//	public String flavor;
	public String skillCalcId;
//	public int level;
//	public String categorySlug;
	
	@D3FieldAnnotation(notInJson=true)
	transient public D3Icon iconSmall = null;
	@D3FieldAnnotation(notInJson=true)
	transient public D3Icon iconLarge = null;
}
