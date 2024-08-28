import java.util.Scanner;
import java.lang.Math;

public class Arrays {
    // All functions are written below the main function...
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Introduction ----------------------------------
        // Arrays -> collection of elements of same data type
        // Declaration -> data type[] variableName = { element1, element2, element3,...};
        // 0 - based indexing

        // Definitions of an Array --------------------------------
        // List of elements of the same type placed in a contiguous memory location
        // "apple", true, 4.9, 8 -> wrong
        // 1, 2, 3, 4 -> int type
        // "apple", "banana", "cherry" -> String type

        // Arrays Creation --------------------------------
        // Operations in Array 
        // 1. Create
        // 2. Input
        // 3. Output
        // 4. Update

        // Creating an Array --------------------------------
        // dataType arrayName[] = new dataType[size];
        // int marks[] = new int[50]; // size -> 50 (Empty array) by default store ->(0,0,0,0,0...)
        // int numbers[] = { 1, 2, 3 }; // size -> 3
        // int morenumbers[] = { 4, 5, 6 }; // size -> 3
        // String fruits[] = { "apple", "orange", "banana", "orange" }; // size -> 4

        // Arrays - Input, Output, Update --------------------------------
        // int marks[] = new int[100];
        // System.out.println("Enter marks :-"); // Input --- 
        // marks[0] = sc.nextInt(); //phy
        // marks[1] = sc.nextInt(); //che
        // marks[2] = sc.nextInt(); //math

        // System.out.println("phy : " + marks[0]); // Output ---
        // System.out.println("che : " + marks[1]);
        // System.out.println("math : " + marks[2]);
        // System.out.println("50 index : " + marks[50]);

        // marks[2] = 100; // Update ---
        // System.out.println("math : " + marks[2]);
        // marks[1] = marks[1] + 1;
        // System.out.println("che : " + marks[1]);

        // double totalMarks = marks[0] + marks[1] + marks[2]; // Percentage ---
        // double percentage = (totalMarks / 300) * 100;
        // System.out.println("Percentage : " + percentage);

        // Find array of length --------------------------------
        // int students[] = new int[50]; 
        // int length = students.length;
        // System.out.println("Students array length : " + length);

        // Arrays as Function Arguments --------------------------------
        // Passing array as argument -> pass by reference / not pass by value
        // int marks[] = { 58, 63, 57 };
        // int nonChangable = 5;
        // update(marks, nonChangable);
        // System.out.println(nonChangable); // Variables value not changed -> pass by value
        // for (int i = 0; i < marks.length; i++) { // Print marks
        //     System.out.print(marks[i] + " "); // Array values changed -> pass by reference
        // }
        // System.out.println();

        // Linear search --------------------------------
        // Check every index ---
        // int numbers[] = { 2, 4, 6, 8, 10, 12, 14 };
        // int key = 10;
        // int index = linearSearch(numbers, key);
        // if (index == -1) {
        //     System.out.println("Not found");
        // } else {
        //     System.out.println("Key is at index = " + index);
        // }

        // Largest or Smallest number --------------------------------
        // int numbers[] = { 1, 2, 6, 3, 5 };
        // getLargest_Smallest(numbers);

        // Binary search --------------------------------
        // prerequisites -> sorted arrays ---
        // int numbers[] = { 2, 3, 5, 8, 9, 12, 15, 18, 19, 24, 28 };
        // int key = 8;
        // int index = binarySearch(numbers, key);
        // if (index == -1) {
        //     System.out.println("Not found");
        // } else {
        //     System.out.println("Key is at index = " + index);
        // }

        // Reverse an Array --------------------------------
        // int numbers[] = { 2, 5, 9, 12 };
        // reverse(numbers);
        // for (int i = 0; i < numbers.length; i++) { // print numbers
        //     System.out.print(numbers[i] + " ");
        // }
        // System.out.println();

        // Pairs in an Array --------------------------------
        // A continuous part of array ---
        // int numb[] = { 3, 5, 8, 9 };
        // printPairs(numb);

        // Print sub-arrays --------------------------------
        // int numb[] = { 2, 4, 6, 8, 10 };
        // printSubarrays(numb);

        // Max sub-arrays sum-1 (Brute force) --------------------------------
        // int numb[] = { 11, 7, 9, 12, 14, 22, 10 };
        // maxSubarraySumB(numb);

        // Max sub-arrays sum-2 (Prefix sum aproch) --------------------------------
        // int nump[] = { 11, 7, 9, 12, 14, 22, 10 };
        // maxSubarraySumP(nump);

        // Max subarrays sum-3 (kadane's -> -ve => 0) --------------------------------
        // int numk[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        // kadanes(numk);
        //Arrays neg -> add special case ---
        // int numks[] = { -23, -21, -22, -32, -11, -23, -15, -13 };
        // kadanes(numks);

        // Trapping Rainwater code --------------------------------
        // int hight[] = { 4, 2, 0, 6, 3, 2, 5 };
        // trappedRainwater(hight);

        // Buy & sell stocks --------------------------------
        int prices[] = { 7, 6, 10, 4, 6, 1 };
        buyAndSellStocks(prices);

        sc.close(); // close the scanner
    }

    // -------------------------------------functions-----------------------------------------------------------
    // The function can be written anywhere before or after the main function...
    public static void update(int marks[], int nonChangable) {
        nonChangable = 10;
        for (int i = 0; i < marks.length; i++) {
            marks[i] = marks[i] + 1;
        }
    }

    public static int linearSearch(int numbers[], int key) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void getLargest_Smallest(int numbers[]) {
        int largest = Integer.MIN_VALUE; // -infinity
        int smallest = Integer.MAX_VALUE; // +infinity
        for (int i = 0; i < numbers.length; i++) {
            if (largest < numbers[i]) {
                largest = numbers[i];
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            if (smallest > numbers[i]) {
                smallest = numbers[i];
            }
        }
        System.out.println("largest value is : " + largest);
        System.out.println("smallest value is : " + smallest);
    }

    public static int binarySearch(int numbers[], int key) {
        int start = 0;
        int end = numbers.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (numbers[mid] == key) { // found
                return mid;
            }
            if (numbers[mid] < key) { // right
                start = mid + 1;
            } else { // left 
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void reverse(int numbers[]) {
        int first = 0, last = numbers.length - 1;
        while (first < last) {
            int temp = numbers[last];
            numbers[last] = numbers[first];
            numbers[first] = temp;
            first++;
            last--;
        }
    }

    public static void printPairs(int numbers[]) {
        int totalPairs = 0;
        for (int i = 0; i < numbers.length; i++) {
            int curr = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                System.out.print("(" + curr + "," + numbers[j] + ") ");
                totalPairs++;
            }
            System.out.println();
        }
        System.out.println("Total no of Pairs = " + totalPairs);
    }

    public static void printSubarrays(int num[]) {
        int totalSubArrays = 0;
        for (int i = 0; i < num.length; i++) { // start subarray index
            int start = i;
            for (int j = i; j < num.length; j++) { // end subarray index
                int end = j;
                for (int k = start; k <= end; k++) { // print sub array code
                    System.out.print(num[k] + ","); // subarrays
                }
                totalSubArrays++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Total Subarrays = " + totalSubArrays);
    }

    public static void maxSubarraySumB(int num[]) { // brute force
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < num.length; i++) {
            for (int j = i; j < num.length; j++) {
                currSum = 0;
                for (int k = i; k <= j; k++) { // print code
                    System.out.print(num[k] + ","); // subarrays
                    currSum += num[k]; // currentSum
                }
                System.out.print(" = " + currSum);
                if (maxSum < currSum) {
                    maxSum = currSum;
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Max sum of subarrays (brute) = " + maxSum);
    }

    public static void maxSubarraySumP(int num[]) { // prefix sum aproch
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[num.length];
        prefix[0] = num[0];
        // calculate prefix arrays
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + num[i];
        }
        for (int i = 0; i < num.length; i++) {
            int start = i;
            for (int j = 0; j < num.length; j++) {
                int end = j;
                currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];
                if (maxSum < currSum) {
                    maxSum = currSum;
                }
            }
            // System.out.println(currSum);
        }
        System.out.println("Max sum of subarrays (prefix sum) = " + maxSum);
    }

    public static void kadanes(int num[]) { // kadane's -> -ve => 0
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        // spacial case -> all elements negative ---
        for (int i = 0; i < num.length; i++) {
            maxSum = Math.max(maxSum, num[i]);
        }
        if (maxSum < 0) { // all elements -> negative
            System.out.println("Max sum of subarrays (kadane's -ve array) = " + maxSum);
            return;
        }
        // element negative or positive ---
        for (int i = 0; i < num.length; i++) {
            currSum = currSum + num[i];
            if (currSum < 0) {
                currSum = 0;
            }
            maxSum = Math.max(currSum, maxSum);
        }
        System.out.println("Max sum of subarrays (kadane's) = " + maxSum);
    }

    public static void trappedRainwater(int hight[]) {
        int n = hight.length;
        //calculate left max boundry  - Array
        int leftMax[] = new int[n];
        leftMax[0] = hight[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(hight[i], leftMax[i - 1]);
        }
        //calculate right max boundry - Array
        int rightMax[] = new int[n];
        rightMax[n - 1] = hight[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(hight[i], rightMax[i + 1]);
        }
        int trappedWater = 0;
        //Loop
        for (int i = 0; i < n; i++) {
            //waterlevel=min(leftmax,rightmax bound)
            int waterLev = Math.min(leftMax[i], rightMax[i]);
            //trappedwater=waterlever-hight[i]       
            trappedWater += waterLev - hight[i];
        }
        System.out.println("trapped Water : " + trappedWater);
    }

    public static void buyAndSellStocks(int prices[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (buyPrice < prices[i]) {
                int profit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = prices[i];
            }
        }
        System.out.println("Max profit : " + maxProfit);
    }
}