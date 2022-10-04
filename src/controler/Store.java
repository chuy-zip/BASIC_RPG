package controler;
import model.Equipment;
import model.MainCharacter;
import model.DivineSword;
import model.MagicShield;

/**
 * A class for the item shop. Elixirs have permanent effects, but consumable items and 
 * the avaialable weapons in the game can also be purchased in the shop
 * @author andre
 *
 */
public class Store {
	private Equipment DivineSword;
	private Equipment MagicShield;
	
	public Store() {
		DivineSword = new DivineSword();
		MagicShield = new MagicShield();
	}
	
	public void buyEnduranceElixir(MainCharacter hero){
		int HpIncrese = 5;
		int SpeedIncrese = 5;
		hero.setHP(hero.getHP() + HpIncrese);
		hero.setSpeed(hero.getSpeed() + SpeedIncrese);
	}
	
	public void buyStrengthElixir(MainCharacter hero){
		int AttckIncrese = 5;
		hero.setAttack(hero.getAttack() + AttckIncrese);
	}
	
	public void buyShield(MainCharacter hero){
		if(hero.getWeapons()[0] != this.DivineSword) {
			hero.getWeapons()[0] = this.DivineSword;
		}
	}
	
	public void buySword(MainCharacter hero){
		if(hero.getWeapons()[1] != this.MagicShield) {
			hero.getWeapons()[1] = this.MagicShield;
		}
	}
	
}
