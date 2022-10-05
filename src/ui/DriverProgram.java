package ui;

import java.util.Scanner;

import controler.Store;
import model.HeroExplorer;
import model.HeroWarrior;
import model.MainCharacter;

public class DriverProgram {
	
	public static void main(String[] args) {
		
		MainCharacter Hero;
		Store GameStore = new Store();
		
		Scanner sc = new Scanner(System.in);
		Hero = CreateNewHero(sc);
		ShowHeroStats(Hero);
		
		while(true) {
			
			
			int action = GetPlayerAction(sc);
			
			if(action == 1) {
				
			}
			else if(action == 2) {
				ShowHeroStats(Hero);
			}
			
			else if(action == 3) {
				int StoreOption = ShopUI(sc);
				System.out.println("Opcion: " + StoreOption);
				
				if(StoreOption == 1) {
					if(GameStore.canBuyItem(Hero, 20)){
						GameStore.buyHealthPot(Hero);
						System.out.println("Comprado");
					}
					else {
						System.out.println("Oro insuficiente");
					}
					
				}
				else if(StoreOption == 2) {
					if(GameStore.canBuyItem(Hero, 50)){
						GameStore.buyDmgPot(Hero);
						System.out.println("Comprado");
					}
					else {
						System.out.println("Oro insuficiente");
					}
				}
				
				else if(StoreOption == 3) {
					if(GameStore.canBuyItem(Hero, 35)){
						GameStore.buyEnduranceElixir(Hero);
						System.out.println("Comprado");
					}
					else {
						System.out.println("Oro insuficiente");
					}
				}
				
				else if(StoreOption == 4) {
					if(GameStore.canBuyItem(Hero, 35)){
						GameStore.buyStrengthElixir(Hero);
						System.out.println("Comprado");
					}
					else {
						System.out.println("Oro insuficiente");
					}
				}
				
				else if(StoreOption == 5) {
					if(GameStore.canBuyItem(Hero, 200)){
						GameStore.buySword(Hero);
						System.out.println("Comprado");
					}
					else {
						System.out.println("Oro insuficiente");
					}
				}
				
				else if(StoreOption == 6) {
					if(GameStore.canBuyItem(Hero, 300)){
						GameStore.buyShield(Hero);
						System.out.println("Comprado");
					}
					else {
						System.out.println("Oro insuficiente");
					}
				}
				
				else if(StoreOption == 7) {
				}
				
			}
			
			else if(action == 4) {
				
			}
			else if(action == 5) {
				
			}
			
		}
			
	}
	
	/**
	 * Method that cerates a new hero at the beginning of the program
	 * @param scan
	 * @return The character
	 */
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
	
	/**
	 * Show the stats of a character
	 * @param hero
	 */
	public static void ShowHeroStats(MainCharacter hero) {
		System.out.println(hero);
		for(int i = 0; i < hero.getInventory().size() ; i++) {
			System.out.println("Item: " + hero.getInventory().get(i).getName());
		}
	}
	
	private static int GetPlayerAction(Scanner scan) {
		System.out.println("\nTe Encuentras en el menu principal que deseas hacer");
		System.out.println("1. Luchar contra un enemigo pequeño\n" + 
							"2. Ver las stats (Incluyendo los items disponibles)\n" + 
							"3. Abrir la tienda\n" +
							"4. Luchar contra un enemigo fuerte\n"+
							"5. Luchar contra el jefe final\n" );
		int Choice = Integer.parseInt(scan.next()); 
		return Choice;
	}
	
	private static int ShopUI(Scanner scan) {
		System.out.println("\nBienvenido a la tienda que desea comprar");
		System.out.println("1. Pocion de vida , 20 monedas \n(Item COnsumible que regenera el 30% de la vida máxima)\n" + 
				"\n2. Pocion de daño, 50 monedas \n(Objeto que se usa en batalla y golpea a todos los enemigos por 40 puntos de salud)\n" + 
				"\n3. Comprar elixir de Resistencia, 35 monedas \\n (Agregar 5 puntos de salud y velocidad permanentemente)\n" +
				"\n4. Comprar elixir de Ataque, 35 monedas \n (Agregar 7 puntos de ataque permanentemente)\n"+
				"\n5. Comprar Espada de Leyenda, 200 monedas \n (Espada que quintuplica los puntos de ataque 1 vez, aumenta mucho la velocidad)\n" +
				"\n6. Comprar Escudo Mágico, 300 monedas \n (Espada que multiplica los puntos de salud por 7 1 vez, multiplica por 2 la velocidad)\n"+
				"\n7. Salir de la tienda\n");
		int Choice = Integer.parseInt(scan.next());
		
		return Choice;
	}


}
