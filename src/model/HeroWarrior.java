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
		setHP(16);
		setCurrentHP(16);
		setGold(0);
		setAttack(6);
		setSpeed(1);
		
		getInventory().add(new HealthPot());
		getInventory().add(new HealthPot());
		getInventory().add(new DmgPot());
		
	}
	
	public void specialAbility() {
		setAttack(getAttack() + 1);
		System.out.println("\nSe ha incrementado tu ataque en una unidad por la habilidad especial!\n");
	}
}
