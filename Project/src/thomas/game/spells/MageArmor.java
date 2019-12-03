package thomas.game.spells;

import thomas.game.entities.Entity;

public class MageArmor extends Buff{
	
	public MageArmor() {
		super("Mage Armor", "You are surrouned by a shimmering light", 1, 5, 500, new StatusEffect[] {new ArmorUp(500)});
	}
	public MageArmor(int modifier) {
		this();
		this.effects[0] = new ArmorUp(modifier) ;
	}
	@Override
	public void affect(Entity entity) {
		entity.setArmor(entity.getArmor() + modifier);		
	}
}
