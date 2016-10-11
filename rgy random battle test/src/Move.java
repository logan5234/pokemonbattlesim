/**
 * 
 * @author Logan Buyea
 *
 */
public class Move {
	
	Type type;
	int damage;
	String damageType;
	double accuracy;
	String effect;
	int pp;
	
	
	public Move(Type _type, int _damage, String _damageType, double _accuracy, String _effect, int _pp) {
		type = _type;
		damage = _damage;
		damageType = _damageType;
		accuracy = _accuracy;
		effect = _effect;
		pp = _pp;
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