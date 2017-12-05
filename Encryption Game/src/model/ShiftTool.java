package model;

public class ShiftTool implements EncryptTool{

	public ShiftTool() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String shift(int intp_shift, String word){
		String str_mutated = "";
		int i = 0;
		char chr_current =' ';
		while(i < word.length()){
			chr_current = (char) ( 97 + ( ( word.charAt(i) - 97  - intp_shift ) % 26 ) );
			str_mutated = str_mutated + chr_current;
			i++;
		}
		return str_mutated;
	}

	@Override
	public String substitution(char chrp_target, char chrp_replace, String strp_sentence) {
		// TODO Auto-generated method stub
		return null;
	}

}
