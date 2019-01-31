package thomas.game.player;

import java.util.Arrays;
import java.util.Scanner;
import thomas.game.GameObject;
import thomas.game.items.Item;
import thomas.game.items.Sword;
import thomas.game.player.Inventory;
@SuppressWarnings("unused")
public class Player implements Inv{
	Item sword = new Sword();
	public Item[] inv = Inventory.inv;
	boolean isChecking;
		int location;
		int c = 0;
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
		public void pickUp(Item item) {
			
			if(item.inInv !=  true && c < inv.length && inv[c] == Inventory.empty){ 
				item.inInv = true;
				inv[c] = item;
				System.out.println("you picked up: " + item.toString());
				
		}else if(item.inInv ==  true && c < inv.length){
			
				item.quantity++;
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

	public String toString(Inventory inv2) {
		return "Player [inv=" + toString(inv2) + ", c=" + c + "]";
		}



	@Override
	public void checkInv(Item[] inv) {
		// TODO Auto-generated method stub
		
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
	public Item[] getItem(Item item) {
		// TODO Auto-generated method stub
		return null;
	}
	}