package model;

public class WordBank implements Bank {

	private String[] wordBank;
	
	public WordBank(int level) {
		this.wordBank = new String[3];
		populateBank(level);
	}
	
	/**
	 * This method populates encryptedBank with three unique String values based on the 
	 * specified level
	 * @param level Game level chosen by the user 
	 */
	@Override
	public void populateBank(int level) {
		switch(level) 
		{
			case 1:
				this.wordBank = new String[] { "class", "application", "java" };
				break;
			case 2:
				this.wordBank = new String[] { "interface", "method", "strings" };
				break;
			case 3:
				this.wordBank = new String[] { "collection", "integer", "dependency" };
				break;
			case 4: 
				this.wordBank = new String[] { "synchronized", "encryption", "abstract"};
				break;
			default:
				System.out.println( "Word bank not set: Level = " + level );
		}
	}
	
	/**
	 * Returns the word in wordBank at the specified index
	 * @param index index of word in wordBank to be returned
	 * @return String value at wordBank[index]
	 */
	@Override
	public String getWord(int index) {
		return this.wordBank[index];
	}
}