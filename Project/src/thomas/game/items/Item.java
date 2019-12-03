package thomas.game.items;

import thomas.game.enums.Colors;
import thomas.game.enums.Rarity;

public class Item {
	

	public String name;
	public int quantity;
	public boolean inInv = false;
	
public Item() {
		
		
	}
	
	public Item(String name, boolean inInv) {
		
		this.name = name;
		this.inInv = inInv;
			
		}
	public String toString() {
		return this.name + this.inInv;
	}
	//@Override
//	public boolean equals(Object item) {
//
//		return this.toString().equals(item.toString());
//
//		
//	}
	
}


