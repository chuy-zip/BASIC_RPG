package model;

public class DmgPot extends Items{
	
	public DmgPot(){
		setType(1);
		setName("Dangerous Potion");
		setDescription("Hits every enemy for 40 total points of health");
		
	}
	
	
	/**
	 * As both heroes and enemies belong too the main charachter clase
	 * This method can now affect enemies instead of the player
	 */
	@Override
	public void AppplyPotionEffect(MainCharacter enemy) {
		int currentHP = enemy.getCurrentHP();
		int damageTaken = 40;
		
		enemy.setCurrentHP(currentHP - damageTaken);
	}
}
