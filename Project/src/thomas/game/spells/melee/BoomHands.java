package thomas.game.spells.melee;

import thomas.game.spells.Spell;

public class BoomHands extends Spell{
	@Override
	public String toString() {
		return "Spell: " + name + ", Mana cost: " + cost + ", Attack: " + attack + ", Effect: " + effect + "\n";
	}
	public BoomHands(String name, int cost, int damage, String effect){
		super(name, cost, damage, effect);
	}

	public BoomHands(){
		super("BoomHands", 5, 5, "Backfire");
	}
}
