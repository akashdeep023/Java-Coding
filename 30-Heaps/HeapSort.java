public class HeapSort {
    // Max Heap heapify function
    private static void heapify(int[] arr, int i, int size) { // TC -> O(logn)
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;
        if (left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }
        if (right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }
        if (maxIdx != i) {
            // swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(arr, maxIdx, size); // call for child element fixed
        }

    }

    public static void sortHeap(int[] arr) { // TC -> (n * logn)
        int n = arr.length;
        // step-1 build maxHeap
        for (int i = n / 2; i >= 0; i--) { // last level to root TC -> (n/2 * logn)
            heapify(arr, i, n);
        }
        // step-2 push largest at end
        for (int i = n - 1; i > 0; i--) { // n-1 to 0 (all children) TC -> (n * logn)
            // swap (largest-first with last)
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        // Heap Sort --------------------------------
        int[] arr = { 1, 2, 4, 5, 3 }; // heap
        sortHeap(arr); // sort heap functions called
        // Print results
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
