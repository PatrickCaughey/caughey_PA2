/*
 * the easiest way to implicitly convert data to string is to concat them with an empty string
 */

public class Encrypter {
	
	public String encrypt(String input){
		//convert to char array
		char[] chars = input.toCharArray();
		int[] ints = new int[4];
		
		//convert to int array
		for (int i = 0; i < 4; i++) {
			ints[i] = Integer.parseInt("" + chars[i]);
		}
		
		//modulo digits
		for (int i = 0; i < 4; i++) {
			ints[i] = (ints[i] + 7) % 10;
		}
		
		//reorder digits
		return "" + ints[2] + ints[3] + ints[0] + ints[1];
	}
}
