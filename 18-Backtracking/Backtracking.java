public class Backtracking {
    public static void printArr(int arr[]) {
        System.out.print("( ");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " , ");
        }
        System.out.println(arr[arr.length - 1] + " )");
    }

    public static void changeArr(int arr[], int i, int val) { // TC -> O(n)
        // Base case
        if (i == arr.length) {
            printArr(arr);
            return;
        }
        // Recursion
        arr[i] = val;
        changeArr(arr, i + 1, val + 1); // fnx call step
        arr[i] = arr[i] - 2; // backtracking step
    }

    public static void findSubSetString(String str, String ans, int i) { // TC -> O(n * n^2) & SC-> O(n)
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }
        // Yes choice
        findSubSetString(str, ans + str.charAt(i), i + 1);
        // No choice
        findSubSetString(str, ans, i + 1);
    }

    public static void findSubSetStringBuilder(String str, StringBuilder ans, int i) {
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }
        // Yes choice
        findSubSetStringBuilder(str, ans.append(str.charAt(i)), i + 1);
        ans = ans.delete(ans.length() - 1, ans.length()); // remove last character
        // No choice
        findSubSetStringBuilder(str, ans, i + 1);
    }

    public static void findPermutation(String str, String ans) { // TC -> O(n * n!)
        // Base case
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        // Recursion
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            // "abcde"="ab"+"de"="abde"
            String newStr = str.substring(0, i) + str.substring(i + 1, str.length()); // str.substring(start,end) Ya str.substring(start) => str.substring(start,str.length())
            findPermutation(newStr, ans + curr);
        }
    }

    public static void nQueens(char board[][], int row) {
        if (row == board.length) { // Base case  
            System.out.println("-------Chess Board-------");
            printBoard(board);
            countWays++;
            return;
        }
        //column loop
        for (int j = 0; j < board.length; j++) {
            if (isSafeQueen(board, row, j)) { // safe hai ya nhi call isSafe
                board[row][j] = 'Q';
                nQueens(board, row + 1); // function call
                board[row][j] = 'X'; // backtracking
            }
        }
    }

    public static boolean isSafeQueen(char board[][], int row, int col) {
        // vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // diag left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // diag right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void printBoard(char board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int countWays = 0;

    public static boolean nQueensSol1(char board[][], int row) {
        if (row == board.length) { // Base case            
            // printBoard(board);
            // countWays++;
            return true;
        }
        //column loop
        for (int j = 0; j < board.length; j++) {
            if (isSafeQueen(board, row, j)) { // safe hai ya nhi call isSafe
                board[row][j] = 'Q';
                if (nQueensSol1(board, row + 1)) {
                    return true;
                }
                board[row][j] = 'X'; // backtracking
            }
        }
        return false;
    }

    public static int gridWays(int i, int j, int n, int m) {
        // Base case
        if (i == n - 1 && j == m - 1) { // condition for last cell
            return 1; // 1 way
        } else if (i == n || j == m) { // boundary cross condition
            return 0; // 0 way
        }
        int w1 = gridWays(i + 1, j, n, m);
        int w2 = gridWays(i, j + 1, n, m);
        return w1 + w2;
    }

    public static boolean sudokuSolver(int sudoku[][], int row, int col) {
        // base case
        if (row == 9) {
            return true;
        }
        //recursion
        int nextRow = row, nextCol = col + 1;
        if (col + 1 == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }
        if (sudoku[row][col] != 0) { // already placed
            return sudokuSolver(sudoku, nextRow, nextCol);
        }
        for (int digit = 1; digit <= 9; digit++) { // choice digit 1 to 9
            if (isSafeSudoku(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if (sudokuSolver(sudoku, nextRow, nextCol)) { // solution exists
                    return true;
                }
                sudoku[row][col] = 0; // backtracking
            }
        }
        return false;
    }

    public static boolean isSafeSudoku(int sudoku[][], int row, int col, int digit) {
        //column
        for (int i = 0; i <= 8; i++) {
            if (sudoku[i][col] == digit) {
                return false;
            }
        }
        //row
        for (int j = 0; j <= 8; j++) {
            if (sudoku[row][j] == digit) {
                return false;
            }
        }
        // grid (3 x 3)
        int sr = (row / 3) * 3; // 1,2,3
        int sc = (col / 3) * 3; // 1,2,3
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void printSudoku(int sudoku[][]) {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    // ------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        // Type of Backtracking --------------------------------
        // 1. Decision
        // 2. Optimization
        // 3. Enumeration

        // Backtracking on Arrays --------------------------------
        int arr[] = new int[5];
        changeArr(arr, 0, 1);
        printArr(arr);
        System.out.println();

        // Find Subsets --------------------------------
        String str = "abc";
        findSubSetString(str, "", 0);
        System.out.println();

        findSubSetStringBuilder(str, new StringBuilder(""), 0);
        System.out.println();

        // Find Permutations --------------------------------
        String str2 = "abc";
        findPermutation(str2, "");
        System.out.println();

        // N Queens --------------------------------
        // Place N Queens on an N x N chess board such that no 2 queens can attack each other. ---
        int n = 4;
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }
        nQueens(board, 0);
        System.out.println();

        // N Queens count ways --------------------------------
        // Count total number of ways in which we can solve N Queens problems. ---
        System.out.println("Total ways to solve n queens = " + countWays);

        // N Queens print one solution --------------------------------
        // Check if problem can be solved & print only 1 solution to N Queens. ---
        if (nQueensSol1(board, 0)) {
            System.out.println("Solution is possible");
            printBoard(board);
        } else {
            System.out.println("Solution is not possible");
        }
        System.out.println();

        // Grid Ways --------------------------------
        // Find number of ways to reach from (0,0) to (N-1,M-1) in a NxM grid. (Allowed moves - right and down) ---
        int row = 3, col = 3;
        System.out.println("Number of ways : " + gridWays(0, 0, row, col));
        System.out.println();

        // Sudoku --------------------------------
        // Write a function to complete a Sudoku. ---
        int sudoku[][] = {
                { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
                { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
                { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
                { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
                { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
                { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
                { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
                { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
                { 8, 2, 7, 0, 0, 9, 0, 1, 3 }
        };
        if (sudokuSolver(sudoku, 0, 0)) {
            System.out.println("----------Solution exists----------");
            printSudoku(sudoku);
        } else {
            System.out.println("----------Solution not exists----------");
        }
    }
}