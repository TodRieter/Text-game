package thomas.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import thomas.game.entities.Dragon;
import thomas.game.entities.Enemy;
import thomas.game.entities.Entity;
import thomas.game.entities.Player;
import thomas.game.items.Item;
import thomas.game.spells.Spell;
import thomas.game.weapons.Sword;
import thomas.game.weapons.Weapon;

public class GameState{
	int score = 1;
	private Player player = (Player)(GameObject.player.clone());
	private Entity enemy = GameObject.enemy; 
	boolean isAlive = true;
	boolean isPlayerTurn = false;
	private String move = "";
	static ArrayList<Integer> deepScores = new ArrayList<>();
	//public static HashMap<Integer, GameState> gameStates = new HashMap<>();
	ArrayList<Integer> scores = new ArrayList<>();
	private int lastScore;
	public GameState(){
		
	}
public GameState(Player player, Entity enemy) {

	this();
	this.enemy = enemy;
	this.player = player;
}


public GameState(Player gsPlayer, Entity gsEnemy, boolean isPlayerTurn) {
	this.player = gsPlayer;
	this.enemy = gsEnemy;
	this.isPlayerTurn = isPlayerTurn;
}
public GameState(Player player, Entity enemy, String move) {
	this();
	this.player = player;
	this.enemy = enemy;
	this.setMove(move);
}
public GameState(Player gsPlayer, Entity gsEnemy, boolean isPlayerTurn, int lastScore) {
	this();
	this.player = gsPlayer;
	this.enemy = gsEnemy;
	this.isPlayerTurn = isPlayerTurn;
	this.lastScore = lastScore;
}

public GameState(Player gsPlayer, Entity gsEnemy, boolean isPlayerTurn, String move, int lastScore) {
	this();
	this.player = gsPlayer;
	this.enemy = gsEnemy;
	this.isPlayerTurn = isPlayerTurn;
	this.lastScore = lastScore;
	this.move = move;
}
public GameState findPlay(Integer finalScore) {
	GameState gs = GameObject.gameStates.get(finalScore);
	System.out.println("find Play Score: " + finalScore);
	if(gs.lastScore == 0) {
		return gs;
	}
	return findPlay(gs.lastScore);
}
GameState buildGameStateTree(int depth, int maxDepth){
	if(depth < maxDepth) {
		int weaponListSize = isPlayerTurn ? this.player.getWeaponList().size() : this.enemy.getWeaponList().size();
		int spellListSize = isPlayerTurn ? this.player.getSpellList().size() : this.enemy.getSpellList().size();
		ArrayList<Weapon> weaponList = isPlayerTurn ? this.player.getWeaponList() : this.enemy.getWeaponList();
		ArrayList<Spell> spellList = isPlayerTurn ? this.player.getSpellList() : this.enemy.getSpellList();
		Entity gsEnemy = enemy.clone();
		Player gsPlayer = (Player)this.player.clone();
		for(Weapon weapon : weaponList) {
			
			if(isPlayerTurn) {
				gsPlayer.setSelectedWeapon(weapon);
			}else {
				gsEnemy.setSelectedWeapon(weapon);
			}
			GameState gsw = new GameState(gsPlayer, gsEnemy, !isPlayerTurn, "strike", this.score);
			gsw.score = gsw.makeScore();
			GameObject.gameStates.put(gsw.score,gsw);
		//	System.out.println(GameObject.gameStates);
			gsw.buildGameStateTree(depth+1, maxDepth);
		}
		for(Spell spell : spellList) {
			 	if(isPlayerTurn) {
			 		gsPlayer.setSelectedSpell(spell);
			 	}else {
			 		gsEnemy.setSelectedSpell(spell);
			 	}
				GameState gs = new GameState(gsPlayer, gsEnemy, !isPlayerTurn, "Cast", this.score);
				gs.score = gs.makeScore();
				GameObject.gameStates.put(gs.score,gs);
			//	System.out.println(GameObject.gameStates);
				gs.buildGameStateTree(depth+1, maxDepth);
		}
	}
	return this;
}

	ArrayList<Integer> getChildrenScores() {
		ArrayList<Weapon> weaponList = isPlayerTurn ? this.player.getWeaponList() : this.enemy.getWeaponList();
		ArrayList<Spell> spellList = isPlayerTurn ? this.player.getSpellList() : this.enemy.getSpellList();
		ArrayList<Integer> childrenScores = new ArrayList<>();
		Player gsPlayer = (Player)this.player.clone();
		Entity gsEnemy = enemy.clone();

		childrenScores.add(this.score);
		for(Weapon weapon : weaponList) {
			if(isPlayerTurn) {
				gsPlayer.setSelectedWeapon(weapon);
			}else {
				gsEnemy.setSelectedWeapon(weapon);
			}
			GameState gs = new GameState(gsPlayer, gsEnemy, "strike");
			gs.score = gs.makeScore();
			childrenScores.add(gs.score == 0 ? 0 : gs.score+this.score);
		}
		for(Spell spell : spellList) {
			if(isPlayerTurn) {
				gsPlayer.setSelectedSpell(spell);
			}else {
				gsEnemy.setSelectedSpell(spell);
			}
			GameState gs = new GameState(gsPlayer, gsEnemy,"cast");
			gs.score = gs.makeScore();
			childrenScores.add(gs.score == 0 ? 0 : gs.score+this.score);
		}
		
	return childrenScores;
}
	public static GameState findBestGameState(GameObject g) {
		Collections.sort(deepScores);
		System.out.println(deepScores);
		int bestScore = deepScores.get(deepScores.size()-1);
		return GameObject.gameStates.get(bestScore);
	}
	
	public GameState fight() {
		Entity attacker = isPlayerTurn ? player : enemy;
		Entity defender = !isPlayerTurn ? player : enemy;

				if (getMove().equalsIgnoreCase("strike")) {
					defender.attack(attacker);
				} else if (getMove().equalsIgnoreCase("cast")) {
					if (getMove().equalsIgnoreCase("cast")) {
						defender.getSelectedSpell().cast(attacker);
					}
				}
				if (attacker.getHealth() <= 0) {
					isAlive = false;
				} else if (defender.getHealth() <= 0) {
			}
				attacker.triggerStatusEffects();
				defender.triggerStatusEffects();
				if (attacker.getHealth() <= 0) {
					isAlive = false;
				} else if (defender.getHealth() <= 0) {
			}
			GameState gs = isPlayerTurn ? new GameState((Player)attacker,defender, !isPlayerTurn) : new GameState((Player)defender,attacker, !isPlayerTurn);
			gs.player.setSelectedSpell(player.getSelectedSpell());
			gs.player.setSelectedWeapon(player.getSelectedWeapon());
			return gs;
		} 
//	public int fight(Entity entity, Player player, String move) {
//
//		Entity attacker = isPlayerTurn ? player: entity;
//		Entity defender = isPlayerTurn ? entity : player;
//		// System.out.println((char)27 + "[31m" + "ERROR MESSAGE IN RED");
//		if (move.equalsIgnoreCase("Strike") || move.equalsIgnoreCase("cast")) {
//			while (attacker.getHealth() > 0 && !move.equalsIgnoreCase("run")) {
//				if (move.equalsIgnoreCase("strike")) {
//					attacker.attack(defender);
//				} else if (move.toLowerCase().contains("cast")) {
//					if (move.equalsIgnoreCase("cast") && attacker.getSpellList().size() > 0
//							&& attacker.getSelectedSpell() != null) {
//						Spell spell =  attacker.getSelectedSpell();
//						attacker.cast(defender, spell);
//					}
//				}
//				attacker.triggerStatusEffects();
//				defender.triggerStatusEffects();
//				if (attacker.getHealth() <= 0) {
//					isAlive = false;
//					break;
//				} else if (defender.getHealth() > 0) {
//					return defender.getHealth();
//				} else if (defender.getHealth() <= 0) {
//					return 0;
//				}
//			}
//		} else if (move.equals("run")) {
//			//System.out.println(location);
//		} else if (move.contains("freeze") || move.equalsIgnoreCase("freeze")) {
//			return 0;
//		}
//			return defender.getHealth();
//
//	}
	int[] getScores(){
		Entity entity = isPlayerTurn ? this.player : this.enemy;
		Entity entity1 = !isPlayerTurn ? this.player : this.enemy;
			int[] scores = new int[entity.getWeaponList().size() + entity.getSpellList().size()];
			int i = 0;
			for(Weapon weapon : entity.getWeaponList()) {
				entity.setSelectedWeapon(weapon);
				GameState newGameState = isPlayerTurn ? new GameState((Player)entity, entity1) : new GameState((Player)entity1, entity);
				scores[i] = newGameState.makeScore();
				i++;
		}
			for(Spell spell : entity.getSpellList()) {
				entity.setSelectedSpell(spell);
				GameState newGameState = isPlayerTurn ? new GameState((Player)entity, entity1) : new GameState((Player)entity1, entity);
				scores[i] = newGameState.makeScore();
				i++;
		}
			System.out.println(Arrays.toString(scores));
			return scores;
	}
	Integer makeScore(){
		int score;
		if(this.player.getHealth() <= 0 || this.enemy.getHealth() <= 0) {
			GameObject.gameStates.put(isPlayerTurn ? 0: Integer.MAX_VALUE, this);
			deepScores.add(isPlayerTurn ? 0: Integer.MAX_VALUE);
			return isPlayerTurn ? 0:Integer.MAX_VALUE;
		}
		if((getEnemy().getHealth() - fight().getEnemy().getHealth())==0) {
			 score = this.isPlayerTurn ? (100*getEnemy().getHealth())/(1+getEnemy().getHealth() - fight().getEnemy().getHealth()) : (player.getHealth() - fight().player.getHealth());
			this.score = score;
			deepScores.add(this.score);
			GameObject.gameStates.put(this.score, this);
			return score;
		}
		
		score = this.isPlayerTurn ? (100*getEnemy().getHealth())/(1+getEnemy().getHealth() - fight().enemy.getHealth()) : (player.getHealth() - fight().player.getHealth());

		this.score = score;
		GameObject.gameStates.put(score, this);
		return score;
	}
	int makeScore(Player player, Entity enemy){
		if(player.getHealth() <= 0 || enemy.getHealth() <= 0) {
			return isPlayerTurn ? 0:Integer.MAX_VALUE;
		}
		int score = this.isPlayerTurn ? getEnemy().getHealth() /(getEnemy().getHealth() - fight().enemy.getHealth()) : (player.getHealth() - fight().player.getHealth());
		this.score = score;
		return score;
	}
	public String toString(){
		return "\nScore: " + score + "\nPlayer: " + getPlayer().getName() + "\nEnemy: " + getEnemy().getSelectedWeapon().name + "\n\n\n";
	}
	public Player getPlayer() {
		return (Player)player.clone();
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Entity getEnemy() {
		return enemy;
	}
	public void setEnemy(Entity enemy) {
		this.enemy = enemy;
	}
	public String getMove() {
		return move;
	}
	public void setMove(String move) {
		this.move = move;
	}
}
