package jodroid.d3calc.cache;

import java.io.File;

import jodroid.d3obj.D3Hero;
import jodroid.d3obj.D3Icon;
import jodroid.d3obj.D3Item;
import jodroid.d3obj.D3Profile;
import jodroid.d3obj.D3ProfileLite;
import jodroid.d3calc.D3Prefs;

public class D3Cache implements ID3Cache {
	private static D3Cache d3cacheInstance;
	private ID3Cache cache;
	
	private D3Cache() {
	}
	
	public static D3Cache getInstance() {
		if (d3cacheInstance == null)
			d3cacheInstance = new D3Cache();
		return d3cacheInstance;
	}
	
	public D3Cache setDelegate(ID3Cache _cache) {
		cache = _cache;
		return this;
	}

	@Override
	public File getBaseDirectory() {
		return cache.getBaseDirectory();
	}

	@Override
	public void createDir(File dir) {
		cache.createDir(dir);
	}

	@Override
	public D3Icon getItemIcon(String url) {
		return cache.getItemIcon(url);
	}

	@Override
	public void writeProfile(D3Profile profile) {
		cache.writeProfile(profile);
	}

	@Override
	public void writeHero(D3Hero hero) {
		cache.writeHero(hero);
	}
	
	@Override
	public D3Profile readProfile(String battlehost, String battletag) {
		return cache.readProfile(battlehost, battletag);
	}

	@Override
	public D3Hero readHero(String battlehost, String battletag, String heroID) {
		return cache.readHero(battlehost, battletag, heroID);
	}

	@Override
	public void getProfile(String battlehost, String battletag, D3Prefs prefs,
			AsyncObjectHandler<D3Profile> aoh) {
		cache.getProfile(battlehost, battletag, prefs, aoh);	
	}
	
	@Override
	public void getProfile(D3ProfileLite prof, D3Prefs prefs,
			AsyncObjectHandler<D3Profile> aoh) {
		cache.getProfile(prof, prefs, aoh);
	}

	@Override
	public void getHero(String battlehost, String battletag, String heroID, D3Prefs prefs,
			AsyncObjectHandler<D3Hero> aoh) {
		cache.getHero(battlehost, battletag, heroID, prefs, aoh);
	}

	@Override
	public void getItem(String url, AsyncObjectHandler<D3Item> aoh) {
		cache.getItem(url, aoh);
	}

	@Override
	public void xmlEncodeToFile(Object obj, String filename) {
		cache.xmlEncodeToFile(obj, filename);
	}

	@Override
	public Object xmlDecodeFromFile(String filename) {
		return cache.xmlDecodeFromFile(filename);
	}
}
