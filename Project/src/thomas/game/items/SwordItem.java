package thomas.game.items;

import thomas.game.enums.Rarity;
import thomas.game.weapons.Sword;
import thomas.game.weapons.Weapon;

public class SwordItem extends Item {
	static Weapon sword = new Sword();
	static String info = Weapon.getInfo(sword);
	@Override
	public String toString() {
		return "Sword" + "(" + quantity + ")" + " " + info;
	}

	public SwordItem(){
	super("sword", 1, false, info, Rarity.MEH);
	
	}
	SwordItem(String name, int quantity, boolean inInv, int attack, int piercing){
		super();
	}


}
	
	

