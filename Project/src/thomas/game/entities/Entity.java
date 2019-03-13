package thomas.game.entities;
import thomas.game.GameObject;
import thomas.game.enums.Colors;
import thomas.game.enums.Effect;
import thomas.game.enums.Rarity;
import thomas.game.spells.Spell;

import java.util.Arrays;
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
	
	Entity(String name, int health, int attack, int armor, int mana, Rarity rareness){
		
		this.health = health;
		this.armor = armor;
		this.attack = attack;	
		this.mana = mana;
		this.rareness = rareness;
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
	public String name(){
		return (char)27 + rareness.code() + name + (char)27 + Colors.RESET.color;
	}
	public void attack(Entity target){
		if(this.health > 0 && target.health != 0){
		target.health = target.getHealth() - getAttack();
		this.health = getHealth() - target.getAttack();
		System.out.print(toString() + "\n\n" + target.toString() + "\n"); 
		}
	}
	
	public void fight(Entity target) {
		
			GameObject.ask("test number 75 You have encountered a " + target.name() + " do you?\n slash, cast, run or freeze(not recommended but you have the option!)");
			//System.out.println((char)27 + "[31m" + "ERROR MESSAGE IN RED");
			if(GameObject.answer.equalsIgnoreCase("Attack") || GameObject.answer.equalsIgnoreCase("cast")){
				while(this.health > 0 && ! GameObject.answer.equalsIgnoreCase("run")){
					if(GameObject.answer.equalsIgnoreCase("slash")){
					this.attack(target);
					} else if(GameObject.answer.toLowerCase().contains("cast")){
						if(GameObject.answer.equalsIgnoreCase("cast")){
						GameObject.ask("What Spell Would you like to cast?\n" + GameObject.player.spellList()+ "\n");
						}
							 String[] splitAnswer = GameObject.answer.split(" ");
							
							 String spellName = formatName(splitAnswer[1]);
							 
							 String targetName = formatName(splitAnswer[splitAnswer.length-1]);
							
							 
							 if(!targetName.equals(target.name)){
								 System.out.println("error 404 enemy not found... if you actually saw " + target.name() + " please consult a your mental health doctor");
							 }else {
							 for(int x = 0; GameObject.player.spellList.size() > x;){

								 if(GameObject.player.spellList.get(x).name.equals(spellName)){
									 Spell.Spells.get(spellName).cast(GameObject.player, Entity.Entities.get(targetName));
									 break;
								 }
								 if(x == GameObject.player.spellList.size()-1) {
									 System.out.println("you don't have that spell! (or it doesn't exist outside of the platonic relm)");
								 }
								 x++;
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
					
					System.out.println("The " + target.name() + " has been slane!");
					GameObject.location++;
					System.out.println(GameObject.location);
					break;
				}
			}
			}else if(GameObject.answer.equalsIgnoreCase("run")) {
			System.out.println("you run like a coward");
			}
		}
		public String formatName(String name){
			String firstLetter = name.substring(0,1).toUpperCase();
			String rest = name.substring(1, name.length()).toLowerCase();
			String formatedName = firstLetter + rest;
			return formatedName;
		}
		
}
