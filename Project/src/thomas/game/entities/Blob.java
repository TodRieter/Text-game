package thomas.game.entities;

public class Blob extends Entity {
	
	@Override
	public String toString(){
		return "Blob [health= " + health + ", attack= " + attack + ", armor= " + armor + ", name= "+ name + "]";
	}
	public Blob() {
	super("Blob", 10, 1, 0);
	}
}
