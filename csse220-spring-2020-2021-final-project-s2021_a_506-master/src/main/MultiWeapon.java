package main;

/**
 * 
 * The purpose of this class is to create a weapon that fires multiple bullets
 * at in quick succession.
 * 
 * @author Roka Brovick and Grayson Snyder
 *
 */
public class MultiWeapon extends Weapon {

	/**
	 * 
	 * Ensures: MultiWeapon is constructed and fields are set.
	 * 
	 * @param xPos
	 * @param yPos
	 * @param w
	 * @param h
	 */
	public MultiWeapon(int xPos, int yPos, int w, int h) {
		super(xPos, yPos, w, h);
		this.normalImage = "Weapon 3.png";
		this.flippedImage = "Weapon 3 Flipped.png";
		this.imageFileName = this.normalImage;
	}// end constructor

	/**
	 * 
	 * Ensures: MultiWeapon shoots properly
	 * 
	 */
	@Override
	void shoot(int lOrR) {
		for (int i = -1; i < 2; i++) {
			Bullet b = new Bullet(this.xPosition + 20 * i, this.yPosition, 5, 5, lOrR);
			this.bullets.add(b);
		} // end for
	}// end shoot

}// end class MultiWeapon
