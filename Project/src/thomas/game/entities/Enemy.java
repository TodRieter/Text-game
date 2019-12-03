package thomas.game.entities;

import java.util.ArrayList;
import java.util.HashMap;

import thomas.game.GameState;
import thomas.game.items.Item;
import thomas.game.spells.Spell;
import thomas.game.spells.StatusEffect;
import thomas.game.weapons.Sword;
import thomas.game.weapons.Weapon;

public abstract class Enemy extends Entity{

	Weapon selectedWeapon = new Sword("stick",1,0);
	Spell selectedSpell;
	GameState gameState = new GameState();
	
	public Enemy(String name, int health, int attack, int armor, int mana, ArrayList<Item> inv, ArrayList<Spell> spellList, Spell selectedSpell, Weapon selectedWeapon, ArrayList<StatusEffect> statusEffects) {
		super(name, health, attack, armor, mana, inv, spellList, statusEffects);
		this.selectedWeapon = selectedWeapon;
		this.selectedSpell = selectedSpell;
	}
	
	
	




	

//	private Integer getMaxScore(){
//		int highScore = 0;
//		
//		for(Spell spell : this.spellList) {
//			Integer spellScore = score(spell);
//			if( highScore < spellScore) {
//				moves.put(spellScore, new Move("cast", spell));
//				highScore = spellScore;
//			}
//		}
//		for(Item weaponItem : this.inv) {
//			if(GameObject.weapons.containsKey(weaponItem.name)) {
//				Weapon weapon = GameObject.weapons.get(weaponItem.name);
//				Integer weaponScore = score(weapon);
//				if(weaponScore > highScore) {
//					moves.put(weaponScore, new Move("attack", weapon));
//					highScore = weaponScore;
//				}
//			}
//		}
//
//		return highScore;
//	}
	
	int manaEfficiency() {
//		Effect spellEffect = selectedSpell.getEffect();
//		if(spellEffect.equals(Effect.NONE)) {
//			return (int)selectedSpell.getAttack()/selectedSpell.getCost();
//		}
//		if(spellEffect.getTarget().equals("target")) {
//			return (int)(selectedSpell.getAttack() + spellEffect.getAttack()*spellEffect.time)/(selectedSpell.getCost()+spellEffect.time);
//		}if(spellEffect.getTarget().equals("caster")) {
//			return (int)(selectedSpell.getAttack() - spellEffect.getAttack()*spellEffect.time)/(selectedSpell.getCost()+spellEffect.time);
//		}
		return 0;
	}
	
	 
	 
//	 public class GameState{
//			Integer score;
//			Spell enemySpell;
//			Spell playerSpell;
//			Weapon enemyWeapon;
//			Weapon playerWeapon;
//			Integer lastScore;
//			Player player;
//			Entity enemy;
//			boolean isAlive;
//			private boolean isPlayerTurn;
//			private String move;
//
//			GameState(){
//				this.score = 0;
//				this.lastScore = 0;
//				this.enemy = new Dragon();
//				this.enemySpell = enemy.selectedSpell;
//				this.playerSpell = player.selectedSpell;
//				this.enemyWeapon = enemy.selectedWeapon;
//				this.playerWeapon = player.selectedWeapon;
//				this.player = GameObject.player;
//				this.isAlive = true;
//				GameObject.gameStates.put(score,this);
//			}
//			
//		void buildTree(int depth){
//			GameObject.
//			while(depth > 0) {
//					for(Integer score : this.getScores()) {
//						Enemy.tree.put(score, (GameState)GameObject.gameStates.get(score).getScores());
//					}
//				}
//			}
//
//			public GameState findBestGameState() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//			
//
//			public int getPostFightHealth(Entity attacker, Entity defender) {
//
//				
//				// System.out.println((char)27 + "[31m" + "ERROR MESSAGE IN RED");
//				if (move.equalsIgnoreCase("Strike") || move.equalsIgnoreCase("cast")) {
//					while (attacker.getHealth() > 0 && !move.equalsIgnoreCase("run")) {
//						if (move.equalsIgnoreCase("strike")) {
//							attacker.attack(defender);
//						} else if (move.toLowerCase().contains("cast")) {
//							if (move.equalsIgnoreCase("cast") && attacker.getSpellList().size() > 0
//									&& attacker.getSelectedSpell() != null) {
//								Spell spell =  attacker.getSelectedSpell();
//								attacker.cast(defender, spell);
//							}
//						}
//						attacker.triggerStatusEffects();
//						defender.triggerStatusEffects();
//						if (attacker.getHealth() <= 0) {
//							isAlive = false;
//							break;
//						} else if (defender.getHealth() > 0) {
//							return defender.getHealth();
//						} else if (defender.getHealth() <= 0) {
//							return 0;
//						}
//					}
//				} else if (move.equals("run")) {
//					//System.out.println(location);
//				} else if (move.contains("freeze") || move.equalsIgnoreCase("freeze")) {
//					return 0;
//				}
//					return defender.getHealth();
//
//			}
//			int[] getScores(){
//				Entity entity = isPlayerTurn ? player : enemy;
//					int[] scores = new int[entity.getInv().size() + entity.spellList.size()];
//					int i = 0;
//					for(Item item : entity.getInv()) {
//						Weapon weapon = GameObject.weapons.get(item.name);
//						entity.setSelectedWeapon(weapon);
//						scores[i] = makeScore();
//						i++;
//				}
//					for(Spell spell : entity.spellList) {
//						entity.setSelectedSpell(spell);
//						scores[i] = makeScore();
//						i++;
//				}
//					System.out.println(Arrays.toString(scores));
//					return scores;
//			}
//			int makeScore(){
//				if(getPostFightHealth(player, enemy) <= 0 || getPostFightHealth(enemy, player) <= 0) {
//					isAlive = !isPlayerTurn;
//					return isPlayerTurn ? 0:Integer.MAX_VALUE;
//				}
//				int score = this.isPlayerTurn ? enemy.health /(enemy.health - getPostFightHealth(player, enemy)) : (player.health - getPostFightHealth(enemy, player));
//				//System.out.println("Weapon Score: " + score);
//				return score;
//			}
//			 
//			public String toString(){
//				return "Score: " + score + " Type: " + move + " Player: " + player + " Enemy: " + enemy;
//			}
//
//	}
}
