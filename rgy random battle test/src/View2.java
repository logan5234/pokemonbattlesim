/**
* View.java- the version of the view that includes a GUI
* 
* @author Paige Ludecker & Logan Buyea
*/

import java.awt.*;
import javax.swing.*;

public class View {

	public static final int FRAMEHEIGHT = 700;
	public static final int FRAMEWIDTH = 500;
	public static final int XHEIGHT = 200

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
	//private ImageIcon spriteR;
	//private ImageIcon spriteB;

	private JButton[] moves;
	private JButton[] pokeOptions;
	private JButton custom;
	private JButton random;
	private JButton exit;
	private JButton backButton;
	//private JButton move;
	//private JButton switchPoke;

	private boolean clicked;


	public View() {
		frame = new JFrame();
		frame.setLayout(null);
		frame.setSize(FRAMEWIDTH, FRAMEHEIGHT);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		clicked = false;
		title = new JLabel("Pokemon Gen 1 Battle Simulator");
		choosePoke = new JLabel("Choose your next Pokemon:");
		rName = new JLabel("DEFAULT R");
		bName = new JLabel("DEFAULT B");
		comments = new JLabel("DEFAULT COMMENT");
		for (i = 0; i < 4; i++) { moves[i] = new JButton(); }
		for (i = 0; i < 6; i++) { pokeOptions[i] = new JButton(); } 
		custom = new JButton("Custom Battle");
		random = new JButton("Random Battle");
		exit = new JButton("Exit");
		backButton = new JButton("Back");
		//move = new JButton("Choose Move");
		//switchPoke = new JButton("Switch Pokemon");
		//set up ImageIcons for active pokemon

		//Creates battle screen and sets up its implements
		//TODO- figure out how to give this elements that make it work
		battlePanel = new JPanel();
		battlePanel.setSize(FRAMEWIDTH, FRAMEHEIGHT - XHEIGHT);
		battlePanel.setLocation(0, 0);
		battlePanel.add(rName);
		battlePanel.add(bName);

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
		for (i = 0; i < 6; i++) { teamPanel.add(pokeOptions[i]); }
		teamPanel.add(backButton);

		//Sets up movesPanel where the player chooses their next move
		movesPanel = new JPanel();
		movesPanel.setSize(FRAMEWIDTH, XHEIGHT);
		movesPanel.setLocation(0, FRAMEHEIGHT - XHEIGHT)
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
		char choice = 'D'; //D will mean that something went wrong and no choice was made

		//checks if user has made a choice yet
		while (!clicked) {
			try { Thread.sleep(200);}
			catch (InterruptedException e) {}
		}

		
		return choice;
	}

	//private class customButtonHandler implements ActionListener {
	//	public void actionPerformed(ActionEvent e) {
	//
	//	}
	//}
}
