package thomas.game.spells;
import thomas.game.enums.*;
import thomas.game.interfaces.IWeaponSpell;
import thomas.game.entities.Entity;
import java.util.HashMap;

public abstract class Spell implements IWeaponSpell{
	public String name;
	public int level;
	public int cost;
	public int attack;
	public Effect effect;
	public int range;
	int timer;
	
	public Spell(String name, int level, int cost, int attack, Effect effect){
		this.name = this.color(level) + name;
		this.level = level;
		this.cost = cost;
		this.attack = attack;
		this.effect = effect;
		Spells.put(this.name, this);
	}
	
	public Spell(){
		System.out.printf("Stats: ", this);
		
	}public void affect(Effect effect, Entity target){
		switch(effect){
		case BACKFIRE: 
			target.health = target.health - this.attack;
			System.out.println(Colors.RED.color + Colors.BOLD.color + "OUCH!" + Colors.RESET.color);
			break;
		case FLAME:
			target.health = target.health - 2;
			timer = effect.time;
			
		default: System.out.println("404 effect was not found");
		}
	}
	public void cast(Entity caster, Entity target){
		 
		if(caster.mana >= this.cost){
			
			caster.mana = caster.mana - this.cost;
			target.health = target.health - this.attack;
			
		 if(this.effect != null){
			affect(effect, caster);
		 }
		 System.out.println(caster + "\n" + target);
		}else if (caster.mana <= this.cost){
			System.out.println("You don't have enough mana!\n" + caster);
		}
	}
	public Colors color(int level){
		switch(level){
		case 1:
			return Colors.BLUE;
		case 2:
			return Colors.GREEN;
		case 3: 
			return Colors.YELLOW;
		default:
		return Colors.WHITE;
		}
	}
	public String name(){
		return color(this.level) + this.name + Colors.RESET;
		
	}
	public static HashMap<String, Spell> Spells = new HashMap<String, Spell>();
}
