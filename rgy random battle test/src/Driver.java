/**
 * 
 * @author Logan Buyea & Paige Ludecker
 * 
 */
public class Driver {

	public static void main(String[] args) {
		String[] fireW = new String[] {"Water","Ground","Rock"};
		String[] fireR = new String[] {"Grass","Fire","Bug"};
		//Type fire = new Type("Fire", fireW, fireR);
		
		String[] waterW = new String[] {"Electric","Grass"};
		String[] waterR = new String[] {"Fire","Ice","Water"};
		//Type water = new Type("Water", waterW, waterR);
		
		//System.out.println("Fire vs Water: " + water.checkEff(fire));
		//System.out.println("Water vs Fire: " + fire.checkEff(water));
		
		View view = new View();
		view.menuDisplay();
		
		
		/**
		 * http://www.smogon.com/rb/articles/differences
		 * https://sites.google.com/site/rbysite/rby-mechanics/1-1-stat-and-damage-formulas
		 * 	controller class runs battle loop
		 * 		-damage calculation, win conditions, comparing speed stats, various 
		 * 		 battle rules(sleep clause, etc??)
		 * 	STARTED player/trainer class
		 * 		-contains team array, player name
		 *
		 *  STARTED pokemon
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
		 * 	STARTED move
		 *  	-165 moves
		 *  	-type, damage type(physical/special/status), damage, accuracy, effect, pp
		 *  	-every move is a child of the move class
		 *  	-OR every move is a move object in an array built from file input
		 *  	-Formula to calculate a Pokemon's critical hit ratio : CH%=BaseSpeed*100/512
		 * 		-Formula to calculate a Pokemon's High Critical Hit ratio: CH%=BaseSpeed*100/64
		 *  	-no methods
		 * 	STARTED type
		 * 		-array of types
		 * 		-method describing effictiveness of every type matchup
		 *  STARTED view
		 *  	-text based
		 *  	-menu
		 *  		-random battle, two players assigned random pokemon with random (learnable)
		 *  		 movesets
		 *  		-team builder, select pokemon and movesets, save to a file
		 *  		-battle, each player selects team from input file, either made from team
		 *  		 builder, or text file formatted correctly
		 *  		-exit
		 *  	-hp as current/max
		 *  	-given enough time possibly ascii sprites?
		 *  	
		 */
	}

}
