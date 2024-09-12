package main;

/**
 * 
 * The purpose of this class is to create an interactable fuel canister to fuel
 * the rocket.
 * 
 * @author snydergi
 *
 */
public class Fuel extends Interactables {

	/**
	 * 
	 * Ensures: fuel is constructed and fields are set.
	 * 
	 * @param xPos
	 * @param yPos
	 * @param w
	 * @param h
	 */
	public Fuel(int xPos, int yPos, int w, int h) {
		super(xPos, yPos, w, h);
		this.imageFileName = "Fuel.png";
	}// end constructor

}// end class Fuel
