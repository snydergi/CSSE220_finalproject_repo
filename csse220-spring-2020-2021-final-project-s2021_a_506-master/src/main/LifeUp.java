package main;

import java.util.Random;

/**
 * 
 * The purpose of this class is to add an interactable that increases player
 * health.
 * 
 * @author Roka Brovick and Grayson Snyder
 *
 */
public class LifeUp extends Interactables {

	public int speed = 1;

	/**
	 * 
	 * Ensures: LifeUp is constructed and fields are set
	 * 
	 * @param xPos
	 * @param yPos
	 * @param w
	 * @param h
	 */
	public LifeUp(int xPos, int yPos, int w, int h) {
		super(xPos, yPos, w, h);
		Random random = new Random();
		this.xPosition = 50 * random.ints(1, 17).findFirst().getAsInt();
		this.imageFileName = "LifeUp.png";
	}// end constructor

	/**
	 * 
	 * Ensures: lifeup moves
	 * 
	 */
	public void move() {
		this.yPosition = this.yPosition + this.speed;
	}// end move

}// end class LifeUp
