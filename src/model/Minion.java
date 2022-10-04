package model;

/**
 * The most simple and easy enemy to defeat. Also the mos common
 * @author andre
 *
 */
public class Minion extends MainCharacter{
	
	public Minion(String name) {
		super(name);
		setHeroType(2);
		setHP(10);
		setCurrentHP(10);
		setGold(5);
		setAttack(3);
		setSpeed(5);
	}
	
	/**
	 * The minion special passive is to heal every turn 4 hp
	 */
	@Override
	public void specialAbility() {
		int maxHP = this.getHP();
		int currentHP = this.getCurrentHP();
		int healingHP = 4;

		/**
		 * If the healing hp is less than the max hp, then aplie healing normally
		 */
		if(currentHP + healingHP < maxHP) {
			this.setCurrentHP(currentHP + healingHP);
		}
		/**
		 * If the healing hp is going to be bigger than max HP, then set HP to MaxHP
		 */
		else if(currentHP + healingHP > maxHP){
			this.setCurrentHP(maxHP);

		}
		

	}
}
