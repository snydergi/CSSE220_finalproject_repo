package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 * 
 * The purpose of this class is to display the start screen.
 * 
 * @author Grayson Snyder and Roka Brovick
 *
 */
@SuppressWarnings("serial")
public class StartScreenHandler extends JComponent {

	/**
	 * 
	 * Ensures: components are painted on screen.
	 * 
	 */
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("SpaceBackground.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		} // end try-catch
		g2d.drawImage(image, 0, 0, 1000, 800, null);
		g2d.setColor(Color.BLUE);
		g2d.setFont(new Font("TimesRoman", Font.PLAIN, 150));
		g2d.drawString("JetPac Man!", 25, 200);
		g2d.setColor(Color.GRAY);
		g2d.setFont(new Font("TimesRoman", Font.PLAIN, 70));
		g2d.drawString("Press 'New Game' Button", 25, 300);
		g2d.setColor(Color.YELLOW);
		g2d.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g2d.drawString("Move With Arrow Keys", 25, 400);
		g2d.drawString("Shoot With Space Bar", 400, 400);
		g2d.drawString("Pick up Blasters with 'S'", 25, 450);
		g2d.drawString("Press 'R' to Restart", 400, 450);
	}// end paintComponent

}// end class StartScreenHandler
