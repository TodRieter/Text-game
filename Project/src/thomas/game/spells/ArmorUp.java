package thomas.game.spells;

import thomas.game.entities.Entity;

public class ArmorUp extends StatusEffect {

	public ArmorUp() {
		super("Armor Up", 5, 500);
	}

	public ArmorUp(String name, int duration, int modifier) {
		super(name, duration, modifier);
		// TODO Auto-generated constructor stub
	}

	public ArmorUp(String name, int duration) {
		super(name, duration);
		// TODO Auto-generated constructor stub
	}

	public ArmorUp(int modifier) {
		this();
		this.modifier = modifier;
	}

	@Override
	public void affect(Entity entity) {
		entity.setArmor(modifier);

	}

	@Override
	public StatusEffect clone() {
		return new ArmorUp(this.name, this.duration, this.modifier);
	}

}
