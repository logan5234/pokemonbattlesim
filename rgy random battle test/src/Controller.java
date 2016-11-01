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


	/**
	* Contructor
	* 
	*/
	
	public Controller() {

	View v = new View();
	win = false;
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
}
