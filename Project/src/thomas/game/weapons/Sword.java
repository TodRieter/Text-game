package thomas.game.weapons;

import thomas.game.enums.Effect;
import thomas.game.enums.Rarity;

public class Sword extends Weapon{
	public String toString() {
		return name() + " attack: " + attack + " piercing: " + armorPierce + effect;
	}
	public Sword(){
		super("Sword", 10, 1, Effect.FLAME, Rarity.MEH);
	}

}
