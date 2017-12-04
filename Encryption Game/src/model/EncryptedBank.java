package model;

public class EncryptedBank implements Bank {

	private String[] encryptedBank;
	
	public EncryptedBank(int level) {
		this.encryptedBank = new String[3];
		populateBank(level);
	}
	
	/**
	 * This method populates wordBank with three unique String values based on the 
	 * specified level
	 * @param level Game level chosen by the user 
	 */
	@Override
	public void populateBank(int level) {
		switch(level) 
		{
			case 1:
				this.encryptedBank = new String[] { "sbqii", "awwlyfatyon", "jxvx" };
				break;
			case 2:
				this.encryptedBank = new String[] { "iqtgrvahg", "vgchnd", "rsqhmfr" };
				break;
			case 3:
				this.encryptedBank = new String[] { "lxuunlcrxw", "ejpacan", "qrcraqrapl" };
				break;
			case 4: 
				this.encryptedBank = new String[] { "flapuebavmrq", "rapelcgvba", "pqhigpri" };
				break;
			default:
				System.out.println( "Word bank not set: Level = " + level );
		}
	}
	/**
	 * Returns the word in encryptedBank at the specified index
	 * @param index index of word in encryptedBank to be returned
	 * @return String value at encryptedBank[index]
	 */
	@Override
	public String getWord(int index) {
		return this.encryptedBank[index];
	}

}
