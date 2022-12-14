package model;

public class ExtraBoss extends MainCharacter{

	private int CloneTimer;
	private int AbilityNumber;
	private MainCharacter Clone;
	
	
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
		System.out.println(getAbilityNumber());
		
		if(getAbilityNumber() == 1) {
			setAttack(getAttack() + 10);
			System.out.println(getName() + " ha mejorado su ataque con una de sus abilidades");
		}
		
		else if(getAbilityNumber() == 2){
			if(getCurrentHP() + 50 > getHP()) {
				setCurrentHP(500);
			}
			else {
				setCurrentHP(getCurrentHP() + 50);
			}
			
			System.out.println(getName() + " se ha curado 50 puntos de vida con una de sus abilidades");
		}
		
	}

	public void cloneHeroPet(MainCharacter heroPet) {
		Clone = new HeroPet(heroPet.getName());
		System.out.println(getName() + "Pesadilla a clonado a " + heroPet.getName() + " y lo ha hecho atacar");
		
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
