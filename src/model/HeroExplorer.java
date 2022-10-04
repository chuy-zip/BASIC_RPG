package model;

/**
 * This is a different type of hero, whos main adavantage its the starting gold, 
 * more initial items. But it has much less initial strength, atack and speed.
 * @author andre
 *
 */
public class HeroExplorer extends MainCharacter{
	
	public HeroExplorer(String name) {
		super(name);
		setHeroType(1);
		setHP(8);
		setCurrentHP(8);
		setGold(20);
		setAttack(2);
		setSpeed(6);
		
		getInventory().add(new HealthPot());
		getInventory().add(new HealthPot());
		getInventory().add(new HealthPot());
		getInventory().add(new DmgPot());
		getInventory().add(new DmgPot());
		
	}
}
