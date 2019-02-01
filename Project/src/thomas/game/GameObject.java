package thomas.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import thomas.game.entities.Blob;
import thomas.game.entities.Dragon;
import thomas.game.entities.Entity;
import thomas.game.entities.Player;
import thomas.game.items.Empty;
import thomas.game.items.Item;
import thomas.game.items.SwordItem;
import thomas.game.player.Inv;
import thomas.game.player.Inventory;

public class GameObject {

	public static int location = 1;
	Entity dragon = new Dragon();
	Item sword = new SwordItem();
	public static Scanner in = new Scanner(System.in);
	Player player = new Player();
	public static String answer;
	String question;
	public static boolean isAlive;

	public void run() {
		player.setPlayerName();

		while (isAlive == true) {

			switch (location) {
			case 0:

				ask(in, "would you like to pick up a sword? ");

				if (answer.equalsIgnoreCase("yes")) {

					player.pickUp(sword);
					player.pickUp(sword);
					player.pickUp(sword);
					player.pickUp(sword);
					player.pickUp(sword);
					player.pickUp(sword); 

				} else if(answer.equalsIgnoreCase("no")) {
					System.out.println("you decide to not pick up the sword");
				}
				ask(in, "would you like to check you inv?");
				location = 1;
				break;

			case 1:
				System.out.print(Arrays.toString(Player.inv));
				location =2;
				break;
			case 2: 
				Entity blob = new Blob();
				ask(in,"you enter a dark hallway and see a amorphus blob do you\n fight, run like a coward or freeze(not recommended)");
				if(answer.equalsIgnoreCase("fight")) 
				{while(player.health > 0){
					
				}
				}else if(answer.equalsIgnoreCase("run")) {
				System.out.println("you run like a coward");
				location = 4;
				}
				break;
			case 3:
				ask(in,"this is game is unfinished!");
				 System.out.println(dragon);
				break;
			case 4:
				ask(in,"this is game is unfinished!");
				break;
			default:
				isAlive = false;
				break;



			}
		}
	}

	void ask(Scanner in, String question) {

		this.question = question;
		System.out.println(this.question);
		answer = in.nextLine();
		if(answer.equalsIgnoreCase("check inv")) {
	System.out.print(Arrays.toString(Player.inv));
		} else if(answer.equalsIgnoreCase("check inv 0")) {
	System.out.print(Player.inv[0]);
		} else if(answer.equalsIgnoreCase("drop 0")) {
			Item empty = new Empty();
	Player.inv[0] = empty;
		}else if(answer.equalsIgnoreCase("Stats")) {
			System.out.println(player);
		}
	}
	
		


	}

