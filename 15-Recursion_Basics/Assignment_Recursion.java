public class Assignment_Recursion {
    // Solution 1 --------------------------------
    public static void printOccurrences(int arr[], int idx, int key) {
        if (idx == arr.length) {
            return;
        }
        if (key == arr[idx]) {
            System.out.print(idx + " ");
        }
        printOccurrences(arr, idx + 1, key);
    }

    // Solution 2 --------------------------------
    static String digits[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    public static void convertToEnglish(int num) {
        if (num == 0) {
            return;
        }
        int numDigit = num % 10;
        convertToEnglish(num / 10); // call for next digit
        System.out.print(digits[numDigit] + " "); // then print digit
    }

    // Solution 3 --------------------------------
    public static int printLength(String str) {
        if (str.length() == 0) {
            return 0;
        }
        // return printLength(str.substring(0, str.length() - 1)) + 1;
        return printLength(str.substring(1)) + 1;
    }

    // Solution 4 --------------------------------
    public static int countSubstrs(String str, int i, int j, int n) {
        if (n == 1) {
            return 1;
        }
        if (n <= 0) {
            return 0;
        }
        int res = countSubstrs(str, i + 1, j, n - 1) +
                countSubstrs(str, i, j - 1, n - 1) -
                countSubstrs(str, i + 1, j - 1, n - 2);
        if (str.charAt(i) == str.charAt(j)) {
            res++;
        }
        return res;

    }

    public static void towerOfHanoi(int n, String src, String helper, String dest) {
        if (n == 1) {
            System.out.println("transfer disk " + n + " from " + src + " to " + dest);
            return;
        }
        //transfer top n-1 from src to helper using dest as 'helper'
        towerOfHanoi(n - 1, src, dest, helper);
        //transfer nth from src to dest
        System.out.println("transfer disk " + n + " from " + src + " to " + helper);
        //transfer n-1 from helper to dest using src as 'helper'
        towerOfHanoi(n - 1, helper, src, dest);
    }

    public static void main(String[] args) {
        // Question 1 : For a given integer array of size N. You have to find all the occurrences (indices) of a given element (Key) and print them. Use a recursive function to solve this problem.
        int arr[] = { 3, 2, 4, 5, 6, 2, 7, 2, 2 };
        int key = 2;
        printOccurrences(arr, 0, key); // Output -> 1 5 7 8
        System.out.println();

        // Question 2 : You are given a number (eg - 2019), convert it into a String of english like “two zero one nine”. Use a recursive function to solve this problem.
        // NOTE - The digits of the number will only be in the range 0-9 and the last digit of a number can’t be 0.
        int number = 1947;
        convertToEnglish(number); // Output -> one nine four seven
        System.out.println();

        // Question 3 : Write a program to find Length of a String using Recursion.
        String name = "akash deep";
        System.out.println(printLength(name));

        // Question 4 : We are given a string S, we need to find the count of all contiguous substrings starting and ending with the same character.
        String str = "abcab";
        int n1 = str.length();
        System.out.print(countSubstrs(str, 0, n1 - 1, n1));
        System.out.println();

        String S = "aba"; // substring = a, b, a, ab, ba, aba
        int n2 = S.length();
        System.out.print(countSubstrs(S, 0, n2 - 1, n2)); //  4 The substrings are a, b, a and aba.
        System.out.println();

        // Question 5 : TOWER OF HANOI (Important!)
        // You have 3 towers and N disks of different sizes which can slide onto any tower. The puzzle starts with disks sorted in ascending order of size from top to bottom (i.e., each disk sits on top of an even larger one).
        int n = 4;
        towerOfHanoi(n, "A", "B", "C");

        // The Solution for this particular question has also been discussed here :
        // https://www.youtube.com/watch?v=u-HgzgYe8KA
        // At timestamp : 00:05
    }
}
