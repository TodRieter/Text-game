package thomas.game.entities;

public class Blob extends Entity {
	
	@Override
	public String toString(){
		return "\nBlob \nhealth: " + health + ", \nattack: " + attack + ", \narmor: " + armor + ", \nname: "+ name;
	}
	public Blob() {
	super("Blob", 10, 1, 0);
	}
}
