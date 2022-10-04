package model;

/**
 * When the divine sword is obtained it multiplies the attack by 5 and adds 3 to the speed value
 * It is applied only 1 time and cannot be undone once obtained.
 * @author andre
 *
 */
public class DivineSword extends Equipment{
	
	DivineSword(){
		setBonusAttack(5);
		setBonusSpeed(3);
	}

	@Override
	public void ApplyBonuses(MainCharacter Hero) {
		Hero.setAttack(Hero.getAttack() * this.getBonusAttack());
		Hero.setSpeed(Hero.getSpeed() + this.getBonusSpeed());
	}
}
