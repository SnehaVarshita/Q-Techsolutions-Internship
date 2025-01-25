import java.util.Scanner;

public class Cryptography {

    // Caesar Cipher
    public static String caesarCipher(String text, int key, boolean isEncrypting) {
        StringBuilder result = new StringBuilder();
        int shift = isEncrypting ? key : -key;

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                c = (char) ((c - base + shift + 26) % 26 + base);
            }
            result.append(c);
        }
        return result.toString();
    }

    // Vigenère Cipher
    public static String vigenereCipher(String text, String key, boolean isEncrypting) {
        StringBuilder result = new StringBuilder();
        key = key.toLowerCase();
        int keyIndex = 0;

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int shift = key.charAt(keyIndex) - 'a';
                shift = isEncrypting ? shift : -shift;
                c = (char) ((c - base + shift + 26) % 26 + base);

                keyIndex = (keyIndex + 1) % key.length();
            }
            result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select the Cipher method:");
        System.out.println("1. Caesar Cipher");
        System.out.println("2. Vigenère Cipher");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Enter the text:");
        String text = scanner.nextLine();

        System.out.println("Encrypt or Decrypt? (E/D):");
        char mode = scanner.nextLine().toUpperCase().charAt(0);
        boolean isEncrypting = mode == 'E';

        String result = "";

        switch (choice) {
            case 1:
                System.out.println("Enter the key (integer):");
                int caesarKey = scanner.nextInt();
                result = caesarCipher(text, caesarKey, isEncrypting);
                break;

            case 2:
                System.out.println("Enter the key (string):");
                String vigenereKey = scanner.nextLine();
                result = vigenereCipher(text, vigenereKey, isEncrypting);
                break;

            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.println("Result: " + result);
        scanner.close();
    }
}
