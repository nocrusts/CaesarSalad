//@author Curtis Lou with Anselme Sorin
//
//@version May 24, 2022

public class CaesarSalad {

	public static String caesarShift(String plaintext, int n) { // This method DOES NOT PRESERVE CASE
		// a - z = 97 - 122
		plaintext = plaintext.toLowerCase();
		String encString = "";
		for (int i = 0; i < plaintext.length(); i ++) {
			int currentCharAscii = plaintext.charAt(i);
			if (!(currentCharAscii < 96)) {
				currentCharAscii += n;
				if (currentCharAscii > 122) {
					currentCharAscii = (i - 122) + 65; 
				} else if (currentCharAscii < 61) {
					currentCharAscii = 122 - (96 - i);
				}
			}
			encString += (char)(currentCharAscii);
		}
		return encString;
	}
	
	public static void main(String args[]) {
		String uncMessage = "1!@/blah ijoi32joir32";
		int shiftAmt = 5;
		
		String encMessage = caesarShift(uncMessage, shiftAmt);
		String decMessage = caesarShift(encMessage, shiftAmt * -1);
		
		System.out.println("Current Shift: " + shiftAmt);
		System.out.println("Raw Message (not passed through decryption): " + uncMessage);
		System.out.println("Encrypted: " + encMessage);
		System.out.println("Decrypted: " + decMessage);
	}

}
