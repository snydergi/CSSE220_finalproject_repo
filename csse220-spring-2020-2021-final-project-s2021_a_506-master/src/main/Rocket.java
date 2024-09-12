package main;

/**
 * 
 * The purpose of this class is to create the rocket for the games end-goal.
 * 
 * @author Roka Brovick and Grayson Snyder
 *
 */
public class Rocket extends Interactables {

	public int size = 1;
	public int fuelLevel = 0;

	/**
	 * 
	 * Ensures: Rocket is created and fiels are set.
	 * 
	 * @param xPos
	 * @param yPos
	 * @param w
	 * @param h
	 */
	public Rocket(int xPos, int yPos, int w, int h) {
		super(xPos, yPos, w, h);
		this.imageFileName = "Rocket Base.png";
	}// end constructor

	/**
	 * 
	 * Ensures: The size of the rocket changes.
	 * 
	 * @param i
	 */
	public void setSize(int i) {
		if (i != this.size) {
			this.yPosition -= 30;
			this.height += 30;
			this.size = i;
			this.imageFileName = "Rocket Base " + i + ".png";
		} // end if
	}// end setSize

	/**
	 * 
	 * Ensures: The rocket gets fuel added to it.
	 * 
	 */
	public void addFuel() {
		this.fuelLevel++;
	}// end addFuel

	/**
	 * 
	 * Ensures: the rocket lifts off and flies to the top of the screen when called.
	 * 
	 */
	public void liftOff() {
		this.yPosition -= 2;
		this.imageFileName = "Rocket Flying.png";
	}// end liftOff

}// end class Rocket
