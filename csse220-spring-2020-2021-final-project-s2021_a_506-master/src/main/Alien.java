package main;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Dimension2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * 
 * The purpose of this class is to create enemy aliens in the game to cause
 * challenges for the player.
 * 
 * @author Grayson Snyder and Roka Brovick
 *
 */
public abstract class Alien {

	public int xPosition;
	public int yPosition;
	int speedX;
	int speedY;
	double genSpeed = 5;
	public Rectangle hitbox;
	protected BufferedImage img;
	protected String imgFilename;
	public ArrayList<Bullet> bullets = new ArrayList<Bullet>();

	/**
	 * 
	 * Ensures: Alien is constructed and parameters are set.
	 * 
	 * @param x
	 * @param y
	 */
	public Alien(int x, int y) {
		this.xPosition = x;
		this.yPosition = y;
		this.speedX = (int) (genSpeed - Math.random() * genSpeed * 2);
		this.speedY = (int) (genSpeed - Math.random() * genSpeed * 2);
		if (this.speedX == 0 || this.speedY == 0) {
			this.speedX = (int) (genSpeed - Math.random() * genSpeed * 2);
			this.speedY = (int) (genSpeed - Math.random() * genSpeed * 2);
		} // end if
		this.hitbox = new Rectangle(xPosition, yPosition, 50, 50);
	}// end Alien constructor

	/**
	 * 
	 * Ensures: The alien moves based on their speed.
	 * 
	 * @param dim
	 */
	public void move(Dimension2D dim) {
		this.xPosition = this.xPosition + this.speedX;
		yPosition += speedY;
		if (xPosition > dim.getWidth() || xPosition < 0) {
			xPosition = (int) Math.min(Math.max(xPosition, 0), dim.getWidth());
			speedX = -speedX;
		} // end if
		if (yPosition > dim.getHeight() || yPosition < 0) {
			speedY = -speedY;
			yPosition = (int) Math.min(Math.max(yPosition, 0), dim.getHeight());
		} // end if
		if (this.speedX == 0 || this.speedY == 0) {
			this.speedX = 1;
			this.speedY = 1;
		} // end if
		this.hitbox.setBounds(xPosition, yPosition, 50, 50);
	}// end move

	/**
	 * 
	 * Ensures: The alien is drawn on the screen.
	 * 
	 * @param g2d
	 */
	public void drawOn(Graphics2D g2d) {
		g2d = (Graphics2D) g2d.create();
		g2d.drawImage(this.img, (int) this.xPosition, (int) this.yPosition, 50, 50, null);
	}// end drawOn
	
	public abstract void shoot();
	
}// end Alien
