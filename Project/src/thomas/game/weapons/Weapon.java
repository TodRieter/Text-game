package thomas.game.weapons;

import java.util.HashMap;

import thomas.game.GameObject;
import thomas.game.entities.Entity;
import thomas.game.items.Item;
import thomas.game.spells.StatusEffect;

public abstract class Weapon{

	//	public enum Effect {
//
//		BACKFIRE("hurts the user"), FLAME("sets the enemy on fire"), SAP("gain life from damage delt");
//		String info;
//		
//		Effect(String descrip){
//			 descrip = this.info;
//		}
//		String getInfo(){
//			return this.info;
//		}
//	}
	public static HashMap<String, Weapon> weapons = new HashMap<>();

	public String name = "";
	public int attack = 0;
	private double armorPierce = 0.0;
	StatusEffect effect;
	public Weapon(){
	}
	public Weapon(String name, int attack, double armorPierce) {
		this.name = name;
		this.attack = attack;
		this.setArmorPierce(armorPierce);
		weapons.put(this.name, this);
	}
	public static String getInfo(Weapon weapon) {
		return "info: " + weapon.name;
	}
	public String getName() {
		return name;
	}
//	public String getColoredName(){
//		return this.rareness.code() + this.name + Colors.RESET.color;
//	}
	public double getArmorPierce() {
		return this.armorPierce;
	}
	public void setArmorPierce(double armorPierce) {
		this.armorPierce = armorPierce;
	}
	public Item toItem() {
		return new Item(name, false);
	}
	public StatusEffect getEffect() {
		return this.effect;
	}
	public void attack(Entity attacker, Entity target) {
		target.setHealth(target.getHealth() - (int) ((attacker.getAttack() + this.attack) * target.calcDefence(this)));
	}
	public int getPostAttackHealth(Entity attacker, Entity target) {
		return target.getHealth() - (int) ((attacker.getAttack() + this.attack) * target.calcDefence(this));	
	}
	public String toString() {
		return this.getClass().getTypeName() + ":\nAtk: " + this.attack + ", Amrp: " + this.getArmorPierce();
	}
}
