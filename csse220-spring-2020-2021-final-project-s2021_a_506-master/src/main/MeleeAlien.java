package main;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * 
 * The purpose of this class is to extend the general idea of an Alien to an
 * Alien that solely does melee combat.
 * 
 * @author Roka Brovick and Grayson SNyder
 *
 */
public class MeleeAlien extends Alien {

	/**
	 * 
	 * Ensures: The MeleeAlien is constructed.
	 * 
	 * @param x
	 * @param y
	 */
	public MeleeAlien(int x, int y) {
		super(x, y);
		this.imgFilename = "MeleeAlien.png";
		try {
			this.img = ImageIO.read(new File(this.imgFilename));
		} catch (IOException e) {
			e.printStackTrace();
		} // end try-catch
	}// end constructor

	@Override
	public void shoot() {
	}
	
}// end MeleeAlien
