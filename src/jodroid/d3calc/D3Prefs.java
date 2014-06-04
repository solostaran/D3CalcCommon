package jodroid.d3calc;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Date;

public class D3Prefs implements Cloneable {
	// load only on demand or if old (false means always download from web)
	private boolean loadOnDemand = true;
	// load if older than (see below)
	private boolean loadOld = true;
	// value in days
	private int olderThan = 10;
	// use last save date (saved into the cache) instead of last updated date (update on the web)  
	private boolean saveLoadDate = true;
	// save profiles and heroes in the json form
	private boolean saveJson = true;
	
	public D3Prefs() {}
	
	private D3Prefs(D3Prefs pref) {
		loadOnDemand = pref.isLoadOnDemand();
		loadOld = pref.isLoadOld();
		olderThan = pref.getOlderThan();
		saveLoadDate = pref.isSaveLoadDate();
		saveJson = pref.isSaveJson();
	}
	
	public boolean isTooOld(long lastUpdated) {
		long today = (new Date().getTime())/1000; // value in seconds
		long diff = (today - lastUpdated)/86400; // difference in days
		if (diff >= olderThan) return true;
		return false;
	}

	public boolean isLoadOnDemand() {
		return loadOnDemand;
	}

	public void setLoadOnDemand(boolean loadOnDemand) {
		this.loadOnDemand = loadOnDemand;
	}

	public boolean isLoadOld() {
		return loadOld;
	}

	public void setLoadOld(boolean loadOld) {
		this.loadOld = loadOld;
	}

	public int getOlderThan() {
		return olderThan;
	}

	public void setOlderThan(int olderThan) {
		this.olderThan = olderThan;
	}

	public boolean isSaveLoadDate() {
		return saveLoadDate;
	}

	public void setSaveLoadDate(boolean saveLoadDate) {
		this.saveLoadDate = saveLoadDate;
	}

	public boolean isSaveJson() {
		return saveJson;
	}

	public void setSaveJson(boolean saveJson) {
		this.saveJson = saveJson;
	}
	
	@Override
	public String toString() {
		Class<?> c=this.getClass();
		Field[] fields=c.getDeclaredFields();
		
		StringBuffer sb = new StringBuffer();
		for (Field f : fields) {
			if ((f.getModifiers() & Modifier.TRANSIENT) != 0) continue;
			if (!f.getType().isPrimitive() & f.getType() != String.class) continue;
			f.setAccessible(true);
			try {
				sb.append(f.getName());
				sb.append(" = ");
				sb.append(f.get(this).toString());
				sb.append("\n");
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
	
	@Override
	public D3Prefs clone() {
		return new D3Prefs(this);	
	}
}
