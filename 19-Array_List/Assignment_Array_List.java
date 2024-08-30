import java.util.ArrayList;

public class Assignment_Array_List {

    // Solution 1. --------------------------------
    public static boolean isMonotonic(ArrayList<Integer> A) {
        boolean inc = true;
        boolean dec = true;
        for (int i = 0; i < A.size() - 1; i++) {
            if (A.get(i) > A.get(i + 1)) {
                inc = false;
            }
            if (A.get(i) < A.get(i + 1)) {
                dec = false;
            }
        }
        return inc || dec;
    }

    public static void main(String[] args) {
        // Question 1 : Monotonic ArrayList (EASY) --------------------------------
        // An Arraylist is monotonic if it is either monotone increasing or monotone decreasing.
        // An Arraylist nums is monotone increasing if for all i <= j, nums.get(i) <= nums.get(j). 
        // An Arraylist nums is monotone decreasing if for all i <= j, nums.get(i) >= nums.get(j).
        // Given an integer Arraylist nums, return true if the given list is monotonic, or false otherwise.
        // Input 1 : nums = [1,2,2,3] Output 1 : true
        ArrayList<Integer> nums1 = new ArrayList<>();
        nums1.add(1);
        nums1.add(2);
        nums1.add(2);
        nums1.add(3);
        System.out.println(isMonotonic(nums1));
        // Input 2 : nums = [6,5,4,4] Output 2 : true
        ArrayList<Integer> nums2 = new ArrayList<>();
        nums2.add(6);
        nums2.add(5);
        nums2.add(4);
        nums2.add(4);
        System.out.println(isMonotonic(nums2));
        // Input 3 : nums = [1,3,2] Output 3 : false
        ArrayList<Integer> nums3 = new ArrayList<>();
        nums3.add(1);
        nums3.add(3);
        nums3.add(2);
        System.out.println(isMonotonic(nums3));

        // Question 2 : Lonely Numbers in ArrayList (MEDIUM) --------------------------------
        // You are given an integer arraylist num1. A number x is lonely when it appears only once, and
        // no adjacent numbers (i.e. x + 1 and x - 1) appear in the arraylist.
        // Return all lonely numbers in nums. You may return the answer in any order
        // Input 1 : nums = [10,6,5,8] Output 1 : [10,8]
        ArrayList<Integer> num1 = new ArrayList<>();
        num1.add(10);
        num1.add(6);
        num1.add(5);
        num1.add(8);

        // Input 2 : nums = [1,3,5,3] Output 2 : [1,5]
        ArrayList<Integer> num2 = new ArrayList<>();
        num2.add(1);
        num2.add(3);
        num2.add(5);
        num2.add(3);

        // Question 3 : Most Frequent Number following Key (EASY) --------------------------------
        // You are given an integer Arraylist nums. You are also given an integer key, which is present in nums.
        // For every unique integer target in nums, count the number of times target immediately follows
        // an occurrence of key in nums. In other words, count the number of indices i such that:
        // 0 <= i <= nums.size() - 2,
        // nums.get(i) == key and,
        // nums.get(i+1) == target.
        // Return the target with the maximum count.
        // (Assumption - that the target with maximum count is unique.) 
        // Hints : Count the number of times each target value follows the key in the arraylist.
        // Choose the target with the maximum count and return it.
        // Input 1 : nums = [1,100,200,1,100], key = 1; Output 1 : 100
        ArrayList<Integer> no1 = new ArrayList<>();
        no1.add(1);
        no1.add(100);
        no1.add(200);
        no1.add(1);
        no1.add(100);
        int key1 = 1;

        // Input 2 : nums = [2,2,2,2,3], key = 2; Output 2 : 2
        ArrayList<Integer> no2 = new ArrayList<>();
        no2.add(2);
        no2.add(2);
        no2.add(2);
        no2.add(2);
        no2.add(3);
        int key2 = 2;

        // Question 4 : Beautiful ArrayList (MEDIUM) --------------------------------
        // An Arraylist nums of size n is beautiful if:
        // nums is a permutation of the integers in the range [1, n].
        // For every 0 <= i < j < n, there is no index k with i < k < j where 2 * nums.get(k) == nums.get(i) + nums.get(j).
        // Given the integer n, return any beautiful arraylist nums of size n. There will be at least one valid
        // answer for the given n.
        // Input 1 : n = 4; Output 1 : [2,1,4,3]
        ArrayList<Integer> nb1 = new ArrayList<>();
        nb1.add(2);
        nb1.add(1);
        nb1.add(4);
        nb1.add(3);

        // Input 2 : n = 5; Output 2 : [3,1,2,5,4]
        ArrayList<Integer> nb2 = new ArrayList<>();
        nb2.add(3);
        nb2.add(1);
        nb2.add(2);
        nb2.add(5);
        nb2.add(4);

    }
}
