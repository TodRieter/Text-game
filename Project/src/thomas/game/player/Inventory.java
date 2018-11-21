package thomas.game.player;

import thomas.game.GameObject;
import thomas.game.items.Item;

public class Inventory{

	int c;
	Item brass;
	public int slot;
	boolean inInv;
	public Inventory[] inv;
	
	Item item;
	String name;
	int lenght = inv.length;
	boolean isChecking;
	public int itemQ;
	
	public Inventory[] getItem(Item item) {
		
		return this.inv;
	}
	
public void checkInv(Item[] inv2){
		if(GameObject.answer.equals("check inv")) {
			isChecking = true;
		while(c<= lenght){
			System.out.println(inv2[c]);
		}
		}else if(isChecking == true){
			System.out.println("continue? ");
			GameObject.answer= GameObject.in.nextLine();
		}
}
	int checkForNull(Inventory inv[]){
		while(c<2 && inv[slot] != null){
			
			if(inv[slot]==null) {
			
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
	
			
			
	}else if(item.inInv ==  true && slot < inv.length){
		
			item.quantity++;
			System.out.println("you picked up: " + item.toString());
			
		}else if(slot < inv.length){
			
			item.inInv = true;
			inv[slot] = this;
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