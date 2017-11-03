package core;

/**
 * Encryption tool, Static class that has various methods to mutate strings a number of different ways.
 * NOTE: I feel there is no need for this to be anything other than static, as it should not be
 * responsible for any data storage.
 * @author Connor Guerra
 *
 */
public class EncryptTool {
	
	/**
	 * String mutator, loops through a given string and replaces all target characters with the replacement character.
	 * Changes one character at a time.
	 * @param chrp_target Target character, character to be replaced.
	 * @param chrp_replace Replacement character, replaces all target characters.
	 * @param strp_sentence Given string, will have all targets replaced with designated character.
	 * @return Mutated string that has all target characters replaced.
	 */
	public static String substitutionTool(char chrp_target, char chrp_replace, String strp_sentence){
		String str_mutated = "";
		int i = 0;
		while(i < strp_sentence.length()){
			if(strp_sentence.charAt(i) == chrp_target){
				str_mutated = str_mutated + chrp_replace;
			}else{
				str_mutated = str_mutated + strp_sentence.charAt(i);
			}
			i++;
		}
		return str_mutated;
	}
	
	/**
	 * String mutator, shifts the ENTIRE string by a given number of characters in the ASCII character set.
	 * @param intp_shift Integer amount that you wish to shift the string by.
	 * @param strp_sentence Given string to be shifted
	 * @return Mutated string that has been shifted by the given amount.
	 */
	public static String shiftTool(int intp_shift, String strp_sentence){
		String str_mutated = "";
		int i = 0;
		char chr_current =' ';
		while(i < strp_sentence.length()){
			chr_current = (char) (strp_sentence.charAt(i) + intp_shift);
			str_mutated = str_mutated + chr_current;
			i++;
		}
		return str_mutated;
	}

}
