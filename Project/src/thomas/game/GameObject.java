package thomas.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

//import java.util.ArrayList;

import java.util.Scanner;

import thomas.game.entities.Blob;
import thomas.game.entities.Dragon;
import thomas.game.entities.Entity;
import thomas.game.entities.Player;
import thomas.game.spells.Boomhands;
import thomas.game.spells.LesserHealing;
import thomas.game.spells.MageArmor;
import thomas.game.spells.Spell;
import thomas.game.weapons.FireSword;
import thomas.game.weapons.Sword;
import thomas.game.weapons.Weapon;

public class GameObject {
	
	public static GameObject g = new GameObject();
	public static int location = 0;
	public static HashMap<Integer,ArrayList<Integer>> tree = new HashMap<>();
	public static HashMap<Integer, GameState> gameStates = new HashMap<>();
	public static Scanner in = new Scanner(System.in);
	public static Player player = new Player();
	public static String answer = "null String";
	String question;
	public static boolean isAlive = true;
	public static Entity enemy;
	public static GameGUI gameGui;

	public void run() {

		gameGui = new GameGUI();

		// System.out.println("GameObject" + gG.p.spellList);

		// ask("Greetings Would You like to play a game of >>Generic Adventure<< ?" +
		// "\n type yes or no");
		// player.setPlayerName();

		// gG.gameArea.setText("This is a test");

		while (isAlive == true) {

			switch (location) {

			case 0:
				// setLocation( 1;
				ask("Greetings Would You like to play a game of >>Generic Adventure<< ?", "yes", "yes", "yes", "yes");

				// ask("would you like to pick up a " + fireSword.name());

				if (answer.equals("yes")) {
					answer = "reset";
					ask("you wake up on what appeares to be a space ship with no memory of who you are or how you got into space.\n you realize instantly that this will not be a generic adventure... or will it?\nyou look around and see a white door that looks space agey, "
							+ "a bed, a book shelf, and a grate. Do you?", "go to the door", "go to the bed",
							"check the bookshelf", "look into the grate");

					if (answer.equals("go to the door")) {
						setLocation(2);
					}
					if (answer.equals("check the bookshelf")) {
						setLocation(3);
					}
					if (answer.equals("go to the bed")) {
						setLocation(4);
					}
					if (answer.equals("look into the grate")) {
						setLocation(1);
					} else if (answer.equals("reset")) {
						continue;
					}
				}
				break;

			case 1:
				System.out.println("test 3");
				enemy = new Blob();
				display("you go to the grate and realize that there seems to be somekind of concrete sewere system on this ship (thats odd) and against you better judgement\n "
						+ "you climb down and enter a dark hallway and see a amorphus blob\n" + enemy);
				player.addEnemy(enemy);
				fight(player, enemy);
//				if(answer.equalsIgnoreCase("run")) {
//					display("you run like a coward");
//					setLocation( -1;
//				}
				setLocation(5);
				break;
			case 2:
				ask("you go to the door and realize that it is locked and has a keypad you try punching in 0000, 1234, 4321, 3141\n "
						+ "and then realize you have no idea if it is even a four digit passcode and that you should probably find the code before you set off the...\n "
						+ "you hear a sound that sounds like a mixture of a air horn, a tornado siren, and elephant that is dying in the desert next to a camel that got stuck in the sand.\n"
						+ " Well the alarm has been sounded (and apparently it has a sense of dramatic timing) do you?",
						"pretend it wasn't you", "go to the bookshelf", "go to the bed", "checkout the grate");
				if (answer.equals("go to the bookshelf")) {
					setLocation(3);
				}
				if (answer.equals("pretend it wasn't you")) {
					setLocation(7);
				}
				if (answer.equals("go to the bed")) {
					setLocation(4);
				}
				if (answer.equals("checkout the grate")) {
					setLocation(1);
				}
				break;
			case 3:
				System.out.println(location);
				ask("you start pulling random books out of the bookshelf and throw them around the room hoping that this is a bookshelf that is like one from\n "
						+ "a book or movie and that if you pull the right book it will open up a secret passage way\n "
						+ "and finally it appears that it is! the bookshelf swings open and reveals a door with a sign on it that reads:\n"
						+ " \"this game is unfinished if you choose to go through this door you will be able to get a preview of the mechanics of combat in this game\" do you?",
						"yes I want a to preview the combat system!", "nah its probably not balanced yet", "", "");
				if (answer.equals("yes I want a to preview the combat system!")) {
					setLocation(6);
				}
				break;
			case 4:
				display("you go to the bed. At first you considered taking a nap but you feel something cold sharp it feels like a knife\n "
						+ "but it's a bit too big its more like a sword. You stand up and on closer examination it isn't like a sword, it is a sword!\n "
						+ "you picked up a boring normal sword.");
				Weapon sword = new Sword();
				pickUp(sword);
				ask("you look around the room and realize that this is a demo,\n"
						+ " and that you should probably explore either the book shelf or the grate or the door. do you",
						"go to the bookshelf", "go to the grate", "go to the door",
						"HA im a rebel im going to take a nap!");

				if (answer.equals("go to the bookshelf")) {
					setLocation(3);
				}
				if (answer.equals("go to the grate")) {
					setLocation(1);
				}
				if (answer.equals("go to the door")) {
					setLocation(2);
				}
				if (answer.equals("HA im a rebel im going to take a nap!")) {
					setLocation(8);
				}
				break;
			case 5:
				gameGui.gameArea.setText("");
				display("this is game is unfinished!");
				if (answer.equals("continue")) {

				}
				break;
			case 6:
				Weapon fireSword = new FireSword();
				Spell boomHands = new Boomhands();
				Spell lesserHealing = new LesserHealing();
				pickUp(fireSword);
				player.learnSpell(boomHands);
				player.learnSpell(lesserHealing);
				player.learnSpell(new MageArmor());
				enemy = new Dragon();
				player.addEnemy(enemy);
				GameObject.g.setEnemy(enemy);
				gameGui.getEnemyBox().setSelectedItem(enemy);
				
				
				fight(player, enemy);
				if (answer.equals("run")) {
					display("you run like a coward");
					setLocation(5);
				}
				if (answer.equals("freeze")) {
					player.setHealth(0);
					display("YOU DIED :(\n I told you it freezing was a bad idea!");
					isAlive = false;
				}
				setLocation(5);
				break;
			case 7:
				ask("Who are you trying to convince?", "yourself", "the people who are not there",
						"three people me, myself, and I", "my doctor");
				setLocation(5);
			case 8:
				display("you try to take a nap but you sense and explosion...***BOOM*** and then it happens and the bed is destroyed and you sense "
						+ "a new power welling up within you");
				Spell bh = new Boomhands();
				player.learnSpell(bh);
			default:
				display("you're not supposed to be here the game isn't finished\n"
						+ " and unfortunally the developer was too lazy to send you back where you are supposed to be so... IDK LOL JSLFKJ LF");
				isAlive = false;
				break;

			}
		}
	}

	private void pickUp(Weapon weapon) {
//		ArrayList<Weapon> weaponList = player.getWeaponList();
//		int maxSize = 10;
//		int size = weaponList.size();
//		if (weaponList.size() < maxSize && !weaponList.contains(weapon)) {
//			weaponList.add(weapon);
//			gameGui.update();
//			display("you picked up: " + weaponList.get(weaponList.indexOf(weapon)));
//
//		} else if (weaponList.size() < maxSize && weaponList.contains(weapon)) {

			// item.quantity++;
			player.getWeaponList().add(weapon);
			gameGui.update();
			display("you picked up: " + weapon);

//		} else if (size == maxSize) {
//
//			display("Your backpack is full! you did not pick up: " + weapon.name);
//		}
//
//		display(weapon.toString());
//		player.getWeaponList().add(Weapon.weapons.get(weapon.name));

	}

	public void display(String text) {
		ask(text, "continue", "", "", "");
	}

//	private void cast(Entity caster, Entity target, Spell spell) {
//
//		if (caster.getMana() >= spell.getCost()) {
//			if (spell.getEffect().equals(Effect.HEAL)) {
//				caster.setMana(caster.getMana() - spell.getCost());
//				target.setHealth(target.getHealth() - spell.getAttack());
//				display(spell.getFlavor());
//				updatePlayerInfo();
//				if (spell.getEffect() != null) {
//					spell.affect(spell.getEffect(), caster);
//				}
//				display(caster + "\n" + target);
//			} else if (caster.getMana() <= spell.getCost()) {
//				display("You don't have enough mana!\n" + caster);
//			}
//		}
//	}

	private void updatePlayerInfo() {
		gameGui.updatePlayerInfo();
		
	}

	

	private void ask(String question, String a1, String a2, String a3, String a4) {
		answer = "reset";
		gameGui.gameArea.setText(question);
		gameGui.setOptions(a1, a2, a3, a4);
		while (answer.equals("reset")) {
			System.out.print("");
		}
	}

	public void fight(Entity attacker, Entity defender) {

		ask("You have encountered a " + defender.getName(), "strike", "cast", "run",
				"freeze(not recommended but you have the option!)");
		// System.out.println((char)27 + "[31m" + "ERROR MESSAGE IN RED");
		if (answer.equalsIgnoreCase("Strike") || answer.equalsIgnoreCase("cast")) {
			while (attacker.getHealth() > 0 && !answer.equalsIgnoreCase("run")) {
				gameGui.update();
				if (answer.equalsIgnoreCase("strike")) {
					attacker.attack(defender);
				} else if (answer.toLowerCase().contains("cast")) {
					if (answer.equalsIgnoreCase("cast") && attacker.getSpellList().size() > 0
							&& (Spell) gameGui.getSpellBox().getSelectedItem() != null) {
						Spell spell =  (Spell) gameGui.getSpellBox().getSelectedItem();
						attacker.cast(defender, spell);
					}
				}
				
				gameGui.update();
				if (attacker.getHealth() <= 0) {
					isAlive = false;
					display("YOU DIED :(");
					break;
				} else if (defender.getHealth() > 0) {
					GameState play = g.makeAMove();
					if(play.getMove().equals("cast")) {
						play.getEnemy().getSelectedSpell().cast(player);
					}else {
						play.getEnemy().getSelectedWeapon().attack(play.getEnemy(),player);

					}
					attacker.triggerStatusEffects();
					defender.triggerStatusEffects();
					gameGui.update();
//					attacker.setHealth(nextGameState.isPlayerTurn ? nextGameState.getPlayer().getHealth() : nextGameState.getEnemy().getHealth());
//					defender.setHealth( nextGameState.isPlayerTurn ? nextGameState.getPlayer().getHealth() : nextGameState.getEnemy().getHealth());
//					attacker.setMana(nextGameState.isPlayerTurn ? nextGameState.getPlayer().getMana() : nextGameState.getEnemy().getMana());
//					defender.setMana(nextGameState.isPlayerTurn ? nextGameState.getPlayer().getMana() : nextGameState.getEnemy().getMana());
					
					ask(defender.toString(), "Strike", "Cast", "run", "freeze");

				} else if (defender.getHealth() <= 0) {
					gameGui.update();
					ask("The " + defender.getName() + " has been slane!", "continue", "", "", "");
					player.removeEnemy(defender);
					return;
				}

			}
		} else if (answer.equals("run")) {
			setLocation(-1);
			//System.out.println(location);
			gameGui.gameArea.setText("");
			display("you run like a coward");
		} else if (answer.contains("freeze") || answer.equalsIgnoreCase("freeze")) {
			player.setHealth(0);
			updatePlayerInfo();
			display("YOU DIED :(\n" + "I told you freezing was a bad Idea!");
		} else {
			setLocation(-1);
		}

	}

	

	

	/*
	 * private void dropItem(Item item) { if (answer.equals("drop" + item)) { if
	 * (item.quantity > 1) {
	 * 
	 * item.quantity--;
	 * 
	 * } else { item.inInv = false; player.inv.remove(item); } } }
	 * 
	 * private void checkInv(ArrayList<Item> inv) { if (answer.equals("check inv"))
	 * { player.isChecking = true; } else if (player.isChecking == true) {
	 * System.out.println("continue? "); answer = GameObject.in.nextLine(); }
	 * 
	 * }
	 */

	private void setLocation(int loc) {
		location = loc;
	//	System.out.println("location answer = " + answer);
		answer = "reset";
	}

	public String formatName(String name) {
		String firstLetter = name.substring(0, 1).toUpperCase();
		String rest = name.substring(1, name.length()).toLowerCase();
		String formatedName = firstLetter + rest;
		return formatedName;
	}
	public GameGUI getGameGui() {
		return gameGui;
	}

	public Entity getEnemy() {
		return GameObject.enemy;
	}

	public void setEnemy(Entity enemy) {
	GameObject.enemy = enemy;
	}
	public GameState toGameState(){
		GameState gs = new GameState(player, player.getSelectedEnemy());
		gs.makeScore();
		return gs;
	}
	public GameState makeAMove() {
//		int score = this.toGameState().makeScore();
		this.toGameState().buildGameStateTree(1);
		ArrayList<Integer> scores = this.toGameState().getChildrenScores();
//		display("Score: " + score);
		//display("Scores: " + scores);
		Collections.sort(scores);
		System.out.println(gameStates.get(scores.get(scores.size()-1)));
		int bestScore = scores.get(scores.size()-1);
		System.out.println(gameStates.containsKey(bestScore));
		GameState gs = gameStates.get(bestScore);
		return gs;
//		System.out.println("Game State Tree: " + gameStates);
//		this.toGameState().buildTree(5);
//		System.out.println("Tree: " + tree);
//		GameState bestGameState = GameState.findBestGameState(g);
//		System.out.println("Best: " + bestGameState);
//		GameObject.player = bestGameState.getPlayer();
//		System.out.println(bestGameState.getPlayer());
//		GameObject.enemy = bestGameState.getEnemy();
//		gameGui.getEnemyBox().setSelectedItem(bestGameState.getEnemy());
//		System.out.println(bestGameState.getEnemy());
	}
}
