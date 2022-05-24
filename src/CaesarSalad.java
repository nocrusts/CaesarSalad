//@author Curtis Lou with Anselme Sorin
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
					currentCharAscii = (n - 'z') + 65; 
				} else if (currentCharAscii < 'a') {
					currentCharAscii = 'z' - (97 - n);
				}
			} else if (!((currentCharAscii < 'A') && !(currentCharAscii > 'Z'))) {
				currentCharAscii += n;
				if (currentCharAscii > 'Z') {
					currentCharAscii = (n - 'Z') + 65;
				} else if (currentCharAscii < 'A') {
					currentCharAscii = 'Z' - (65 - n);
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
			encString += caesarShift(tempString, convertedSingleKey);
			keyIdx++;
		}
		return encString;
	}
	
	public static void main(String args[]) {
		String uncMessage = "i am sleepy";
		int shiftAmt = 1;
		String key = "2428375565"; 
		
		String encMessage = caesarShift(uncMessage, shiftAmt);
		String decMessage = caesarShift(encMessage, shiftAmt * -1);
		
		System.out.println("Part 1a/1b:");
		System.out.println("Current Shift: " + shiftAmt);
		System.out.println("Raw Message (not passed through decryption): " + uncMessage);
		System.out.println("Encrypted: " + encMessage);
		System.out.println("Decrypted: " + decMessage);

		String encMessageMulti = caesarShiftMultiDigit(uncMessage, key, true);
		String decMessageMulti = caesarShiftMultiDigit(uncMessage, key, false);

		System.out.println();
		System.out.println("Part 2:");
		System.out.println("Current Key: " + key);
		System.out.println("Raw Message (not passed through decryption): " + uncMessage);
		System.out.println("Encrypted: " + encMessageMulti);
		System.out.println("Decrypted: " + decMessageMulti);
	}

}
