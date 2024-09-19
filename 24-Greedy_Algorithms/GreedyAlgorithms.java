import java.util.*;
import java.util.Arrays;
import java.lang.Math;

public class GreedyAlgorithms {
    public static void main(String[] args) {
        // Gready algorithm (Base on Real tife example) --------------------------------
        // 1st -> Optimization (min , max)
        // 2nd -> Sorting
        // 3rd -> No fixed rule

        // Definition => Gready algorithm is the problem solving technique where we make the locally 
        // optimum(best) choice at each stage & hope to achive a global optimum.

        // Pros -> Simple & easy, Good enough Time complexity 
        // Cons -> A lot of time, global optimum is not achived

        // Activity selection -------------------------------- TC -> O(nlogn)
        // (Same problem -> Disjoint Set or Max meeting in a room)
        // You are given n activities with their start and end times. Select the maximum number of activities that can be 
        // performed by a single person, assuming that a person can only work on a single activity at a time. 
        // Activities are sorted according to end time.
        // int start[] = { 1, 3, 0, 5, 8, 5 }; // start time
        // int end[] = { 2, 4, 6, 7, 9, 9 }; // end time basis sorted
        int start[] = { 0, 3, 5, 1, 5, 8 }; // start time
        int end[] = { 6, 4, 9, 2, 7, 9 }; // end time (unsorted)

        // sorting end time
        int activities[][] = new int[start.length][3];
        for (int i = 0; i < activities.length; i++) {
            activities[i][0] = i; // store index
            activities[i][1] = start[i]; // store start 
            activities[i][2] = end[i]; // store end
        }
        // Sort 2D arrays using lambda function of Comparator
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2])); // shortform column wise idx 2

        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        // 1st activity add in ans
        maxAct = 1;
        // ans.add(0);
        ans.add(activities[0][0]);
        // int lastEnd = end[0];
        int lastEnd = activities[0][2];
        ;
        for (int i = 1; i < end.length; i++) { // select activity add
            // if (start[i] >= lastEnd) {
            if (activities[i][1] >= lastEnd) {
                maxAct++;
                // ans.add(i);
                ans.add(activities[i][0]);
                // lastEnd = end[i];
                lastEnd = activities[i][2];
            }
        }
        // Print activity
        System.out.println("Max activities : " + maxAct); // Output -> 4
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println("\n");

        // Fractional Knapsack(Bag) -------------------------------- TC -> O(nlogn)
        // Given the weights and values of N items, put these items in a knapsack of capacity W to get
        // the maximum total value in the knapsack.
        int val[] = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };
        int w = 50;

        double ratio[][] = new double[val.length][2];
        // ratio sorting in ascending order
        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i; // 0st col = index
            ratio[i][1] = val[i] / (double) weight[i]; // 1st col = ratio
        }
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1])); // sort ascending order
        int finalVal = 0;
        int capacity = w;
        for (int i = ratio.length - 1; i >= 0; i--) { // reverse loop because we should max values
            int idx = (int) ratio[i][0];
            if (capacity >= weight[idx]) { // include full item
                capacity = capacity - weight[idx];
                finalVal += val[idx];
            } else { // include fractional item
                finalVal += capacity * ratio[i][1];
                break; // capacity full
            }
        }
        System.out.println("Price : " + finalVal); // Output -> 240
        System.out.println();

        // Minimum Sum Absolute Difference Pairs. -------------------------------- TC -> O(nlogn)
        // Given two arrays A and B of equal length n, Pair each element of array A to an element in array B,
        // such that Sum S of absolute difference of all  the pairs is minimum.
        // int A[] = { 1, 2, 3 };
        // int B[] = { 2, 1, 3 }; // Output -> 0
        int A[] = { 4, 1, 8, 7 };
        int B[] = { 2, 3, 6, 5 }; // Output -> 6

        // Sort ascending order of elements
        Arrays.sort(A);
        Arrays.sort(B);
        int minDiff = 0;
        for (int i = 0; i < A.length; i++) {
            minDiff += Math.abs(A[i] - B[i]);
        }
        System.out.println("Min Sum Abs difference : " + minDiff);
        System.out.println();

        // Max Length chain of Pairs -------------------------------- TC -> O(nlog)
        // You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
        // A pair (c,d) can come after pair (a,b) if b<c.
        // Find the longest chain which can be formed from a given set of pairs.
        int pairs[][] = {
                { 5, 24 },
                { 39, 60 },
                { 5, 28 },
                { 27, 40 },
                { 50, 90 }
        };

        // sort pairs (Based on 2nd number of pairs)
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1])); // sort ascending order
        int chainEnd = pairs[0][1];
        int chainLen = 1;
        for (int i = 1; i < pairs.length; i++) {
            if (chainEnd <= pairs[i][0]) {
                chainLen++;
                chainEnd = pairs[i][1];
            }
        }
        System.out.println("Max Chain length : " + chainLen);
        System.out.println();

        // Indian Coins --------------------------------
        // We are given an infinite supply of denominations [1,2,5,10,20,50,100,500,2000].
        // Find min no of Coins/Notes to make change for a value V.
        Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        Arrays.sort(coins, Comparator.reverseOrder()); // reverse order
        int amount = 590;
        ArrayList<Integer> ansCoins = new ArrayList<>();
        for (int i = 0; i < coins.length; i++) {
            while (coins[i] <= amount) {
                ansCoins.add(coins[i]);
                amount -= coins[i];
            }
        }
        System.out.println("Min no of Coins/Notes : " + ansCoins.size());
        for (int i = 0; i < ansCoins.size(); i++) {
            System.out.print(ansCoins.get(i) + " ");
        }
    }
}