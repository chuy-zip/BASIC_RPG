package ui;

import java.util.ArrayList;
import java.util.Scanner;

import controler.EventCombat;
import controler.Store;
import model.Boss;
import model.ExtraBoss;
import model.HeroExplorer;
import model.HeroHunter;
import model.HeroPet;
import model.HeroWarrior;
import model.Mage;
import model.MainCharacter;
import model.Minion;

public class DriverProgram {
	
	public static void main(String[] args) {
		
		MainCharacter Hero;
		Store GameStore = new Store();
		EventCombat EventCombat = new EventCombat();
		ArrayList<MainCharacter> Enemies = new ArrayList<MainCharacter>(); 
		HeroPet Assistant;
		
		Scanner sc = new Scanner(System.in);
		Assistant = null;
		Hero = CreateNewHero(sc);
		if(Hero.getHeroType() == 5) {
			System.out.println("Cual es el nombre de tu fiel mascota dragon");
			String PetName = sc.next();
			Assistant = new HeroPet(PetName);
		}
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
					 * Al elegir la opcion de atacar empieza el combate por turnos
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
								Hero.specialAbility();
							}
							
							/**
							 * Solo ser? valido elegir a un segundo objetivo si hay 2 objetivos
							 */
							else if(target == 2 && Enemies.size() == 2) {
								EventCombat.HeroAttack(Hero, Enemies, 1);
								Hero.specialAbility();
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
						EventCombat.deleteEnemies(Enemies, Hero);
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
						for(int i = 0; i < Enemies.size(); i++) {
							Enemies.get(i).specialAbility();
						}
						
						/**
						 * Si la vida del jugaor llega a 0 se pierde el juego
						 */
						if(Hero.getCurrentHP() <= 0) {
							System.out.println("GameOver, te has quedado sin puntos de salud");
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
				Enemies.add(new Mage("Mago"));
				
				System.out.println("Te enfrentas a un poderoso mago, cuidado!");
				ShowHeroStats(Hero);
				showEnemiesStats(Enemies);
				int turn = 1;
				EventCombat.setCombatStatus(true);
				while(EventCombat.isCombatStatus()) {
					/**
					 * Al elegir la opcion de atacar empieza el combate por turnos
					 */
					if(turn == 1) {
						
						int battleOpt = battleMenu(sc);
						/**
						 * Esta la posibilidad de atacar o usar un item, la opcion 1 es para los items
						 */
						if(battleOpt == 1) {
							
							EventCombat.HeroAttack(Hero, Enemies, 0);
							Hero.specialAbility();
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
						EventCombat.deleteEnemies(Enemies, Hero);
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
						for(int i = 0; i < Enemies.size(); i++) {
							Enemies.get(i).specialAbility();
						}
						/**
						 * Si la vida del jugaor llega a 0 se pierde el juego
						 */
						if(Hero.getCurrentHP() <= 0) {
							System.out.println("GameOver, te has quedado sin puntos de salud");
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
			else if(action == 5) {
				Enemies.add(new Boss("Final Boss"));
				
				System.out.println("Te enfrentas al jefe final!");
				ShowHeroStats(Hero);
				showEnemiesStats(Enemies);
				int turn = 1;
				EventCombat.setCombatStatus(true);
				while(EventCombat.isCombatStatus()) {
					/**
					 * Al elegir la opcion de atacar empieza el combate por turnos
					 */
					if(turn == 1) {
						
						int battleOpt = battleMenu(sc);
						/**
						 * Esta la posibilidad de atacar o usar un item, la opcion 1 es para los items
						 */
						if(battleOpt == 1) {
							
							EventCombat.HeroAttack(Hero, Enemies, 0);
							Hero.specialAbility();
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
						EventCombat.deleteEnemies(Enemies, Hero);
						System.out.println(Enemies.size());
						if(Enemies.size() < 1) {
							EventCombat.setCombatStatus(false);
							System.out.println("Felicidades has vencido la jefe y has ganado!");
							System.exit(0);
						}
						turn = 2;
					}
					/**
					 * Para el turno del enemigo, se ataca por cada enemigo en el array
					 */
					else if(turn == 2) {
						EventCombat.EnemyAttack(Enemies, Hero);
						
						/**
						 * The special condition for this fight, is that having the shield unables the boss
						 * to make his special ability
						 */
						if (Hero.getWeapons()[1] == null) {
							for(int i = 0; i < Enemies.size(); i++) {
								System.out.println("El jefe final subira su ataque a 9999 dentro de: " + 
							((Boss)Enemies.get(i)).getFinalAtackCounter() + " turnos");
								Enemies.get(i).specialAbility();
							}
						}
						else {
							System.out.println("El escudo m?gico te protege de los ataques "
									+ "devastadores y el jefe no puede cargar su ataque!");
						}
						
						/**
						 * Si la vida del jugaor llega a 0 se pierde el juego
						 */
						if(Hero.getCurrentHP() <= 0) {
							System.out.println("GameOver, te has quedado sin puntos de salud");
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
			/////////////////////////////////////////////////////////////////////////////////
			else if(action == 6) {
				ExtraBoss RaidBoss = new ExtraBoss("Pesadilla, Rey de las sombras");
				
				Enemies.add(RaidBoss);
				Instructions();
				
				int EnemiesQty = (int) ( Math.random() * 2 + 1);
				for(int i = 0; i < EnemiesQty ; i++) {
					Enemies.add(new Mage("Mago+"));
				}
				System.out.println("Te enfrentas a: " + RaidBoss.getName());
				
				System.out.println("Y a este lo siguen: " + EnemiesQty + " Mago(s) +");
				
				ShowHeroStats(Hero);
				
				//Checking if the user has a pet
				if(Assistant != null) {
					ShowHeroStats(Assistant);
				}
				
				showEnemiesStats(Enemies);
				int turn = 1;
				EventCombat.setCombatStatus(true);
				while(EventCombat.isCombatStatus()) {
					/**
					 * Al elegir la opcion de atacar empieza el combate por turnos
					 */
					if(turn == 1) {
						
						int RaidbattleOpt = RaidbattleMenu(sc);
						/**
						 * Esta la posibilidad de atacar o usar un item, la opcion 1 es para los atacques
						 */
						if(RaidbattleOpt == 1) {
							
							int target = RaidtargetAtack(sc);
							
							/**
							 * Esta condicion es para poder saber cual es el objetivo a atacar
							 */
							if(target == 1) {
								EventCombat.HeroAttack(Hero, Enemies, 0);
								Hero.specialAbility();
								System.out.println("Has atacado al enemigo 1\n");
							}
							
							/**
							 * Solo sera valido elegir a un segundo objetivo si hay 2 objetivos
							 */
							else if(target == 2 && Enemies.size() == 2) {
								EventCombat.HeroAttack(Hero, Enemies, 1);
								Hero.specialAbility();
								System.out.println("Has atacado al enemigo 2\n");
							}
							
							/**
							 * Solo sera valido elegir a un segundo objetivo si hay 3 objetivos
							 */
							
							else if(target == 3 && Enemies.size() == 3) {
								EventCombat.HeroAttack(Hero, Enemies, 2);
								Hero.specialAbility();
								System.out.println("Has atacado al enemigo 3\n");
							}
							
						}
						
						/**
						 * La segunda opcion para el menu de ataque es utilizar un item
						 */
						else if (RaidbattleOpt == 2) {
							int itemOption = ItemSelection(sc);
							System.out.println(itemOption);
							if(itemOption == 1) {
								EventCombat.UseSelfitem(Hero, "Recovery Potion");
							}
							else if(itemOption == 2){
								EventCombat.UseAtackItem(Hero, Enemies,"Dangerous Potion");
							}
						}
						
						/*
						 * Opcion de curar mascota si esta existe
						 */
						else if (RaidbattleOpt == 3) {
							if(Assistant != null) {
								EventCombat.UseHealItemOnPet(Hero, "Recovery Potion", Assistant);
								
							}
							else {
								System.out.println("No tienes una mascota para realizar esta habilidad");
							}
						}
						
						/*
						 * Opcion para comandar un ataque con la mascota, si esta existe y no esta noqueada
						 */
						else if (RaidbattleOpt == 4) {
							if(Assistant != null && !Assistant.isThrowable()) {
								System.out.println("Han atacado al enemigo principal por:" + Assistant.getAttack());
								EventCombat.HeroAttack(Assistant, Enemies, 0);
								
							}
							else {
								System.out.println("No tienes una mascota disponible en este momento para realizar esta habilidad");
							}
						}
						
						/*
						 * Opcion para que la mascota defienda al heroe
						 */
						else if (RaidbattleOpt == 5) {
							if(Assistant != null && Assistant.getCurrentHP() > 0) {
								Assistant.setDefending(true);
								System.out.println(Assistant.getName() + " se para frente a ti y se dispone a protegerte hasta el fin");
								
							}
							else {
								System.out.println("No tienes una mascota disponible por el momento para hacer la accion");
							}
						}
						
						/*
						 * Opcion para lanzar a la mascota si esta esta noqueada, deben de pasar 3 turnos para que se recupere la mascota
						 * esto es parte de su habilidad pasiva que ocurre al final del turno enemigo
						 */
						else if (RaidbattleOpt == 6) {
							if(Assistant != null && Assistant.isThrowable()) {
								EventCombat.HeroAttack(Assistant, Enemies, 0);
								System.out.println("En un intento desesperado haz lanzado a tu querida mascota" + Assistant.getName() +"para atacar");
								
							}
							else {
								System.out.println("Al intentar lanzar a tu mascota te ha visto con una mirada preocupante, pierdes el turno"
										+ " Tal vez cuando este noqueado....");
							}
						}
						
						
						/**
						 * Revisar al final del turno del jugador si quedan enemigos
						 */
						EventCombat.deleteEnemies(Enemies, Hero);
						System.out.println("Quedan " + Enemies.size() + " Enemigo(s)");
						if(Enemies.size() < 1) {
							EventCombat.setCombatStatus(false);
							System.out.println("Felicidades has vencido el raid y completado el desafi?, Gracias por jugar!");
							System.exit(0);
						}
						System.out.println("Fin de tu turno__________________________________________________________________________________________________");
						
						turn = 2;
					}
					/**
					 * Para el turno del enemigo, se ataca por cada enemigo en el array de enemigos
					 */
					else if(turn == 2) {
						
						/*
						 * Verificacion para saber cual sera el objetivo, este es el caso en el que el usuario
						 * dicidio defenderse con su mascota
						 */
						if(Assistant != null && Assistant.isDefending()) {
							EventCombat.EnemyAttack(Enemies, Assistant);
							for(int i = 0; i < Enemies.size(); i++) {
								//Si el que esta atacando es el jefe final
								if(Enemies.get(i).getHeroType() == 7) {
									
									Enemies.get(i).specialAbility();
									// Y si su habilidad al azar espcial es la de clonar a la mascota (habilidad 3) si esta existe
									if(((ExtraBoss) Enemies.get(i)).getAbilityNumber() == 3 && Assistant != null) {
										((ExtraBoss) Enemies.get(i)).cloneHeroPet(Assistant);
										Hero.setCurrentHP(Hero.getCurrentHP() - Assistant.getAttack());
									}
								}
								// LLevar a cabo la habilidad pasiva
								else {
									Enemies.get(i).specialAbility();
								}
								
							}
							
						}
						/*
						 * Caso en el cual el usuario no decidio defenderse con la mascota, el recibe los ataques como
						 * como lo es en general
						 */
						else {
							EventCombat.EnemyAttack(Enemies, Hero);
							for(int i = 0; i < Enemies.size(); i++) {
								if(Enemies.get(i).getHeroType() == 7) {
									
									Enemies.get(i).specialAbility();
									// Y si su habilidad al azar espcial es la de clonar a la mascota (habilidad 3) si esta existe
									if(((ExtraBoss) Enemies.get(i)).getAbilityNumber() == 3 && Assistant != null) {
										((ExtraBoss) Enemies.get(i)).cloneHeroPet(Assistant);
										Hero.setCurrentHP(Hero.getCurrentHP() - Assistant.getAttack());
									}
								}
							}
						}
						/**
						 * Si la vida del jugaor llega a 0 se pierde el juego
						 */
						if(Hero.getCurrentHP() <= 0) {
							System.out.println("GameOver, te has quedado sin puntos de salud");
							EventCombat.setCombatStatus(false);
							System.exit(0);
							
						}
						//Las abilidades de la mascota se activan luego del turno enemigo (FInal de los turnos)
						if(Assistant != null) {
							Assistant.setDefending(false);
							Assistant.specialAbility();
						}
						
						/**
						 * Mostrar las estadisticas luego del turno 2
						 */
						ShowHeroStats(Hero);
						//Checking if the user has a pet
						if(Assistant != null) {
							ShowHeroStats(Assistant);
						}
						showEnemiesStats(Enemies);
						
						turn = 1;
					}
					
				}	
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
							"2. Un aventurero, que posee mayor oro y objetos al comienzo\n"+
							"3. Un Cazador, Muy poco poder de ataque pero gran vida y podr?s tener una mascota para los Raids");
		
		int heroClass = Integer.parseInt(scan.next());
		
		System.out.println("?Cual es tu nombre?");
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
			
			else if(heroClass == 3){
				hero =  new HeroHunter(heroName);
				
				System.out.println("Todo Listo cazador, tu aventura comienza ahora!");
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
		System.out.println("1. Luchar contra un enemigo peque?o\n" + 
							"2. Ver las stats (Incluyendo los items disponibles)\n" + 
							"3. Abrir la tienda\n" +
							"4. Luchar contra un enemigo fuerte\n"+
							"5. Luchar contra el jefe final\n"+ 
							"6. Participar en un Raid");
		int Choice = Integer.parseInt(scan.next()); 
		return Choice;
	}
	
	private static int ShopUI(Scanner scan) {
		System.out.println("\nBienvenido a la tienda que desea comprar");
		System.out.println("1. Pocion de vida , 20 monedas \n(Item COnsumible que regenera el 30% de la vida m?xima)\n" + 
				"\n2. Pocion de da?o, 50 monedas \n(Objeto que se usa en batalla y golpea a todos los enemigos por 40 puntos de salud)\n" + 
				"\n3. Comprar elixir de Resistencia, 35 monedas \\n (Agregar 5 puntos de salud y velocidad permanentemente)\n" +
				"\n4. Comprar elixir de Ataque, 35 monedas \n (Agregar 7 puntos de ataque permanentemente)\n"+
				"\n5. Comprar Espada de Leyenda, 200 monedas \n (Espada que quintuplica los puntos de ataque 1 vez, aumenta mucho la velocidad)\n" +
				"\n6. Comprar Escudo M?gico, 300 monedas \n (Espada que multiplica los puntos de salud por 7 1 vez, multiplica por 2 la velocidad)\n"+
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
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	//Specefic elements for ui in raid Battles
	private static void Instructions() {
		System.out.println("**************************************************************************************************************************************************************");
		System.out.println("Bienvenido a las Raid Battles, aque te encontraras con un jefe formidable que puede venir acompa?ado por 1 o mas enemigos"
				+ "\nLos cazadores tienen la posibilidad de poder usar mascotas en esta area, pero si no tienes una..... bueno te deseamos suerte :)");
		
	}
	//Menu de raid Battle con todas las opciones
	private static int RaidbattleMenu(Scanner scan) {
		System.out.println("\nSelect the action you want to do");
		System.out.println("1. Atacar          2. Utilizar un item \n" + 
							"\n3. Sanar Mascota    4. Ataque Mascota (Da Prioridad al jefe)\n"
							+"\n5. Proteccion de Mascota    6. Lanzar Mascota :o (Da Prioridad al jefe)");
		int Choice = Integer.parseInt(scan.next());
		return Choice;
	}
	
	//Menu para elegir objetivo para raid battle
	private static int RaidtargetAtack(Scanner scan) {
		System.out.println("Desea atacar al objetivo 1, 2, o 3 (No ocurrirra nada si eliges un enemigo que ya fue derrotado)");
		int choice = Integer.parseInt(scan.next());
		
		return choice;
	}
}
