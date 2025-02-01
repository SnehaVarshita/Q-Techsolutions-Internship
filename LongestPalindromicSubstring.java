import java.util.Scanner;

public class LongestPalindromicSubstring {
    public static String findLongestPalindromicSubstring(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0, maxLength = 1;
        
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }
        
        
        for (int length = 3; length <= n; length++) {
            for (int i = 0; i < n - length + 1; i++) {
                int j = i + length - 1; 
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    maxLength = length;
                }
            }
        }
        
        return s.substring(start, start + maxLength);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        String longestPalindrome = findLongestPalindromicSubstring(input);
        System.out.println("Longest Palindromic Substring: " + longestPalindrome);
        
        scanner.close();
    }
}
