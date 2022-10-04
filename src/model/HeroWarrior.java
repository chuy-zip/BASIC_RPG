package model;

public class HeroWarrior extends MainCharacter{
	
	/**
	 * A type of main character that has more hp and attack. But is slow and has less item
	 * advantages
	 * @param Only uses parent constructor to save name
	 */
	public HeroWarrior(String name) {
		super(name);
		setHeroType(0);
		setHP(12);
		setCurrentHP(12);
		setGold(0);
		setAttack(6);
		setSpeed(1);
		
		getInventory().add(new HealthPot());
		getInventory().add(new HealthPot());
		getInventory().add(new DmgPot());
		
	}
}
