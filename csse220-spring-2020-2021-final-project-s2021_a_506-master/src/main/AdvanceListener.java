package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * The purpose of this class is to call the actions that happen in each tick of
 * the game timer.
 * 
 * @author Grayson Snyder and Roka Brovick
 *
 */
public class AdvanceListener implements ActionListener {

	GameMainComponent component;
	private int count = 0;
	private int loops = 0;

	/**
	 * 
	 * Ensures: AdvanceListener is constructed and it knows the GameMainComponent it
	 * is manipulating.
	 * 
	 * @param component
	 */
	public AdvanceListener(GameMainComponent component) {
		this.component = component;
	}// end constructor

	/**
	 * 
	 * Ensures: All relevant methods of the component are called with each call of
	 * the AdvanceListener
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		component.createLabel();
		component.heroMove(component.isHeroLanded());
		component.moveAliens();
		component.handleBullets();
		component.handleCollisions();
		component.repaint();
		component.checkWin();
		component.checkLoss();
		if (count == 50) {
			component.aliensFire();
			this.count = 0;
			this.loops += 1;
		} // end if
		if (count == 30 & this.loops == 5) {
			component.spawnLifeUp();
			this.loops = 0;
		} // end if
		this.count = this.count + 1;
	}// end actionPerformed

}// end class AdvanceListener
