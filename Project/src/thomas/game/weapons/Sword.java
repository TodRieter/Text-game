package thomas.game.weapons;

import thomas.game.GameObject;
import thomas.game.enums.Effect;

public class Sword extends Weapon{

	public Sword(){
		super("Sword", 10, 1);
		Weapon.weapons.put(this.name, this);

	}
	public Sword(String name, int atk, int pierce){
		super(name, atk, pierce);
		Weapon.weapons.put(this.name, this);

	}
}
