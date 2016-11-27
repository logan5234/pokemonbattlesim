import java.io.File;

import javax.swing.ImageIcon;

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
	ImageIcon frontSprite;
	ImageIcon backSprite;
	
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
		frontSprite = new ImageIcon("src/sprites/"+name+"2.png");
		backSprite = new ImageIcon("src/sprites/"+name+".png");
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
		frontSprite = new ImageIcon("src/sprites/"+name+"2.png");
		backSprite = new ImageIcon("src/sprites/"+name+".png");
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
	 * Getter for status
	 * @return the status of the pokemon
	 */
	public String getStatus() {
		return status;
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
	public ImageIcon getFront() {
		return frontSprite;
	}
	
	public ImageIcon getBack() {
		return backSprite;
	}
	/**
	 * setters
	 */
	/**
	 * Sets the hp of the pokemon
	 * @param hp to be set to
	 */
	public void setHP(int hp) {
		health = hp;
	}
	/**
	 * Sets the first type of the pokemon
	 * @param type1 to be set to
	 */
	public void setType1(Type type1) {
		this.type1 = type1;
	}
	/**
	 * Sets the second type of the pokemon
	 * @param type2 to be set to
	 */
	public void setType2(Type type2) {
		this.type2 = type2;
	}
	/**
	 * Sets the atk of the pokemon
	 * @param attack to be set to
	 */
	public void setATK(int attack) {
		this.attack = attack;
	}
	/**
	 * Sets the def of the pokemon
	 * @param defence to be set to
	 */
	public void setDEF(int defence) {
		this.defence = defence;
	}
	/**
	 * Sets the spc of the pokemon
	 * @param special to be set to
	 */
	public void setSPC(int special) {
		this.special = special;
	}
	/**
	 * Sets the speed of the pokemon
	 * @param speed to be set to
	 */
	public void setSPE(int speed) {
		this.speed = speed;
	}
	/**
	 * Sets the status of the pokemon
	 * @param status to be set to
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * Sets the moveset of the pokemon
	 * @param ms to be set to
	 */
	public void setMoveset(Move[] ms) {
		moveset = ms;
	}
	public void setFront(ImageIcon f) {
		frontSprite = f;
	}
	public void setBack(ImageIcon b) {
		backSprite = b;
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
