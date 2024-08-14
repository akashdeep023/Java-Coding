public class Assignment_Divide_Conquer {
    // Solution 1. -----------------------------------
    public static void sort(String arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;
        sort(arr, si, mid);
        sort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
    }

    public static void merge(String arr[], int si, int mid, int ei) {
        String temp[] = new String[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= ei) {
            if (arr[i].charAt(0) - 'a' <= arr[j].charAt(0) - 'a') {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        // Extra part
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= ei) {
            temp[k++] = arr[j++];
        }
        // copy in orginal array
        for (int k2 = 0, oi = si; k2 < temp.length; k2++, oi++) {
            arr[oi] = temp[k2];
        }
    }

    public static void printArray(String arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Solution 2. -----------------------------------

    public static void main(String[] args) {
        // Question 1 : Apply Merge sort to sort an array of Strings. (Assume that all the characters in all the Strings are in lowercase). (EASY)
        String arrs[] = { "sun", "earth", "mars", "mercury" }; // Output ->  {"earth", "mars", "mercury", "sun"}
        sort(arrs, 0, arrs.length - 1);
        printArray(arrs);

        // Question 2 : Given an array nums of size n, return the majority element. (MEDIUM)
        // The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
        int nums[] = { 3, 2, 3 }; // Output -> 3

        int nums2[] = { 2, 2, 1, 1, 1, 2, 2 }; // Output -> 2

        // Question 3 : Given an array of integers. Find the Inversion Count in the array. (HARD)
        // Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If the array is already sorted then the inversion count is 0. If an array is 
        // sorted in the reverse order then the inversion count is the maximum. Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
        // (Hint : A sorting algorithm will be used to solve this question.)
        int N = 5;
        int arr[] = { 2, 4, 1, 3, 5 }; // Output -> 3, because it has 3 inversions - (2, 1), (4, 1), (4, 3).

        int N2 = 5;
        int arr2[] = { 2, 3, 4, 5, 6 }; // Output -> 0, because the array is already sorted

        int N3 = 3;
        int arr3[] = { 5, 5, 5 }; // Output -> 0, because all the elements of the array are the same & already in a sorted manner.

    }
}