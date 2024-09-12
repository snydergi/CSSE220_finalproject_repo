package main;

/**
 * 
 * The purpose of this class is to act as the default, base weapon that the hero
 * will spawn with.
 * 
 * @author Grayson Snyder and Roka Brovick
 *
 */
public class WeaponDefault extends Weapon {

	/**
	 * 
	 * Ensures: the WeaponDefault is created and its fields are set.
	 * 
	 * @param xPos
	 * @param yPos
	 * @param w
	 * @param h
	 */
	public WeaponDefault(int xPos, int yPos, int w, int h) {
		super(xPos, yPos, w, h);
		this.normalImage = "Weapon Default.png";
		this.flippedImage = "Weapon Default Flipped.png";
		this.imageFileName = this.normalImage;
	}// end constructor

	/**
	 * 
	 * Ensures: weapon shoots properly
	 * 
	 */
	public void shoot(int lOrR) {
		Bullet b = new Bullet(this.xPosition, this.yPosition, 5, 5, lOrR);
		this.bullets.add(b);
	}// end shoot

}// end class WeaponDefault
