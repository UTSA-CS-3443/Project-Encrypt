package core;

/**
 * Abstract class for Players, if we add AI players or different types of players, this should be the parent class. 
 * Currently is responsible for score and name. May add a write to file function later.
 * @author Connor Guerra
 *
 */
public abstract class Player {
	private int int_score;
	private String str_name;
	
	/**
	 * Constructor of Player class, initializes score and sets name to the given parameter
	 * @param strp_name String, player name.
	 */
	public Player(String strp_name){
		this.setStr_name(strp_name);
		this.setInt_score(0);
	}
	
	/**
	 * Updates the player's score by adding the parameter to the original score. 
	 * @param intp_scoreChange Integer amount that you wish to change the player's score by. Can be negative or positive.
	 */
	public void changeScore(int intp_scoreChange){
		setInt_score(getInt_score() + intp_scoreChange);
	}

	/**
	 * Simple getter method for the name of the player.
	 * @return Name of the player.
	 */
	public String getStr_name() {
		return str_name;
	}
	
	/**
	 * Setter method for the name of the player. I recommend deleting this, as the player name should not change after creation.
	 * @param str_name New name of the player.
	 */
	public void setStr_name(String str_name) {
		this.str_name = str_name;
	}

	/**
	 * Simple getter method for the score of the player.
	 * @return Integer score of the player.
	 */
	public int getInt_score() {
		return int_score;
	}

	/**
	 * Simple setter method for the score of the player. Recommend we keep this if we want to reset the player's score at any time.
	 * @param int_score New Integer score of the player.
	 */
	public void setInt_score(int int_score) {
		this.int_score = int_score;
	}

}
