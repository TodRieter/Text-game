package thomas.game.entities;

import thomas.game.GameObject;
import thomas.game.spells.Spell;

import java.util.Arrays;
import java.util.HashMap;

public abstract class Entity {
	
	public int health;
	public int attack;
	public int armor;
	public String name;
	public String stats;
	public int mana;
	
	public Entity() {
		
		System.out.printf("Stats: ", this);
		
	}
	
	Entity(String name, int health, int attack, int armor, int mana){
		
		this.health = health;
		this.armor = armor;
		this.attack = attack;
		this.name = name;
		this.mana = mana;
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
	public void attack(Entity target){
		if(this.health > 0 && target.health != 0){
		target.health = target.getHealth() - getAttack();
		this.health = getHealth() - target.getAttack();
		System.out.print(toString() + "\n\n" + target.toString() + "\n"); 
		}
	}
		public void fight(Entity target) {
			if(GameObject.answer.equalsIgnoreCase("Attack") || GameObject.answer.equalsIgnoreCase("cast")){
				while(this.health > 0 && ! GameObject.answer.equalsIgnoreCase("run")){
					if(GameObject.answer.equalsIgnoreCase("attack")){
					this.attack(target);
					} else if(GameObject.answer.equalsIgnoreCase("Cast")) {
						GameObject.ask("What Spell Would you like to cast?\n" + GameObject.player.spellList());
						 if (GameObject.answer.toLowerCase().contains("cast")){
							 String[] splitAnswer = GameObject.answer.split(" ");
							 System.out.println(Arrays.toString(splitAnswer));
							 String spellName = splitAnswer[1];
							 if(splitAnswer.length == 4) {
							 String targetName = splitAnswer[splitAnswer.length-1];
							 for(int x = 0; GameObject.player.spellList.size() > x;){
								 if(GameObject.player.spellList.get(x).name.equals(spellName)){
									 Spell.Spells.get(spellName).cast(GameObject.player, Entity.Entities.get(targetName));
									 break;
								 }
								 x++;
							 }
							}
						}
					}
				if(this.health <= 0) {
					GameObject.isAlive = false;
					System.out.println("YOU DIED :(");
					break;
				}else if(target.health > 0) {
					
				GameObject.ask("Attack, Cast or run");
				
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
