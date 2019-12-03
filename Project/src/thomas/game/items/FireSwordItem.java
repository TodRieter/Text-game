package thomas.game.items;

import thomas.game.weapons.Sword;
import thomas.game.weapons.Weapon;

public class FireSwordItem extends Item{
	static Weapon sword = new Sword();
	

	public FireSwordItem(){
		super("Fire Sword", false);
	
	}
	FireSwordItem(String name, int quantity, boolean inInv, int attack, int piercing){
		super();
	}
}
