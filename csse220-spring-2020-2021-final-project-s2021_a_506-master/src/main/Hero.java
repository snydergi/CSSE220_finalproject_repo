package main;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * 
 * The purpose of this class is to provide a playable character for the player
 * of the game.
 * 
 * @author Roka Brovick and Grayson Snyder
 *
 */
public class Hero {

	int xPosition = -10;
	int yPosition = -10;
	int width = 50;
	int height = 50;
	int xSpeed = 5;
	int ySpeed = 8;
	boolean isRight = false;
	boolean isLeft = false;
	boolean isUp = false;
	boolean isColliding = true;
	int gravityConstant;
	int health;
	private BufferedImage img;
	Rectangle hitbox;
	int score = 0;
	public Interactables heldItem;
	private boolean emptyHand = true;
	int MAX_HEALTH = 3;
	public Weapon weapon;
	private boolean facingRight = true;
	public String imgFilename = "Astro Normal.png";

	/**
	 * 
	 * Ensures: Hero is constructed and fields are set.
	 * 
	 */
	public Hero() {
		this.gravityConstant = 3;
		this.health = MAX_HEALTH;
		hitbox = new Rectangle(xPosition, yPosition, width, height);
		try {
			this.img = ImageIO.read(new File(imgFilename));
		} catch (IOException e) {
			e.printStackTrace();
		} // end try-catch
		this.weapon = new WeaponDefault(this.xPosition + 34, this.yPosition + 22, 16, 5);
	}// end constructor

	/**
	 * 
	 * Ensures: Hero is moved in proper direction and hitbox updates position with
	 * it.
	 * 
	 * @param dir
	 */
	public void move(boolean collides) {
		if (isRight & this.xPosition + this.width < 800) {
			this.xPosition = this.xPosition + xSpeed;
			hitbox.setBounds(xPosition, yPosition, width, height);
			this.facingRight = true;
		} // end if
		if (isLeft & this.xPosition > 0) {
			this.xPosition = this.xPosition - xSpeed;
			hitbox.setBounds(xPosition, yPosition, width, height);
			this.facingRight = false;
		} // end if
		if (isUp & this.yPosition > 0) {
			this.yPosition = this.yPosition - ySpeed;
			hitbox.setBounds(xPosition, yPosition, width, height);
			if (facingRight) {
				this.imgFilename = "Astro Flying.png";
			} else {
				this.imgFilename = "Astro Flying Left.png";
			} // end if-else
		} else {
			if (facingRight) {
				this.imgFilename = "Astro Normal.png";
			} else {
				this.imgFilename = "Astro Normal Left.png";
			} // end if-else
		} // end if-else
		this.yPosition = this.yPosition + gravityConstant;
		hitbox.setBounds(xPosition, yPosition, width, height);
		try {
			this.img = ImageIO.read(new File(imgFilename));
		} catch (IOException e) {
			e.printStackTrace();
		} // end try-catch
		if (collides) {
			this.yPosition = this.yPosition - gravityConstant;
			hitbox.setBounds(xPosition, yPosition, width, height);
		} // end if
	}// end move

	/**
	 * 
	 * Ensures: hero is drawn on the screen.
	 * 
	 * @param g2d
	 */
	public void drawOn(Graphics2D g2d) {
		this.imgFilename = "Astro Flying.png";
		hitbox.setBounds(xPosition, yPosition, width, height);
		g2d = (Graphics2D) g2d.create();
		if (facingRight) {
			this.weapon.flipImage(1);
			this.weapon.xPosition = this.xPosition + 34;
			this.weapon.yPosition = this.yPosition + 23;
		} else {
			this.weapon.flipImage(0);
			this.weapon.xPosition = this.xPosition;
			this.weapon.yPosition = this.yPosition + 23;
		} // end if-else
		g2d.drawImage(img, this.xPosition, this.yPosition, 50, 50, null);
	}// drawOn

	/**
	 * 
	 * Ensures: hero grabs interactable
	 * 
	 * @param i
	 */
	public void grab(Interactables i) {
		if (this.emptyHand) {
			this.heldItem = i;
			this.emptyHand = false;
		} // end if
		if (this.heldItem != null) {
			heldItem.xPosition = this.xPosition - 20;
			heldItem.yPosition = this.yPosition;
		} // end if
	}// end grab

	/**
	 * 
	 * Ensures: hero switched equipped weapon.
	 * 
	 * @param w
	 */
	public void swapWeapon(Weapon w) {
		this.weapon = w;
	}// end swapWeapon

	/**
	 * 
	 * Ensures: held Item is dropped.
	 * 
	 */
	public void dropItem() {
		this.heldItem = null;
		this.emptyHand = true;
	}// end dropItem

	/**
	 * 
	 * Ensures: hero is removed from screen by sending it off into distant space.
	 * 
	 */
	public void remove() {
		this.xPosition = 10000;
		this.yPosition = 10000;
	}// end remove

	/**
	 * 
	 * Ensures: hero fires weapon.
	 * 
	 */
	public void fireWeapon() {
		if (facingRight) {
			this.weapon.shoot(1);
		} else {
			this.weapon.shoot(-1);
		} // end if-else
	}//end fireWeapon

	public ArrayList<Bullet> getBullets() {	
		return this.weapon.getBullets();
	}
	
}// end class Hero
