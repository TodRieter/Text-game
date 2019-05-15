package thomas.game.spells.melee;

import java.awt.Color;

import thomas.game.enums.*;
import thomas.game.items.Item;
import thomas.game.spells.Spell;

public class Boomhands extends Spell{
	
	public Boomhands(String name, int level, int cost, int damage, Effect effect){
		super(name, level, cost, damage, effect);
	}

	public Boomhands(){
		super("Boomhands", 1, 5, 5, Effect.BACKFIRE);
	}
	@Override
	public void affect(Effect effect) {
		this.affect(effect);
		
	}
	@Override
	public Item toItem() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
