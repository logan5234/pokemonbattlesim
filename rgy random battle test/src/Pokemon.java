/**
 * 
 * @author Logan Buyea & Paige Ludecker
 *
 */
public class Pokemon {
	
	String name;
	String nickname;
	Type type1;
	Type type2;
	int health;
	int attack;
	int defence;
	int special;
	int speed;
	String status;
	Move[] moveset;
	Move[] learnableMoves;
	
	/**
	 * Constructor
	 * @param n		the name of the pokemon species
	 * @param nn	the nickname of the pokemon
	 * @param t1	the type of the pokemon
	 * @param t2	the secondary type of the pokemon
	 * @param hp	the health/hit points of the pokemon
	 * @param atk	the attack stat of the pokemon
	 * @param def	the defence stat of the pokemon
	 * @param spc	the special stat of the pokemon
	 * @param spe	the speed stat of the pokemon
	 * @param ls	the learnable moves of the pokemon
	 */
	public Pokemon(String n,String nn,Type t1,Type t2,int hp,int atk,int def,int spc,int spe,Move[] lm) {
		name = n;
		nickname = nn;
		type1 = t1;
		type2 = t2;
		health = hp;
		attack = atk;
		defence = def;
		special = spc;
		speed = spe;
		learnableMoves = lm;
	}
	/**
	 * Constructor
	 * @param n		the name of the pokemon species
	 * @param t1	the type of the pokemon
	 * @param t2	the secondary type of the pokemon
	 * @param hp	the health/hit points of the pokemon
	 * @param atk	the attack stat of the pokemon
	 * @param def	the defence stat of the pokemon
	 * @param spc	the special stat of the pokemon
	 * @param spe	the speed stat of the pokemon
	 * @param ls	the learnable moves of the pokemon
	 */
	public Pokemon(String n,Type t1,Type t2,int hp,int atk,int def,int spc,int spe,Move[] ls) {
		name = n;
		type1 = t1;
		type2 = t2;
		health = hp;
		attack = atk;
		defence = def;
		special = spc;
		speed = spe;
		learnableMoves = ls;
	}
	
	/**
	 * getters
	 */
	/**
	 * Getter for name
	 * @return name of the pokemon species
	 */
	public String getName() {
		return name;
	}
	/**
	 * Getter for nickname
	 * @return nickname of pokemon if one has been set
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * Getter for type1
	 * @return type of pokemon
	 */
	public Type getType1() {
		return type1;
	}
	/**
	 * Getter for type2
	 * @return secondary type of pokemon
	 */
	public Type getType2() {
		return type2;
	}
	/**
	 * Getter for health
	 * @return the current health of the pokemon
	 */
	public int getHP() {
		return health;
	}
	/**
	 * Getter for attack stat
	 * @return the attack stat of the pokemon
	 */
	public int getATK() {
		return attack;
	}
	/**
	 * Getter for defence stat
	 * @return the defence stat of the pokemon
	 */
	public int getDEF() {
		return defence;
	}
	/**
	 * Getter for special stat
	 * @return the special stat of the pokemon
	 */
	public int getSPC() {
		return special;
	}
	/**
	 * Getter for speed stat
	 * @return the speed stat of the pokemon
	 */
	public int getSPE() {
		return speed;
	}
	/**
	 * Getter for moveset
	 * @return the moveset array
	 */
	public Move[] getMoveset() {
		return moveset;
	}
	/**
	 * Getter for learnableMoves
	 * @return the learnableMoves array
	 */
	public Move[] getLearnableMoves() {
		return learnableMoves;
	}
	/**
	 * setters
	 */
	public void setHP(int hp) {
		health = hp;
	}
	public void setMoveset(Move[] ms) {
		moveset = ms;
	}
	/**
	 * toString method override
	 */
	public String toString() {
		String result = name + " ";
		if (nickname != "")
			result += "\"" + nickname + "\" ";
		return result;
	}
}





/** 	pokemon
 * 		-all at max level with max/most common stat setups
 * 		-name, type, array of four moves, health, status
 * 		-TODO (important for teambuilder)array of learnable moves?
 * 		-every different max evolved pokemon (so every available pokemon in this project)
 * 		 is a child of the pokemon class
 * 		-OR every pokemon is a pokemon object in an array built from file input
 * 		-each move has it's own method(so moveSlot1() uses move at index 1)
 * 		-venusaur, charizard, blastoise, butterfree, beedrill, pidgeot, raticate, 
 * 		 fearow, arbok, raichu, sandslash, nidoqueen, nidoking, clefable, ninetails, 
 * 		 wigglytuff, golbat, vileplume, parasect, venomoth, dugtrio, persian, golduck, 
 * 		 primeape, arcanine, poliwrath, alakazam, machamp, victreebel, tentacruel, 
 * 		 golem, rapidash, slowbro, magneton, farfetch'd, dodrio, dewgong, muk, cloyster,
 * 		 gengar, onix, hypno, kingler, electrode, exeggutor, marowak, hitmonlee, 
 * 		 hitmonchan, lickitung, weezing, rhydon, chansey, tangela, kangaskhan, seadra, 
 * 		 seaking, starmie, mr. mime, scyther, jynx, electabuzz, magmar, pinsir, tauros, 
 * 		 gyarados, lapras, ditto, vaporeon, jolteon, flareon, porygon, omastar, kabutops, 
 * 		 aerodactyl, snorlax, articuno, zapdos, moltres, dragonite, mewtwo, mew 
*/
