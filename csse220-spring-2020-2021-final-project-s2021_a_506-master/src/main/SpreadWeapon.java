package main;

/**
 * 
 * The purpose of this class is to create a weapon variation that shoots a
 * spread of bullets.
 * 
 * @author Roka Brovick and Grayson Snyder
 *
 */
public class SpreadWeapon extends Weapon {

	/**
	 * 
	 * Ensures: SpreadWeapon is constructed and fields are set.
	 * 
	 * @param xPos
	 * @param yPos
	 * @param w
	 * @param h
	 */
	public SpreadWeapon(int xPos, int yPos, int w, int h) {
		super(xPos, yPos, w, h);
		this.normalImage = "Weapon 1.png";
		this.flippedImage = "Weapon 1 Flipped.png";
		this.imageFileName = this.normalImage;
	}// end constructor

	/**
	 * 
	 * Ensures: the weapon shoots properly with its spread.
	 * 
	 */
	@Override
	void shoot(int lOrR) {
		for (int i = -1; i < 2; i++) {
			Bullet b = new Bullet(this.xPosition, this.yPosition + 10 * i, 5, 5, lOrR);
			this.bullets.add(b);
		} // end for
	}// end shoot

}// end class SpreadWeapon
