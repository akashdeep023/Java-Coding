import java.util.Scanner;

public class TwoD_Arrays {
    // Print Matrix
    public static void printMatrix(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Search Elements
    public static boolean searchElements(int matrix[][], int key) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (key == matrix[i][j]) {
                    System.out.println("Key found: [" + i + "," + j + "]");
                    return true;
                }
            }
        }
        System.out.println("Key not found");
        return false;
    }

    public static void printSpiral(int arr[][]) {
        int rs = 0, re = arr.length - 1, cs = 0, ce = arr[0].length - 1;
        while (rs <= re && cs <= ce) {
            // top boundary
            for (int i = cs; i < ce; i++) {
                System.out.print(arr[rs][i] + ",");
            }
            // right boundary
            for (int i = rs; i < re; i++) {
                System.out.print(arr[i][ce] + ",");
            }
            // bottom boundary
            for (int i = ce; i > cs; i--) {
                if (rs == re) { // single line boundary (rs == re)
                    break;
                }
                System.out.print(arr[re][i] + ",");
            }
            // left boundary
            for (int i = re; i > rs; i--) {
                if (cs == ce) { // single line boundary (cs == ce)
                    break;
                }
                System.out.print(arr[i][cs] + ",");
            }
            rs++;
            re--;
            cs++;
            ce--;
        }
        System.out.println();
    }

    public static int diagonalSum(int arr[][]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];
            if (i != arr.length - 1 - i) { // special case (1X1) common values (allready added)
                sum += arr[i][arr.length - 1 - i];
            }
        }
        return sum;
    }

    public static boolean staircaseSearch(int arr[][], int key) {
        int i = 0, j = arr[0].length - 1;
        while (i < arr.length && j >= 0) {
            if (arr[i][j] == key) {
                System.out.println("Found key " + arr[i][j] + " at = (" + i + "," + j + ")");
                return true;
            } else if (arr[i][j] < key) {
                i++;
            } else {
                j--;
            }
        }
        System.out.println("Key not found");
        return false;
    }

    public static void main(String[] args) {
        // Creating 2D Arrays --------------------------------
        Scanner sc = new Scanner(System.in);

        // int matrix[][] = new int[3][3]; // row -> 3, column -> 3
        // for (int i = 0; i < 3; i++) { // input matrix
        //     for (int j = 0; j < 3; j++) {
        //         System.out.print("Enter element at position [" + i + "][" + j + "]: ");
        //         matrix[i][j] = sc.nextInt();
        //     }
        // }

        // printMatrix(matrix); // output matrix

        // searchElements(matrix, 6); // search elements

        // Spiral Matrix --------------------------------
        // int spiralMatrix[][] = {
        //         { 1, 2, 3, 4 },
        //         { 5, 6, 7, 8 },
        //         { 9, 10, 11, 12 },
        //         { 13, 14, 15, 16 }
        // };
        // printSpiral(spiralMatrix);

        // Diagonal Sum (n X n)--------------------------------
        // int diagMatrix[][] = {
        //         { 1, 2, 3, 4 },
        //         { 5, 6, 7, 8 },
        //         { 9, 10, 11, 12 },
        //         { 13, 14, 15, 16 }
        // };

        // int diagMatrix2[][] = {
        //         { 1, 2, 3 },
        //         { 4, 5, 6 },
        //         { 7, 8, 9 }
        // };
        // System.out.println("Diagonal Sum : " + diagonalSum(diagMatrix));
        // System.out.println("Diagonal Sum : " + diagonalSum(diagMatrix2));

        // Search in Sorted Matrix (Staircase search)--------------------------------
        // Search for a key in row wise & column wise sorted matrix---
        int stMatrix[][] = {
                { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 }
        };
        int key = 37;
        staircaseSearch(stMatrix, key);

        sc.close();
    }
}