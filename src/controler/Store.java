package controler;
import model.Equipment;
import model.HealthPot;
import model.MainCharacter;
import model.DivineSword;
import model.DmgPot;
import model.MagicShield;

/**
 * A class for the item shop. Elixirs have permanent effects, but consumable items and 
 * the avaialable weapons in the game can also be purchased in the shop. Each method represents
 * an item that can be purchased
 * @author Ricardo Chuy
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
		
		hero.setGold(hero.getGold() - 35);
	}
	
	public void buyStrengthElixir(MainCharacter hero){
		int AttckIncrese = 7;
		hero.setAttack(hero.getAttack() + AttckIncrese);
		
		hero.setGold(hero.getGold() - 35);
		
	}
	
	public void buyHealthPot(MainCharacter hero){
		hero.getInventory().add(new HealthPot());
		
		hero.setGold(hero.getGold() - 20);
	}
	
	public void buyDmgPot(MainCharacter hero){
		hero.getInventory().add(new DmgPot());
		
		hero.setGold(hero.getGold() - 50);
	}
	
	public void buyShield(MainCharacter hero){
		if(hero.getWeapons()[1] != this.DivineSword) {
			hero.getWeapons()[1] = this.DivineSword;
			hero.getWeapons()[1].ApplyBonuses(hero);
			hero.setGold(hero.getGold() - 300);
		}
	}
	
	public void buySword(MainCharacter hero){
		if(hero.getWeapons()[0] != this.MagicShield) {
			hero.getWeapons()[0] = this.MagicShield;
			hero.getWeapons()[0].ApplyBonuses(hero);
			hero.setGold(hero.getGold() - 200);
		}
	}
	
	public boolean canBuyItem(MainCharacter hero, int ItemCost) {
		if(hero.getGold() - ItemCost >= 0) {
			return true;
		}
		else {
			return false;
		}	
	}
	
}
