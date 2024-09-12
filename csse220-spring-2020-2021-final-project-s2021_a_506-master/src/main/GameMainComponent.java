package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 * 
 * The purpose of this class is to implement different drawable components into
 * the game.
 * 
 * @author Grayson Snyder and Roka Brovick
 *
 */
@SuppressWarnings("serial")
public class GameMainComponent extends JComponent {

	private Hero hero = new Hero();
	private Level level = new Level();
	private int currentLevel = 1;
	private int priorLevel = 1;
	private String levelName = "Level" + currentLevel;
	private ArrayList<Platform> allPlatforms;
	public boolean hitPlatUp = false;
	public boolean hitPlatRight = false;
	private ArrayList<Alien> aliens;
	private ArrayList<RocketPiece> rPieces;
	private Rocket rBase;
	private ArrayList<Fuel> fuel;
	private ArrayList<Weapon> weapons;
	private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	private ArrayList<Bullet> aBullets = new ArrayList<>();
	private List<Bullet> bulletsToRemove = new ArrayList<>();
	private List<Alien> aliensToRemove = new ArrayList<>();
	private ArrayList<Resource> resources = new ArrayList<Resource>();
	private List<Interactables> resourcesToRemove = new ArrayList<>();
	private List<LifeUp> lifeUps = new ArrayList<>();
	String healthLabel = "";
	String scoreLabel = "";
	String fuelLabel = "";
	String winOrLoss = "";

	/**
	 * 
	 * Ensures: components are painted on screen.
	 * 
	 */
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		BufferedImage backGroundImage = null;
		try {
			backGroundImage = ImageIO.read(new File("SpaceBackground.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		} // end try-catch
		g2d.drawImage(backGroundImage, 0, 0, 1000, 800, null);
		if (this.currentLevel <= 6) {
			level.readFile(levelName, g2d);
		} else {
			hero.remove();
			healthLabel = "";
			scoreLabel = "";
			fuelLabel = "";
			g2d.setColor(Color.GREEN);
			g2d.setFont(new Font("TimesRoman", Font.PLAIN, 100));
			g2d.drawString("YOU WIN!", 100, 200);
			g2d.drawString("Score: " + hero.score, 120, 350);
			g2d.drawString("Press 'r' to Restart", 50, 500);
		} // end if-else
		if ((hero.xPosition < 0 & hero.yPosition < 0)
				|| this.priorLevel != this.currentLevel && this.currentLevel <= 6) {
			hero.xPosition = level.heroX;
			hero.yPosition = level.heroY;
			this.priorLevel = this.currentLevel;
			this.rBase = level.rBase;
			this.weapons = level.weapons;
		} // end if
		this.aliens = level.aliens;
		this.rPieces = level.rPieces;
		this.rBase = level.rBase;
		this.fuel = level.fuel;
		allPlatforms = level.allPlatforms;
		this.resources = level.resource;
		for (Platform platform : this.allPlatforms) {
			platform.drawOn(g2d);
		} // end for
		for (Alien aliens : this.aliens) {
			aliens.drawOn(g2d);
		} // end for
		for (Rocket rPiece : this.rPieces) {
			rPiece.drawOn(g2d);
		} // end for
		for (Fuel f : this.fuel) {
			f.drawOn(g2d);
		} // end for
		for (Weapon w : this.weapons) {
			w.drawOn(g2d);
		} // end for
		for (Resource r : this.resources) {
			r.drawOn(g2d);
		} // end for
		for (LifeUp l : this.lifeUps) {
			if (this.currentLevel <= 6) {
				l.drawOn(g2d);
			} // end if
		} // end for
		if (this.currentLevel > 1 & this.rBase.size < 3) {
			this.rBase.setSize(2);
			this.rBase.setSize(3);
		} // end if
		if (rBase != null) {
			rBase.drawOn(g2d);
		} // end if
		hero.drawOn(g2d);
		hero.weapon.drawOn(g2d);
		for (Bullet b : bullets) {
			b.drawOn(g2d, Color.RED);
		} // end for
		for (Bullet b : aBullets) {
			b.drawOn(g2d, Color.GREEN);
		} // end for
		g2d.setColor(Color.RED);
		g2d.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		g2d.drawString(healthLabel, 10, 20);
		g2d.drawString(scoreLabel, 200, 20);
		g2d.drawString(fuelLabel, 400, 20);
		g2d.setFont(new Font("TimesRoman", Font.PLAIN, 100));
		g2d.drawString(winOrLoss, 90, 350);
	}// end paintComponent

	/**
	 * 
	 * Ensures: Handles hero movement.
	 * 
	 * @param collides
	 */
	public void heroMove(boolean collides) {
		hero.move(collides);
	}// end heroMove

	/**
	 * 
	 * Ensures: hero direction is set to left if positive n.
	 * 
	 * @param n
	 */
	public void heroLeft(int n) {
		if (n > 0) {
			hero.isLeft = true;
		} else if (n < 0) {
			hero.isLeft = false;
		} // end if-else
	}// end heroLeft

	/**
	 * 
	 * Ensures: hero direction is set to right if positive n.
	 * 
	 * @param n
	 */
	public void heroRight(int n) {
		if (n > 0) {
			hero.isRight = true;
		} else if (n < 0) {
			hero.isRight = false;
		} // end if-else
	}// end heroRight

	/**
	 * 
	 * Ensures: hero is told to fly if positive n received.
	 * 
	 * @param n
	 */
	public void heroFly(int n) {
		if (n > 0) {
			hero.isUp = true;
		} else if (n < 0) {
			hero.isUp = false;
		} // end if-else
	}// end heroFly

	/**
	 * 
	 * Ensures: sets the level based on files when called. Resets hero health upon
	 * level change. Clears lists when level switches.
	 * 
	 */
	public void changeLevel(int posNeg) {
		this.currentLevel = this.currentLevel + posNeg;
		if (this.currentLevel < 1) {
			this.currentLevel = 1;
		} else {
			levelName = "Level" + currentLevel;
			this.hero.health = hero.MAX_HEALTH;
			clear();
		} // end if-else
	}// end changeLevel

	/**
	 * 
	 * Ensures: returns true if hero is landed on a platform.
	 * 
	 * @return
	 */
	public boolean isHeroLanded() {
		for (Platform plat : allPlatforms) {
			if (plat.isColliding(hero)) {
				return true;
			} // end if
		} // end for
		return false;
	}// end isHeroLanded

	/**
	 * 
	 * Ensures: handles the hero shooting whatever blaster it has.
	 * 
	 */
	public void heroShootBlaster() {
		this.hero.fireWeapon();
		this.bullets = hero.getBullets();
	}// end heroShootBlaster

	/**
	 * 
	 * Ensures: aliens are moved
	 * 
	 */
	@SuppressWarnings("deprecation")
	public void moveAliens() {
		for (Alien aliens : this.aliens) {
			aliens.move(this.size());
		} // end for
	}// end moveAliens

	/**
	 * 
	 * Ensures: aliens that are able to shoot, shoot
	 * 
	 */
	public void aliensFire() {
		for (Alien alien : this.aliens) {
			alien.shoot();
			this.aBullets.addAll(alien.bullets);
		} // end for
	}// end aliensFires

	/**
	 * 
	 * Ensures: bullets are handled. Bullets are moved and removed if in the
	 * bulletsToRemove list.
	 * 
	 */
	public void handleBullets() {
		for (Bullet b : this.bullets) {
			b.move(800);
		} // end for
		for (Bullet b : this.bullets) {
			boolean shouldRemove = false;
			if (b.getX() > 800 || b.getX() < 0) {
				shouldRemove = true;
			} // end if
			if (shouldRemove) {
				bulletsToRemove.add(b);
			} // end if
		} // end for
		for (Bullet b : this.aBullets) {
			b.move(1);
		} // end for
		for (Bullet b : this.aBullets) {
			boolean shouldRemove = false;
			if (b.getX() > 800 || b.getX() < 0 || b.isColliding(hero)) {
				shouldRemove = true;
			} // end if
			if (shouldRemove) {
				bulletsToRemove.add(b);
			} // end if
		} // end for
		for (Bullet b : bulletsToRemove) {
			this.bullets.remove(b);
			this.aBullets.remove(b);
		} // end for
	}// end handleBullets

	/**
	 * 
	 * Ensures: list fields are cleared.
	 * 
	 */
	public void clear() {
		this.aBullets.clear();
		this.aliens.clear();
		this.bullets.clear();
		this.allPlatforms.clear();
		this.fuel.clear();
		this.rPieces.clear();
		this.weapons.clear();
		this.lifeUps.clear();
		this.resources.clear();
		this.rBase = null;
	}// end clear

	/**
	 * 
	 * Ensures: labels to print on screen are created
	 * 
	 */
	public void createLabel() {
		healthLabel = "Hero Health: " + hero.health;
		scoreLabel = "Score: " + hero.score;
		if (rBase != null) {
			fuelLabel = "Fuel Level: " + rBase.fuelLevel + "%";
		} // end if
	}// end createLabel

	/**
	 * 
	 * Ensures: collisions between bullets and aliens, bullets and the hero, aliens
	 * and the hero, and Hero and interactables. Also removes necessary components.
	 * 
	 */
	public void handleCollisions() {
		for (Bullet bullet : this.aBullets) {
			if (bullet.isOverlapping(hero.hitbox)) {
				hero.health--;
				bulletsToRemove.add(bullet);
			} // end if
		} // end for
		for (Bullet bullet : this.bullets) {
			for (Alien alien : this.aliens) {
				if (bullet.isOverlapping(alien.hitbox)) {
					aliensToRemove.add(alien);
					bulletsToRemove.add(bullet);
					hero.score += 15;
				} // end if
			} // end for
		} // end for
		for (Alien alien : this.aliens) {
			if (alien.hitbox.intersects(hero.hitbox)) {
				aliensToRemove.add(alien);
				hero.health--;
			} // end if
		} // end for
		for (Bullet b : bulletsToRemove) {
			this.bullets.remove(b);
			this.aBullets.remove(b);
		} // end for
		for (Alien a : aliensToRemove) {
			this.aliens.remove(a);
		} // end for
		for (Rocket r : rPieces) {
			if (r.isOverlapping(hero.hitbox)) {
				hero.grab(r);
			} // end if
		} // end for
		if (this.rBase != null) {
			if (this.rBase.size == 3) {
				for (Fuel f : this.fuel) {
					if (f.isOverlapping(hero.hitbox)) {
						hero.grab(f);
					} // end if
				} // end for
			} // end if
			if (this.rBase.isOverlapping(hero.hitbox)) {
				this.rPieces.remove(hero.heldItem);
				this.fuel.remove(hero.heldItem);
				if (this.rBase.size == 3 & hero.heldItem != null) {
					rBase.fuelLevel += 25;
				} // end if
				hero.dropItem();
				this.rBase.setSize(3 - this.rPieces.size());
			} // end if
		} // end if
		for (Resource resources : this.resources) {
			if (resources.objectHitbox.intersects(hero.hitbox)) {
				hero.score += 50;
				resourcesToRemove.add(resources);
			} // end if
		} // end for
		for (LifeUp oneUp : this.lifeUps) {
			for (Platform plat : this.allPlatforms) {
				if (plat.isOverlapping(oneUp.objectHitbox) || oneUp.yPosition >= 590) {
					oneUp.speed = 0;
				} // end if
				oneUp.move();
			} // end for
			if (oneUp.isOverlapping(hero.hitbox)) {
				hero.health += 1;
				resourcesToRemove.add(oneUp);
			}
		} // end for
		for (Interactables r : resourcesToRemove) {
			resources.remove(r);
			lifeUps.remove(r);
		} // end for
	}// end handleCollisions

	/**
	 * 
	 * Ensures: checks if the current level is won.
	 * 
	 */
	public void checkWin() {
		if (rBase != null) {
			if (rBase.fuelLevel == 100) {
				this.hero.remove();
				rBase.liftOff();
			} // end if
			if (rBase.yPosition < 0) {
				changeLevel(1);
			} // end if
		} // end if
	}// end checkWin

	/**
	 * 
	 * Ensures: checks if hero has died. Changes winOrLoss Label accordingly.
	 * 
	 */
	public void checkLoss() {
		if (this.hero.health <= 0) {
			this.hero.remove();
			winOrLoss = "GAME OVER!";
		} // end if
	}// end checkLoss

	/**
	 * 
	 * Ensures: weapon is swapped.
	 * 
	 */
	public void swapWeapon() {
		for (Weapon w : weapons) {
			if (w.isOverlapping(this.hero.hitbox) & this.hero.weapon != w) {
				hero.swapWeapon(w);
				return;
			} // end if
		} // end for
	}// end swapWeapon

	public void spawnLifeUp() {
		this.lifeUps.add(new LifeUp(0, 0, 25, 25));
	}// end spawnLifeUp

}// end class GameMainComponent
