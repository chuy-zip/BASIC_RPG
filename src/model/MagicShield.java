package model;

/**
 * When the magic shield is obtained, it boosts only the HP and speed of the MainCharacter
 * It is applied only 1 time and cannot be undone
 * @author andre
 *
 */
public class MagicShield extends Equipment{

	public MagicShield(){
		setBonusHP(7);
		setBonusSpeed(2);
	}

	@Override
	public void ApplyBonuses(MainCharacter Hero) {
		Hero.setHP(Hero.getHP() * this.getBonusHP());
		Hero.setSpeed(Hero.getSpeed() * this.getBonusSpeed());
	}
}
