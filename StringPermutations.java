import java.util.Scanner;

public class StringPermutations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("Permutations of the string are:");
        generatePermutations("", input);
    }

    private static void generatePermutations(String prefix, String remaining) {
        if (remaining.isEmpty()) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < remaining.length(); i++) {
                char currentChar = remaining.charAt(i);
                String before = remaining.substring(0, i);
                String after = remaining.substring(i + 1);
                generatePermutations(prefix + currentChar, before + after);
            }
        }
    }
}