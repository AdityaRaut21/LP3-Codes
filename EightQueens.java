public class EightQueens {

    static final int SIZE = 8;
    static int[][] board = new int[SIZE][SIZE];

    // Method to place the first queen on the board
    static void placeFirstQueen(int row, int col) {
        board[row][col] = 1;
    }

    // Method to check if placing a queen at a specific position is safe
    static boolean isSafe(int row, int col) {
        // Check this row on the left side
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        // Check upper diagonal on left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check lower diagonal on left side
        for (int i = row, j = col; j >= 0 && i < SIZE; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    // Method to solve the 8-Queens problem starting from a given column
    static boolean solveQueens(int col) {
        // Base case: All queens are placed
        if (col >= SIZE)
            return true;

        // Try placing a queen in each row of this column
        for (int row = 0; row < SIZE; row++) {
            // Skip the first queen's position to avoid overwriting it
            if (col == 0 && board[row][col] == 1) {
                continue;
            }

            // Check if placing a queen here is safe
            if (isSafe(row, col)) {
                board[row][col] = 1; // Place the queen

                // Recur to place the rest of the queens
                if (solveQueens(col + 1))
                    return true;

                // Backtrack
                board[row][col] = 0;
            }
        }

        return false;
    }

    // Method to print the board
    static void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Place the first queen (for example, at position (0,0))
        int firstQueenRow = 0;
        int firstQueenCol = 0;
        placeFirstQueen(firstQueenRow, firstQueenCol);

        // Start solving from the next column after the initial queen
        if (solveQueens(1)) {
            printBoard();
        } else {
            System.out.println("Solution does not exist");
        }
    }
}
