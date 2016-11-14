/**
 * Move class defining properties of a move
 * @author Logan Buyea & Paige Ludecker
 * SHOULD BE DONE
 */
public class Move {
	
	String name;
	Type type;
	int damage;
	String damageType;
	int accuracy;
	String effect;
	int pp;
	double critChance;
	
	/**
	 * Constructor
	 * @param n		the name of the move
	 * @param t		the type of the move (water/fire/grass/etc)
	 * @param d		the amount of damage it does
	 * @param dT	the type of damage (physical/special/status)
	 * @param a		the accuracy of the move
	 * @param p		the pp (power points) of the move, how many times it can be used
	 * @param e		any special effects the move might have(should be one or two words only)
	 */
	public Move(String n, Type t, String dT,int d, int a, int p, String e) {
		name = n;
		type = t;
		damage = d;
		damageType = dT;
		accuracy = a;
		pp = p;
		effect = e;
	}
	/**
	 * Getter for name
	 * @return the name of the move
	 */
	public String getName() {
		return name;
	}
	/**
	 * Getter for type
	 * @return the type of the move
	 */
	public Type getType() {
		return type;
	}
	/**
	 * Getter for damage
	 * @return the amount of damage move does
	 */
	public int getDamage() {
		return damage;
	}
	/**
	 * Getter for damageType
	 * @return the type of damage done
	 */
	public String getDamageType() {
		return damageType;
	}
	/**
	 * Getter for accuracy
	 * @return the accuracy of the move
	 */
	public double getAccuracy() {
		return accuracy;
	}
	/**
	 * Getter for effect
	 * @return the effect of the move
	 */
	public String getEffect() {
		return effect;
	}
	/**
	 * Getter for pp
	 * @return the remaining PP of the move
	 */
	public int getPP() {
		return pp;
	}
	
	/**
	 * Getter for crit chance
	 * @return the chance to critically hit on a damage move
	 */
	public double getCritChance() {
		return critChance;
	}
	
	/**
	 * toString method override
	 */
	public String toString() {
		return name + " " + type + " " + damageType + " " + damage + " " + accuracy +  " " + pp + " " + effect;
	}
}
/**move
*  	-165 moves
*  	-type, damage type(physical/special/status), damage, accuracy, effect, pp
*  	-every move is a child of the move class
*  	-OR every move is a move object in an array built from file input
*  	-Formula to calculate a Pokemon's critical hit ratio : CH%=BaseSpeed*100/512
* 		-Formula to calculate a Pokemon's High Critical Hit ratio: CH%=BaseSpeed*100/64
*  	-no methods
*/