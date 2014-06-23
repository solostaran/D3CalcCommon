package jodroid.d3obj;

public class D3SkillActive extends D3Obj implements ID3Skill {

	private static final long serialVersionUID = 20121219L;
	
	public D3Skill skill;
	public D3Rune rune;
	
	@Override
	public D3Skill getSkill() {
		return skill;
	}
	
	@Override
	public String toString() {
		if (skill == null) return "skill undefined";
		return skill.name + (rune != null ? " / " + rune.name : "");
	}
}
