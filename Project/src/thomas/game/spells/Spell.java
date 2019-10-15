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
	public String flavor;
	
	public Spell(String name, int level, int cost, int attack, Effect effect, String flavor){
		this.name = name;
		this.level = level;
		this.cost = cost;
		this.attack = attack;
		this.effect = effect;
		this.flavor = flavor;
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
	
	public String color(int level){
		switch(level){
		case 1:
			return (char)27 + Colors.BLUE.color;
		case 2:
			return (char)27 + Colors.GREEN.color;
		case 3: 
			return (char)27 + Colors.YELLOW.color;
		default:
		return (char)27 + Colors.WHITE.color;
		}
	}
	public String toString(){
		return this.name;
	}
	public String name(){
		return color(this.level) + this.name + Colors.RESET.color + "";
	}
	public String getFlavor(){
		return this.flavor;
	}
	public String getInfo(){
		return "Spell: " + color(level) + this.name + (char)27 + Colors.RESET.color + " Mana cost: " + cost + " Attack: " + attack + " Effect: " + effect;

	}
	public static HashMap<String, Spell> Spells = new HashMap<String, Spell>();
}
