package main;

import java.util.ArrayList;

/**
 * 
 * The purpose of this class is to create the base for weapons.
 * 
 * @author Roka Brovick and Grayson Snyder
 *
 */
public abstract class Weapon extends Interactables {

	protected String flippedImage;
	protected String normalImage;
	public ArrayList<Bullet> bullets = new ArrayList<>();

	/**
	 * 
	 * Ensures: the weapon is constructed and fields are set.
	 * 
	 * @param xPos
	 * @param yPos
	 * @param w
	 * @param h
	 */
	public Weapon(int xPos, int yPos, int w, int h) {
		super(xPos, yPos, w, h);
	}// end constructor

	/**
	 * 
	 * Ensures: the weapons shoots the given direction
	 *
	 * @param lOrR
	 */
	abstract void shoot(int lOrR);

	/**
	 * 
	 * Ensures: images is flipped when hero turns.
	 * 
	 * @param i
	 */
	void flipImage(int i) {
		if (i > 0) {
			this.imageFileName = this.normalImage;
		} else {
			this.imageFileName = this.flippedImage;
		} // end if-else
	}// end flipImage

	public ArrayList<Bullet> getBullets() {
		return this.bullets;
	}

}// end class Weapon
