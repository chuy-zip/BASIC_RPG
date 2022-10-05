package controler;

import java.util.ArrayList;

import model.Items;
import model.MainCharacter;

public class EventCombat {
	private int turn; 
	private boolean combatStatus;
	
	public EventCombat() {
		this.turn = 1; 
		this.combatStatus = true;
	}

	public void HeroAttack(MainCharacter hero, ArrayList<MainCharacter> enemies, int target) {
		System.out.println("Enemigo objetivo: " + target);

	}
	
	public void EnemyAttack(ArrayList<MainCharacter> enemies, MainCharacter hero) {
		for(MainCharacter anEnemy:enemies) {
			System.out.println("Enemigo ataco");
			
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
				System.out.println("cura");
				Hero.getInventory().remove(i);
				return;
			}
		}
		System.out.println("No esta disponible el item");
	}
	
	public void UseAtackItem(MainCharacter Hero, ArrayList<MainCharacter> enemies, String ItemName) {
		for(int i = 0; i < Hero.getInventory().size(); i++) {
			if(Hero.getInventory().get(i).getName().equals(ItemName) ) {
				
				for(MainCharacter anEnemy:enemies) {
					Hero.getInventory().get(i).AppplyPotionEffect(anEnemy);
					System.out.println("Applied damage to all");
					
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
	
	public void deleteEnemies(ArrayList<MainCharacter> enemies) {
		if(enemies.get(1).getCurrentHP() <= 0) {
			enemies.remove(1);
		}
		if(enemies.get(0).getCurrentHP() <= 0) {
			enemies.remove(0);
		}
		
	}

}
