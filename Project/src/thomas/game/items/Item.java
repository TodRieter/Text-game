package thomas.game.items;

import thomas.game.enums.Colors;
import thomas.game.enums.Rarity;

public abstract class Item {
	

	public String name;
	public int quantity;
	public boolean inInv = false;
	public String info;
	public Rarity rareness;
	
public Item() {
		
		System.out.printf("Stats: ", this);
		
	}
	
	public Item(String name, int quantity, boolean inInv, String info, Rarity rareness) {
		
		this.name = name;
		this.quantity = quantity;
		this.inInv = inInv;
		this.info = info;
		this.rareness = rareness;
			
		}
	
	
	String name(){
		
		return this.rareness.code() + name + Colors.RESET.color;
		
		}
	

	@Override
	public String toString() {
		return name() + "(" + quantity +  ")";
	}
	
}


