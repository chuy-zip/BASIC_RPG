package model;
/**
 * A much mor stronger enemy that infinitely scales its Damage with each turn
 * @author andre
 *
 */
public class Mage extends MainCharacter{
	public Mage(String name) {
		super(name);
		setHeroType(3);
		setHP(60);
		setCurrentHP(60);
		setGold(100);
		setAttack(20);
		setSpeed(15);
	}
	
	/**
	 * The minion special passive is to increase its damage by 5 points every turn
	 */
	@Override
	public void specialAbility() {
		setAttack( getAttack() + 5);
		System.out.println("El mago ha aumentado su ataque por 5 puntos");
		
	}
}