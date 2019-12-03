package thomas.game.entities;

import java.util.ArrayList;

import thomas.game.GameObject;
import thomas.game.items.Item;
import thomas.game.spells.AttackSpell;
import thomas.game.spells.Spell;
import thomas.game.spells.StatusEffect;
import thomas.game.weapons.Sword;
import thomas.game.weapons.Weapon;

public class Player extends Entity{

	private ArrayList<Entity> enemyList = new ArrayList<>();
	
	public Player(){
		super("Temp Name", 800, 5, 5, 500, new ArrayList<Weapon>(), (Weapon)new Sword("Hand",0,0), new ArrayList<Spell>(), null, new ArrayList<StatusEffect>());
		this.setMaxHealth(health);
	}
	public Player(String name){
		this();
		this.name = name;
		this.setMaxHealth(health);
	}
	Player(Weapon weapon){
		this();
		selectedWeapon = weapon;
		this.weaponList.add(weapon);
	}
	Player(Spell spell){
		this();
		
		this.selectedSpell = spell;
		this.spellList.add(spell);
	}
	Player(Weapon weapon, Spell spell){
		this();
		this.selectedWeapon = weapon;
		this.weaponList.add(weapon);
		this.selectedSpell = spell;
		this.spellList.add(spell);
	}
	Player(String name, int health, int attack, int armor, int mana, ArrayList<Weapon> weaponList, Weapon selectedWeapon, ArrayList<Spell> spellList, Spell selectedSpell, ArrayList<StatusEffect> statusEffects){
		this.name = name;
		this.health = health;
		this.attack = attack;
		this.armor = armor;
		this.mana = mana;
		this.weaponList = weaponList;
		this.selectedWeapon = selectedWeapon;
		this.spellList = spellList;
		this.selectedSpell = selectedSpell;
		this.statusEffects = statusEffects;
	}
	@Override
	public String toString() {
		return " \nname: " + name + " \nhealth: " + health + " \nmana: " + mana + "\nselected spell: " + selectedSpell +" \nattack: " + getAttack() + "\nselected weapon: " + selectedWeapon + " \narmor: " + getArmor() + "\nstatus effects: " + statusEffects;
	}
	public ArrayList<Entity> getEntityList() {
		return enemyList;
	}
	public void setEnemyList(ArrayList<Entity> enemyList) {
		this.enemyList = enemyList;
	}
	
	public void learnSpell(Spell spell) {
		this.getSpellList().add(spell);
		GameObject.gameGui.getSpellBox().setSelectedItem(spell);
		GameObject.gameGui.update();
		GameObject.g.display("You learned the spell " + spell.getInfo());

	}

	public void addEnemy(Entity enemy) {
		this.getEntityList().add(enemy);
		GameObject.gameGui.update();
	}

	public void removeEnemy(Entity enemy) {
		this.getEntityList().remove(enemy);
		GameObject.gameGui.update();
	}
	/*public ArrayList<Item> inv = new ArrayList<Item>(1);
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
		spellNameList.add(spell.getName());
	}
	return spellNameList;
}*/
	
	
		
	public void setSelectedSpell(Spell spell) {
		GameObject.gameGui.getSpellBox().setSelectedItem(spell);
		selectedSpell = spell;
	}
	public Spell getSelectedSpell() {
		return selectedSpell;
	}
	public void setSelectedWeapon(Object item) {
		selectedWeapon = (Weapon)item;
	}
	public void setSelectedWeapon() {
		selectedWeapon = (Weapon) GameObject.gameGui.getWeaponBox().getSelectedItem();
	}
	public Weapon getSelectedWeapon() {
		return selectedWeapon;
	}
	public Entity getSelectedEnemy() {
		return (Entity)GameObject.gameGui.getEnemyBox().getSelectedItem();
	}
	@Override
	public Entity clone() {
		return new Player(this.name, this.health, this.attack, this.armor, this.mana, this.weaponList, this.selectedWeapon, this.spellList, this.selectedSpell, this.statusEffects);
	}
	public void setSelectedSpell(Object spell) {
		this.selectedSpell = (Spell)spell;
		
	}
}