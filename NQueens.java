import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NQueens {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the chessboard (N):");
        int n = scanner.nextInt();

        List<List<String>> solutions = solveNQueens(n);

        System.out.println("Number of solutions: " + solutions.size());
        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        int[] queens = new int[n]; 
        solve(0, n, queens, solutions);
        return solutions;
    }

    private static void solve(int row, int n, int[] queens, List<List<String>> solutions) {
        if (row == n) {
            solutions.add(formatSolution(queens, n));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, queens)) {
                queens[row] = col; 
                solve(row + 1, n, queens, solutions); 
            }
        }
    }
    private static boolean isSafe(int row, int col, int[] queens) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || Math.abs(queens[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    private static List<String> formatSolution(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            for (int j = 0; j < n; j++) {
                row[j] = '.';
            }
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
