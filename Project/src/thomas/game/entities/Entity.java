package thomas.game.entities;
import thomas.game.GameObject;
import thomas.game.enums.Colors;
import thomas.game.enums.Rarity;
import thomas.game.spells.Spell;
import java.util.HashMap;


public abstract class Entity{
	
	public int health;
	public int attack;
	public int armor;
	public String name;
	public String stats;
	public int mana;
	public Rarity rareness;
	
	public Entity() {
		
		System.out.printf("Stats: ", this);
		
	}
	
	Entity(String name, int health, int attack, int armor, int mana){
		
		this.health = health;
		this.armor = armor;
		this.attack = attack;	
		this.mana = mana;
		
		this.name = name;
		Entities.put(this.name, this);
		
	}
	

public static HashMap<String, Entity> Entities = new HashMap<String, Entity>();
public int getHealth() {
		
		return this.health;
	}
public int getMana() {
	return this.mana;
}
	
public String getStats(){
	
	return stats;
	
}
	public int getAttack() {
		
		return this.attack;
	}
//	public String name(){
//		return (char)27 + rareness.code() + name + (char)27 + Colors.RESET.color;
//	}
	
	
	
		
}
