package thomas.game;

import java.util.ArrayList;

//import java.util.ArrayList;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import thomas.game.entities.Blob;
import thomas.game.entities.Dragon;
import thomas.game.entities.Entity;
import thomas.game.entities.Player;
import thomas.game.items.Item;
import thomas.game.items.SwordItem;
import thomas.game.spells.Spell;
import thomas.game.spells.melee.Boomhands;
import thomas.game.weapons.FireSword;
import thomas.game.weapons.Sword;
import thomas.game.weapons.Weapon;


public class GameObject {

	public static int location = 0;
	Entity dragon = new Dragon();
	Item sword = new SwordItem();
	public static Scanner in = new Scanner(System.in);
	public static Player player = new Player("Tempname");
	public static String answer = "";
	public static GameObject g = new GameObject();
	String question;
	public static boolean isAlive = true;
	public static ArrayList<Entity> enemyList = new ArrayList<>();
	public static ArrayList<Weapon> inventoryList = new ArrayList<>();
	public static Entity target;
	public GameGUI gG;
	public void run() {
		
		
		gG = new GameGUI();
		
		
		
		//System.out.println("GameObject" + gG.p.spellList);

		//ask("Greetings Would You like to play a game of >>Generic Adventure<< ?" + "\n type yes or no");
		//player.setPlayerName();
		
		//gG.gameArea.setText("This is a test");
	
		while (isAlive == true) {
			
			switch (location) {
			
			case 0:
				//location = 1;
				ask("Greetings Would You like to play a game of >>Generic Adventure<< ?", "yes", "yes","yes","yes");

				//ask("would you like to pick up a " + fireSword.name());
				
				if (answer.equals("yes")) {
ask("you wake up on what appeares to be a space ship with no memory of who you are or how you got into space.\n you realize instantly that this will not be a generic adventure... or will it?\nyou look around and see a white door that looks space agey, "
		+ "a bed, a book shelf, and a grate. Do you?", "go to the door", "go to the bed", "check the bookshelf", "look into the grate");
if(answer.equals("go to the door"))
				location = 2;		
				}
				if(answer.equals("check the bookshelf")) {
					location = 3;
				}
				if(answer.equals("go to the bed")) {
					location = 4;
				}
				break;

			case 1:
				System.out.println("test 3");
				Entity blob = new Blob();
				display("you go to the grate and realize that there seems to be somekind of concrete sewere system on this ship (thats odd) and against you better judgement\n "
						+ "you climb down and enter a dark hallway and see a amorphus blob\n" + blob);
				addEnemy(blob);
					fight(player, blob);
//				if(answer.equalsIgnoreCase("run")) {
//					display("you run like a coward");
//					location = -1;
//				}
				break;
			case 2:
				ask("you go to the door and realize that it is locked and has a keypad you try punching in 0000, 1234, 4321, 3141\n "
						+ "and then realize you have no idea if it is even a four digit passcode and that you should probably find the code before you set off the...\n "
						+ "you hear a sound that sounds like a mixture of a air horn, a tornado siren, and elephant that is dying in the desert next to a camel that got stuck in the sand.\n"
						+ " Well the alarm has been sounded (and apparently it has a sense of dramatic timing) do you?", 
						"pretend it wasn't you", "go to the bookshelf", "go to the bed", "checkout the grate");
				if(answer.equals("go to the bookshelf")){
					location = 3;
				}
				if(answer.equals("pretend it wasn't you")){
					location = 7;
				}if(answer.equals("go to the bed") ){
					location = 4;
				}if(answer.equals("checkout the grate")){
					location = 1;
				}
				break;
			case 3:
				System.out.println(location);
				ask("you start pulling random books out of the bookshelf and throw them around the room hoping that this is a bookshelf that is like one from\n "
						+ "a book or movie and that if you pull the right book it will open up a secret passage way\n "
						+ "and finally it appears that it is! the bookshelf swings open and reveals a door with a sign on it that reads:\n"
						+ " \"this game is unfinished if you choose to go through this door you will be able to get a preview of the mechanics of combat in this game\" do you?",
						"yes I want a to preview the combat system!", "nah its probably not balanced yet", "","");
				if(answer.equals("yes I want a to preview the combat system!")) {
					location = 6;
				}
				break;
			case 4:
				display("you go to the bed. At first you considered taking a nap but you feel something cold sharp it feels like a knife\n "
						+ "but it's a bit too big its more like a sword. You stand up and on closer examination it isn't like a sword, it is a sword!\n "
						+ "you picked up a boring normal sword.");
				Weapon sword = new Sword();
				pickUp(sword);
				ask("you look around the room and realize that this is a demo,\n"
						+ " and that you should probably explore either the book shelf or the grate or the door. do you"
						, "go to the bookshelf","go to the grate","go to the door", "HA im a rebel im going to take a nap!");
				
				if(answer.equals("go to the bookshelf")) {	
					location = 3;
				}
				if(answer.equals("go to the grate")) {
					location = 1;
				}
				if(answer.equals("go to the door")) {
					location = 2;
				}
				break;
			case 5:
				gG.gameArea.setText("");
				display("this is game is unfinished!");
				if(answer.equals("continue")){
					
				}
				break;
			case 6:
				Weapon fireSword = new FireSword();
				Spell boomHands = new Boomhands();
				pickUp(fireSword);
				learnSpell(boomHands);
				Entity dragon = new Dragon();
				addEnemy(dragon);
				fight(player, dragon);
				if(answer.equals("run")) {
					display("you run like a coward");
					location = 5;
				}
				if(answer.equals("freeze")) {
					player.health = 0;
					display("YOU DIED :(\n I told you it freezing was a bad idea!");
					isAlive = false;
				}
				break;
			case 7: 
				ask("Who are you trying to convince?", "yourself", "the people who are not there", "three people me, myself, and I", "my doctor");
				location = 5;
			default:
				display("you're not supposed to be here the game isn't finished\n"
						+ " and unfortunally the developer was too lazy to send you back where you are supposed to be so... IDK LOL JSLFKJ LF");
				isAlive = false;
				break;



			}
		}
	}
	 public void pickUp(Weapon item) {
			ArrayList<Weapon> inv = inventoryList; 
			int maxSize = 10;
			int size = inv.size();
			if(inv.size() < maxSize && ! inv.contains(item)){
				inv.add(item);
				gG.update();
				display("you picked up: " + inv.get(inv.indexOf(item)));
				
			}else if(inv.size() < maxSize && inv.contains(item)) {
				
			//	item.quantity++;
				display("you picked up: " + inv.get(inv.indexOf(item)));
					
			}else if(size == maxSize) {
				
				display("Your backpack is full! you did not pick up: " + item.name);
			}
			
			display(item.toString());
			inventoryList = inv;
			
		}
public void display(String text){
	ask(text,"continue","","","");
}
public void cast(Entity caster, Entity target, Spell spell){
	 
	if(caster.mana >= spell.cost){
		
		caster.mana = caster.mana - spell.cost;
		target.health = target.health - spell.attack;
		
	 if(spell.effect != null){
		spell.affect(spell.effect, caster);
	 }
	 display(caster + "\n" + target);
	}else if (caster.mana <= spell.cost){
		display("You don't have enough mana!\n" + caster);
	}
}
public void learnSpell(Spell spell){
	 player.spellList.add(spell);
	 gG.update();
}
public void addEnemy(Entity enemy){
	enemyList.add(enemy);
	gG.update();
}
public void removeEnemy(Entity enemy) {
	enemyList.remove(enemy);
	gG.update();
}
	public void ask(String question, String a1, String a2, String a3, String a4) {
		answer = "";
		gG.gameArea.setText(question);
		gG.setOptions(a1, a2, a3, a4);
		while(answer.equals("")){
			System.out.print("");
		}
		if(answer.equalsIgnoreCase("check inv")) {
	System.out.print(player.inv);
		} else if(answer.equalsIgnoreCase("check inv")) {
	System.out.print(player.inv);
		}else if(answer.equalsIgnoreCase("Stats")) {
			System.out.println(player.toString());
		}else if(answer.equalsIgnoreCase("spell List")){
			System.out.print(player.spellList().toString());
		}		
	}
	public void fight(Entity attacker, Entity target) {
		
		ask("You have encountered a " + target.name, "strike", "cast", "run", "freeze(not recommended but you have the option!)");
		//System.out.println((char)27 + "[31m" + "ERROR MESSAGE IN RED");
		if(answer.equalsIgnoreCase("Strike") || answer.equalsIgnoreCase("cast")){
			while(attacker.health > 0 && ! answer.equalsIgnoreCase("run")){
				if(answer.equalsIgnoreCase("strike")){
					attack(player, target);
				} else if(answer.toLowerCase().contains("cast")){
					if(answer.equalsIgnoreCase("cast")){
						cast(player, target, (Spell)gG.spellBox.getSelectedItem());
					}
						}
								
			if(attacker.health <= 0) {
				isAlive = false;
				display("YOU DIED :(");
				break;
			}else if(target.health > 0) {
				gG.update();
			ask(target.toString(),"Strike", "Cast", "run", "freeze");
			
			}else if(target.health <= 0){
				
				ask("The " + target.name + " has been slane!","continue","","","");
				removeEnemy(target);
				break;
			}
		}
		}else if(answer.equals("run")) {
			location = -1;
			System.out.println(location);
			gG.gameArea.setText("");
		display("you run like a coward");
		}else if(answer.contains("freeze")||answer.equalsIgnoreCase("freeze")) {
			player.health = 0;
			display("YOU DIED :(\n"
					+ "I told you freezing was a bad Idea!");
		}
		else {
			location = -1;
		}
		
	}
	public void attack(Entity attacker, Entity target){
		if(attacker.health > 0 && target.health != 0){
		target.health = target.getHealth() - (attacker.getAttack() + ((Weapon) gG.weaponBox.getSelectedItem()).attack);
		attacker.health = attacker.getHealth() - target.getAttack();
		display(player.toString() + "\n\n" + target.toString()); 
		}
	}
	public void dropItem(Item item) {
		if(answer.equals("drop"+ item)) {
		if(item.quantity > 1){
			
			item.quantity--;
			
		}else {
		item.inInv = false;
		player.inv.remove(item);
			}
		}
	}
	public void checkInv(ArrayList<Item> inv){
		if(answer.equals("check inv")) {
			player.isChecking = true;
		}else if(player.isChecking == true){
			System.out.println("continue? ");
			answer= GameObject.in.nextLine();
		}

}
	public String formatName(String name){
		String firstLetter = name.substring(0,1).toUpperCase();
		String rest = name.substring(1, name.length()).toLowerCase();
		String formatedName = firstLetter + rest;
		return formatedName;
	}
}

