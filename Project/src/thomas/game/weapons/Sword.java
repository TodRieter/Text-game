package thomas.game.weapons;

import thomas.game.enums.Effect;
import thomas.game.enums.Rarity;
import thomas.game.items.Item;
import thomas.game.items.SwordItem;

public class Sword extends Weapon{
	Item swordItem = new SwordItem();
	public String toString() {
		return name + " attack: " + attack + " piercing: " + armorPierce + effect;
	}
	public Sword(){
		super("Sword", 10, 1, null);
	}
	public Sword(String name, int atk, int pierce, Effect effect){
		super(name, atk, pierce, effect);
	}
	@Override
	public void affect(Effect effect) {
		affect(effect);
		
	}
	@Override
	public Item toItem() {
		return item;
	}

}
