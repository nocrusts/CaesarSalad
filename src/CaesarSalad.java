//@author Curtis Lou with Anselme Sorin
//
//@version May 24, 2022

public class CaesarSalad {

	public static String caesarShift(String plaintext, int n) { // This method DOES NOT PRESERVE CASE
		// a - z = 97 - 122
		// A - Z = 
		String encString = "";
		for (int i = 0; i < plaintext.length(); i ++) {
			int currentCharAscii = plaintext.charAt(i);
			if (!((currentCharAscii < 'a') && !(currentCharAscii > 'z'))) {
				currentCharAscii += n;
				if (currentCharAscii > 'z') {
					currentCharAscii = (i - 'z') + 65; 
				} else if (currentCharAscii < 'a') {
					currentCharAscii = 'z' - (96 - i);
				}
			} else if (!((currentCharAscii < 'A') && !(currentCharAscii > 'Z'))) {
				currentCharAscii += n;
				if (currentCharAscii > 'Z') {
					currentCharAscii = (i - 'Z') + 65;
				} else if (currentCharAscii < 'A') {
					currentCharAscii = 'Z' - (64 - i);
				}
			}
			encString += (char)(currentCharAscii);
		}
		return encString;
	}
	
	public static void main(String args[]) {
		String uncMessage = "1!@/blah testing ABDCE";
		int shiftAmt = 5;
		
		String encMessage = caesarShift(uncMessage, shiftAmt);
		String decMessage = caesarShift(encMessage, shiftAmt * -1);
		
		System.out.println("Current Shift: " + shiftAmt);
		System.out.println("Raw Message (not passed through decryption): " + uncMessage);
		System.out.println("Encrypted: " + encMessage);
		System.out.println("Decrypted: " + decMessage);
	}

}
