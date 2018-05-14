package domain;

public abstract class PassEnc {
	
	public static String encrypt (String s) {
		String s2 = "";		
		for(int i = 0; i < s.length(); i++) {
			s2 = s2 + (char)((int)s.charAt(i)+1);
		}
		return s2;
		
	}
	
	public static String decrypt (String s) {
		String s2 = "";		
		for(int i = 0; i < s.length(); i++) {
			s2 = s2 + (char)((int)s.charAt(i)-1);
		}
		return s2;
		
	}
	
	
}