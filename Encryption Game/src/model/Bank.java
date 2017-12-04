package model;

public interface Bank {
	
	/**
	 * This method populates the bank with three unique String values based on the specified level
	 * @param level Game level chosen by the user
	 */
	public void populateBank(int level);
	
	/**
	 * Returns the word in the bank at the specified index
	 * @param index index of word in bank to be returned
	 * @return String value at bank[index]
	 */
	public String getWord(int index);
	
}
