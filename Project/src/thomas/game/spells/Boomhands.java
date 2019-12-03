package thomas.game.spells;

import thomas.game.entities.Entity;

public class Boomhands extends AttackSpell{
	
	public Boomhands(String name, String flavor, int level, int cost, int damage, int attack, int modifier){
		super(name, flavor, level, cost, attack, modifier);
	}

	public Boomhands(){
		super("Boomhands", "**BOOM**\nOUCH!!", 1, 5, 5, 2);
	}

	@Override
	public void affect(Entity caster) {
		caster.setHealth(caster.getHealth() - 2);
		
	}
	
}
