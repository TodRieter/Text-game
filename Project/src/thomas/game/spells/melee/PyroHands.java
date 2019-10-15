package thomas.game.spells.melee;

import thomas.game.enums.Effect;
import thomas.game.items.Item;
import thomas.game.spells.Spell;

public class PyroHands extends Spell{

	
	public PyroHands(){
		super("Pyro Hands", 5, 1, 5, Effect.FLAME,"FWOOOSH");
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
