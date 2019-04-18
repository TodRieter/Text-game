package thomas.game.items;

import thomas.game.enums.Rarity;
import thomas.game.weapons.Sword;
import thomas.game.weapons.Weapon;

public class FireSwordItem extends Item{
	static Weapon sword = new Sword();
	static String info = Weapon.getInfo(sword);
	

	public FireSwordItem(){
	super("Fire Sword", 1, false, info, Rarity.ACMERARE);
	
	}
	FireSwordItem(String name, int quantity, boolean inInv, int attack, int piercing){
		super();
	}
}
