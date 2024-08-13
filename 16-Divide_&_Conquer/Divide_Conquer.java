public class Divide_Conquer {
    public static void printArrays(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void mergeSort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;// (si + ei) / 2; -> si + ei = greater than int value
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si; // iterator for left part
        int j = mid + 1; // iterator for right part
        int k = 0; // iterator for temp arr
        // Compair and merge
        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        // Extra left part merge
        while (i <= mid) {
            temp[k++] = arr[i++]; // pre increment
        }
        // Extra right part merge
        while (j <= ei) {
            temp[k++] = arr[j++]; // pre increment
        }
        // Copy temp to original array
        for (int t = 0, oi = si; t < temp.length; t++, oi++) {
            arr[oi] = temp[t];
        }
    }

    public static void main(String[] args) {
        // Divide & Conquer -> Algorithms

        // Merge sort algorithm --------------------------------
        int arr[] = { 6, 3, 9, 5, 2, 8 };
        mergeSort(arr, 0, arr.length - 1);
        printArrays(arr);
    }
}