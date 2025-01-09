import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the password to check its strength:");
        String password = sc.nextLine();

        String strength = checkPasswordStrength(password);

        System.out.println("Password Strength: " + strength);
    }

    public static String checkPasswordStrength(String password) {
        if (password.length() < 6) {
            return "Weak"; // Too short to be strong
        }

        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }

        if (hasUppercase && hasLowercase && hasDigit && hasSpecialChar && password.length() >= 12) {
            return "Strong";
        } else if ((hasUppercase || hasLowercase) && hasDigit && (hasSpecialChar || password.length() >= 8)) {
            return "Medium";
        } else {
            return "Weak";
        }
    }
}
