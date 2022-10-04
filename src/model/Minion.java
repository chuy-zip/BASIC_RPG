package model;

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
