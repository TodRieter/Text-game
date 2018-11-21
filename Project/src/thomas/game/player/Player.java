package thomas.game.player;

import java.util.Arrays;
import java.util.Scanner;
import thomas.game.GameObject;
import thomas.game.items.Item; 
import thomas.game.player.Inventory;
public class Player implements Inv{
	Inventory[] inv = new Inventory[5];
	boolean isChecking;
		int location;
		int c;
public static String playerName;
	String yes = "yes";
	Scanner p = new Scanner(System.in);
	public void setPlayerName(){
		
		System.out.println("What is your Name?");
		@SuppressWarnings("resource")
		final Scanner sc = new Scanner(System.in);
		playerName = sc.nextLine();
		System.out.println("You are " + playerName +" correct?");
		//GameObject.in.nextLine();
		GameObject.answer = GameObject.in.nextLine();
		System.out.println(GameObject.answer);
		if(GameObject.answer.equalsIgnoreCase(yes)){
		GameObject.isAlive = true;
		System.out.println("alive");
		GameObject.location = 0;
		}else if(GameObject.answer != "yes"){
			System.out.println(GameObject.answer);
		}
		
	}
	

	
	 public static String getPlayerName(){
		 
		 return playerName;
	 }
		public void pickUp(Inventory item) {
			
			if(item.inInv !=  true && c < inv.length && this.inv[c] == null){ 
				item.inInv = true;
				System.out.println("you picked up: " + item.toString());
				
		}else if(item.inInv ==  true && c < inv.length){
			
				item.itemQ++;
				System.out.println("you picked up: " + item.toString());
				
			}else if(c < inv.length){
				
				item.inInv = true;
				inv[c] = item;
				System.out.println("you picked up: " + item.toString());
				c++; 
				
			}else if(c >= inv.length) {
				
				System.out.println("Your backpack is full! you did not pick up: ");
			}
			
			item.toString();
		}

	@Override
	public Item[] getItem(Item item) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void checkInv(Inventory[] inv2){
		
			isChecking = true;
		while(c<= inv2.length){
			
			System.out.println(toString(inv2));
			c++;
		}
			if(isChecking == true){
			System.out.println("continue? ");
			GameObject.answer= GameObject.in.nextLine();
		
		}
}



	public String toString(Inventory[] inv2) {
		return "Player [inv=" + toString(inv2[c]) + ", c=" + c + "]";
	}



	@Override
	public void dropItem(Item item) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public String toString(Item inv) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void pickUp(Item item) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void checkInv(Item[] inv) {
		// TODO Auto-generated method stub
		
	}

}
