
// import java.util.ArrayList; // Java Collections Framework
// import java.util.Collections;
import java.util.*;
import java.lang.Math;

public class Array_List {
    public static void swapElement(ArrayList<Integer> list, int idx1, int idx2) {
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }

    public static int storeWater(ArrayList<Integer> height) { // Brute forse TC -> O(n^2)
        int max = 0;
        for (int i = 0; i < height.size(); i++) {
            for (int j = i + 1; j < height.size(); j++) {
                int lHeight = Math.min(height.get(i), height.get(j));
                int width = j - i;
                max = Math.max(max, lHeight * width);
            }
        }
        return max;
    }

    public static int storeWaterOpt(ArrayList<Integer> height) { // Two pointer approach TC -> O(n)
        int maxWater = 0;
        int lp = 0; // left pointer
        int rp = height.size() - 1; // right pointer
        while (lp < rp) {
            // Calculate water area
            int minheight = Math.min(height.get(lp), height.get(rp));
            int width = rp - lp;
            int water = minheight * width;
            maxWater = Math.max(maxWater, water);
            // Update pointer
            if (height.get(lp) < height.get(rp)) {
                lp++;
            } else {
                rp--;
            }
        }
        return maxWater;
    }

    public static boolean pairSum1Brute(ArrayList<Integer> list, int target) { // Brute forse  TC -> O(n^2)
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int currSum = list.get(i) + list.get(j);
                if (target == currSum) {
                    return true;
                    // System.out.print("("+list.get(i)+","+list.get(j)+") ");
                }
            }
        }
        return false;
        // System.out.println();
    }

    public static boolean pairSum1TwoPointer(ArrayList<Integer> list, int target) { // Two pointer approach  TC -> O(n)
        int lp = 0;
        int rp = list.size() - 1;
        while (lp < rp) {
            if (target == list.get(lp) + list.get(rp)) {
                return true;
            } else if (target > list.get(lp) + list.get(rp)) {
                lp++;
            } else {
                rp--;
            }
        }
        return false;
    }

    public static boolean pairSum2(ArrayList<Integer> list, int target) {
        // Fint pivot 
        int bp = -1;
        int n = list.size();
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                bp = i;
                break;
            }
        }
        int rp = bp;
        int lp = bp + 1;
        while (lp != rp) {
            if (target == list.get(lp) + list.get(rp)) {
                return true;
            }
            if (target > list.get(lp) + list.get(rp)) { // target big then incressing index
                lp = (lp + 1) % n; // range (0 to n-1)
            } else {
                rp = (n + rp - 1) % n; // range (0 to n-1)
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Introduction to ArrayList --------------------------------
        // Array -> Fixed size & primitive data types can be stored
        // ArrayList -> Dynamic size (dynamic array that can grow and shrink as needed) & primitive data types can't be stored directly
        // Declaration -> ArrayList<data-type> variableName = new ArrayList<>();
        // ArrayList<String> list = new ArrayList<>(); // String type -> non primitive
        ArrayList<Integer> list = new ArrayList<>(); // Integer type -> non primitive

        // Operations on ArrayList --------------------------------
        // Add elements --- TC -> O(1)
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);

        // list.add(1, 10); // TC -> O(n)
        // System.out.println(list);

        // Get elements --- TC -> O(1)
        // System.out.println(list.get(2));

        // Remove (Delete) elements --- TC -> O(n)
        // list.remove(2);
        // System.out.println(list);

        // Set (Update) elements --- TC -> O(n)
        // list.set(2, 5);
        // System.out.println(list);

        // Contains elements --- TC -> O(n)
        // System.out.println(list.contains(1));
        // System.out.println(list.contains(15));

        // Size of ArrayList --------------------------------
        // using size() method ---
        System.out.println(list.size());

        for (int i = 0; i < list.size(); i++) { // TC -> O(n)
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        // Print Reverse -------------------------------- TC -> O(n)
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        // Find Maximum -------------------------------- TC -> O(n)
        ArrayList<Integer> num = new ArrayList<>();
        num.add(2);
        num.add(5);
        num.add(9);
        num.add(3);
        num.add(6);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < num.size(); i++) {
            // if (max < num.get(i)) {
            //     max = num.get(i);
            // }
            max = Math.max(max, num.get(i));
        }
        System.out.println("Max element: " + max);

        // Swap Two numbers --------------------------------
        // System.out.println(num);
        // swapElement(num, 1, 3);
        // System.out.println(num);

        // Sorting an ArrayList --------------------------------
        // Collections.sort(); // Collections -> Class & Collection -> Interface
        System.out.println(num);
        Collections.sort(num); // Accending order
        System.out.println(num);

        Collections.sort(num, Collections.reverseOrder()); // reverseOrder -> Comparator (function logic define)
        System.out.println(num);

        // Multi dimensional ArrayList --------------------------------
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>(); // ArrayList store ArrayList
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            list1.add(i * 1);
            list2.add(i * 2);
            list3.add(i * 3);
        }

        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);

        list1.remove(2); // remove (doesn't matter list same size) 
        list3.remove(4);
        System.out.println(mainList);

        for (int i = 0; i < mainList.size(); i++) { // nested loop for print arraylist ---
            ArrayList<Integer> currList = mainList.get(i);
            for (int j = 0; j < currList.size(); j++) {
                System.out.print(currList.get(j) + " ");
            }
            System.out.println();
        }

        // Container with most water --------------------------------
        // For given n lines on x-axix, use 2 lines to form a container such that it holds maximum water. ---
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println(height);

        // Brute force --- O(n^2)
        System.out.println("Container with most Water : " + storeWater(height));

        // Two pointer approach --- O(n)
        System.out.println("Container with most Water Opt : " + storeWaterOpt(height));

        // Pair Sum 1 --------------------------------
        // Find if any pair in a Sorted ArrayList has a target sum.
        ArrayList<Integer> numList = new ArrayList<>();
        // 1,2,3,4,5,6
        numList.add(1);
        numList.add(2);
        numList.add(3);
        numList.add(4);
        numList.add(5);
        numList.add(6);
        int target = 5;
        System.out.println(pairSum1Brute(numList, target));
        System.out.println(pairSum1TwoPointer(numList, target)); // numList sorted

        // Pair Sum 2 --------------------------------
        // Find if any pair in a Sorted & Rotated ArrayList has a target sum.
        ArrayList<Integer> numList2 = new ArrayList<>();
        // 11,15,6,8,9,10
        numList2.add(11);
        numList2.add(15);
        numList2.add(6);
        numList2.add(8);
        numList2.add(9);
        numList2.add(10);
        int target2 = 16;
        System.out.println(pairSum2(numList2, target2));
    }
}