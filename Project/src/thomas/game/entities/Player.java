package thomas.game.entities;

import java.util.Arrays;
import java.util.Scanner;
import thomas.game.GameObject;
import thomas.game.items.Item;
import thomas.game.items.SwordItem;
import thomas.game.player.Inv;
import thomas.game.player.Inventory;
@SuppressWarnings("unused")
public class Player extends Entity{
	@Override
	public String toString() {
		return "name: " + playerName + "\nhealth: " + health + "\nattack: " + attack + "\narmor: " + armor;
	}
	public Player(){
		super(playerName, 20, 2, 1);	
	}
	Player(String name, int health, int attack, int armor, Item[] inv){

	}

	Item sword = new SwordItem();
	public static Item[] inv = Inventory.inv;
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
	}