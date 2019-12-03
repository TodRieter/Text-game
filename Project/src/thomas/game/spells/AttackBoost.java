package thomas.game.spells;

import thomas.game.entities.Entity;

public class AttackBoost extends StatusEffect{

	AttackBoost(){
		super("Attack Boost", 5,5);
	}
	AttackBoost(int modifier){
		this.modifier = modifier;
	}
	
	public AttackBoost(int duration, int modifier) {
		super(duration, modifier);
	}
	
	public AttackBoost(String name, int modifier, int duration) {
		super(name, duration, modifier);
	}
	public int getModifier() {
		return modifier;
	}
	public void setModifier(int modifier){
		this.modifier = modifier;
	}
	@Override
	public void affect(Entity entity) {
		entity.setAttack(entity.getAttack() + this.modifier);
	}
	@Override
	public StatusEffect clone() {
		// TODO Auto-generated method stub
		return new AttackBoost(this.name, this.modifier, this.duration);
	}

}
