/**
 * Move class defining properties of a move
 * @author Logan Buyea & Paige Ludecker
 * 
 */
public class Move {
	
	String name;
	Type type;
	int damage;
	String damageType;
	int accuracy;
	String description;
	int effect;
	int pp;
	
	/*
	 * Effects: healing/leech, lower opponent stats, boost self stats,
	 * 		lower self stats, bide, bind/wrap, flinch, freeze, paralyze,
	 * 		multi hit, confusion, conversion, counter, highcrit, dig/fly,
	 * 		disable(disables move), recoil, dragon rage(40hp damage), 
	 * 		dream eater(leech if asleep), burn, explosion/sd, ohko,
	 * 		haze(stat reset), recharge, sleep,
	 * 		metronome, mimic, mirror move, mist, night shade, multihit self-confuse,
	 * 		poison, psywave, priority, rage, seismic toss, sonic boom,
	 * 		substitute, super fang, swift, transform
	 * 
	 * healing, damage over time, stat change, set damage/no power, incapacitate, recoil
	 * status effects, recover, ohko, dream eater, haze,  dragon rage, multi hit moves
	 * 
	 * transform, mimic, mirror move, metronome, sonic boom, priority, substitute,
	 * 
	 */
	
	/**
	 * Constructor
	 * @param n		the name of the move
	 * @param t		the type of the move (water/fire/grass/etc)
	 * @param d		the amount of damage it does
	 * @param dT	the type of damage (physical/special/status)
	 * @param a		the accuracy of the move
	 * @param p		the pp (power points) of the move, how many times it can be used
	 * @param desc	description of the move
	 */
	public Move(String n, Type t, String dT,int d, int a, int p, String desc) {
		name = n;
		type = t;
		damage = d;
		damageType = dT;
		accuracy = a;
		pp = p;
		description = desc;
		effect = determineEffect();
	}
	
	private int determineEffect() {
		int result = -1;
		
		return result;
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
	 * Getter for description
	 * @return the description of the move
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Getter for effect
	 * @return the effect of the move
	 */
	public int getEffect() {
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
	 * toString method override
	 */
	public String toString() {
		return name + " " + type + " " + damageType + " " + damage + " " + accuracy +  " " + pp + " " + description;
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