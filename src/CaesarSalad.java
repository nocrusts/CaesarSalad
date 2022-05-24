//@author Curtis Lou
//Caesar Cipher encryption / decryption method.
//@version May 24, 2022

public class CaesarSalad {

	public static String caesarShift(String plaintext, int n) { // Input: Plaintext, shift integer
		String encString = "";
		for (int i = 0; i < plaintext.length(); i ++) {
			int currentCharAscii = plaintext.charAt(i);
			if (!((currentCharAscii < 'a') && !(currentCharAscii > 'z'))) {
				currentCharAscii += n;
				if (currentCharAscii > 'z') {
					currentCharAscii = (currentCharAscii - 'z') + 'a' - 1;
					
				} else if (currentCharAscii < 'a') {
					currentCharAscii = 'z' - ('a' - currentCharAscii) + 1;
				}
			} else if (!((currentCharAscii < 'A') && !(currentCharAscii > 'Z'))) {
				currentCharAscii += n;
				if (currentCharAscii > 'Z') {
					currentCharAscii = (currentCharAscii - 'Z') + 'A' - 1;
				} else if (currentCharAscii < 'A') {
					currentCharAscii = 'Z' - ('A' - currentCharAscii) + 1;
				}
			}
			encString += (char)(currentCharAscii);
		}
		return encString;
	}
	
	//Inputs: plaintext, multidigit key, encryption mode.
	// mode true for encryption
	// mode false for decryption
	public static String caesarShiftMultiDigit(String plaintext, String key, boolean mode) {   
		int keyIdx = 0;
		String encString = "";
		for (int i = 0; i < plaintext.length(); i++) {
			
			if (keyIdx > key.length() - 1) {
				keyIdx = 0;
			}
			
			int convertedSingleKey = key.charAt(keyIdx) - 48;
			String tempString = "";
			tempString += plaintext.charAt(i);
			if (!(plaintext.charAt(i) == 32)) {
				if (mode == true) {
					encString += caesarShift(tempString, convertedSingleKey);
				} else {
					encString += caesarShift(tempString, convertedSingleKey * -1);
				}

				keyIdx++;
			} else {
				encString += ' ';
			}
			
		}
		return encString;
	}
	
	public static void main(String args[]) {
		String uncMessage = "i am sleepy";
		
		// Configurable options
		int shiftAmt = 8; // For single digit shifting
		String key = "2428375565"; // For multidigit shifting (key mode)
		//
		
		String encMessage = caesarShift(uncMessage, shiftAmt);
		String decMessage = caesarShift(encMessage, shiftAmt * -1);
		
		System.out.println("Part 1a/1b:");
		System.out.println("Current Shift: " + shiftAmt);
		System.out.println("Raw Message (not passed through decryption): " + uncMessage);
		System.out.println("Encrypted: " + encMessage);
		System.out.println("Decrypted: " + decMessage);

		String encMessageMulti = caesarShiftMultiDigit(uncMessage, key, true);
		String decMessageMulti = caesarShiftMultiDigit(encMessageMulti, key, false);

		System.out.println();
		System.out.println("Part 2:");
		System.out.println("Current Key: " + key);
		System.out.println("Raw Message (not passed through decryption): " + uncMessage);
		System.out.println("Encrypted: " + encMessageMulti);
		System.out.println("Decrypted: " + decMessageMulti);
	}

}
