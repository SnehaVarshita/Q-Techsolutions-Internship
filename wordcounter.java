import java.util.Scanner;

public class wordcounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a string of text:");
        String input = sc.nextLine();
        int wordCount = countWords(input);
        System.out.println("The total number of words is: " + wordCount);
        sc.close();
    }

    public static int countWords(String text) {
        if (text == null) {
            return 0; 
        }
        String trimmedText = text.trim();
        if (trimmedText.isEmpty()) {
            return 0; 
        }
        String[] words = trimmedText.split("\\s+");
        int wordCount = words.length;
        return wordCount;
    }
}
