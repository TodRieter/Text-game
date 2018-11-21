package thomas.game.enemies;

public abstract class Enemy {
	
	public int health;
	public int attack;
	public int armor;
	public String name;
	public String stats;
	
	public Enemy() {
		
		System.out.printf("Stats: ", this);
		
	}
	
	Enemy(String name, int health, int attack, int armor){
		
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
