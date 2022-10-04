package model;

/**
 * Consumable items that heal 30% of the players health
 * @author andre
 *
 */
public class HealthPot extends Items{
	
	public HealthPot() {
		setType(0);
		setName("Recovery Potion");
		setDescription("A very efective potion that heals 30% of your max Health");
	}
	
	@Override
	public void AppplyPotionEffect(MainCharacter Hero) {
		int maxHP = Hero.getHP();
		int currentHP = Hero.getCurrentHP();
		int healingHP = (int) (maxHP * 0.30);

		/**
		 * If the healing hp is less than the max hp, then aplie healing normally
		 */
		if(currentHP + healingHP < maxHP) {
			Hero.setCurrentHP(currentHP + healingHP);
		}
		/**
		 * If the healing hp is going to be bigger than max HP, then set HP to MaxHP
		 */
		else if(currentHP + healingHP > maxHP){
			Hero.setCurrentHP(maxHP);

		}
		
	}
}
