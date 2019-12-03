package thomas.game.spells;
import thomas.game.enums.*;
import thomas.game.GameObject;
import thomas.game.entities.Entity;
import java.util.HashMap;

public abstract class Spell{

	protected String name;
	protected int level;
	protected int cost;
	protected int range;
	private int timer;
	protected String flavor;
	
	public Spell(String name, String flavor, int level, int cost){
		this.name = name;
		this.level = level;
		this.cost = cost;
		this.flavor = flavor;
		Spells.put(this.name, this);
	}
	
	public Spell(){
		System.out.print(this);
		
}

	public void cast(Entity entity, Entity target) {
		this.affect(entity);
	}
	public void cast(Entity entity) {
		this.affect(entity);
	}
	public String toString(){
		return getInfo();
	}
	public String getFlavor(){
		return this.flavor;
	}
	public String getInfo(){
		return " Spell: " + this.name + " \nLevel: " + this.level + " \nMana cost: " + this.cost;

	}
	public static HashMap<String, Spell> Spells = new HashMap<String, Spell>();

	public String getName() {
		return name;
	}

	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		this.timer = timer;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public abstract void affect(Entity entity);

}
