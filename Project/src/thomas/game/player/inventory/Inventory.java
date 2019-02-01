package thomas.game.player.inventory;

import java.util.Arrays;

import thomas.game.GameObject;
import thomas.game.items.Empty;
import thomas.game.items.Item;

public class Inventory{

	int c;
	Item brass;
	public int slot;
	boolean inInv;
	static Item empty = new Empty();
	public static Item[] inv = {empty,empty,empty,empty,empty};
	
	Item item;
	String name;
	int length = inv.length;
	boolean isChecking;
	public int itemQ;
	 
	public Item getItem(Item item) {
		
		return this.item;
	}
	
public void checkInv(Item[] inv){
		if(GameObject.answer.equals("check inv")) {
			isChecking = true;
			Arrays.toString(inv);
		}else if(isChecking == true){
			System.out.println("continue? ");
			GameObject.answer= GameObject.in.nextLine();
		}

}
	int checkForNull(Item inv[]){
		while(c<2 && inv[slot] != null){
			
			if(inv[slot]==null) {
				return slot;
			
			}else if(slot<inv.length) {
				
				slot++;
			} else if(slot>inv.length && c<1) {
				
				slot = 0;
			}
			
		}
		return slot;
		
	}
	public void pickUp(Item item) {
		
		if(item.inInv !=  true && slot < inv.length && inv[slot] == null){ 
	
			inv[slot] = item;  
			
	}else if(item.inInv ==  true && slot < inv.length){
		
			item.quantity++;
			System.out.println("you picked up: " + item.toString());
			
		}else if(slot < inv.length){
			
			item.inInv = true;
			inv[slot] = this.item;
			System.out.println("you picked up: " + item.toString());
			slot++; 
			
		}else if(slot >= inv.length) {
			
			System.out.println("Your backpack is full! you did not pick up: " + item.name);
		}
		
		item.toString();
	}
	public void dropItem(Item item) {
		if(GameObject.answer.equals("drop"+ item)) {
		if(item.quantity > 1){
			
			item.quantity--;
			
		}else {
		item.inInv = false;
		inv[slot] = null;
		slot--;
			}
		}
	}
}