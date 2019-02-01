package thomas.game.entities;

public abstract class Entity {
	
	public int health;
	public int attack;
	public int armor;
	public String name;
	public String stats;
	
	public Entity() {
		
		System.out.printf("Stats: ", this);
		
	}
	
	Entity(String name, int health, int attack, int armor){
		
		this.health = health;
		this.armor = armor;
		this.attack = attack;
		this.name = name;
		
	}


	public int getHealth() {
		
		return this.health;
	}
	
public String getStats(){
	
	return stats;
	
}
	public int getAttack() {
		
		return this.attack;
	}
	public void attack(){
		
		health = getHealth() - getAttack();
		
	}
}
