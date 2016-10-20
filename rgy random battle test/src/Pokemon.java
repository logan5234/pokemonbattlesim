/**
 * 
 * @author Logan Buyea & Paige Ludecker
 *
 */
public class Pokemon {
	
	String name;
	String nickname;
	Type type;
	int health;
	String status;
	Move[] moveset;
	Move[] learnableMoves;
	
	/**
	 * Constructor
	 * @param _name		the name of the pokemon species
	 * @param _nickname the nickname of the pokemon if the trainer provides one
	 * @param _type		the type of the pokemon
	 * @param _moveset	the moveset of the pokemon
	 */
	public Pokemon(String _name, String _nickname, Type _type, Move[] _moveset) {
		name = _name;
		nickname = _nickname;
		type = _type;
		moveset = _moveset;
	}
	/**
	 * Constructor
	 * @param _name		the name of the pokemon species
	 * @param type		the type of the pokemon
	 * @param _moveset	the moveset of the pokemon
	 */
	public Pokemon(String _name, Type _type, Move[] _moveset) {
		name = _name;
		type = _type;
		moveset = _moveset;
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
	 * Getter for type
	 * @return type of pokemon
	 */
	public Type getType() {
		return type;
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
