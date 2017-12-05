package model;

public class SubstitutionTool implements EncryptTool{

	public SubstitutionTool() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String substitution(char chrp_target, char chrp_replace, String strp_sentence){
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

	@Override
	public String shift(int intp_shift, String word) {
		// TODO Auto-generated method stub
		return null;
	}
}
