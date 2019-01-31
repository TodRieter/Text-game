package thomas.game.items;



public class Sword extends Item {
	
	@Override
	public String toString() {
		return "Sword [name=" + name + ", quantity=" + quantity + "]";
	}

	public Sword(){
	super("sword", 1, false);
	
	}

}
	
	

