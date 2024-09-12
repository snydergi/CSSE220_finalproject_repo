package main;

/**
 * 
 * The purpose of this class is to add a weapon variety to the game which fires
 * faster than the default.
 * 
 * @author Roka Brovick and Grayson Snyder
 *
 */
public class SpeedyWeapon extends Weapon {

	/**
	 * 
	 * Ensures: SpeedyWeapon is constructed and fields are set.
	 * 
	 * @param xPos
	 * @param yPos
	 * @param w
	 * @param h
	 */
	public SpeedyWeapon(int xPos, int yPos, int w, int h) {
		super(xPos, yPos, w, h);
		this.normalImage = "Weapon 2.png";
		this.flippedImage = "Weapon 2 Flipped.png";
		this.imageFileName = this.normalImage;
	}// end constructor

	/**
	 * 
	 * Ensures: bullets are shot from the weapon
	 * 
	 */
	@Override
	void shoot(int lOrR) {
		Bullet b = new Bullet(this.xPosition, this.yPosition, 5, 5, lOrR);
		b.xVelocity = 24;
		this.bullets.add(b);
	}// end shoot

}// end class SpeedyWeapon
