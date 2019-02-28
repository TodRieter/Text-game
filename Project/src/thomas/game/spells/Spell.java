package thomas.game.spells;

import thomas.game.entities.Entity;
import thomas.game.entities.Player;
import java.util.HashMap;

public abstract class Spell {
	public String name;
	public int cost;
	public int attack;
	public String effect;
	public int range;
	
	public Spell(String name, int cost, int attack, String effect){
		this.name = name;
		this.cost = cost;
		this.attack = attack;
		this.effect = effect;
		Spells.put(name, this);
	}
	
	public Spell(){
		System.out.printf("Stats: ", this);
	}
	public void cast(Entity caster, Entity target){
		 
		if(caster.mana >= this.cost){
			
			caster.mana = caster.mana - this.cost;
			target.health = target.health - this.attack;
			
		 if(this.effect.equalsIgnoreCase("backfire")){
			caster.health = caster.health - this.attack;
			System.out.println("OUCH!");
		}
		 System.out.println(caster + "\n" + target);
		}else if (caster.mana <= this.cost){
			System.out.println("You don't have enough mana!\n" + caster);
		}
	}
	public static HashMap<String, Spell> Spells = new HashMap<String, Spell>();

}
