package main;

/**
 * 
 * The purpose of this class is to create the rocket pieces that are to be
 * assembled.
 * 
 * @author Roka Brovick and Grayson Snyder
 *
 */
public class RocketPiece extends Rocket {

	/**
	 * 
	 * Ensures: RocketPiece is created and fields are set.
	 * 
	 * @param xPos
	 * @param yPos
	 * @param w
	 * @param h
	 */
	public RocketPiece(int xPos, int yPos, int w, int h) {
		super(xPos, yPos, w, h);
		this.imageFileName = "Rocket Part Box.png";
	}// end constructor

}// end class RocketPiece
