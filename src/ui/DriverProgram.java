package ui;

import java.util.ArrayList;
import java.util.Scanner;

import controler.EventCombat;
import controler.Store;
import model.HeroExplorer;
import model.HeroWarrior;
import model.MainCharacter;
import model.Minion;

public class DriverProgram {
	
	public static void main(String[] args) {
		
		MainCharacter Hero;
		Store GameStore = new Store();
		EventCombat EventCombat = new EventCombat();
		ArrayList<MainCharacter> Enemies = new ArrayList<MainCharacter>(); 
		
		Scanner sc = new Scanner(System.in);
		Hero = CreateNewHero(sc);
		ShowHeroStats(Hero);
		
		while(true) {
		
			int action = GetPlayerAction(sc);
			
			if(action == 1) {
				
				int EnemiesQty = (int) ( Math.random() * 2 + 1);
				for(int i = 0; i < EnemiesQty ; i++) {
					Enemies.add(new Minion("Minion"));
				}
				System.out.println("Te enfrentas a: " + EnemiesQty + " Minion(s)");
				
				int turn = 1;
				EventCombat.setCombatStatus(true);
				
				while(EventCombat.isCombatStatus()) {
					/**
					 * Al elegir la opcion de atacar
					 */
					if(turn == 1) {
						
						int battleOpt = battleMenu(sc);
						/**
						 * Esta la posibilidad de atacar o usar un item, la opcion 1 es para los items
						 */
						if(battleOpt == 1) {
							
							int target = targetAtack(sc);
								
							/**
							 * Esta condicion es para poder saber cual es el objetivo a atacar
							 */
							if(target == 1) {
								EventCombat.HeroAttack(Hero, Enemies, 0);
							}
							
							/**
							 * Solo será valido elegir a un segundo objetivo si hay 2 objetivos
							 */
							else if(target == 2 && Enemies.size() == 2) {
								EventCombat.HeroAttack(Hero, Enemies, 1);
							}
						}
						
						/**
						 * La segunda opcion para el menu de ataque es utilizar un item
						 */
						else if (battleOpt == 2) {
							int itemOption = ItemSelection(sc);
							System.out.println(itemOption);
							if(itemOption == 1) {
								EventCombat.UseSelfitem(Hero, "Recovery Potion");
							}
							else if(itemOption == 2){
								EventCombat.UseAtackItem(Hero, Enemies,"Dangerous Potion");
							}
							
							
						}
						
						/**
						 * Revisar al final del turno del jugador si quedan enemigos
						 */
						EventCombat.deleteEnemies(Enemies);
						System.out.println(Enemies.size());
						if(Enemies.size() < 1) {
							EventCombat.setCombatStatus(false);
						}
						
						turn = 2;
					}
					
					/**
					 * Para el turno del enemigo, se ataca por cada enemigo en el array
					 */
					else if(turn == 2) {
						EventCombat.EnemyAttack(Enemies, Hero);
						
						/**
						 * Si la vida del jugaor llega a 0 se pierde el juego
						 */
						if(Hero.getCurrentHP() <= 0) {
							System.out.println("GameOver");
							EventCombat.setCombatStatus(false);
							System.exit(0);
							
						}
						
						turn = 1;
					}
					/**
					 * Mostrar las estadisticas luego de 1 turno
					 */
					ShowHeroStats(Hero);
					showEnemiesStats(Enemies);
				}
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
	private static void ShowHeroStats(MainCharacter hero) {
		System.out.println(hero);
		for(int i = 0; i < hero.getInventory().size() ; i++) {
			System.out.println("Item: " + hero.getInventory().get(i).getName());
			
		}
		System.out.println("#############################");
	}
	
	private static void showEnemiesStats(ArrayList<MainCharacter> enemies) {
		for(int i = 0; i < enemies.size(); i++) {
			System.out.println(enemies.get(i));
			System.out.println("#############################");
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

	
	private static int battleMenu(Scanner scan) {
		System.out.println("\nSelect the action you want to do");
		System.out.println("1. Atacar\n" + 
				"\n2. Utilizar un item\n");
		int Choice = Integer.parseInt(scan.next());
		return Choice;
	}
	
	private static int targetAtack(Scanner scan) {
		System.out.println("Desea atackar al objetivo 1 o al 2");
		int choice = Integer.parseInt(scan.next());
		
		return choice;
	}
	private static int ItemSelection(Scanner scan) {
		System.out.println("Deseas gastar una pocion de curacion (1) o una pocion de ataque (2)");
		int choiceItem = Integer.parseInt(scan.next());
		
		return choiceItem;
	}
	
}
