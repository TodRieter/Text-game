package thomas.game.entities;

public class Dragon extends Entity{ 
	
	@Override 
	public String toString() {
		return "Dragon [health= " + health + ", attack= " + attack + ", armor= " + armor + ", name= " + name + "]";
	}
	public Dragon(){
	super("Dragon", 10, 8, 10, 50); 
	
	}
	Dragon(String name, int health, int attack, int armor, int mana){
		super(name, health, attack, armor, mana);	
	}
}
