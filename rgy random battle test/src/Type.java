/**
 * Type class containing array of every type and it's weaknesses/strengths vs other types
 * @author Logan Buyea
 *
 */
public class Type {
	
	private String type;
	private String[] weaknesses;
	private String[] resists;
	
	/**
	 * Constructor
	 */
	public Type(String _type, String[] _weaknesses, String[] _resists) {
		type = _type;
		weaknesses = _weaknesses;
		resists = _resists;
	}
	/**
	 * Getter for the name of the type
	 * @return the name of the specific type instance
	 */
	public String getType() {
		return type;
	}
	/**
	 * Getter for weaknesses array
	 * @return weaknesses array
	 */
	public String[] getWeaknesses() {
		return weaknesses;
	}
	/**
	 * Getter for resists array
	 * @return resists array
	 */
	public String[] getResists() {
		return resists;
	}
	/** THIS ACTUALLY WORKS I'M A GENIUS
	 * Determines the effectiveness of a given type vs another type
	 * @param moveType the type of the move used against the pokemon of this type
	 * @return double to multiply the move's damage by
	 */
	public double checkEff(Type moveType) {
		double result = 1;
		for (int i = 0; i < weaknesses.length; i++)
			if (moveType.toString().equals(weaknesses[i].toString()))
				result *= 2;
		for (int i = 0; i < resists.length; i++)
			if (moveType.toString().equals(resists[i].toString()))
				result *= .5;
		return result;
	}
	
	public String toString() {
		return type;
	}
	
	/**
	 * Called to determine the effectiveness of a move used on a pokemon
	 * @param moveType the type of the move used
	 * @param pFirst  the pokemon's first type
	 * @param pSecond the pokemon's second type, will be the same as the first unless pokemon
	 * 			is dual type
	 *
	public void detEff(Type moveType, Type pFirst, Type pSecond) {
		double eff = 1;
		//switch statement maybe?
		//trash this method and then create an effictiveness class?
		//contains an array of every type, each type has an array of resistances as a
		//instance variable. type class has no methods, only properties. creating array just feed
		//in the effectiveness chart.
		//check resistance array on every move call then multiply damage by the double returned?
		//
	}*/
}
