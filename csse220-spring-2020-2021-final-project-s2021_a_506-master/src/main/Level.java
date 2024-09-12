package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * The purpose of this class is to create levels for the Jetpac Man game.
 * 
 * @author Grayson Snyder and Roka Brovick
 *
 */
public class Level {

	public int heroX;
	public int heroY;
	public ArrayList<Platform> allPlatforms = new ArrayList<>();
	public ArrayList<Alien> aliens = new ArrayList<Alien>();
	public ArrayList<RocketPiece> rPieces = new ArrayList<>();
	public ArrayList<Fuel> fuel = new ArrayList<>();
	public Rocket rBase;
	public ArrayList<Weapon> weapons = new ArrayList<>();
	public ArrayList<Resource> resource = new ArrayList<>();
	private boolean notRead = true;
	private String cFile = "";
	private String nFile;

	/**
	 * 
	 * Ensures: Level object is constructed
	 * 
	 */
	public Level() {
	}// end constructor

	/**
	 * 
	 * Ensures: file is read and level is created and displayed based on its
	 * contents.
	 * 
	 * @param filename
	 * @param g2d
	 */
	public void readFile(String filename, Graphics2D g2d) {
		this.nFile = filename;
		if (!cFile.equals(nFile)) {
			this.notRead = true;
			this.cFile = this.nFile;
		} // end if
		Scanner scanner;
		File newFileVar = null;
		try {
			newFileVar = new File(filename);
			scanner = new Scanner(newFileVar);
		} catch (FileNotFoundException e) {
			System.out.println("absolute path: " + newFileVar.getAbsolutePath());
			System.out.println(filename + " not found");
			return;
		} // end try-catch
		int lineNumber = 1;
		if (notRead) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				char[] a = line.toCharArray();
				for (int k = 0; k < a.length; k++) {
					if (a[k] == '_') {
						g2d = (Graphics2D) g2d.create();
						Platform plat = new Platform(k * 50, (lineNumber - 1) * 50, 50, 25, Color.DARK_GRAY);
						allPlatforms.add(plat);
					} // end if
					if (a[k] == 'H') {
						heroX = k * 50;
						heroY = (lineNumber - 1) * 50;
					} // end if
					if (a[k] == 'M') {
						MeleeAlien m = new MeleeAlien(k * 50, (lineNumber - 1) * 50);
						aliens.add(m);
					} // end if
					if (a[k] == 'P') {
						ProjectileAlien m = new ProjectileAlien(k * 50, (lineNumber - 1) * 50);
						aliens.add(m);
					} // end if
					if (a[k] == 'B') {
						Rocket b = new Rocket(k * 50, (lineNumber - 1) * 50 + 20, 30, 30);
						this.rBase = b;
					} // end if
					if (a[k] == 'R') {
						RocketPiece r = new RocketPiece(k * 50, (lineNumber - 1) * 50 + 20, 30, 30);
						rPieces.add(r);
					} // end if
					if (a[k] == 'F') {
						Fuel f = new Fuel(k * 50, (lineNumber - 1) * 50 + 20, 30, 30);
						fuel.add(f);
					} // end if
					if (a[k] == 'S') {
						Weapon w = new SpreadWeapon(k * 50, (lineNumber - 1) * 50, 10, 5);
						weapons.add(w);
					} // end if
					if (a[k] == 'V') {
						Weapon w = new SpeedyWeapon(k * 50, (lineNumber - 1) * 50, 10, 5);
						weapons.add(w);
					} // end if
					if (a[k] == 'T') {
						Weapon w = new MultiWeapon(k * 50, (lineNumber - 1) * 50, 10, 5);
						weapons.add(w);
					} // end if
					if (a[k] == 'D') {
						Resource r = new Resource(k * 50, (lineNumber - 1) * 50 + 25, 25, 25);
						resource.add(r);
					} // end if
				} // end for
				lineNumber++;
			} // end while
			scanner.close();
			this.notRead = false;
		} // end if
	} // readFile

}// end class Level
