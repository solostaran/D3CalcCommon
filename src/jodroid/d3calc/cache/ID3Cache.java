package jodroid.d3calc.cache;

import java.io.File;

import jodroid.d3obj.D3Hero;
import jodroid.d3obj.ID3Icon;
import jodroid.d3obj.D3Item;
import jodroid.d3obj.D3Profile;
import jodroid.d3obj.D3ProfileLite;
import jodroid.d3calc.D3Prefs;

public interface ID3Cache {
	/**
	 * The cache base directory (platform dependent).<br/>
	 * In desktop java, it is the launch directory's sub-directory "cache".<br/>
	 * In Android, it is in the "data/d3calc" sub-directory of the external storage.
	 * @return a File object that represents the base directory.
	 */
	File getBaseDirectory();
	
	/**
	 * Create a sub-directory in the cache directory.
	 * @param dir sub-directory's reference
	 */
	void createDir(File dir);
	
	/**
	 * Give a D3Item's icon either from cache or by downloading it. 
	 * @param url an url to the icon (references also the file in cache)
	 * @return a ID3Icon who contains the icon's bitmap.
	 */
	ID3Icon getItemIcon(String url);
	
	/**
	 * Write a D3Profile in the cache.
	 * @param profile
	 */
	void writeProfile(D3Profile profile);
	
	/**
	 * Write a D3Hero in the cache.
	 * @param hero
	 */
	void writeHero(D3Hero hero);
	
	/**
	 * Read a D3Profile from the cache.
	 * @param battlehost
	 * @param battletag
	 * @return a D3Profile or null if not found
	 */
	D3Profile readProfile(String battlehost, String battletag);
	
	/**
	 * Read a D3hero from the cache.
	 * @param battlehost
	 * @param heroID
	 * @return a D3Hero or null if not found
	 */
	D3Hero readHero(String battlehost, String battletag, String heroID);
	
	/**
	 * Get a D3Profile either from the cache or from the web.
	 * @param battlehost
	 * @param battletag
	 * @param prefs conditions about the download depending on cache presence.
	 * @param aoh a handler for asynchronous download. 
	 */
	void getProfile(String battlehost, String battletag, D3Prefs prefs, AsyncObjectHandler<D3Profile> aoh);
	void getProfile(D3ProfileLite prof, D3Prefs prefs, AsyncObjectHandler<D3Profile> aoh);
	
	/**
	 * Get a D3Hero either from the cache or from the web.
	 * @param battlehost
	 * @param heroID
	 * @param prefs conditions about the download depending on cache presence.
	 * @param aoh a handler for asynchronous download.
	 */
	void getHero(String battlehost, String battletag, String heroID, D3Prefs prefs, AsyncObjectHandler<D3Hero> aoh);

	/**
	 * Get a D3Item from the web.
	 * @param url to interrogate the d3api
	 * @param aoh a handler for asynchronous download.
	 */
	void getItem(String url, AsyncObjectHandler<D3Item> aoh);
	
	/**
	 * Serialize an object to an xml file.
	 * @param obj
	 * @param filename according to the base directory
	 */
	void xmlEncodeToFile(Object obj, String filename);
	
	/**
	 * Unserialize an object from an xml file.
	 * @param filename according to the base directory
	 * @return
	 */
	Object xmlDecodeFromFile(String filename);
}
