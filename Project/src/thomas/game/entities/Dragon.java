package thomas.game.entities;

import thomas.game.enums.Rarity;

public class Dragon extends Entity{ 

	@Override 
	public String toString() {
		return name() + "[health= " + health + ", attack= " + attack + ", armor= " + armor + "]";
	}
	public Dragon(){
	super("Dragon", 10, 8, 10, 50, Rarity.UBERRARE); 
	}
	Dragon(String name, int health, int attack, int armor, int mana, Rarity rareness){
		super(name, health, attack, armor, mana, rareness);	
	}
}
