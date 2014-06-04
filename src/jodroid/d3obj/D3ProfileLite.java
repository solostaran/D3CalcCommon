package jodroid.d3obj;

/**
 * Represents the minimal informations of a Diablo 3 player profile.<br/>
 * <br/>The informations that we need to access a profile are :
 * <ul><li>battlehost</li><li>battletag</li></ul>
 * @author JRD
 * @see D3Profile
 * @see <a href="http://blizzard.github.com/d3-api-docs/">Diablo 3 Web API</a>
 */
public class D3ProfileLite extends D3Obj {

	private static final long serialVersionUID = 20140504;

	public String battleTag;
	@D3FieldAnnotation(notInJson=true)
	public String battlehost;
	
	public D3ProfileLite() {}
	
	public D3ProfileLite(String host, String tag) {
		battlehost = host;
		battleTag = tag.replace("#", "-");
	}
	
	@Override
	public String toString() {
		return battlehost+"/"+battleTag;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof D3ProfileLite) {
			D3ProfileLite prof = (D3ProfileLite)obj;
			if (battlehost.equalsIgnoreCase(prof.battlehost))
				if (battleTag.replace("#", "-").equalsIgnoreCase(prof.battleTag.replace("#", "-")))
					return true;
		}
		return false;
	}
}
