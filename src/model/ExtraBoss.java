package model;

public class ExtraBoss extends MainCharacter{

	private int CloneTimer;
	private int AbilityNumber;
	private MainCharacter Clone;
	private String name;
	
	
	public ExtraBoss(String name) {
		super(name);
		setHeroType(7);
		setHP(500);
		setCurrentHP(500);
		setGold(9999);
		setAttack(70);
		setSpeed(40);
		name = "";
		
		// TODO Auto-generated constructor stub
	}
	//This boss has diferent abilities and can clone de pet of the user
	@Override
	public void specialAbility() {
		setAbilityNumber((int) ( Math.random() * 3 + 1)) ;
		
		if(getAbilityNumber() == 1) {
			setAttack(getAttack() + 10);
			System.out.println("Pesadilla: El rey de las sombras ha mejorado su ataque con una de sus abilidades");
		}
		
		else if(getAbilityNumber() == 2){
			setCurrentHP(getCurrentHP() + 50);
			System.out.println("Pesadilla: El rey de las sombras se ha curado 50 puntos de vida con una de sus abilidades");
		}
		
	}

	public void cloneHeroPet(MainCharacter heroPet) {
		Clone = new HeroPet(heroPet.getName());
		System.out.println("Pesadilla a clonadoa " + heroPet.getName());
	}
	
	public int getCloneTimer() {
		return CloneTimer;
	}

	public void setCloneTimer(int cloneTimer) {
		CloneTimer = cloneTimer;
	}

	public int getAbilityNumber() {
		return AbilityNumber;
	}

	public void setAbilityNumber(int abilityNumber) {
		AbilityNumber = abilityNumber;
	}
	
	
}
