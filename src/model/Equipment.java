package model;
/**
 * This class is the parent of all obtainable weapons, there are only 2 currently
 * Applied bonues stats depend on the weapon, so the metho must be overriten
 * @author andre
 *
 */
public abstract class Equipment {
	
	protected int bonusHP;
	protected int bonusAttack;
	protected int bonusSpeed;

	public int getBonusHP() {
		return bonusHP;
	}

	public void setBonusHP(int bonusHP) {
		this.bonusHP = bonusHP;
	}

	public int getBonusAttack() {
		return bonusAttack;
	}

	public void setBonusAttack(int bonusAttack) {
		this.bonusAttack = bonusAttack;
	}

	public int getBonusSpeed() {
		return bonusSpeed;
	}

	public void setBonusSpeed(int bonusSpeed) {
		this.bonusSpeed = bonusSpeed;
	}
	
	public void ApplyBonuses(MainCharacter Hero) {
		
	}
}
