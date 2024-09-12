package main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 * The purpose of this class is to create an outline of an Interactable for
 * other classes to extend.
 * 
 * @author Grayson Snyder and Roka Brovick
 *
 */
public class Interactables {

	protected int xPosition;
	protected int yPosition;
	protected int width;
	protected int height;
	protected Rectangle objectHitbox;
	protected String imageFileName;
	protected BufferedImage image;

	/**
	 * 
	 * Ensures: interactable is created and fields are set.
	 * 
	 * @param xPos
	 * @param yPos
	 * @param w
	 * @param h
	 */
	public Interactables(int xPos, int yPos, int w, int h) {
		xPosition = xPos;
		yPosition = yPos;
		width = w;
		height = h;
		objectHitbox = new Rectangle(xPos, yPos, w, h);
	}// end constructor

	/**
	 * 
	 * Ensures: interactable is drawn on the screen.
	 * 
	 * @param g2d
	 */
	public void drawOn(Graphics g2d) {
		objectHitbox.setBounds(xPosition, yPosition, width, height);
		try {
			this.image = ImageIO.read(new File(this.imageFileName));
		} catch (IOException e) {
			e.printStackTrace();
		} // end try-catch
		g2d.drawImage(this.image, this.xPosition, this.yPosition, this.image.getWidth(),
				this.image.getHeight(), null);
	}// end drawOn

	/**
	 * 
	 * Ensures: Returns true if colliding with hero, else false.
	 * 
	 * @param h
	 * @return
	 */
	public boolean isColliding(Hero h) {
		if ((h.xPosition + h.width) >= this.xPosition & (h.yPosition + h.height) >= this.yPosition
				& h.xPosition <= this.xPosition + this.width
				& (h.yPosition + h.height) <= this.yPosition + h.gravityConstant - 1) {
			return true;
		} else {
			return false;
		} // end if-else
	}// end isColliding

	/**
	 * 
	 * Ensures: returns true if hitbox is overlapping, else false.
	 * 
	 * @param hitbox
	 * @return
	 */
	public boolean isOverlapping(Rectangle hitbox) {
		if (hitbox.intersects(objectHitbox)) {
			return true;
		} // end if
		return false;
	}// end isOverlapping

}// end Interactables
