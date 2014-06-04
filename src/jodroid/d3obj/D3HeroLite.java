package jodroid.d3obj;

import java.util.Date;

import jodroid.d3calc.R;

/**
 * Represents a minimalist D3 Hero that the D3api provides in the player profile JSON file.
 * @author JRD
 *
 */
public class D3HeroLite extends D3Obj {
	
	private static final long serialVersionUID = 20121214L;
	
	public String name;
	public long id;
	public int level;
	@D3FieldAnnotation(method="getHardcore")
	public boolean hardcore;
	@D3FieldAnnotation(method="getParagon")
	public int paragonLevel;
	@D3FieldAnnotation(method="getGender")
	public int gender;
	public boolean dead;
	@D3FieldAnnotation(jsonName="class")
	public String _class;
	@D3FieldAnnotation(jsonName="last-updated", method="getLastUpdated")
	public long last_updated;
	@D3FieldAnnotation(notInJson=true)
	public long last_save;
	
	@Override
	public String toString() {
		return level+" "+name+" {"+_class+"}"+(hardcore ? " hardcore":"");
	}
	
	public String getHardcore() {
		return hardcore ? context.getString(R.string.hardcore) : new String();
	}
	
	public String getGender() {
		return gender == 0 ? context.getString(R.string.gendermale) : context.getString(R.string.genderfemale);
	}
	
	public String getParagon() {
		return paragonLevel > 0 ? context.getString(R.string.paragon)+" ("+paragonLevel+")" : new String();
	}
	
	public String getLastUpdated() {
		Date date = new Date(last_updated*1000);
		return date2text(date);
	}
	
	public String getLastSave() {
		Date date = new Date(last_save*1000);
		return date2text(date);
	}
}
