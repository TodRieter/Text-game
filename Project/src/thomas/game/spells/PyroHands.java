package thomas.game.spells;


public class PyroHands extends AttackSpell{

	StatusEffect effect = new Flame();
	public PyroHands(){
		super("Pyro Hands", "FWOOOSH", 1, 5, 5);
	}

}
