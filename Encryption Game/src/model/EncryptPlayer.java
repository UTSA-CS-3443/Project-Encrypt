package model;

import model.Player;

/**
 * Extension of the Player abstract class, holds data about players of the Encryption game and any specialized data not covered by the Player class.
 * NOTE: This is as it stands, an empty class. I included it in case we need to make changes later. Maybe add a write to file function.
 * @author Connor Guerra
 *
 */
public class EncryptPlayer extends Player {
	
	/**
	 * Calls parent class constructor, takes in a String for the player name
	 * @param strp_name String, Player name 
	 */
	public EncryptPlayer(String strp_name) {
		super(strp_name);
	}

}
