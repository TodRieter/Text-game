package thomas.game.entities;

import java.util.ArrayList;

import thomas.game.enums.Effect;
import thomas.game.items.Item;
import thomas.game.spells.Spell;
import thomas.game.spells.StatusEffect;
import thomas.game.weapons.Weapon;

public class Blob extends Entity {

	@Override
	public String toString(){
		return "\n" + getName() + "\nhealth: " + getHealth() + ", \n mana: " + getMana() + ", \nattack: " + getAttack() + ", \narmor: " + getArmor();
	}
	public Blob() {
		super("Blob", 10, 1, 0, 0, null, null, null, null, new ArrayList<>());
	}
	public Blob(String name, int attack, int health, int mana, int armor, ArrayList<Weapon> inv, Weapon selectedWeapon,
			ArrayList<Spell> spellList, Spell selectedSpell, ArrayList<StatusEffect> statusEffects) {
		super(name, attack, health, mana, armor, inv, selectedWeapon, spellList, selectedSpell, statusEffects);
	}
	@Override
	public Entity clone() {
		return new Blob(this.name, this.attack, this.health, this.mana, this.armor, this.weaponList, this.selectedWeapon, this.spellList, this.selectedSpell, this.statusEffects);
	}
}
