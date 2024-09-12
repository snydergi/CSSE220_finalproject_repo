package main;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * The purpose of this class is to serve as the central organizer for the JetPac
 * Man game.
 * 
 * @author Roka Brovick and Grayson Snyder
 *
 */
public class GameMainViewer {

	private int DELAY = 15;
	GameMainComponent component = new GameMainComponent();

	/**
	 * 
	 * Ensures: Game runs.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		int frameWidth = 800;
		int frameHeight = 600;
		frame.setSize(frameWidth, frameHeight);
		frame.setTitle("JetPac Man!");
		frame.setVisible(true);
		StartScreenHandler startScreen = new StartScreenHandler();
		frame.add(startScreen);
		JPanel bottomPanel = new JPanel();
		frame.setTitle("JetPac Man!");
		JButton newGameButton = new JButton("New Game");
		bottomPanel.add(newGameButton, BorderLayout.CENTER);
		frame.add(bottomPanel, BorderLayout.SOUTH);
		newGameButton.addActionListener(new ActionListener() {

			/**
			 * ensures: when New Game button is pressed, old code is disposed of and game
			 * starts.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				GameMainViewer game = new GameMainViewer();
				game.addTimer();
			}// end actionPerformed

		});// end anonymous class
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// end main

	/**
	 * 
	 * Ensures: adds timer to the game to control the flow.
	 * 
	 */
	public void addTimer() {
		AdvanceListener advanceListener = new AdvanceListener(component);
		Timer timer = new Timer(DELAY, advanceListener);
		timer.start();
		System.out.println("Timer Started");
	}// end addTimer

	/**
	 * 
	 * Constructor for the GameMainViewer. In charge of displaying the whole game.
	 * 
	 */
	public GameMainViewer() {
		JFrame frame = new JFrame();
		int frameWidth = 800;
		int frameHeight = 600;
		frame.setSize(frameWidth, frameHeight);
		frame.setTitle("JetPac Man!");
		frame.getContentPane().setBackground(Color.BLACK);
		component.repaint();
		KeyListener k = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 39) {
					component.heroRight(1);
				} // end if
				if (e.getKeyCode() == 38) {
					component.heroFly(1);
				} // end if
				if (e.getKeyCode() == 37) {
					component.heroLeft(1);
				} // end if
				if (e.getKeyCode() == 85) {
					component.changeLevel(1);
				} // end if
				if (e.getKeyCode() == 68) {
					component.changeLevel(-1);
				} // end if
				if (e.getKeyCode() == 32) {
					component.heroShootBlaster();
				} // end if
				if (e.getKeyCode() == 83) {
					component.swapWeapon();
				} // end if
				if (e.getKeyCode() == 82) {
					frame.dispose();
					GameMainViewer game = new GameMainViewer();
					game.addTimer();
				} // end if
			}// end keyPressed

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == 39) {
					component.heroRight(-1);
				} // end if
				if (e.getKeyCode() == 38) {
					component.heroFly(-1);
				} // end if
				if (e.getKeyCode() == 37) {
					component.heroLeft(-1);
				} // end if
			}// end keyReleased
		};// end keyListener

		JPanel panel = new JPanel();
		frame.repaint();
		panel.addKeyListener(k);
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		frame.add(panel);
		frame.add(component);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(0, 0);

	}// end GameMainViewer constructor

}// end class GameMainViewer