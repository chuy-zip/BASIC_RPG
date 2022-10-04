package model;
/**
 * This is the strongest possible enemy in the game
 * Can only be fought once and when defeated the game ends
 * @author Ricardo Chuy
 *
 */
public class Boss extends MainCharacter{
	
	private int FinalAtackCounter;
	
	public Boss(String name) {
		super(name);
		setHeroType(4);
		setHP(500);
		setCurrentHP(500);
		setGold(9999);
		setAttack(100);
		setSpeed(40);
		setFinalAtackCounter(10);
	}
	
	/**
	 * The boss passive is to increase its atack to the maximum possible to 
	 * one shot the player with one atack if the combat reaches 10 turns
	 */
	public void specialAbility() {
		setFinalAtackCounter(getFinalAtackCounter() - 1);
		
		if(getFinalAtackCounter() == 0) {
			setAttack(99999999);
		}
		
	}

	public int getFinalAtackCounter() {
		return FinalAtackCounter;
	}

	public void setFinalAtackCounter(int finalAtackCounter) {
		FinalAtackCounter = finalAtackCounter;
	}
	
}
