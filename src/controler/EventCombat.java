package controler;

import java.util.ArrayList;

import model.HeroPet;
import model.Items;
import model.MainCharacter;
/**
 * Class that manages most of the game logic and events that can occur in a battle
 * @author andre
 *
 */
public class EventCombat {
	private int turn; 
	private boolean combatStatus;
	
	public EventCombat() {
		this.turn = 1; 
		this.combatStatus = true;
	}
	/**
	 * Method that makes the hero deal damage
	 * @param hero
	 * @param enemies
	 * @param target
	 */
	public void HeroAttack(MainCharacter hero, ArrayList<MainCharacter> enemies, int target) {
		enemies.get(target).setCurrentHP(enemies.get(target).getCurrentHP() - hero.getAttack());
	}
	
	public void EnemyAttack(ArrayList<MainCharacter> enemies, MainCharacter hero) {
		for(MainCharacter anEnemy:enemies) {
			hero.setCurrentHP(hero.getCurrentHP() - anEnemy.getAttack());
			System.out.println("\nEnemigo ha atacado_________________________________________________________________________");
		}
	}
	/**
	 * Using an item if founnd on the item array list
	 * @param Hero
	 * @param ItemName
	 */
	public void UseSelfitem(MainCharacter Hero, String ItemName) {
		
		for(int i = 0; i < Hero.getInventory().size(); i++) {
			if(Hero.getInventory().get(i).getName().equals(ItemName) ) {
				Hero.getInventory().get(i).AppplyPotionEffect(Hero);
				System.out.println("Curacion exitosa");
				Hero.getInventory().remove(i);
				return;
			}
		}
		System.out.println("No esta disponible el item");
	}
	
	public void UseHealItemOnPet(MainCharacter Hero, String ItemName, HeroPet pet) {
		
		for(int i = 0; i < Hero.getInventory().size(); i++) {
			if(Hero.getInventory().get(i).getName().equals(ItemName) ) {
				Hero.getInventory().get(i).AppplyPotionEffect(pet);
				System.out.println("Curacion exitosa");
				Hero.getInventory().remove(i);
				return;
			}
		}
		System.out.println("No esta disponible el item");
	}
	/**
	 * Method for items that deal damage
	 * @param Hero
	 * @param enemies
	 * @param ItemName
	 */
	public void UseAtackItem(MainCharacter Hero, ArrayList<MainCharacter> enemies, String ItemName) {
		for(int i = 0; i < Hero.getInventory().size(); i++) {
			if(Hero.getInventory().get(i).getName().equals(ItemName) ) {
				
				for(MainCharacter anEnemy:enemies) {
					Hero.getInventory().get(i).AppplyPotionEffect(anEnemy);
					System.out.println("Enemigo golpeado por pocion");
					
				}
				Hero.getInventory().remove(i);
				return;
				
			}
		}
		System.out.println("No esta disponibles el item");
	}

	public boolean isCombatStatus() {
		return combatStatus;
	}

	public void setCombatStatus(boolean combatStatus) {
		this.combatStatus = combatStatus;
	}
	/**
	 * Delete enemies when theirhp is equal or below to 0
	 * @param enemies
	 * @param Hero
	 */
	public void deleteEnemies(ArrayList<MainCharacter> enemies, MainCharacter Hero) {
		if(enemies.size() == 2) {
			if(enemies.get(1).getCurrentHP() <= 0) {
				Hero.setGold(Hero.getGold() + enemies.get(1).getGold());
				System.out.println("\nHas ganado monedas por derrotar a un enemigo\n");
				enemies.remove(1);
			}
			if(enemies.get(0).getCurrentHP() <= 0) {
				Hero.setGold(Hero.getGold() + enemies.get(0).getGold());
				System.out.println("\nHas ganado monedas por derrotar a un enemigo\n");
				enemies.remove(0);
			}
		}
		
		else if(enemies.size() == 1) {
			if(enemies.get(0).getCurrentHP() <= 0) {
				Hero.setGold(Hero.getGold() + enemies.get(0).getGold());
				System.out.println("\nHas ganado monedas por derrotar a un enemigo\n");
				enemies.remove(0);
			}
		}
	}

}
