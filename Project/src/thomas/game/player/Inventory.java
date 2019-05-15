package thomas.game.player;

import java.util.ArrayList;
import java.util.Arrays;

import thomas.game.GameObject;

import thomas.game.items.Item;

public class Inventory{

	int c;
	Item brass;
	public int slot;
	boolean inInv;
	public static ArrayList<Item> inv;
	
	Item item;
	String name;
	int size = inv.size();
	int maxSize = 10;
	boolean isChecking;
	public int itemQ;
	 
	public Item getItem(Item item) {
		
		return this.item;
	}
	

	/*int checkForNull(Item inv[]){
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
	*/
	public void pickUp(Item item) {
		
		if(size < maxSize){
			inv.add(item);
		}else if(size == maxSize) {
			
			System.out.println("Your backpack is full! you did not pick up: " + item.name);
		}
		
		item.toString();
	}
	
}