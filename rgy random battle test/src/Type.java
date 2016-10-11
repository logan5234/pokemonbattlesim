/**
 * Type class containing array of every type and it's weaknesses/strengths vs other types
 * @author Logan Buyea
 *
 */
public class Type {
	
	private static final String[] TYPES = {"Normal", "Fire", "Water", "Grass", "Flying",
			"Ground", "Rock", "Ice", "Bug", "Fighting", "Electric", "Poison", "Psychic",
			"Ghost", "Dragon"};
	private double effectiveness = 1;
	
	/**
	 * Constructor
	 */
	public Type(){
		
	}
	
	/**
	 * Called to determine the effectiveness of a move used on a pokemon
	 * @param moveType the type of the move used
	 * @param pFirst  the pokemon's first type
	 * @param pSecond the pokemon's second type, will be the same as the first unless pokemon
	 * 			is dual type
	 */
	public void detEff(Type moveType, Type pFirst, Type pSecond) {
		double eff = 1;
		//switch statement maybe?
		//trash this method and then create an effictiveness class?
		//contains an array of every type, each type has an array of weaknesses/strengths as a
		//instance variable. type class has no methods, only properties. creating array just feed
		//in the effectiveness chart.
	}
}
