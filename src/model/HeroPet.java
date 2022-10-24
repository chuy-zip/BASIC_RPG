package model;

public class HeroPet extends MainCharacter{

	private boolean Throwable;
	private int ReviveCounter;
	
	public HeroPet(String name) {
		super(name);
		setHeroType(6);
		setHP(50);
		setCurrentHP(50);
		setGold(0);
		setAttack(30);
		setSpeed(1);
		setReviveCounter(3);
	}

	@Override
	public void specialAbility() {
		if(getCurrentHP() < 0) {
			setThrowable(true);
			setReviveCounter(getReviveCounter() - 1);
			
			if(getReviveCounter() <= 0) {
				setCurrentHP(50);
				System.out.println("Luego de descansar unos turnos tu mascota se a recuperado!");
				
			}
		}
		
		System.out.println("Tu mascota se ha debilitado");
	}

	public boolean isThrowable() {
		return Throwable;
	}

	public void setThrowable(boolean throwable) {
		Throwable = throwable;
	}

	public int getReviveCounter() {
		return ReviveCounter;
	}

	public void setReviveCounter(int reviveCounter) {
		ReviveCounter = reviveCounter;
	}
	
	
}
