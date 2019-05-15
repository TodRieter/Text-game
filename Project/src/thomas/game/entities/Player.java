package thomas.game.entities;

import java.util.ArrayList;
import java.util.Scanner;
import thomas.game.GameObject;
import thomas.game.enums.Rarity;
import thomas.game.items.Item;
import thomas.game.player.Inventory;
import thomas.game.spells.Spell;
import thomas.game.spells.melee.Boomhands;

public class Player extends Entity{

	public ArrayList<Spell> spellList = new ArrayList<Spell>(); 
	

	public Player(){
		super("Temperary Name", 20, 5, 1, 50);	
	}
	public Player(String name){
		super(name, 20, 5, 1, 50);	
	}
	
	Player(String name, int health, int attack, int armor, int mana, ArrayList<Item> inv, ArrayList<Spell> spellList){
		this.inv = inv;
		this.spellList = spellList;
		this.mana = mana;
		this.name = name;
	}
	@Override
	public String toString() {
		return " \nname: " + name + " \nhealth: " + health + " \nmana: " + mana + " \nattack: " + attack + " \narmor: " + armor;
	}

	public ArrayList<Item> inv = new ArrayList<Item>(1);
	int size = inv.size();
	int maxSize = 10;
	public boolean isChecking;
		int location;
		int c = 0;
		
public static String playerName;
	String yes = "yes";
Scanner p = new Scanner(System.in);
public void setPlayerName(){
	System.out.println("What is your Name?");
//	@SuppressWarnings("resource")
//	final Scanner sc = new Scanner(System.in);
//	playerName = sc.nextLine();
//	System.out.println("You are " + playerName +" correct?");
//	//GameObject.in.nextLine();
//	GameObject.answer = GameObject.in.nextLine();
//	System.out.println(GameObject.answer);
//	if(GameObject.answer.equalsIgnoreCase(yes)){
//	GameObject.isAlive = true;
//	System.out.println("alive");
//	GameObject.location = 0;
//	}else if(GameObject.answer != "yes"){
//		System.out.println(GameObject.answer);
//}
	
}



 public static String getPlayerName(){	 
	 return playerName;
 }

 
 public String getSpellList(){
	 return "you know the spells: " + this.spellList.toString();
 }
 
public String toString(Inventory inv2) {
	return "Player [inv=" + toString(inv2) + ", c=" + c + "]";
	}
public String spellList() {
	// TODO Auto-generated method stub
	return spellList.toString();
}	
public ArrayList<String> getSpellNamesFromList(){
	ArrayList<String> spellNameList = new ArrayList<>();
	for(Spell spell : this.spellList){
		spellNameList.add(spell.name);
	}
	return spellNameList;
}
}