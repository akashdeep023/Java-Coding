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

    }
}