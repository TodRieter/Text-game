package thomas.game.weapons;

import thomas.game.enums.Colors;
import thomas.game.enums.Effect;
import thomas.game.enums.Rarity;

public abstract class Weapon {
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
	public Weapon(){
		System.out.printf(" " + this);
	}
	public Weapon(String name, int attack, double armorPierce, Effect effect, Rarity rareness) {
		this.name = name;
		this.attack = attack;
		this.armorPierce = armorPierce;
		this.effect = effect;
		this.rareness = rareness;
	}
	public static String getInfo(Weapon weapon) {
		return "info: " + weapon;
	}
	public String name(){
		return this.rareness.code() + this.name + Colors.RESET.color;
	}

}
