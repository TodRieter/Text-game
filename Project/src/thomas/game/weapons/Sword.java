package thomas.game.weapons;

import thomas.game.enums.Effect;
import thomas.game.enums.Rarity;
import thomas.game.items.Item;
import thomas.game.items.SwordItem;

public class Sword extends Weapon{
	static Item swordItem = new SwordItem();
	public String toString() {
		return name() + " attack: " + attack + " piercing: " + armorPierce + effect;
	}
	public Sword(){
		super("Sword", 10, 1, null, Rarity.MEH, swordItem);
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
