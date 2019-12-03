package thomas.game.weapons;

import thomas.game.GameObject;
import thomas.game.entities.Entity;
import thomas.game.items.*;
import thomas.game.spells.*;
public class FireSword extends Weapon{
	StatusEffect effect = new Flame();
	public FireSword(){
		super("FireSword", 10, 10);
		this.effect = new Flame();
	}
	
	

	public Item fireSword = new FireSwordItem();
	
	public String toString() {
		return "Name: " + name + " atk: " + attack + " pierce: " + getArmorPierce() + effect.getName();
	}
	@Override
	public void attack(Entity attacker, Entity target) {
		target.setHealth(target.getHealth() - (int) ((attacker.getAttack() + this.attack) * target.calcDefence(this)));
		effect.addStatusEffect(target);
	}

}
