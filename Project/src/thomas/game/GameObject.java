package thomas.game;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import thomas.game.entities.Blob;
import thomas.game.entities.Dragon;
import thomas.game.entities.Entity;
import thomas.game.entities.Player;
import thomas.game.items.Empty;
import thomas.game.items.Item;
import thomas.game.items.SwordItem;
import thomas.game.spells.Spell;
import thomas.game.spells.melee.BoomHands;


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
		//player.setPlayerName();
player.name = "Thomas";
isAlive = true;
		while (isAlive == true) {

			switch (location) {
			case 0:
				//location = 1;
				ask("would you like to pick up a sword? ");
				answer = "yes";

				if (answer.equalsIgnoreCase("yes")) {

					player.pickUp(sword);
					Spell BoomHands = new BoomHands();
					player.learnSpell(BoomHands);
				ask("You learned BoomHands to look at your list of spells type spell list ");
				

				} else if(answer.equalsIgnoreCase("no")) {
					System.out.println("you decide to not pick up the sword");
				}
				location = 1;
				break;

			case 1:
				Entity blob = new Blob();
				ask("you enter a dark hallway and see a amorphus blob do you\n fight, run like a coward or freeze(not recommended)");
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
				 System.out.println(dragon);
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

