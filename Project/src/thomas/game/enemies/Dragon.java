package thomas.game.enemies;

public class Dragon extends Enemy{
	
	@Override
	public String toString() {
		return "Dragon [health=" + health + ", attack=" + attack + ", armor=" + armor + ", name=" + name + "]";
	}
	public Dragon(){
	super("Dragon", 10, 8, 10);
	
	}
	Dragon(String name, int health, int attack, int armor){
		super(name, health, attack, armor);	
	}
}
