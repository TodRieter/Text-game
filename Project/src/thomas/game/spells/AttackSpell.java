package thomas.game.spells;
import thomas.game.enums.*;
import thomas.game.GameObject;
import thomas.game.entities.Entity;
import java.util.HashMap;

public abstract class AttackSpell extends Spell{
	
	private int attack;
	int modifier = 0;
	public AttackSpell(String name, String flavor, int level, int cost, int attack, int modifier){
		super(name, flavor, level, cost);
		this.setAttack(attack);
		this.modifier = modifier;
		Spells.put(this.name, this);
	}
	
	public AttackSpell(){
		super();
		System.out.printf("Stats: ", this);
	}
//	}public void affect(Effect effect, Entity target){
//		switch(effect){
//		case BACKFIRE: 
//			target.setHealth(target.getHealth() - this.effect.getAttack());
//			System.out.println(Colors.RED.color + Colors.BOLD.color + "OUCH!" + Colors.RESET.color);
//			break;
//		case FLAME:
//			target.setHealth(target.getHealth() - effect.getAttack());
//			break;
////		case HEAL:
////			if(target.getHealth() + this.getAttack() >= target.getMaxHealth()) {
////				target.setHealth(target.getMaxHealth());
////			}
////			target.setHealth(target.getHealth() + this.getAttack());
////			break;
//		default: System.out.println("404 effect was not found");
//		}
//	}
	

	public AttackSpell(String name, String flavor, int level, int cost, int attack) {
		super(name, flavor, level, cost);
		this.setAttack(attack);
	}

	@Override
	public void affect(Entity target) {
		target.setHealth(target.getHealth()-this.getAttack());
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}
}
