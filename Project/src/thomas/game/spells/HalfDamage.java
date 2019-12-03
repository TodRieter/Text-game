package thomas.game.spells;

import thomas.game.entities.Entity;

public class HalfDamage extends StatusEffect {
	
	public HalfDamage() {
		super();
		this.name = "half damage";
		
	}
	public HalfDamage(String name, int duration, int modifier) {
		super(name, duration, modifier>>1);
	}
	
	public HalfDamage(int modifier) {
		this();
		this.modifier = modifier>>1;
	}
	public HalfDamage(int duration, int modifier) {
		this();
		this.duration = 5;
		this.modifier = modifier>>1;
	}
	public int getModifier(int attack){
		return attack/2;
	}
	@Override
	public void affect(Entity entity) {
		entity.setHealth(entity.getHealth()-this.modifier);
	}
	@Override
	public StatusEffect clone() {
		return new HalfDamage(this.name, this.duration, this.modifier);
	}

}
