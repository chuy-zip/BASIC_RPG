package model;

import java.util.ArrayList;

/**
 * This class defines the qualities of each different type of hero and also enemies
 * the constructor only saves name. The other charactersitcs 
 * and special ability may vary from each type of hero or enemy
 * There will also only be 2 weopn slots (Only 2 weapons in the game)
 * @author Ricardo Chuy
 *
 */
public abstract class MainCharacter {
	
	protected int HeroType;
	protected String Name;
	protected int HP;
	protected int currentHP;
	protected int Gold;
	protected int Attack;
	protected int Speed;
	protected Equipment[] Weapons;
	protected ArrayList<Items> Inventory;
	
	public MainCharacter(String name){
		setName(name);
		Weapons = new Equipment[1];
		Inventory = new ArrayList<Items>();
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public int getGold() {
		return Gold;
	}

	public void setGold(int gold) {
		Gold = gold;
	}

	public int getAttack() {
		return Attack;
	}

	public void setAttack(int attack) {
		Attack = attack;
	}

	public int getSpeed() {
		return Speed;
	}

	public void setSpeed(int speed) {
		Speed = speed;
	}

	public Equipment[] getWeapons() {
		return Weapons;
	}

	public void setWeapons(Equipment[] weapons) {
		Weapons = weapons;
	}

	public ArrayList<Items> getInventory() {
		return Inventory;
	}

	public void setInventory(ArrayList<Items> inventory) {
		Inventory = inventory;
	}
	
	public int getHeroType() {
		return HeroType;
	}

	public void setHeroType(int heroType) {
		HeroType = heroType;
	}

	public void specialAbility() {
		
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}
	
	
	
} 
