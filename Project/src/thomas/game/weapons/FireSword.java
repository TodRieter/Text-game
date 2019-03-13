package thomas.game.weapons;

import thomas.game.enums.Effect;
import thomas.game.enums.Rarity;
import thomas.game.items.Item;
import thomas.game.items.FireSwordItem;

public class FireSword extends Weapon{
	static Item fireSword = new FireSwordItem();
	public String toString() {
		return name() + " attack: " + attack + " piercing: " + armorPierce + effect;
	}
	public FireSword(){
		super("FireSword", 10, 1, Effect.FLAME, Rarity.ACMERARE, fireSword);
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
