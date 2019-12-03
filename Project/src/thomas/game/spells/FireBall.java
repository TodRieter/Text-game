/**
 * 
 */
package thomas.game.spells;

import thomas.game.entities.Entity;

public class FireBall extends Spell{

	StatusEffect effect;
	int attack;
	public FireBall() {
		super("Fire Ball", "FWOOSH KABOOM!", 1, 5);
		this.attack = 25;
		this.effect = new Flame();;
	}

	public FireBall(String name, String flavor, int level, int cost, int attack) {
		this.name = name;
		this.flavor = flavor;
		this.cost = cost;
		this.level = level;
		this.attack = attack;
	}

	@Override
	public void affect(Entity entity) {
		entity.setHealth(entity.getHealth()-attack);
		entity.setMana(entity.getMana()-this.cost);
		effect.addStatusEffect(entity);
	}
	
}
