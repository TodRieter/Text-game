package thomas.game.items;

public class Empty extends Item {
	
	@Override
	public String toString() {
		return "Empty name=" + name;
	}

	public Empty(){
	super("empty", 0, true);
	
	}
}
