package thomas.game.weapons;

public class Sword extends Weapon{
	public String toString() {
		return " attack: " + attack + " piercing: " + armorPierce + "%";
	}
	public Sword(){
		super("Sword", 10, 1, null);
	}

}
