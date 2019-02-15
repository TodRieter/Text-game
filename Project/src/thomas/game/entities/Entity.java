package thomas.game.entities;

import thomas.game.GameObject;

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
	public void attack(Entity target){
		if(this.health > 0 && target.health != 0){
		target.health = target.getHealth() - getAttack();
		this.health = getHealth() - target.getAttack();
		System.out.print(toString() + "\n\n" + target.toString() + "\n");
		}
	}
		public void fight(Entity target) {
			if(GameObject.answer.equalsIgnoreCase("fight")){
				
				while(this.health > 0 && GameObject.answer.equalsIgnoreCase("fight")){		
					this.attack(target);
				if(this.health <= 0) {
					GameObject.isAlive = false;
					System.out.println("YOU DIED :(");
					break;
				}else if(target.health > 0) {
					
				GameObject.ask("fight or run");
				
				}else if(target.health <= 0){
					
					System.out.println("The " + target.name + " has been slane!");
					GameObject.location++;
					System.out.println(GameObject.location);
					break;
				}
			}
			}else if(GameObject.answer.equalsIgnoreCase("run")) {
			System.out.println("you run like a coward");
			}
		}
	}
