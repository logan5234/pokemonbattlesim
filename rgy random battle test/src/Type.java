/**
 * Type class containing array of every type and it's weaknesses/strengths vs other types
 * @author Logan Buyea & Paige Ludecker
 *
 */
public class Type {
	
	private String type;
	private String[] weaknesses;
	private String[] resists;
	private String[] immunes;
	
	/**
	 * Constructor
	 */
	public Type(String _type) {
		type = _type;
	}
	public Type(String _type, String[] w, String[] r, String[] i) {
		type = _type;
		weaknesses = w;
		resists = r;
		immunes = i;
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
	/**
	 * Getter for immunities array
	 * @return immunities array
	 */
	public String[] getImmunes() {
		return immunes;
	}
	/**
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
		for (int i = 0; i< immunes.length; i++)
			if (moveType.toString().equals(immunes[i].toString()))
				result *= 0;
		return result;
	}
	
	/**
	 * toString
	 */
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
