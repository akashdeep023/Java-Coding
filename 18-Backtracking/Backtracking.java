public class Backtracking {
    public static void printArr(int arr[]) {
        System.out.print("( ");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " , ");
        }
        System.out.println(arr[arr.length - 1] + " )");
    }

    public static void changeArr(int arr[], int i, int val) {
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

    public static void main(String[] args) {
        // Type of Backtracking --------------------------------
        // 1. Decision
        // 2. Optimization
        // 3. Enumeration

        // Backtracking on Arrays --------------------------------
        int arr[] = new int[5];
        changeArr(arr, 0, 1);
        printArr(arr);
    }
}