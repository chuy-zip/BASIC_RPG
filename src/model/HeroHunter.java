package model;

public class HeroHunter extends MainCharacter{

	public HeroHunter(String name) {
		super(name);
		setHeroType(5);
		setHP(35);
		setCurrentHP(9000);
		setGold(0);
		setAttack(2);
		setSpeed(1);
		
		getInventory().add(new HealthPot());
		getInventory().add(new HealthPot());
		getInventory().add(new DmgPot());
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void specialAbility() {
		setCurrentHP(getCurrentHP() + 5);
		setHP(getHP() + 5);
		System.out.println("\nHas ganado 5 puntos de salud por tu habilidad especial\n");
	}

}
