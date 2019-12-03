package thomas.game.entities;

import java.util.ArrayList;

import thomas.game.enums.Effect;
import thomas.game.items.Item;
import thomas.game.spells.*;
import thomas.game.weapons.DragonClaw;
import thomas.game.weapons.DragonTeeth;
import thomas.game.weapons.Weapon;

public class Dragon extends Entity{ 
	
	
	@Override 
	public String toString() {
		return name + "[health= " + health + ", attack= " + getAttack() + ", armor= " + getArmor() + " mana= "+ mana + " status effects= " + statusEffects+ "]";
	}
	
	
	public Dragon(){
		super("Dragon", 1000, 8, 10, 10, new ArrayList<Weapon>(), (Weapon)new DragonClaw(), new ArrayList<Spell>(), new DragonsBreath(), new ArrayList<StatusEffect>());
		this.spellList.add(new DragonsBreath());
		this.spellList.add(new DragonFlex());
		this.weaponList.add(new DragonClaw());
		this.maxHealth = health;
	}
	Dragon(ArrayList<Weapon> weaponList, ArrayList<Spell> spellList){
		this.weaponList = weaponList;
		this.spellList = spellList;
		this.spellList.add(new DragonFlex());
	}
	Dragon(Weapon weapon){
		this();
		this.selectedWeapon = weapon;
		this.weaponList.add(weapon);
	}
	Dragon(Spell spell){
		this();
		this.selectedSpell = spell;
		this.spellList.add(spell);
		this.spellList.add(new DragonFlex());
	}
	Dragon(String name, int health, int attack, int armor, int mana, ArrayList<Weapon> inv, Weapon selectedWeapon, ArrayList<Spell> spellList, Spell selectedSpell, ArrayList<StatusEffect> statusEffects){
		super(name, health, attack, armor, mana, inv, selectedWeapon, spellList, selectedSpell, statusEffects);

		this.setMaxHealth(health);
	}
	@Override
	public Entity clone() {
		return new Dragon(this.name, this.health, this.attack, this.mana, this.armor, this.weaponList, this.selectedWeapon, this.spellList, this.selectedSpell, this.statusEffects);
	}
}
