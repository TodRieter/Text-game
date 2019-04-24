package thomas.game.interfaces;

import thomas.game.enums.Effect;
import thomas.game.items.Item;

public interface IWeaponSpell {
	public void affect(Effect effect);
	public Item toItem();

}
