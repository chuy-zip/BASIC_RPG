package model;

public class HeroWarrior extends MainCharacter{
	
	/**
	 * A type of main character that has more hp and attack
	 * @param Only uses parent constructor to save name
	 */
	public HeroWarrior(String name) {
		super(name);
		setHeroType(0);
		setHP(10);
		setCurrentHP(10);
		setGold(0);
		setAttack(4);
		setSpeed(1);
		
		getInventory().add(new HealthPot());
		getInventory().add(new HealthPot());
		getInventory().add(new DmgPot());
		
	}
}
