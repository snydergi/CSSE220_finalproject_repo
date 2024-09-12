package main;

import java.awt.Color;

/**
 * 
 * The purpose of this class is to create platforms for the hero to land and
 * walk on.
 * 
 * @author Grayson Snyder and Roka Brovick
 *
 */
public class Platform extends Interactables {

	public Platform(int xPos, int yPos, int w, int h, Color color) {
		super(xPos, yPos, w, h);
		this.imageFileName = "Platform.png";
	}// end constructor

}// end class Platform
