package thomas.game.spells;

import thomas.game.GameObject;
import thomas.game.entities.Entity;

public class DragonsBreath extends Spell{
	StatusEffect effect;
	int attack;
	public DragonsBreath() {
		super("Dragon's Breath", "FWOAOOAOAOSHAHAHHSSHHH", 1, 10);
		this.attack = 100;
		this.effect = new Flame();
	}
	public DragonsBreath(StatusEffect effect) {
		this();
		this.effect = effect;
	}
	@Override
	public void affect(Entity entity) {
		GameObject.g.display(flavor);
		entity.setHealth(entity.getHealth()-attack);
		effect.addStatusEffect(entity);
		
	}
	public String toString() {
		return " Spell: " + this.name + " \nLevel: " + this.level + " \nMana cost: " + this.cost + "\nAttack: " + this.attack + "\n";
	}
}
