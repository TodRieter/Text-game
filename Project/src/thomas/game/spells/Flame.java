package thomas.game.spells;

import thomas.game.entities.Entity;

public class Flame extends StatusEffect {

	public Flame() {
		super("Flame", 5, 5);
	}

	public Flame(String name, int duration, int modifier) {
		super(name, duration, modifier);
		// TODO Auto-generated constructor stub
	}

	public Flame(String name, int duration) {
		super(name, duration);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void affect(Entity entity) {
		entity.setHealth(entity.getHealth() - modifier);
	}

	@Override
	public StatusEffect clone() {
		return new Flame(this.name, this.duration, this.modifier);
	}

}
