
// import java.util.*; // import all package
import java.util.Arrays; // import Array package
import java.util.Collections; // import Collection package

public class Sorting {
    // Bubble Sort -> Large element come to the end of array by swapping with adjacent elements.
    public static void bubbleSort(int arr[]) { // Time Complexity : O(n^2)
        for (int turn = 0; turn < arr.length - 1; turn++) { // last element already in sorted (0 to n - 2)
            for (int j = 0; j < arr.length - 1 - turn; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Modified Bubble Sort
    public static void modifiedBubbleSort(int arr[]) { // Time Complexity : O(n^2)
        for (int turn = 0; turn < arr.length - 1; turn++) { // last element already in sorted (0 to n - 2)
            boolean swapped = false;
            for (int j = 0; j < arr.length - 1 - turn; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false) { // already sorted array
                break;
            }
        }
    }

    // Selection Sort -> Pick the smallest (from unsorted), put it the beginning
    public static void selectionSort(int arr[]) { // Time Complexity : O(n^2)
        for (int i = 0; i < arr.length - 1; i++) { // last element already in sorted (0 to n - 2)
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) { // unsort part (find min element)
                if (arr[minPos] > arr[j]) {
                    minPos = j;
                }
            }
            // swap min element with current element
            int temp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = temp;
        }
    }

    // Insertion Sort -> Pick an element (from unsorted part) & place in the right position in sorted part
    public static void insertionSort(int arr[]) { // Time Complexity : O(n^2)
        for (int i = 1; i < arr.length; i++) { // 1st element is in sorted part (1 to n - 1)
            int key = arr[i]; // store current element
            int prev = i - 1;
            while (prev >= 0 && arr[prev] > key) { // finding out the current position to insert
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = key; // insertion 
        }
    }

    // Counting Sort -> Store frequency of elements in count array (no of element max but element value (range) min)
    public static void countingSort(int arr[]) { // Time Complexity : O(n + range) (range => largest element)
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]); // Find largest element
        }
        int count[] = new int[largest + 1]; // Create (largest + 1 size) array
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++; // arr[i] index count value increased by one
        }
        //Sorting
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        // What is Sorting --------------------------------
        // Sorting is the process of rearranging a collection of objects in a specific order.

        // Types of Basic Sorting Algorithms ---
        // 1. Bubble Sort               (TC -> O(n^2))
        // 2. Selection Sort            (TC -> O(n^2))
        // 3. Insertion Sort            (TC -> O(n^2))
        // 4. Counting Sort (Advanced)  (TC -> O(n logn))

        // Bubble Sort Example --------------------------------
        // int arr[] = { 5, 4, 1, 3, 2 };
        // bubbleSort(arr);
        // printArray(arr);

        //Modified Bubble Sort ---
        // int arr2[] = { 1, 2, 3, 4, 6, 8, 1, 9 };
        // modifiedBubbleSort(arr2);
        // printArray(arr2);

        // Selection Sort --------------------------------
        // int arr[] = { 5, 4, 1, 3, 2 };
        // selectionSort(arr);
        // printArray(arr);

        // Insertion Sort --------------------------------
        // int arr[] = { 5, 4, 1, 3, 2 };
        // insertionSort(arr);
        // printArray(arr);

        // Inbuilt Sort (TC -> O(n logn))-------------------------------- import package -> import java.util.Arrays; | import java.util.*;
        // int arr[] = { 5, 4, 1, 3, 2 }; // Accending order
        // Arrays.sort(arr);
        // printArray(arr);

        // int arr[] = { 5, 4, 1, 3, 2 };
        // Arrays.sort(arr, 0, 3); // ending index non included (sort -> 0 to 2 index)
        // printArray(arr);

        // Integer arr[] = { 5, 4, 1, 3, 2 }; // Integer -> Object type & int -> Primitive type
        // Arrays.sort(arr, Collections.reverseOrder()); //import java.util.Collections; (Collection.reverseOrder() function work only Object type)
        // printArray(arr);

        // Integer arr[] = { 5, 4, 1, 3, 2 };
        // Arrays.sort(arr, 0, 4, Collections.reverseOrder());
        // printArray(arr);

        // Counting Sort --------------------------------
        int arr[] = { 1, 4, 1, 3, 2, 4, 3, 7 };
        countingSort(arr);
        printArray(arr);
    }

    // Print array ---
    public static void printArray(int arr[]) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 1) {
                System.out.print(arr[i] + ",");
            } else {
                System.out.print(arr[i]);
            }
        }
        System.out.println("]");
    }

    // Print array ---
    public static void printArray(Integer arr[]) { // Objective type
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 1) {
                System.out.print(arr[i] + ",");
            } else {
                System.out.print(arr[i]);
            }
        }
        System.out.print("]");
        System.out.println();
    }
}