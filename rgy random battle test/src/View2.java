
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
	public static final int FRAMEWIDTH = 500;
	public static final int XHEIGHT = 200;

	private JFrame frame;
	private JPanel battlePanel;
	private JPanel menuPanel;
	private JPanel teamPanel;
	private JPanel movesPanel;
	private JPanel commentPanel;

	private JLabel title;
	private JLabel choosePoke;
	private JLabel rName;
	private JLabel bName;
	private JLabel comments;
	private JLabel rHP;
	private JLabel bHP;
	private JLabel spriteR;
	private JLabel spriteB;

	private JButton moves[];
	private JButton pokeOptions[];
	private JButton custom;
	private JButton random;
	private JButton exit;
	private JButton backButton;
	//private JButton move;
	//private JButton switchPoke;

	private boolean clicked;
	private int pmChoice;
	private char menuChoice;
	private Pokemon pokeChoice;
	private Move moveChoice;


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
		
		//move = new JButton("Choose Move");
		//switchPoke = new JButton("Switch Pokemon");
		//set up ImageIcons for active pokemon

		//Creates battle screen and sets up its implements
		//TODO- figure out how to give this elements that make it work
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
		
		//battlePanel.add(rHP, BorderLayout.NORTH);
		//battlePanel.add(bHP, BorderLayout.NORTH);

		//Creates menu screen and sets up its implements
		menuPanel = new JPanel();
		menuPanel.setSize(FRAMEWIDTH, FRAMEHEIGHT);
		menuPanel.setLocation(0, 0);
		menuPanel.setLayout(new GridLayout(4, 1));
		menuPanel.add(title);
		menuPanel.add(custom);
		menuPanel.add(random);
		menuPanel.add(exit);

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
		
		frame.setVisible(true); 
	}

	public char mainMenu() {
		//set up menu display
		frame.add(menuPanel);
		//menuPanel.paintImmediately(menuPanel.getVisibleRect());
		frame.setVisible(true);
		clicked = false;
		menuChoice = 'D'; //D = no choice was made somehow

		//checks if user has made a choice yet
		while (!clicked) {
			try { Thread.sleep(200);}
			catch (InterruptedException e) {}
		}

		frame.remove(menuPanel);
		frame.setVisible(true);
		return menuChoice;
	}
	
	public Move chooseMove(Move[] moveList) {
		for (int i = 0; i < 4; i++) {
		moves[i].setText(moveList[i].getName() + "/" + moveList[i].getPP());
			//moves[i].setText(moveList[i].getName());
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
	
	public Pokemon choosePoke(Pokemon[] teamX) {
		for (int i = 0; i < 6; i++) {
		pokeOptions[i].setText(teamX[i].getName() + "/" + teamX[i].getHP());
		}
		
		frame.remove(battlePanel);
		frame.remove(commentPanel);
		frame.add(teamPanel);
		frame.setVisible(true);
		
		pmChoice = 3;
		clicked = false;
		
		while (!clicked) {
			try { Thread.sleep(200);}
			catch (InterruptedException e) {}
		}
		
		pokeChoice = teamX[pmChoice];
		frame.remove(teamPanel);
		frame.add(battlePanel);
		frame.add(commentPanel);
		frame.setVisible(true);

		return pokeChoice;
	}
	
	public void setUpBattle(Pokemon pokeR, Pokemon pokeB) {
		rName.setText(pokeR.getName());
		rName.setHorizontalAlignment(SwingConstants.LEFT);
		bName.setText(pokeB.getName());
		bName.setHorizontalAlignment(SwingConstants.RIGHT);
		rHP.setText("HP:  " + pokeR.getHP());
		rHP.setHorizontalAlignment(SwingConstants.LEFT);
		bHP.setText("HP:  " + pokeB.getHP());
		bHP.setHorizontalAlignment(SwingConstants.RIGHT);
		spriteR.setIcon(pokeR.getBack());
		spriteB.setIcon(pokeB.getFront());
		//spriteR = new JLabel(new ImageIcon("Charizard2.png"));
		//spriteB = new ImageIcon("Ninetales.png");
		//Total vs current HP??
		//rHP.setText(pokeR.getHP() + "/" + pokeR.getHP());
		//bHP = 
		frame.add(battlePanel);
		frame.add(commentPanel);
		frame.setVisible(true);
	
	}
	public void switchPokeR(Pokemon x) {
		rName.setText(x.getName());
		//spriteR = x.getSprite();
		//Get HP
		
	}
	
	public void switchPokeB(Pokemon x) {
		bName.setText(x.getName());
		//spriteB = x.getSprite();
		//Get HP
		
	}
	
	public void commentary(String x) {
		comments.setText(x);
		commentPanel.paintImmediately(commentPanel.getVisibleRect());
		try { Thread.sleep(2000);}
		catch (InterruptedException e) {}
	}
	
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
	
	
}
