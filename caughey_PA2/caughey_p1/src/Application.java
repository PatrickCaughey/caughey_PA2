import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//get input
		System.out.printf("Enter a 4 digit number: ");
		String input = scanner.nextLine();
		
		//get mode
		System.out.printf("Do you want to encrypt or decrypt? (e/d): ");
		String setting = scanner.nextLine();
		
		if (setting.equalsIgnoreCase("e")) {
			//encrypt
			Encrypter encrypter = new Encrypter();
			String encrypted = encrypter.encrypt(input);
			//print
			System.out.printf("Your number encrypted is: %s", encrypted);
		} else if (setting.equalsIgnoreCase("d")) {
			//decrypt
			Decrypter decrypter = new Decrypter();
			String decrypted = decrypter.decrypt(input);
			//print
			System.out.printf("Your number decrypted is: %s", decrypted);
		} else {
			//invalid input
			System.out.printf("Try again later.%n");
		}
		
		scanner.close();
	}

}
