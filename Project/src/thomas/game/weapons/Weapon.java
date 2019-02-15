package thomas.game.weapons;

public abstract class Weapon {
	String name;
	int attack;
	double armorPierce;
	String effect;
	public Weapon(){
		System.out.printf(" " + this);
	}
	public Weapon(String name, int attack, double armorPierce, String effect) {
		this.name = name;
		this.attack = attack;
		this.armorPierce = armorPierce;
		this.effect = effect;
		
	}
	public static String getInfo(Weapon weapon) {
		return "info: " + weapon;
	}

}
