import java.util.*;
import java.util.Arrays;

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

        // Activity selection -------------------------------- (Same problem -> Disjoint Set or Max meeting in a room)
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
        System.out.println("Max activities : " + maxAct);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();
    }
}