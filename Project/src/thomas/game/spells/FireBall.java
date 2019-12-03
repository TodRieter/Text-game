/**
 * 
 */
package thomas.game.spells;



public class FireBall extends AttackSpell{

	StatusEffect effect = new Flame();
	
	public FireBall() {
		super("Fire Ball", "FWOOSH KABOOM!", 1, 5, 25);
	}
	
}
