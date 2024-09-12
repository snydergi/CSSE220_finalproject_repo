package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * 
 * The purpose of this class is to create an alien that shoots bullets at the
 * hero.
 * 
 * @author Grayson Snyder and Roka Brovick
 *
 */
public class ProjectileAlien extends Alien {

	/**
	 * 
	 * Ensures: ProjectileAlien is created and fields are set.
	 * 
	 * @param x
	 * @param y
	 */
	public ProjectileAlien(int x, int y) {
		super(x, y);
		this.imgFilename = "ProjectileAlien.png";
		try {
			this.img = ImageIO.read(new File(this.imgFilename));
		} catch (IOException e) {
			e.printStackTrace();
		} // end try-catch
	}// end constructor

	@Override
	public void shoot() {
		Bullet b = new Bullet(this.xPosition + this.img.getWidth() / 2, this.yPosition + this.img.getHeight() / 4, 5, 5,
				1);
		this.bullets.add(b);
		Bullet b2 = new Bullet(this.xPosition + this.img.getWidth() / 2, this.yPosition + this.img.getHeight() / 4, 5,
				5, -1);
		this.bullets.add(b2);
	}

}// end ProjectileAlien
