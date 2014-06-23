package jodroid.d3obj;

import java.lang.reflect.Field;

import android.util.Log;


public class D3Items extends D3Obj {
	
	private static final long serialVersionUID = 20121214L;
	
	private static ID3Items platformD3Items;
	public static void setDelegate(ID3Items delegate) {
		platformD3Items = delegate;
	}

	// on modification, change these string arrays :
	// R.array.ItemsJsonNames and R.array.ItemsJsonFields
	public D3ItemLite head;
	public D3ItemLite shoulders;
	public D3ItemLite neck;
	public D3ItemLite torso;
	public D3ItemLite bracers;
	public D3ItemLite hands;
	public D3ItemLite waist;
	public D3ItemLite rightFinger;
	public D3ItemLite leftFinger;
	public D3ItemLite legs;
	public D3ItemLite feet;
	public D3ItemLite mainHand;
	public D3ItemLite offHand;
	
	@D3FieldAnnotation(notInJson=true)
	transient public D3ItemLite [] itemArray = null;
	
	/**
	 * Given the name, parse through all field names, find the corresponding one and return its value.
	 * @param name the field name to compare to
	 * @return the item or null if not found
	 */
	public D3ItemLite getItemByName(String name) {
		Class<?> c=this.getClass();
		Field[] fields=c.getFields();
		for (Field f : fields) {
			if (f.getName().equals(name)) {
				try {
					return (D3ItemLite)(f.get(this));
				} catch (IllegalArgumentException e) {
					Log.w(this.getClass().getName(), e.getMessage());
				} catch (IllegalAccessException e) {
					Log.w(this.getClass().getName(), e.getMessage());
				}
			}
		}
		return null;
	}
	
	/**
	 * Try to find the item reference in the items and return the slot name of this item if found.
	 * @param item the item reference
	 * @return slot name of the item
	 */
	public String getItemSlot(D3ItemLite item) {
		Class<?> c=this.getClass();
		Field[] fields=c.getFields();
		for (Field f : fields) {
			try {
				if (f.get(this) == item) {
					return f.getName();
				}
			} catch (IllegalArgumentException e) {
				Log.e(this.getClass().getName(), e.getMessage());
			} catch (IllegalAccessException e) {
				Log.e(this.getClass().getName(), e.getMessage());
			}
		}
		return null;
	}
	
	/**
	 * Generate a list of items without missing items.<br/>
	 * Some of this is platform dependent.
	 */
	public void buildItemArray() {
		itemArray = platformD3Items.buildItemArray(this);
	}
	
	/**
	 * Made for Serialization
	 */
	public void itemArray2Items() {
		int index = 0;
		if (head != null) head = itemArray[index++];
		if (neck != null) neck = itemArray[index++];
		if (shoulders != null) shoulders = itemArray[index++];
		if (torso != null) torso = itemArray[index++];
		if (bracers != null) bracers = itemArray[index++];
		if (hands != null) hands = itemArray[index++];
		if (waist != null) waist = itemArray[index++];
		if (rightFinger != null) rightFinger = itemArray[index++];
		if (leftFinger != null) leftFinger = itemArray[index++];
		if (legs != null) legs = itemArray[index++];
		if (feet != null) feet = itemArray[index++];
		if (mainHand != null) mainHand = itemArray[index++];
		if (offHand != null) offHand = itemArray[index++];
	}
}
