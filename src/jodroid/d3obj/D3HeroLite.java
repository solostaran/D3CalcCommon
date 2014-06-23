package jodroid.d3obj;

import java.util.Date;

/**
 * Represents a minimalist D3 Hero that the D3api provides in the player profile JSON file.
 * @author JRD
 *
 */
public class D3HeroLite extends D3Obj {
	
	private static final long serialVersionUID = 20121214L;
	
	private static ID3HeroLite platformHeroLite;
	public static void setDelegate(ID3HeroLite delegate) {
		platformHeroLite = delegate;
	}
	
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
		return hardcore ? platformHeroLite.getHardcore() : new String();
	}
	
	public String getGender() {
		return platformHeroLite.getGender(gender);
	}
	
	public String getParagon() {
		return paragonLevel > 0 ? platformHeroLite.getParagon()+" ("+paragonLevel+")" : new String();
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
