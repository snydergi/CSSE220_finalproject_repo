package main;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * 
 * The purpose of this class is to create bullets shot by blasters and aliens.
 * 
 * @author Roka Brovick and Grayson Snyder
 *
 */
public class Bullet extends Interactables {

	public int xVelocity = 8;
	private int direction;

	/**
	 * 
	 * Ensures: Bullet is constructed and parameters are set.
	 * 
	 * @param xPosition
	 * @param yPosition
	 * @param w
	 * @param h
	 * @param lOrR
	 */
	public Bullet(int xPosition, int yPosition, int w, int h, int lOrR) {
		super(xPosition, yPosition, w, h);
		this.direction = lOrR;
	}// end Bullet constructor

	/**
	 * 
	 * Ensures: bullet moves based on firing direction
	 * 
	 * @param bottom The y-coordinate of the bottom of the screen.
	 * @return True if the raindrop fell off the bottom of the screen
	 */
	public void move(int width) {
		this.xPosition += this.xVelocity * this.direction;
		if (this.xPosition > width || this.xPosition < 0) {
		} // end if
	}// end move

	/**
	 * 
	 * Ensures: bullet is drawn on screen.
	 * 
	 * @param g
	 * @param c
	 */
	public void drawOn(Graphics2D g, Color c) {
		objectHitbox.setBounds(xPosition, yPosition, width, height);
		g.setColor(c);
		g.fillOval(this.xPosition, this.yPosition, this.width, this.height);
	}// end drawOn

	/**
	 * 
	 * Ensures: X position of the bullet is returned.
	 * 
	 * @return
	 */
	public double getX() {
		return this.xPosition;
	}// end getX

}// end class Bullet
