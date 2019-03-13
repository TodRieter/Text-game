package thomas.game.weapons;

import thomas.game.enums.Colors;
import thomas.game.enums.Effect;
import thomas.game.enums.Rarity;
import thomas.game.interfaces.IWeaponSpell;
import thomas.game.items.Item;

public abstract class Weapon implements IWeaponSpell{
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
	String name;
	int attack;
	double armorPierce;
	Effect effect;
	Rarity rareness;
	public Item item;
	public Weapon(){
		System.out.printf(" " + this);
	}
	public Weapon(String name, int attack, double armorPierce, Effect effect, Rarity rareness, Item item) {
		this.name = name;
		this.attack = attack;
		this.armorPierce = armorPierce;
		this.effect = effect;
		this.rareness = rareness;
		this.item = item;
	}
	public static String getInfo(Weapon weapon) {
		return "info: " + weapon;
	}
	public String name(){
		return this.rareness.code() + this.name + Colors.RESET.color;
	}

}
