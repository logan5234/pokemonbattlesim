import java.util.Scanner;
/**
 * View class
 * @author Logan Buyea & Paige Ludecker
 *
 */
public class View {
	Scanner inputScan;
	
	public View() {
		inputScan = new Scanner(System.in);
		//testing
	}
	
	public void menuDisplay() {
		System.out.println("Pokemon Gen 1 Battle Simulator");
		boolean inMenu = true;
		System.out.println("Menu: [R]andom Battle(NYI), [T]eam Builder(NYI), [B]attle(NYI)"
				+ ", [E]xit");
		while (inMenu) {
			switch (inputScan.next()) {
				case "R":
						inMenu = false;
						randomBattle();
						break;
				case "T":
						inMenu = false;
						teamBuilder();
						break;
				case "B":
						inMenu = false;
						battle();
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
	
	public void randomBattle() {
		//TODO
	}
	
	public void teamBuilder() {
		//TODO
	}
	
	public void battle() {
		//TODO
	}
	
	public void exit() {
		System.exit(0);
	}
}
