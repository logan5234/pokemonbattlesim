import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
* Controller class
* @author Paige Ludecker & Logan Buyea
* 
*/
public class Controller {
	private boolean win;
	private int healthR;
	private int healthB;
	private Pokemon pokeR;
	private Pokemon pokeB;
	private Type[] typeArray;
	private Move[] moveArray;
	private Pokemon[] pokemonArray;

	/**
	* Contructor
	* 
	*/
	//TODO MAKE BIG METHODS INTO SMALLER METHODS
	public Controller() {
		View v = new View();
		typeArray = initTypeArray();
		moveArray = initMoveArray();
		pokemonArray = initPokemonArray();
		win = false;
		v.menuDisplay();
	}

	/**
	* The method that controls the battle
	* @param teamR  An array of 6 pokemon objects
	* @param teamB  An array of 6 pokemon objects
	*/

	public void battleLoop(Pokemon[] teamR, Pokemon[] teamB) {
		win = false;
		healthR = teamR[0].getHP();
		healthB = teamB[0].getHP();
		pokeR = teamR[0];
		pokeB = teamB[0];


		while (!win) {
			//compare speed, higher speed moves first
			while (healthR > 0 && healthB > 0) {
				//Choose moves
				//if (pokeR.getSpeed() > pokeB.getSpeed()) {useMove(moveR);}
				//else {useMove(moveB);}
				//When switching follow immediately by reassigning which was faster and reset 
				//health for team to new Pokemon health
				//First check if there are any pokemon left in array if not win = true;
			}
		}
	}
	
	/**
	 * Scans an input file and builds an array from the contents
	 * @return array of Type objects containing every type available for pokemon and moves
	 */
	private Type[] initTypeArray() {
		Type[] typeArray = new Type[16];
		try {
			Scanner inputScan = new Scanner(new File("src/types")).useDelimiter(",");
			String name = "";
			String[] weakness = {};
			String[] resist = {};
			String[] immune = {};
			int counter = 0;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return typeArray;
	}
	
	/**
	 * Scans input file containing moves and builds an array from the contents
	 * @return array of Move objects including every move available to pokemon
	 */
	private Move[] initMoveArray() {
		Move[] moveArray = new Move[160];
		try {
			Scanner inputScan = new Scanner(new File("src/moves")).useDelimiter(",");
			String name = "";
			Type type = typeArray[0];
			String inputType = "";
			String damageType = "";
			int damage = 0;
			int accuracy = 0;
			int pp = 0;
			String effect = "";
			int counter = 0;
			while (counter < 160) {
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
				for (int i = 0;i < 160;i++) {
					for (int j = 0;j < lm.length;j++) {
						if (lm[j] == moveArray[i].getName())
							learnableMoves[j] = moveArray[i];
					}
				}
				pokemonArray[counter] = new Pokemon(name,type1,type2,hp,atk,def,spc,spe,learnableMoves);
				counter++;
			}
			inputScan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pokemonArray;
	}
	
}
