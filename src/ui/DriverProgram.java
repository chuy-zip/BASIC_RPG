package ui;

import java.util.Scanner;
import model.HeroExplorer;
import model.HeroWarrior;
import model.MainCharacter;

public class DriverProgram {
	
	public static void main(String[] args) {
		
		MainCharacter Hero;
		
		Scanner sc = new Scanner(System.in);;
		
		Hero = CreateNewHero(sc);
		ShowHeroStats(Hero);
		
	}
	
	
	public static MainCharacter CreateNewHero(Scanner scan){
		MainCharacter hero;
		
		System.out.println("Bienvenido a una nueva emocionante aventura");
		System.out.println("Estas por enfrentarte a peligrosos enemigos y salvar al mundo");
		System.out.println("Que tipo de guerrero te gustaria ser:\n" + 
							"1. Un guerrero, con mayor fuerza y puntos de salud\n" +
							"2. Un aventurero, que posee mayor oro y objetos al comienzo");
		
		int heroClass = Integer.parseInt(scan.next());
		
		System.out.println("¿Cual es tu nombre?");
		String heroName = scan.next(); 
		
		while(true){
			if (heroClass == 1) {
				hero =  new HeroWarrior(heroName);
				System.out.println("Todo Listo guerrero, tu aventura comienza ahora!");
				return hero;
			}
			
			else if(heroClass == 2){
				hero =  new HeroExplorer(heroName);
				System.out.println("Todo Listo aventurero, tu aventura comienza ahora!");
				return hero;
			}
		}
		
	}
	
	public static void ShowHeroStats(MainCharacter hero) {
		System.out.println(hero);
	}

}
