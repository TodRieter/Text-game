package thomas.game.entities;

import thomas.game.enums.Colors;
import thomas.game.enums.Rarity;

public class Blob extends Entity {
	
	@Override
	public String toString(){
		return "\n" + name + "\nhealth: " + health + ", \n mana: " + mana + ", \nattack: " + attack + ", \narmor: " + armor;
	}
	public Blob() {
	super("Blob", 10, 1, 0, 0);
	}
	public Blob(String string, int i, int j, int k, int l) {
super(string, i, j, k, l);

	}
}
