import java.util.Scanner;
/**
 * View class
 * @author Logan Buyea & Paige Ludecker
 *
 */
public class View {
	Scanner inputScan;
	Controller c;
	
	public View(Controller _c) {
		inputScan = new Scanner(System.in);
		c = _c;
		//testing
	}
	
	public void menuDisplay() {
		System.out.println("Pokemon Gen 1 Battle Simulator");
		boolean inMenu = true;
		System.out.println("Menu: [C]ustom Battle(NYI)" + ", [R]andom Battle(NYI)" +", [E]xit");
		while (inMenu) {
			switch (inputScan.next()) {
				case "C":
						inMenu = false;
						c.teamBattle();
						break;
				case "R":
						inMenu = false;
						c.randomBattle();
						break;
				case "E":
						inMenu = false;
						exit();
						break;
				default:
						System.out.println("Invalid input, try again");
						break;
			}
		}	
	}
	
	//How to represent which moves have no PP left??
	public Move chooseMove(Move[] moveList){
		Move moveX = null;
		System.out.println("Choose move:");
		System.out.println("[1] " + moveList[0].getName() + "    [2] " + moveList[1].getName());
		System.out.println("[3] " + moveList[2].getName() + "    [4] " + moveList[3].getName());
		boolean inMenu = true;
		while (inMenu) {
			switch (inputScan.next()) {
				case "1":
						inMenu = false;
						moveX = moveList[0];
						break;
				case "2":
						inMenu = false;
						moveX = moveList[1];
						break;
				case "3":
						inMenu = false;
						moveX = moveList[2];
						break;
				case "4":
						inMenu = false;
						moveX = moveList[3];
						break;
				default:
						System.out.println("Invalid input, try again");
						break;
			}
		}
		return moveX;
	}
	
	//How to represent which pokemon are already fainted??
	public Pokemon choosePoke(Pokemon[] pokeList){
		Pokemon pokeX = null;
		System.out.println("Choose next pokemon:");
		System.out.println("[1] " + pokeList[0].getName() + "    [2] " + pokeList[1].getName() + "    [3] " + pokeList[2].getName());
		System.out.println("[4] " + pokeList[3].getName() + "    [5] " + pokeList[4].getName() + "    [6] " + pokeList[5].getName());
		boolean inMenu = true;
		while (inMenu) {
			switch (inputScan.next()) {
				case "1":
						inMenu = false;
						pokeX = pokeList[0];
						break;
				case "2":
						inMenu = false;
						pokeX = pokeList[1];
						break;
				case "3":
						inMenu = false;
						pokeX = pokeList[2];
						break;
				case "4":
						inMenu = false;
						pokeX = pokeList[3];
						break;
				case "5":
						inMenu = false;
						pokeX = pokeList[4];
						break;
				case "6":
						inMenu = false;
						pokeX = pokeList[5];
						break;
				default:
						System.out.println("Invalid input, try again");
						break;
			}
		}
		return pokeX;
	}
	
	public void exit() {
		System.exit(0);
	}
}
