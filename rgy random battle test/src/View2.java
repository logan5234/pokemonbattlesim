
/**
* View.java- the version of the view that includes a GUI
* 
* @author Paige Ludecker & Logan Buyea
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class View2 {

	public static final int FRAMEHEIGHT = 550;
	public static final int FRAMEWIDTH = 600;
	public static final int XHEIGHT = 200;

	private JFrame frame;
	private JPanel battlePanel;
	private JPanel menuPanel;
	private JPanel teamPanel;
	private JPanel movesPanel;
	private JPanel commentPanel;
	private JPanel teamBuildPanel;
	private JPanel teamNamePanel;
	private JPanel imagePanel;

	private JLabel title;
	private JLabel choosePoke;
	private JLabel rName;
	private JLabel bName;
	private JLabel comments;
	private JLabel rHP;
	private JLabel bHP;
	private JLabel spriteR;
	private JLabel spriteB;
	private JLabel pokeList;
	private JLabel teamNameAsk;

	private JButton moves[];
	private JButton pokeOptions[];
	private JButton custom;
	private JButton random;
	private JButton exit;
	private JButton backButton;
	private JButton goButton;
	private JButton goButton2;

	private boolean clicked;
	private int pmChoice;
	private String pokeIndex;
	private char menuChoice;
	private Pokemon pokeChoice;
	private Move moveChoice;
	private ImageIcon emptyIcon;
	private JTextArea indexChoice;
	private JTextArea inputField;


	/**
	 * Giant ugly constructor to setup the application window
	 */
	public View2() {
		frame = new JFrame();
		frame.setLayout(null);
		frame.setSize(FRAMEWIDTH, FRAMEHEIGHT);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		clicked = false;
		pmChoice = 3;
		menuChoice = 'D';
		pokeChoice = null;
		moveChoice = null;
		emptyIcon = new ImageIcon("src/emptyIcon.png");
		title = new JLabel("Pokemon Gen 1 Battle Simulator", SwingConstants.CENTER);
		title.setFont(new Font("Serif", Font.PLAIN, 18));
		choosePoke = new JLabel("Choose your next Pokemon:");
		choosePoke.setFont(new Font("Serif", Font.PLAIN, 18));
		rName = new JLabel("DEFAULT R");
		bName = new JLabel("DEFAULT B");
		comments = new JLabel("DEFAULT COMMENT");
		rHP = new JLabel("Remaining/Total", SwingConstants.LEFT);
		bHP = new JLabel("Remaining/Total", SwingConstants.RIGHT);
		
		moves = new JButton[4];
		for (int i = 0; i < 4; i++) { moves[i] = new JButton(); }
		moves[0].addActionListener(new pm0Handler());
		moves[1].addActionListener(new pm1Handler());
		moves[2].addActionListener(new pm2Handler());
		moves[3].addActionListener(new pm3Handler());
		
		pokeOptions = new JButton[6];
		for (int i = 0; i < 6; i++) { pokeOptions[i] = new JButton(); }
		pokeOptions[0].addActionListener(new pm0Handler());
		pokeOptions[1].addActionListener(new pm1Handler());
		pokeOptions[2].addActionListener(new pm2Handler());
		pokeOptions[3].addActionListener(new pm3Handler());
		pokeOptions[4].addActionListener(new pm4Handler());
		pokeOptions[5].addActionListener(new pm5Handler());
		
		custom = new JButton("Custom Battle");
		custom.addActionListener(new customButtonHandler());
		random = new JButton("Random Battle");
		random.addActionListener(new randomButtonHandler());
		exit = new JButton("Exit");
		exit.addActionListener(new exitButtonHandler());
		backButton = new JButton("Back");

		//Creates battle screen and sets up its implements
		battlePanel = new JPanel();
		battlePanel.setSize(FRAMEWIDTH, FRAMEHEIGHT - XHEIGHT);
		battlePanel.setLocation(0, 0);
		battlePanel.setLayout(new GridLayout(3, 2));
		battlePanel.setBackground(Color.WHITE);
		battlePanel.add(rName);
		battlePanel.add(bName);
		battlePanel.add(rHP);
		battlePanel.add(bHP);
		spriteR = new JLabel(new ImageIcon("src/Ninetales2.png"));
		spriteB = new JLabel(new ImageIcon("src/Pikachu.png"));
		battlePanel.add(spriteR);
		battlePanel.add(spriteB);

		//Creates menu screen and sets up its implements
		menuPanel = new JPanel();
		menuPanel.setSize(FRAMEWIDTH, FRAMEHEIGHT);
		menuPanel.setLocation(0, 0);
		menuPanel.setLayout(new GridLayout(4, 1));
		menuPanel.add(title);
		menuPanel.add(custom);
		menuPanel.add(random);
		menuPanel.add(exit);
		
		//Panel that holds the image with the list of Pokemon
		imagePanel = new JPanel();
		imagePanel.setSize(FRAMEWIDTH, FRAMEHEIGHT);
		imagePanel.setLocation(0, 0);
		pokeList = new JLabel(new ImageIcon("src/PokeList.png"));
		imagePanel.add(pokeList);
		
		//Creates the screen to make a custom pokemon team
		teamBuildPanel = new JPanel();
		teamBuildPanel.setSize(FRAMEWIDTH, 250);
		teamBuildPanel.setLocation(0, 310);
		teamBuildPanel.setLayout(new GridLayout(2,1));
		goButton = new JButton("GO");
		goButton.addActionListener(new goButtonHandler());
		indexChoice = new JTextArea("Enter the number of your choice");
		teamBuildPanel.add(indexChoice, BorderLayout.CENTER);
		teamBuildPanel.add(goButton, BorderLayout.SOUTH);
		

		//Creates screen to choose active pokemon
		teamPanel = new JPanel();
		teamPanel.setSize(FRAMEWIDTH, FRAMEHEIGHT);
		teamPanel.setLocation(0, 0);
		teamPanel.add(choosePoke);
		for (int i = 0; i < 6; i++) { teamPanel.add(pokeOptions[i]); }
		teamPanel.add(backButton);

		//Sets up movesPanel where the player chooses their next move
		movesPanel = new JPanel();
		movesPanel.setSize(FRAMEWIDTH, XHEIGHT);
		movesPanel.setLocation(0, FRAMEHEIGHT - XHEIGHT);
		movesPanel.setLayout(new GridLayout(2, 2));
		for (int i = 0; i < 4; i++) {movesPanel.add(moves[i]);}

		//Sets up commentPanel where the comments say what is happening throughout the battle
		commentPanel = new JPanel();
		commentPanel.setSize(FRAMEWIDTH, XHEIGHT);
		commentPanel.setLocation(0, FRAMEHEIGHT - XHEIGHT);
		commentPanel.add(comments);
		
		teamNamePanel = new JPanel();
		teamNamePanel.setSize(FRAMEWIDTH, FRAMEHEIGHT);
		teamNamePanel.setLocation(0, 0);
		teamNamePanel.setLayout(new GridLayout(3,1));
		teamNameAsk = new JLabel("Choose your team name default",SwingConstants.CENTER);
		goButton2 = new JButton("GO");
		goButton2.addActionListener(new goButtonHandler2());
		inputField = new JTextArea();
		teamNamePanel.add(teamNameAsk);
		teamNamePanel.add(inputField);
		teamNamePanel.add(goButton2);
		
		frame.setTitle("Pokemon Gen 1 Battle Sim");
		frame.setVisible(true); 
	}
	
	/**
	 * Main menu for the program
	 * @return the selection made my the user
	 */
	public char mainMenu() {
		//sets up menu display
		frame.add(menuPanel);
		frame.setVisible(true);
		clicked = false;
		menuChoice = 'D';

		//checks if user has made a choice yet
		while (!clicked) {
			try { Thread.sleep(200);}
			catch (InterruptedException e) {}
		}

		frame.remove(menuPanel);
		frame.setVisible(true);
		return menuChoice;
	}
	
	/**
	 * Displays move list for user to choose from
	 * @param moveList the current pokemon's moves
	 * @return the move the user selected
	 */
	public Move chooseMove(Move[] moveList) {
		for (int i = 0; i < 4; i++) {
			moves[i].setText(moveList[i].getName() + "/" + moveList[i].getPP());
		}
		
		frame.remove(commentPanel);
		frame.add(movesPanel);
		frame.setVisible(true);
		
		pmChoice = 3;
		clicked = false;
		
		while (!clicked) {
			try { Thread.sleep(200);}
			catch (InterruptedException e) {}
		}
		
		moveChoice = moveList[pmChoice];
		frame.remove(movesPanel);
		frame.add(commentPanel);
		frame.setVisible(true);
		
		return moveChoice;
	}
	
	/**
	 * Panel to create your own team of pokemon
	 * @return the index of the pokemon the user entered
	 */
	public String buildTeam() {
		frame.add(imagePanel);
		frame.add(teamBuildPanel);
		frame.setVisible(true);
		
		clicked = false;
		while (!clicked) {
			try { Thread.sleep(200);}
			catch (InterruptedException e) {}
		}
		
		frame.remove(teamBuildPanel);
		frame.remove(imagePanel);
		frame.setVisible(true);
		return pokeIndex;
	}
	
	/**
	 * Panel to name your custom team
	 * @param n team number
	 * @return the name entered by the user
	 */
	public String chooseTeamName(int n) {
		teamNameAsk.setText("Player " + n + " choose your name:");
		frame.add(teamNamePanel);
		frame.setVisible(true);
		
		clicked = false;
		while (!clicked) {
			try { Thread.sleep(200);}
			catch (InterruptedException e) {}
		}
		
		frame.remove(teamNamePanel);
		frame.setVisible(true);
		return pokeIndex;
	}
	
	/**
	 * Menu to select pokemon to use next in battle
	 * @param teamX the team to select from
	 * @return the selected pokemon
	 */
	public Pokemon choosePoke(Pokemon[] teamX) {
		for (int i = 0; i < 6; i++) {
			pokeOptions[i].setText(teamX[i].getName() + "/" + teamX[i].getHP());
		}
		
		frame.remove(battlePanel);
		frame.remove(commentPanel);
		frame.add(teamPanel);
		teamPanel.setVisible(true);
		frame.setVisible(true);
		pmChoice = 3;
		clicked = false;
		
		while (!clicked) {
			try { Thread.sleep(200);}
			catch (InterruptedException e) {}
		}
		
		pokeChoice = teamX[pmChoice];
		frame.remove(teamPanel);
		teamPanel.setVisible(false);
		frame.add(battlePanel);
		frame.add(commentPanel);
		frame.setVisible(true);
		return pokeChoice;
	}
	
	/**
	 * Sets up the battle pane
	 * @param pokeR player 1's pokemon
	 * @param pokeB player 2's pokemon
	 */
	public void setUpBattle(Pokemon pokeR, Pokemon pokeB) {
		rName.setText(pokeR.getName());
		rName.setHorizontalAlignment(SwingConstants.LEFT);
		bName.setText(pokeB.getName());
		bName.setHorizontalAlignment(SwingConstants.RIGHT);
		rHP.setText("HP:  " + pokeR.getHP());
		rHP.setHorizontalAlignment(SwingConstants.LEFT);
		bHP.setText("HP:  " + pokeB.getHP());
		bHP.setHorizontalAlignment(SwingConstants.RIGHT);
		spriteR.setIcon(new ImageIcon("src/sprites/"+pokeR.getName().trim()+"2.png"));
		spriteB.setIcon(new ImageIcon("src/sprites/"+pokeB.getName().trim()+".png"));
		
		frame.add(battlePanel);
		frame.add(commentPanel);
		frame.setVisible(true);
	
	}
	/**
	 * Switches player 1's pokemon
	 * @param x pokemon to switch to
	 */
	public void switchPokeR(Pokemon x) {
		rName.setText(x.getName());
		spriteR.setIcon(new ImageIcon("src/sprites/"+x.getName().trim()+"2.png"));
		rHP.setText("HP: "+x.getHP()); 
	}
	
	/**
	 * Switches player 2's pokemon
	 * @param x pokemon to switch to
	 */
	public void switchPokeB(Pokemon x) {
		bName.setText(x.getName());
		spriteB.setIcon(new ImageIcon("src/sprites/"+x.getName().trim()+".png"));
		bHP.setText("HP: "+x.getHP());
	}
	
	/**
	 * Displays any commentary or announcements made throughout the battle
	 * @param x String to display
	 */
	public void commentary(String x) {
		comments.setText(x);
		commentPanel.paintImmediately(commentPanel.getVisibleRect());
		try { Thread.sleep(2000);}
		catch (InterruptedException e) {}
	}
	
	/**
	 * Flashes pokemon sprite and updates HP
	 * @param pokeR player 1's pokemon
	 * @param pokeB player 2's pokemon
	 */
	public void moveUpdateR(Pokemon pokeR, Pokemon pokeB) {
		spriteB.setIcon(emptyIcon);
		battlePanel.paintImmediately(battlePanel.getVisibleRect());
		try { Thread.sleep(500);}
		catch (InterruptedException e) {}
		
		spriteB.setIcon(new ImageIcon("src/sprites/"+pokeB.getName().trim()+".png"));
		battlePanel.paintImmediately(battlePanel.getVisibleRect());
		try { Thread.sleep(500);}
		catch (InterruptedException e) {}
		
		spriteB.setIcon(emptyIcon);
		battlePanel.paintImmediately(battlePanel.getVisibleRect());
		try { Thread.sleep(500);}
		catch (InterruptedException e) {}
		
		spriteB.setIcon(new ImageIcon("src/sprites/"+pokeB.getName().trim()+".png"));
		
		
		if (pokeB.getHP() <= 0) {bHP.setText("HP:  " + 0);}
		else {bHP.setText("HP:  " + pokeB.getHP());}
		
		frame.setVisible(true);
	}
	
	/**
	 * Flashes pokemon sprite and updates HP
	 * @param pokeR player 1's pokemon
	 * @param pokeB player 2's pokemon
	 */
	public void moveUpdateB(Pokemon pokeR, Pokemon pokeB) {
		spriteR.setIcon(emptyIcon);
		battlePanel.paintImmediately(battlePanel.getVisibleRect());
		try { Thread.sleep(500);}
		catch (InterruptedException e) {}
		
		spriteR.setIcon(new ImageIcon("src/sprites/"+pokeR.getName().trim()+"2.png"));
		battlePanel.paintImmediately(battlePanel.getVisibleRect());
		try { Thread.sleep(500);}
		catch (InterruptedException e) {}
		
		spriteR.setIcon(emptyIcon);
		battlePanel.paintImmediately(battlePanel.getVisibleRect());
		try { Thread.sleep(500);}
		catch (InterruptedException e) {}
		
		spriteR.setIcon(new ImageIcon("src/sprites/"+pokeR.getName().trim()+"2.png"));
		
		if (pokeR.getHP() <= 0) {rHP.setText("HP:  " + 0);}
		else {rHP.setText("HP:  " + pokeR.getHP());}
		
		frame.setVisible(true);
	}
	
	/**
	 * Exits the program
	 */
	public void exit() { System.exit(0); }
	
	/**
	* Button handlers for ALL THOSE BUTTONS.  Sets clicked to true and returns the button number or abbreviation.
	*/
	
	private class customButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			menuChoice = 'C';
			clicked = true;
		}
	}
	
	private class randomButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			menuChoice = 'R';
			clicked = true;
		}
	}
	
	private class exitButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			exit();
			clicked = true;
		}
	}
	
	private class pm0Handler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			pmChoice = 0;
			clicked = true;
		}
	}
	
	private class pm1Handler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			pmChoice = 1;
			clicked = true;
		}
	}
	
	private class pm2Handler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			pmChoice = 2;
			clicked = true;
		}
	}
	
	private class pm3Handler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			pmChoice = 3;
			clicked = true;
		}
	}
	
	private class pm4Handler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			pmChoice = 4;
			clicked = true;
		}
	}
	
	private class pm5Handler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			pmChoice = 5;
			clicked = true;
		}
	}
	private class goButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			pokeIndex = indexChoice.getText();
			clicked = true;
		}
	}
	private class goButtonHandler2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			pokeIndex = inputField.getText();
			clicked = true;
		}
	}
	
	
}
