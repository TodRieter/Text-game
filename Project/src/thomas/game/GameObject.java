package thomas.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import thomas.game.enemies.Dragon;
import thomas.game.enemies.Enemy;
import thomas.game.items.Item;
import thomas.game.items.Sword;
import thomas.game.player.Inv;
import thomas.game.player.Inventory;
import thomas.game.player.Player;

public class GameObject {

	public static int location = 1;
	Enemy dragon = new Dragon();
	Item sword = new Sword();
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
				System.out.print(Arrays.toString(player.inv));
				location = -1;
				break;

			default:
				isAlive = false;
				break;

			// System.out.println(dragon);

			}
		}
	}

	void ask(Scanner in, String question) {

		this.question = question;
		System.out.println(this.question);
		answer = in.nextLine();
		if(answer.equalsIgnoreCase("check inv")) {
	System.out.print(Arrays.toString(player.inv));
		}
	}
	
		


	}

