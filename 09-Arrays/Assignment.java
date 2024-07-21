public class Assignment {
    public static void main(String[] args) {
        // Question 1: Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
        // int nums1[] = { 1, 2, 3, 1 }; // true
        // System.out.println(twiceValue(nums1));

        // int nums2[] = { 1, 2, 3, 4 }; // false
        // System.out.println(twiceValue(nums2));

        // int nums3[] = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }; // true
        // System.out.println(twiceValue(nums3));

        // Question 2: There is an integer array nums sorted in ascending order (with distinct values). Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
        // Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums. You must write an algorithm with O(log n) runtime complexity.
        // int numb[] = { 4, 5, 6, 7, 0, 1, 2 };
        // int target = 0; // 4
        // System.out.println(search(numb, target));

        // int target2 = 3; // -1
        // System.out.println(search(numb, target2));

        // int numb2[] = { 1 };
        // int target3 = 0; // -1
        // System.out.println(search(numb2, target3));

        // Question 3: You are given an array prices where prices[i] is the price of a given stock on the i th day. Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
        // int numk[] = { 7, 1, 5, 3, 6, 4 }; // 5
        // System.out.println(maxProfit(numk));

        // int numk2[] = { 7, 6, 4, 3, 1 }; // 0
        // System.out.println(maxProfit(numk2));

        // Question 4: Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
        int numh[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }; // 6
        System.out.println(trapWater(numh));
        System.out.println("trap : " + trap(numh));

        int numh2[] = { 4, 2, 0, 3, 2, 5 }; // 9
        System.out.println(trapWater(numh2));
        System.out.println("trap : " + trap(numh2));

        // Question 5: Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0. Notice that the solution set must not contain duplicate triplets.
        // int numc[] = { -1, 0, 1, 2, -1, -4 }; // [ [-1, -1, 2] , [-1, 0, 1] ]
        // printTriplets(numc);

        // int numc2[] = {}; // []
        // printTriplets(numc2);

        // int numc3[] = { 0 }; // []
        // printTriplets(numc3);

        // Solution 5. => Next chapter
    }

    // function ----------------------------------------------------------------
    // Solution 1 ---
    public static boolean twiceValue(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // Solution 2 ---
    public static int search(int arr[], int target) {
        int min = minSearch(arr);
        if (arr[min] <= target && arr[arr.length - 1] >= target) {
            return search(arr, min, arr.length - 1, target); // range (min to arr.length - 1)
        } else {
            return search(arr, 0, min, target); // range (0 to min)
        }
    }

    public static int minSearch(int arr[]) { // find minmum value of array and return index
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mid > 0 && arr[mid - 1] > arr[mid]) {
                return mid;
            } else if (arr[mid] >= arr[left] && arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static int search(int arr[], int start, int end, int target) { // binary search and return index
        int l = start, r = end;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    // Solution 3 ---
    public static int maxProfit(int arr[]) {
        int maxProfit = 0;
        int buy = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (buy < arr[i]) {
                int profit = arr[i] - buy;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buy = arr[i];
            }
        }
        return maxProfit;
    }

    public static int trapWater(int arr[]) {
        int trapWater = 0;
        int leftMax[] = new int[arr.length];
        leftMax[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            leftMax[i] = Math.max(arr[i], leftMax[i - 1]);
        }
        int rightMax[] = new int[arr.length];
        rightMax[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(arr[i], rightMax[i + 1]);
        }
        for (int i = 0; i < arr.length; i++) {
            int wl = Math.min(leftMax[i], rightMax[i]);
            trapWater += wl - arr[i];
        }

        return trapWater;
    }

    // Maam Code ---
    public static int trap(int[] height) {
        int n = height.length;
        int res = 0, l = 0, r = n - 1;
        int rMax = height[r], lMax = height[l];
        while (l < r) {
            if (lMax < rMax) {
                l++;
                lMax = Math.max(lMax, height[l]);
                res += lMax - height[l];
            } else {
                r--;
                rMax = Math.max(rMax, height[r]);
                res += rMax - height[r];
            }
        }
        return res;
    }
}
