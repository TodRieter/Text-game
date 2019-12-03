package thomas.game.items;

import thomas.game.weapons.Sword;
import thomas.game.weapons.Weapon;

public class SwordItem extends Item {
	static Weapon sword = new Sword();
	public SwordItem(){
	super("sword", false);
	
	}
	SwordItem(String name, int quantity, boolean inInv, int attack, int piercing){
		super();
	}


}
	
	

