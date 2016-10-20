/** Trainer class representing a player, contains name and array of pokemon team
 *  
 * @author Logan Buyea & Paige Ludecker
 *
 */
public class Trainer {
	private String name;
	private Pokemon[] team;
	
	/**
	 * Constructor
	 * @param _name is the input name for the Trainer instance
	 * @param _team is the input team for the Trainer instance
	 */
	public Trainer(String _name) {
		setName(_name);
	}
	
	/**
	 * Setter for name variable
	 * @param newName is the new value for name
	 */
	public void setName(String newName) {
		name = newName;
	}
	
	public void setTeam(Pokemon[] newTeam) {
		newTeam = team;
	}
	/**
	 * Getter for name variable
	 * @return the name of the Trainer instance
	 */
	public String getName() {
		return name;
	}
	/**
	 * Getter for team
	 * @return the team array
	 */
	public Pokemon[] getTeam() {
		return team;
	}
	/**
	 * toString method returns Trainer name and team list
	 */
	public String toString() {
		//TODO print team array
		String result = "Pokemon Trainer " + name;
		for (int i = 0; i < team.length; i++)
			result += team[i].toString();
		return result; 
	}
}