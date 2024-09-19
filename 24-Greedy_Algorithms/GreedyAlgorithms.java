import java.util.*;
import java.util.Arrays;
import java.lang.Math;

public class GreedyAlgorithms {
    static class Job {
        int id; // 1(A), 2(B), 3(C), 4(D)....
        int deadline;
        int profit;

        public Job(int i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }
    }

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
        System.out.println("\n");

        // Job Sequence Problem -------------------------------- TC -> O(nlogn)
        // Given an array of jobs where every job has a deadline and profit it the job is finished before the deadline.
        // It is also given that every job takes a single unit of time, so the minimum possible deadline is for any job is 1.
        // Maximum the total profit if only one job can be scheduled at a time.
        int jobInfo[][] = {
                { 4, 20 },
                { 1, 10 },
                { 1, 40 },
                { 1, 30 }
        };
        // Create static Job class ---
        ArrayList<Job> jobs = new ArrayList<>(); // Create ArrayList of Job type
        for (int i = 0; i < jobInfo.length; i++) {
            Job curr = new Job(i, jobInfo[i][0], jobInfo[i][1]); // Create Job
            jobs.add(curr); // Add Job in ArrayList
        }
        Collections.sort(jobs, (job1, job2) -> job2.profit - job1.profit); // sort descending order based on profit
        int time = 0; // start time
        ArrayList<Integer> seq = new ArrayList<>(); // ArrayList to store sequence
        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (curr.deadline > time) {
                seq.add(curr.id);
                time++;
            }
        }
        // Print Job sequence
        System.out.println("Max Job sequence : " + seq.size());
        for (int i = 0; i < seq.size(); i++) {
            System.out.print((char) ('A' + seq.get(i)) + " ");
        }
        System.out.println("\n");

        // Chocola Problem --------------------------------
        // We are given a bar of chocolate composed of m x n square pieces. One should break the chocolate into single squares.
        // Each break of a part of the chocolate is charged a cost expressed by a positive integer. This cost does not depend 
        // on the size of the part that is being broken but only depends on the line the break goes along. Let us denote the costs
        // of breaking alog consecutive vertical lines with x1,x2,x3,...,sm-1 and along horizontal lines with y1,y2,y3,...,yn-1.
        // Compute the minimum cost of breaking the whole chocolate into sinngle square pieces.
        int n = 4, m = 6; // number of chocolate pieces = n X m
        Integer costVer[] = { 2, 1, 3, 1, 4 };
        Integer costHor[] = { 4, 1, 2 };

        Arrays.sort(costVer, Comparator.reverseOrder()); // sort reverse order
        Arrays.sort(costHor, Comparator.reverseOrder()); // sort reverse order
        int h = 0, v = 0; // horizontal pointer or vertical pointer
        int hp = 1, vp = 1;
        int cost = 0;
        while (h < costHor.length && v < costVer.length) {
            if (costHor[h] <= costVer[v]) { // vertical cut
                cost += costVer[v] * hp; // cost = cost of vertical cut * horizontal peices
                vp++; // vertical peices increment by 1
                v++;
            } else { // horizontal cut
                cost += costHor[h] * vp; // cost = cost of horizontal cut * vertical peices
                hp++; // horizontal peices increment by 1
                h++;
            }
        }
        while (v < costVer.length) { // extra vertical cut
            cost += costVer[v] * hp; // cost = cost of vertical cut * horizontal peices
            vp++; // vertical peices increment by 1
            v++;
        }
        while (h < costHor.length) { // extra horizontal cut
            cost += costHor[h] * vp; // cost = cost of horizontal cut * vertical peices
            hp++; // horizontal peices increment by 1
            h++;
        }
        System.out.println("Min cost of cuts : " + cost);
    }
}