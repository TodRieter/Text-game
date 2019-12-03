package thomas.game.spells;

import thomas.game.entities.Entity;

public class LesserHealing extends Spell{
	public String flavor;
	int modifier = 5;
	public LesserHealing(){
		super("Lesser Healing", "Thats Better", 1, 5);
	}

	@Override
	public void cast(Entity entity) {
		if(entity.getHealth() + modifier >= entity.getMaxHealth()) {
			entity.setHealth(entity.getMaxHealth());
		} else {
			entity.setHealth(entity.getHealth() + modifier);
		}
		
	}

	@Override
	public void affect(Entity entity) {
		return;
		
	}
}
