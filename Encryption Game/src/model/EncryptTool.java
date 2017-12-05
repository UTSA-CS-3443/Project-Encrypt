package model;

/**
 * Encryption tool, Static class that has various methods to mutate strings a number of different ways.
 * NOTE: I feel there is no need for this to be anything other than static, as it should not be
 * responsible for any data storage.
 * @author Connor Guerra
 *
 */
public interface EncryptTool {
	
	/**
	 * String mutator, loops through a given string and replaces all target characters with the replacement character.
	 * Changes one character at a time.
	 * @param chrp_target Target character, character to be replaced.
	 * @param chrp_replace Replacement character, replaces all target characters.
	 * @param strp_sentence Given string, will have all targets replaced with designated character.
	 * @return Mutated string that has all target characters replaced.
	 */
	public String substitution(char chrp_target, char chrp_replace, String strp_sentence);

	
	/**
	 * String mutator, shifts the ENTIRE string by a given number of characters in the ASCII character set.
	 * @param intp_shift Integer amount that you wish to shift the string by.
	 * @param strp_sentence Given string to be shifted
	 * @return Mutated string that has been shifted by the given amount.
	 */
	public String shift(int intp_shift, String word);


}
