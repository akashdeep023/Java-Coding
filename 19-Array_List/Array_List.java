
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

    }
}