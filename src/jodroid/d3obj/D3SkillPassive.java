package jodroid.d3obj;

public class D3SkillPassive extends D3Obj implements ID3Skill {

	private static final long serialVersionUID = 20121219L;

	public D3Skill skill;
	
	@Override
	public String toString() {
		return (skill != null ? skill.name : "skill undefined");
	}

	@Override
	public D3Skill getSkill() {
		return skill;
	}
}
