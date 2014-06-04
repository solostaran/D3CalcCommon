package jodroid.d3obj;

import java.util.Date;


/**
 * Represents a Diablo 3 player profile that the D3api provides in the form of a JSON file.<br/>
 * The JSON Resource file can be found with :
 * <ul>
 * <li>battleTag-name ::= &lt;regional battleTag allowed characters&gt;</li>
 * <li>battleTag-code ::= &lt;integer&gt;</li>
 * <li>url ::= &lt;host&gt; "/api/d3/profile/" &lt;battleTag-name&gt; "-" &lt;battleTag-code&gt; "/"</li>
 * </ul>
 * @author JRD
 * @see D3HeroLite
 * @see <a href="http://blizzard.github.com/d3-api-docs/">Diablo 3 Web API</a>
 */
public class D3Profile extends D3ProfileLite {

	private static final long serialVersionUID = 20121219L;
	
	public D3HeroLite [] heroes;
	public long lastUpdated;
	public D3Kills kills;
	public D3Artisan [] artisans;
	@D3FieldAnnotation(notInJson=true)
	public long lastSaveDate;
	
	public D3Profile() {}
	
	public D3Profile(String _server) {
		this.battlehost = _server;
	}
	
	@Override
	public String toString() {
		return battleTag;
	}
	
	public String getLastUpdated() {
		Date date = new Date(lastUpdated*1000);
		return date2text(date);
	}
	
	
	public String getLastSave() {
		Date date = new Date(lastSaveDate*1000);
		return date2text(date);
	}
}
