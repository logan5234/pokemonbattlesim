import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.ImageIcon;

/**
* Controller class
* @author Paige Ludecker & Logan Buyea
* 
*/
public class Controller {
	
	private View2 v;
	private boolean win;
	private boolean validChoice;
	private boolean someoneLeftAlive;
	private char menuChoice;
	private Pokemon[] teamR;
	private Pokemon[] teamB;
	private int healthR;
	private int healthB;
	private Pokemon pokeR;
	private Pokemon pokeB;
	private Move moveR;
	private Move moveB;
	private int speedR;
	private int speedB;
	private int pokeNum;
	private String rName;
	private String bName;
	private Type[] typeArray;
	private Move[] moveArray;
	private Pokemon[] pokemonArray;

	/**
	* Contructor
	* Commented out testing
	*/
	public Controller() {
		v = new View2();
		typeArray = initTypeArray();
		moveArray = initMoveArray();
		pokemonArray = initPokemonArray();
		teamR = new Pokemon[6];
		teamB = new Pokemon[6];
		
		//View testing section
		/*String answer = v.buildTeam();
		System.out.println(answer);
		String nameAnswer = v.chooseTeamName(1);
		System.out.println(nameAnswer);
		Pokemon[] teamX = {pokemonArray[4], pokemonArray[72], pokemonArray[81], pokemonArray[56], pokemonArray[0], pokemonArray[22]};
		Pokemon chosen = v.choosePoke(teamX);
		Move[] setX = {moveArray[1], moveArray[4], moveArray[20], moveArray[45]};
		v.setUpBattle(pokemonArray[22], pokemonArray[4]);
		v.commentary(chosen.getName());
		Move m = v.chooseMove(setX);
		System.out.println(m.getName());
		v.commentary("Overlap working?");
		Move[] moveSetX = pokemonArray[44].getLearnableMoves();
		System.out.println(moveSetX[1].toString());*/
		
		
		win = false;
		someoneLeftAlive = false;
		menuChoice = v.mainMenu();
		while (true) {
		if (menuChoice == 'C') {
			rName = customTeamBuilder(1);
			bName = customTeamBuilder(2);
			String w = battleLoop(rName, bName);
			v.commentary(w + " has won the battle");
			menuChoice = v.mainMenu();
		} else if (menuChoice == 'R') {
			randomBattleInit();
			rName = "Red";
			bName = "Blue";
			String w = battleLoop(rName,bName);
			v.commentary(w + " has won the battle"); //or something like that
			menuChoice = v.mainMenu();
		}}
	}

	/**
	* The method that controls the battle
	* @param teamR  An array of 6 pokemon objects
	* @param teamB  An array of 6 pokemon objects
	*/

	public String battleLoop(String redName, String blueName) {
		win = false;
		String winner = "";
		healthR = teamR[0].getHP();
		healthB = teamB[0].getHP();
		speedR = teamR[0].getSPE();
		speedB = teamB[0].getSPE();
		pokeR = teamR[0];
		pokeB = teamB[0];
		int fairMoveCount = 0;


		while (!win) {
			v.setUpBattle(pokeR, pokeB);
			//compare speed, higher speed moves first
			while (healthR > 0 && healthB > 0) {
				v.commentary(redName + " sent out " + pokeR.getName() + ", " + blueName + " sent out " + pokeB.getName());
				validChoice = false;
				v.commentary("Player 1 choose your move.");
				while (!validChoice) {
					moveR = v.chooseMove(pokeR.getMoveset());
					if (moveR.getPP() > 0) {validChoice = true;}
				}
				validChoice = false;
				v.commentary("Player 2 choose your move.");
				while (!validChoice) {
					moveB = v.chooseMove(pokeB.getMoveset());
					if (moveB.getPP() > 0) {validChoice = true;}
				}
				
				if (speedR == speedB) {
					if (fairMoveCount % 2 == 0) {
						useMoveR();
						v.commentary(pokeR.getName() + " used " + moveR.getName());
						if (healthB > 0) {
							useMoveB();
							v.commentary(pokeB.getName() + " used " + moveB.getName());
						}
						fairMoveCount++;
					} 
				 else {
						useMoveB();
						v.commentary(pokeB.getName() + " used " + moveB.getName());
						if (healthR > 0) {
							useMoveR();
							v.commentary(pokeR.getName() + " used " + moveR.getName());
						}
						
						fairMoveCount++;
					}}  
				 else if (speedR > speedB) {
					useMoveR();
					v.commentary(pokeR.getName() + " used " + moveR.getName());
					if (healthB > 0) {
						useMoveB();
						v.commentary(pokeB.getName() + " used " + moveB.getName());
					} }
				 else {
					useMoveB();
					v.commentary(pokeB.getName() + " used " + moveB.getName());
					if (healthR > 0) {
						useMoveR();
						v.commentary(pokeR.getName() + " used " + moveR.getName());
					}
				}
				
				
				//Checking if there are no pokemon left for either team, if so, the battle loop ends
				for (int i = 0; i < 6; i++) {
					if (teamR[i].getHP() > 0) {
						someoneLeftAlive = true;
					}
				}
				if (!someoneLeftAlive) {
					win = true; 
					winner = blueName;
				}
				someoneLeftAlive = false;
				for (int i = 0; i < 6; i++) {
					if (teamB[i].getHP() > 0) {
						someoneLeftAlive = true;
					}
				}
				if (!someoneLeftAlive) {
					win = true; 
					winner = redName;
				}
				
				//Setting to new Pokemon if any fainted in the last round of moves as long as 
				// there are still some left
				if (!win && healthR <= 0) { 
					validChoice = false;
					while (!validChoice) {
						pokeR = v.choosePoke(teamR);
						if (pokeR.getHP() > 0) {validChoice = true;}
					}
					v.commentary(redName + " sent out " + pokeR);
					healthR = pokeR.getHP();
					speedR = pokeR.getSPE();
					v.switchPokeR(pokeR);
				}
				if (!win && healthB <= 0) { 
					validChoice = false;
					while (!validChoice) {
						pokeB = v.choosePoke(teamB);
						if (pokeB.getHP() > 0) {validChoice = true;}
					}
					v.commentary(blueName + " sent out " + pokeB);
					healthB = pokeB.getHP();
					speedB = pokeB.getSPE();
					v.switchPokeB(pokeB);
				}
			}
		}
		return winner;
	}
	
	/**
	 * Runs the teambuilder to make custom teams of pokemon the user chooses
	 * @param n team number
	 * @return the name of the team
	 */
	private String customTeamBuilder(int n) {
		Random r = new Random();
		Move[] lm = {};
		Move[] ms = new Move[4];
		String s = v.chooseTeamName(n);
		for (int i = 0; i < 6; i++) {
			validChoice = false;
			while (!validChoice) {
				String x = v.buildTeam();
				pokeNum = Integer.parseInt(x)-1;
				if (pokeNum > 0 && pokeNum < 82) {validChoice = true;}
			}
				if (n == 1) {
					teamR[i] = new Pokemon(pokemonArray[pokeNum].getName(), pokemonArray[pokeNum].getType1(), pokemonArray[pokeNum].getType2(), 
							pokemonArray[pokeNum].getHP(), pokemonArray[pokeNum].getATK(), pokemonArray[pokeNum].getDEF(), 
							pokemonArray[pokeNum].getSPC(), pokemonArray[pokeNum].getSPE(), 
							pokemonArray[pokeNum].getLearnableMoves());
					System.out.print(teamR[i].getName());
					lm = teamR[i].getLearnableMoves();
					for (int j = 0; j < 4; j++) {
						ms[j] = lm[r.nextInt(lm.length)];
						System.out.println(ms[j]);
					}
					teamR[i].setMoveset(ms);
				} else {
					teamB[i] = new Pokemon(pokemonArray[pokeNum].getName(), pokemonArray[pokeNum].getType1(), pokemonArray[pokeNum].getType2(), 
							pokemonArray[pokeNum].getHP(), pokemonArray[pokeNum].getATK(), pokemonArray[pokeNum].getDEF(), 
							pokemonArray[pokeNum].getSPC(), pokemonArray[pokeNum].getSPE(), 
							pokemonArray[pokeNum].getLearnableMoves());
					System.out.print(teamB[i].getName());
					lm = teamB[i].getLearnableMoves();
					for (int j = 0; j < 4; j++) {
						ms[j] = lm[r.nextInt(lm.length)];
						System.out.println(ms[j]);
					}
					teamB[i].setMoveset(ms);
				}
		}
		return s;
	}
	
	/**
	 * Initializes two random teams of pokemon
	 */
	private void randomBattleInit() {
		int n = 0;
		Random r = new Random();
		int rNum = r.nextInt(82);
		Move[] ms = new Move[4];
		Move[] lm = {};
		System.out.println(rNum);
		for (int i = 0; i < 6; i++) {
			teamR[i] = new Pokemon(pokemonArray[rNum].getName(), pokemonArray[rNum].getType1(), pokemonArray[rNum].getType2(), 
					      pokemonArray[rNum].getHP(), pokemonArray[rNum].getATK(), pokemonArray[rNum].getDEF(), 
					      pokemonArray[rNum].getSPC(), pokemonArray[rNum].getSPE(), 
					      pokemonArray[rNum].getLearnableMoves());
			rNum = r.nextInt(82);
			lm = teamR[i].getLearnableMoves();
			for (int j = 0; j < 4; j++) {
				ms[j] = lm[r.nextInt(lm.length)];
			}
			teamR[i].setMoveset(ms);
		}
		for (int i = 0; i < 6; i++) {
			teamB[i] = new Pokemon(pokemonArray[rNum].getName(), pokemonArray[rNum].getType1(), pokemonArray[rNum].getType2(), 
					      pokemonArray[rNum].getHP(), pokemonArray[rNum].getATK(), pokemonArray[rNum].getDEF(), 
					      pokemonArray[rNum].getSPC(), pokemonArray[rNum].getSPE(), 
					      pokemonArray[rNum].getLearnableMoves());
			rNum = r.nextInt(82);
			lm = teamB[i].getLearnableMoves();
			for (int j = 0; j < 4; j++) {
				ms[j] = lm[r.nextInt(lm.length)];
			}
			teamB[i].setMoveset(ms);
		}
	}
	
	/**
	 * Calculates the damage a given move will cause on a given pokemon
	 * @param user		the pokemon that used the move
	 * @param target	the pokemon the move was used against
	 * @param move		the move used
	 * @return			the damage caused
	 * Total damage = {{[[(Level * CH * 2 / 5)} + 2] * Attack * Power / Defense} / 50]} + 2} * X} * Random / 255}
	 */
	private double damageCalc(Pokemon user,Pokemon target,Move move) {
		double result = 0;
		int atk = 0;
		int def = 0;
		double STAB = 1;
		if (move.getDamageType().equals("Special")) {
			atk = user.getSPC();
			def = target.getSPC();
		} else if (move.getDamageType().equals("Physical")) {
			atk = user.getATK();
			def = target.getDEF();
		}
		if (user.getType1().equals(move.getType()) || user.getType2().equals(move.getType()))
			STAB = 1.5;
		
		result = (((((42 * atk * move.getDamage() / def) / 50) + 2) * (STAB * target.getType1().checkEff(move.getType())))
				* ThreadLocalRandom.current().nextInt(217,256) / 255);
		return result;
	}
	
	
	/**
	 * Uses player 1's selected move
	 */
	private void useMoveR() {
		if (!moveR.getDamageType().equals("Status")) {
			pokeB.setHP((int) (pokeB.getHP() - damageCalc(pokeR,pokeB,moveR)));
			healthB = (int) (pokeB.getHP() - damageCalc(pokeR,pokeB,moveR));
		}
		//do effect
		v.moveUpdateR(pokeR, pokeB);
	}
	/**
	 * Uses player 2's selected move
	 */
	private void useMoveB() {
		if (!moveB.getDamageType().equals("Status")) {
			pokeR.setHP((int) (pokeR.getHP() - damageCalc(pokeB,pokeR,moveB)));
			healthR = (int) (pokeB.getHP() - damageCalc(pokeR,pokeB,moveR));
		}
		//do effect
		v.moveUpdateB(pokeR,pokeB);
	}
	
	/**
	 * Scans an input file and builds an array from the contents
	 * @return array of Type objects containing every type available for pokemon and moves
	 */
	private Type[] initTypeArray() {
		Type[] typeArray = new Type[16];
		String name = "";
		String[] weakness = {};
		String[] resist = {};
		String[] immune = {};
		int counter = 0;
		try {
			Scanner inputScan = new Scanner(new File("src/types")).useDelimiter(",");
			
			while (counter < 16) {
				if (inputScan.hasNextLine()) {
					name = inputScan.next();
					weakness = inputScan.next().split(" ");
					resist = inputScan.next().split(" ");
					immune = inputScan.next().split(" ");
					inputScan.nextLine();
				}
				typeArray[counter] = (new Type(name,weakness,resist,immune));
				counter++;
			}
			inputScan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return typeArray;
	}
	
	/**
	 * Scans input file containing moves and builds an array from the contents
	 * @return array of Move objects including every move available to pokemon
	 */
	private Move[] initMoveArray() {
		Move[] moveArray = new Move[161];
		String name = "";
		Type type = typeArray[0];
		String inputType = "";
		String damageType = "";
		int damage = 0;
		int accuracy = 0;
		int pp = 0;
		String effect = "";
		int counter = 0;
		try {
			Scanner inputScan = new Scanner(new File("src/moves")).useDelimiter(",");
			while (counter < 161) {
				if (inputScan.hasNextLine()) {
					name = inputScan.next();
					inputType = inputScan.next();
					for (int i = 0;i < 16;i++)
						if (inputType.equals(typeArray[i].toString()))
							type = typeArray[i];
					damageType = inputScan.next();
					damage = Integer.parseInt(inputScan.next());
					accuracy = Integer.parseInt(inputScan.next());
					pp = Integer.parseInt(inputScan.next());
					effect = inputScan.next();
				}
				moveArray[counter] = (new Move(name,type,damageType,damage,accuracy,pp,effect));
				counter++;
			}
			inputScan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return moveArray;
	}
	/**
	 * Scans an input file and builds an array from the contents
	 * @return array of Pokemon objects containing every available pokemon
	 */
	private Pokemon[] initPokemonArray() {
		Pokemon[] pokemonArray = new Pokemon[82];
		String name = "";
		Type type1 = typeArray[0];
		String inputType1 = "";
		Type type2 = typeArray[0];
		String inputType2 = "";
		int hp = 0;
		int atk = 0;
		int def = 0;
		int spc = 0;
		int spe = 0;
		String[] lm = {};
		Move[] learnableMoves;
		int counter = 0;
		try {
			//TODO move while loop to private helper method
			Scanner inputScan = new Scanner(new File("src/pokemon")).useDelimiter("\\.");
			while (counter < 82) {
				if (inputScan.hasNextLine()) {
					name = inputScan.next();
					inputType1 = inputScan.next();
					for (int i = 0;i < 16;i++)
						if (inputType1.equals(typeArray[i].toString()))
							type1 = typeArray[i];
					inputType2 = inputScan.next();
					for (int i = 0;i < 16;i++)
						if (inputType2.equals(typeArray[i].toString()))
							type2 = typeArray[i];
					hp = Integer.parseInt(inputScan.next());
					atk = Integer.parseInt(inputScan.next());
					def = Integer.parseInt(inputScan.next());
					spc = Integer.parseInt(inputScan.next());
					spe = Integer.parseInt(inputScan.next());
					lm = inputScan.next().split(",");
				}
				//TODO move this to private helper method
				learnableMoves = new Move[lm.length];
				for (int i = 0; i < lm.length; i++) {
					int j = Integer.parseInt(lm[i]);
					learnableMoves[i] = moveArray[j];
				}
				pokemonArray[counter] = new Pokemon(name,type1,type2,hp,atk,def,spc,spe,learnableMoves);
				counter++;
			}
			inputScan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return pokemonArray;
	}
}
