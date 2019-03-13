package thomas.game;

//import java.util.ArrayList;

import java.util.Scanner;
import thomas.game.entities.*;
import thomas.game.items.*;
import thomas.game.spells.*;
import thomas.game.spells.melee.Boomhands;
import thomas.game.weapons.FireSword;
import thomas.game.weapons.Weapon;


public class GameObject {

	public static int location;
	Entity dragon = new Dragon();
	Item sword = new SwordItem();
	public static Scanner in = new Scanner(System.in);
	public static Player player = new Player();
	public static String answer;
	String question;
	public static boolean isAlive;

	public void run() {
		
		ask("Greetings Would You like to play a game of >>Generic Adventure<< ?" + "\n type yes or no");
		player.setPlayerName();

isAlive = true;
		while (isAlive == true) {

			switch (location) {
			case 0:
				//location = 1;
				Entity dragon  = new Dragon();
				System.out.println(dragon);
				Weapon fireSword = new FireSword();
				ask("would you like to pick up a " + fireSword.name());
				
				
				answer = "yes";

				if (answer.equalsIgnoreCase("yes")) {

					player.pickUp(fireSword.item);
					Spell BoomHands = new Boomhands();
					player.learnSpell(BoomHands);
				ask("You learned BoomHands to look at your list of spells type spell list ");

				} else if(answer.equalsIgnoreCase("no")) {
					System.out.println("you decide to not pick up the sword");
				}
				location = 1;
				break;

			case 1:
				Entity blob = new Blob();
				System.out.print("you enter a dark hallway and see a amorphus " + blob.name() + "\n");
					player.fight(blob);
				if(answer.equalsIgnoreCase("run")) {
				System.out.println("you run like a coward");
				location = 3;
				}
				break;
			case 2:
				System.out.println("This game is unfinished!!");
				isAlive =false;
				break;
			case 3:
				ask("this is game is unfinished!");
				 //System.out.println(dragon);
				break;
			case 4:
				ask("this is game is unfinished!");
				break;
			default:
				isAlive = false;
				break;



			}
		}
	}

	public static void ask(String question) {

		System.out.println(question);
		answer = in.nextLine();
		if(answer.equalsIgnoreCase("check inv")) {
	System.out.print(player.inv);
		} else if(answer.equalsIgnoreCase("check inv")) {
	System.out.print(player.inv);
		}else if(answer.equalsIgnoreCase("Stats")) {
			System.out.println(player);
		}else if(answer.equalsIgnoreCase("spell List")){
			System.out.print(player.spellList());
		}
	}
	
		


	}

