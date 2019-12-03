package thomas.game.entities;
import java.util.ArrayList;
import java.util.HashMap;

import thomas.game.GameObject;
import thomas.game.enums.Rarity;
import thomas.game.items.Item;
import thomas.game.spells.Buff;
import thomas.game.spells.Spell;
import thomas.game.spells.StatusEffect;
import thomas.game.weapons.Weapon;



public abstract class Entity{
	
	protected int health;
	protected int attack;
	protected int armor;
	protected String name;
	public String stats;
	protected int mana;
	protected ArrayList<Spell> spellList = new ArrayList<>();
	protected ArrayList<Weapon> weaponList = new ArrayList<>();
	protected ArrayList<StatusEffect> statusEffects = new ArrayList<>();
	protected int maxHealth;
	protected ArrayList<Buff> buffList;
	protected Weapon selectedWeapon;
	protected Spell selectedSpell;
	
	public Entity() {

	}
	
	Entity(String name, int health, int attack, int armor, int mana, ArrayList<Weapon> weaponList, Weapon selectedWeapon, ArrayList<Spell> spellList, Spell selectedSpell, ArrayList<StatusEffect> statusEffects){
		
		this.name = name;
		this.health = health;
		this.attack = attack;	
		this.armor = armor;
		this.mana = mana;		
		this.weaponList = weaponList;
		this.selectedWeapon = selectedWeapon;
		this.spellList = spellList;
		this.selectedSpell = selectedSpell;
		this.statusEffects = statusEffects;
		Entities.put(this.name, this);
		
	}
	
	

public Entity(String string, int i, int j, int k, int l, ArrayList<Item> arrayList, ArrayList<Spell> arrayList2,
			ArrayList<StatusEffect> arrayList3) {
		this();
	}
public Entity(String name, int health, int armor, int attack, int mana) {
	this();
	this.name = name;
	this.health = health;
	this.armor = armor;
	this.attack = attack;
	this.mana = mana;
}
Entity(Weapon weapon){
	this();
	selectedWeapon = weapon;
	this.weaponList.add(weapon);
}
Entity(Spell spell){
	this();
	selectedSpell = spell;
	this.spellList.add(spell);
}

Entity(Weapon weapon, Spell spell){
	this();
	selectedWeapon = weapon;
	this.weaponList.add(weapon);
	selectedSpell = spell;
	this.spellList.add(spell);
}

public static HashMap<String, Entity> Entities = new HashMap<String, Entity>();
public String toString() {
	return name + "[health= " + health + ", attack= " + attack + ", armor= " + armor + " mana= "+ mana + " status effects= " + statusEffects+ "]";

}
public int getHealth() {
		return this.health;
	}
public int getMana() {
	return this.mana;
}
	
public String getStats(){
	
	return stats;
	
}
	public int getAttack() {
		
		return this.attack;
	}

	public int getArmor() {
		// TODO Auto-generated method stub
		return this.armor;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void setSpellList(ArrayList<Spell> spellList) {
		this.spellList = spellList;
	}
	public ArrayList<Weapon> getWeaponList(){
		return this.weaponList;
	}

	public void heal(Buff buff) {
		this.setMana(this.getMana() - buff.getCost());
		if(this.getHealth() + buff.getModifier() <= this.getMaxHealth()) {
			this.setHealth(this.getHealth() + buff.getModifier());
		} else {
			this.setHealth(getMaxHealth());
		}
	}
	
	public void cast(Entity target, Spell spell) {
		if(this.mana - spell.getCost() >= 0) {
			spell.cast(this, target);
			return;
		}
		GameObject.g.display("you have not enough pyl... uhh mana");
		return;

//		if (this.getMana() >= spell.getCost()) {
//	
//			if (spell.getEffect() != Effect.NONE && spell.getEffect().getTarget().equals("caster")) {
//				//spell.affect(spell.getEffect(), this);
//				GameObject.g.display(spell.getFlavor());
//				this.addEffect(spell.getEffect());
//			}else if (spell.getEffect() != null && spell.getEffect().getTarget().equals("target")) {
//				GameObject.g.display(spell.getFlavor());
//				target.addEffect(spell.getEffect());	
//			}
//			target.setHealth(target.getHealth() - spell.getAttack());
//			this.setMana(this.getMana()-spell.getCost());
//			GameObject.gameGui.updatePlayerInfo();
//			GameObject.g.display(this + "\n" + target);
//			
//		} else if (this.getMana() <= spell.getCost()) {
//			//GameObject.g.display("You don't have enough mana!\n" + this);
//		}
	}


	public double calcDefence(Weapon weapon) {
		if (this.getArmor() * weapon.getArmorPierce() < 1) {
			return (double) 1 - (this.getArmor() * weapon.getArmorPierce());
		} else {
			return 1;
		}
	}
	public void attack(Entity target) {
		Entity attacker = (Entity)this;
		attacker.selectedWeapon.attack(this, target);
	}
//	public void attack(Entity target) {
//		Item weaponItem = ((Weapon)GameObject.gameGui.getWeaponBox().getSelectedItem()).toItem();
//		Weapon weapon = GameObject.weapons.get(weaponItem.name);
//		double defenceMod = calcDefence(weapon, target);
//		
//			target.setHealth(target.getHealth() - (int) ((this.getAttack() + weapon.attack) * defenceMod));
//		if (weapon.getEffect(). {
//			this.addEffect(weapon.getEffect());
//		}else if (weapon.getEffect().getTarget().equals("target")) {
//			System.out.println(weapon.getEffect().getName());
//			target.addEffect(weapon.getEffect());	
//		}
//			GameObject.gameGui.updatePlayerInfo();
//			GameObject.g.display(GameObject.player.toString() + "\n" + target.toString());
//	}
	public int getMaxHealth() {
		return maxHealth;
	}
	
//	public void attack(Weapon weapon) {
//		double defenceMod = calcDefence(weapon, GameObject.player);
//		if (this.getHealth() >= 0 && GameObject.player.getHealth() >= 0) {
//			GameObject.player.setHealth(GameObject.player.getHealth() - (int) ((this.getAttack() + weapon.attack) * defenceMod));
//		}else if (weapon.getEffect() != Effect.NONE && weapon.getEffect().getTarget().equals("caster")) {
//			//spell.affect(spell.getEffect(), this);
//			this.addEffect(weapon.getEffect());
//		}else if (weapon.getEffect() != null && weapon.getEffect().getTarget().equals("target")) {
//			GameObject.player.addEffect(weapon.getEffect());	
//		}
//			GameObject.g.display(this.name + " used " + weapon.name);
//			GameObject.gameGui.updatePlayerInfo();
//			GameObject.g.display(GameObject.player.toString() + "\n" + this.toString());
//	}
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
	public void setSelectedWeapon(Weapon weapon) {
		selectedWeapon = weapon;
	}
	public Weapon getSelectedWeapon() {
		return selectedWeapon;
	}
	public void setSelectedSpell(Spell spell) {
		selectedSpell = spell;
	}
	public Spell getSelectedSpell() {
		return selectedSpell;
	}
//	public void affect(){
//			ArrayList<StatusEffect> finishedStatusEffects = new ArrayList<>();
//			for(StatusEffect effect : this.statusEffects) {
//
//				if(effect.getDuration() <= 0) {
//					finishedStatusEffects.add(effect);
//					GameObject.g.display(this.name + " has lost the status effect: " + effect.name);
//					effect.setDuration(effect.getDuration()-1);
//				}
//				if(effect.getModifier() >= 0) {
//						this.setHealth(this.getHealth() - effect.getModifier());
//						GameObject.g.display(this.name + " has taken " + effect.getModifier() + " damage from the effect: " + effect.name);
//						//effect.time--;
//				}
//			}
//			statusEffects.removeAll(finishedStatusEffects);
//		}

		public ArrayList<StatusEffect> getStatusEffects() {
			return statusEffects;
			
		}

		public ArrayList<Buff> getBuffList() {
			return buffList;
		}

		public void setBuffList(ArrayList<Buff> buffList) {
			this.buffList = buffList;
		}

		public ArrayList<Spell> getSpellList() {
			return this.spellList;
		}

		public void setAttack(int attack) {
			this.attack = attack;
		}

		public void setArmor(int armor) {
			this.armor = armor;
		}
		
		public void triggerStatusEffects(){
			ArrayList<StatusEffect> statusEffects = (ArrayList<StatusEffect>) this.getStatusEffects().clone();
			for(StatusEffect effect : this.statusEffects) {
				System.out.println(effect);
				effect.affect(this);
				effect.tickEffect();
				statusEffects.removeIf((x)-> (x.getDuration() > effect.getDuration() || x.getDuration() <= 0));
			}
			System.out.println(statusEffects);
			this.statusEffects.clear();
			this.statusEffects = statusEffects;
		}


		public void setWeaponList(ArrayList<Weapon> weaponList) {
			this.weaponList = weaponList;
		}
		public abstract Entity clone();
}
