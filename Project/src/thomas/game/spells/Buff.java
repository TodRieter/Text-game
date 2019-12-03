package thomas.game.spells;

import thomas.game.entities.Entity;

public abstract class Buff extends Spell{
	protected int modifier;
	protected char opperator;
	StatusEffect[] effects;
	
	public Buff() {
		super();
	}
	public Buff(String name, String flavor, int level, int cost,  int modifier, StatusEffect[] effects) {
		super(name, flavor, level, cost);
		this.effects = effects;
		this.modifier = modifier;
	}

	public int getModifier() {
		return modifier;
	}

	public void setModifier(int modifier) {
		this.modifier = modifier;
	}
	public void addStatusEffects(Entity entity){
		for(StatusEffect effect : effects) {
			entity.getStatusEffects().add(effect);
		}
	}

}
