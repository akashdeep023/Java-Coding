public class Recursion {
    public static void printDecreasing(int n) {
        if (n == 1) { // Base case
            System.out.println(n);
            return;
        }
        System.out.print(n + " "); // Work
        printDecreasing(n - 1); // Inner function call
    }

    public static void printIncreasing(int n) {
        if (n == 1) { // Base case
            System.out.print(1 + " ");
            return;
        }
        printIncreasing(n - 1); // Inner function call
        System.out.print(n + " "); // Work
    }

    public static int factorial(int n) { // Time Complexity -> O(n), Space Complexity -> O(n)
        if (n == 0) { // Base case
            return 1;
        }
        int fac_n = n * factorial(n - 1);
        return fac_n;
    }

    public static int sumOfN(int n) {
        if (n == 1) {
            return 1;
        }
        // int snm1=sumOfN(n-1);
        // int sn=n+snm1;
        // return sn;
        return n + sumOfN(n - 1); // sort
    }

    public static int fibonacci(int n) { // Time Complexity -> O(2^n), Space Complexity -> O(n)
        if (n == 0 || n == 1) {
            return n;
        }
        int fibo = fibonacci(n - 1) + fibonacci(n - 2);
        return fibo;
    }

    public static boolean isSorted(int arr[], int i) {
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return isSorted(arr, i + 1);
    }

    public static int firstOccu(int arr[], int key, int i) {
        if (i == arr.length) { // Base case
            return -1;
        }
        if (arr[i] == key) { // Key Match than return index (i)
            return i;
        }
        return firstOccu(arr, key, i + 1); // call for next index
    }

    public static int lastOccu(int arr[], int key, int i) {
        if (i == arr.length) { // Base case
            return -1;
        }
        int isFound = lastOccu(arr, key, i + 1); // call for next index
        if (isFound == -1 && arr[i] == key) {
            return i;
        }
        return isFound;
    }

    public static int power(int x, int n) {
        if (n == 1) {
            return x;
        }
        // int xPnm1=power(x,n-1);
        // int xPn=x * xPnm1;
        // return xPn;
        return x * power(x, n - 1); // sort form uper three line
    }

    public static int optimzedPower(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int halfPower = optimzedPower(x, n / 2);
        int halfPowerSq = halfPower * halfPower;
        if (n % 2 != 0) { // power (n) is odd number
            halfPowerSq = x * halfPowerSq;
        }
        return halfPowerSq;
    }

    public static int tilingProblem(int n) { // 2 X n (floor size)
        if (n == 0 || n == 1) {
            return 1;
        }
        // choise vertical 
        int fnm1 = tilingProblem(n - 1);
        // choise horizontal 
        int fnm2 = tilingProblem(n - 2);
        int totWays = fnm1 + fnm2;
        return totWays;
    }

    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]) {
        if (idx == str.length()) {
            System.out.println("New string : " + newStr);
            return;
        }
        char currChar = str.charAt(idx);
        if (map[currChar - 'a'] == false) {
            newStr = newStr.append(currChar);
            map[currChar - 'a'] = true;
        }
        removeDuplicates(str, idx + 1, newStr, map);
    }

    public static int friendsPairing(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int singleFriend = friendsPairing(n - 1); // choice single friend
        int pairFriend = friendsPairing(n - 2); // choice pair friend
        int totalWays = singleFriend + ((n - 1) * pairFriend); // n friends -> 1 friend n-1 with pair -> multiple (n-1) with pairFriend
        return totalWays;
    }

    public static void printBinStrings(int n, int lastPlace, String str) {
        if (n == 0) {
            System.out.println(str);
            return;
        }
        printBinStrings(n - 1, 0, str + "0");
        if (lastPlace == 0) {
            printBinStrings(n - 1, 1, str + "1");
        }
    }

    public static void main(String[] args) {
        // What is Recursion? --------------------------------
        // => Recursion is a method  of solving a computation problem where the solution depends on solution to smaller instances of the same problem.
        // Recursion based on iteration or function.
        // Mostly used to Trees, Graphs, and DP.
        // Assume calling => main -> fun -> fun -> fun -> fun(base case).
        // 3 Step -> Know base case, work, inner call.

        // Problem 1. Print number from n to 1 (Decrreasing order). --------------------------------
        for (int i = 10; i > 0; i--) { // Using loop
            System.out.print(i + " ");
        }
        System.out.println();
        printDecreasing(10); // Using recursion

        // Stack Overflow --------------------------------
        // parameters memory full
        // too many function calls
        // Solution -> base case must be added

        // Problem 2. Print number from  to n (Increasing order). --------------------------------
        printIncreasing(10);
        System.out.println();

        // Problem 3. Find factorial of n. --------------------------------
        System.out.println("Factorial : " + factorial(5));

        // Problem 4. Print Sum of n natural numbers. --------------------------------
        System.out.println("Sum of N : " + sumOfN(10));

        // Problem 5. Print nth fibonacci number. --------------------------------
        System.out.println("Fibonacci : " + fibonacci(25));

        // Problem 6. Check if a given array is sorted or not. --------------------------------
        int arr[] = { 1, 2, 3, 4, 5 };
        System.out.println("Is Sorted : " + isSorted(arr, 0));

        // Problem 7. First occurrence. --------------------------------
        int arr2[] = { 8, 3, 6, 9, 5, 10, 2, 5, 3 };
        System.out.println("First Occurrence : " + firstOccu(arr2, 5, 0));

        // Problem 8. Last occurrence. --------------------------------
        System.out.println("Last Occurrence : " + lastOccu(arr2, 5, 0));

        // Problem 9. Print x to the power n. --------------------------------
        System.out.println("Power : " + power(25, 2));

        // Problem 10. Print x to the power n. (Optimized) --------------------------------
        System.out.println("Optimzed Power : " + optimzedPower(2, 5));

        // Problem 11. Tiling problem --------------------------------
        // -> Given a "2 X n" board (floor) and tiles of size "2 X 1", count the number of ways to the given board using the "2 X 1" tiles.
        System.out.println("Tiling Problem : " + tilingProblem(4));

        // Problem 12. Remove Duplicates in a String. --------------------------------
        String str = "appnnacollege";
        removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);

        // Problem 13. Friends Pairing problem. --------------------------------
        // -> Given n friends each one can remain single or can be paired up with some other friend. Each friend can be paired only once. Find out the total number of ways in which friends can remain single or can be paired up.
        System.out.println("Friends Pairing : " + friendsPairing(4));

        // Problem 14. Binary String problem. --------------------------------
        // Print all binary strings if Size N without consecutive ones.
        printBinStrings(3, 0, "");
    }
}