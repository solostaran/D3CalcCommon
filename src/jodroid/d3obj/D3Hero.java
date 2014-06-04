package jodroid.d3obj;


/**
 * Represents the complete D3 Hero that the D3api provides in a JSON file.<br/>
 * Resource JSON file can be found with :<br/>
 * <ul>
 * <li>battleTag-name ::= &lt;regional battleTag allowed characters&gt;</li>
 * <li>battleTag-code ::= &lt;integer&gt;</li>
 * <li>hero-id ::= &lt;integer&gt;</li>
 * <li>url ::= &lt;host&gt; "/api/d3/profile/" &lt;battleTag-name&gt; "-" &lt;battleTag-code&gt; "/hero/" &lt;hero-id&gt;</li>
 * </ul>
 * The "hero-id" can be found in the player profile JSON file.
 * @author JRD
 * @see D3HeroLite
 * @see D3Profile
 * @see <a href="http://blizzard.github.com/d3-api-docs/">Diablo 3 Web API</a>
 */
public class D3Hero extends D3HeroLite {

	private static final long serialVersionUID = 20121219L;
	
	@D3FieldAnnotation(notInJson=true)
	public String battlehost = null;
	@D3FieldAnnotation(notInJson=true)
	public String battletag = null;
	
	public D3Items items;
	public D3Stats stats;
	public D3Kills kills;
	public D3Skills skills;
	
	public D3Hero() {}
	
	public D3Hero(String battlehost, String battletag) {
		this(battlehost);
		this.battletag = battletag;
	}
	
	public D3Hero(String battlehost) {
		this.battlehost = battlehost;
	}
	
	@Override
	public String toString() {
		return id+" ("+name+")";
	}
}
