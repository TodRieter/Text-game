package thomas.game.spells;
import thomas.game.enums.*;
import thomas.game.entities.Entity;
import java.util.HashMap;

public abstract class Spell {
	public String name;
	public int cost;
	public int attack;
	public Effect effect;
	public int range;
	
	public Spell(String name, int cost, int attack, Effect effect){
		this.name = name;
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
			System.out.println(Colors.RED.color + Colors.BOLD.color + "OUCH!" + Colors.RESET);
			break;
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
	public static HashMap<String, Spell> Spells = new HashMap<String, Spell>();
}
