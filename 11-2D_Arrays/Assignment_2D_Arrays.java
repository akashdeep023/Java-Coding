public class Assignment_2D_Arrays {
    public static int elementCount(int arr[][], int key) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == key) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int secondRowSum(int arr[][]) {
        int sum = 0;
        for (int i = 0; i < arr[0].length; i++) {
            sum += arr[1][i];
        }
        return sum;
    }

    public static void transposeMatrix(int arr[][]) {
        int transMatrix[][] = new int[arr[0].length][arr.length]; // m X n
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                transMatrix[j][i] = arr[i][j];
            }
        }
        System.out.println("Print Transpose Matrix :");
        printMatrix(transMatrix);
    }

    public static void main(String[] args) {
        // Question 1 : Print the number of 7’s that are in the 2d array.
        int[][] array = { { 4, 7, 8 }, { 8, 8, 7 } }; // Output -> 2
        System.out.println("count of 7 is : " + elementCount(array, 7));

        // Question 2 : Print out the sum of the numbers in the second row of the “nums” array.
        int[][] nums = { { 1, 4, 9 }, { 11, 4, 3 }, { 2, 2, 3 } }; // Output -> 18
        System.out.println("Sum of second row is : " + secondRowSum(nums));

        // Question 3 : Write a program to Find Transpose of a Matrix.
        // What is Transpose? -> Transpose of a matrix is the process of swapping the rows to columns. For a 2x3 matrix.
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 } }; // Output -> { { 1, 4 }, { 2, 5 }, { 3, 6 } }
        System.out.println("Print original matrix :");
        printMatrix(matrix);
        transposeMatrix(matrix);
    }

    public static void printMatrix(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
