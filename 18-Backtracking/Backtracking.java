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

    }
}