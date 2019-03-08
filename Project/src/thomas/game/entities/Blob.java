package thomas.game.entities;

import thomas.game.enums.Colors;
import thomas.game.enums.Rarity;

public class Blob extends Entity {
	
	@Override
	public String toString(){
		return "\n" + (char)27 + rareness.code() + name + Colors.RESET.color + "\nhealth: " + health + ", \n mana: " + mana + ", \nattack: " + attack + ", \narmor: " + armor;
	}
	public Blob() {
	super("Blob", 10, 1, 0, 0, Rarity.RARE);
	}
}
