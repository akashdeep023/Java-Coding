import java.util.Arrays;
import java.util.Scanner;

public class Assignment_Strings {
    public static int vowelsOccured(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }

        return count;
    }

    public static void isAnagram(String str1, String str2) {
        //Convert Strings to lowercase. Why? so that we don't have to check
        // separately for lower & uppercase.
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        // First check - if the lengths are the same
        if (str1.length() == str2.length()) {
            // convert strings into char array
            char[] str1charArray = str1.toCharArray();
            char[] str2charArray = str2.toCharArray();
            // sort the char array
            Arrays.sort(str1charArray);
            Arrays.sort(str2charArray);
            // if the sorted char arrays are same or identical then the strings are anagram
            boolean result = Arrays.equals(str1charArray, str2charArray);
            if (result) {
                System.out.println(str1 + " and " + str2 + " are anagrams of each other.");
            } else {
                System.out.println(str1 + " and " + str2 + " are not anagrams of each other.");
            }
        } else {
            // case when lengths are not equal
            System.out.println(str1 + " and " + str2 + " are not anagrams of each other.");
        }
    };

    public static void main(String[] args) {
        // Question 1 : Count how many times lowercase vowels occurred in a String entered by the user.
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter sentence : ");
        // String sent = sc.nextLine();
        // System.out.println(vowelsOccured(sent) + " times vowel occurrences.");
        // sc.close();

        // Question 2 : What will be the output of the following code?
        // String str = "ShradhaDidi";
        // String str1 = "ApnaCollege";
        // String str2 = "ShradhaDidi";
        // System.out.println(str.equals(str1) + " " + str.equals(str2)); // Output -> false true

        // Question 3 : What will be the output of the following code?
        // String strc = "ApnaCollege".replace("l", "");
        // System.out.println(strc); // Output -> ApnaCoege

        // Question 4 : Determine if 2 Strings are anagrams of each other.
        // What are anagrams? -> If two strings contain the same characters but in a different order, they can be said to be anagrams. Consider race and care. 
        // In this case, race's characters can be formed into a study, or care's characters can be formed into race. Below is a java program to check if two strings are anagrams or not.
        String stra = "race";
        String stra2 = "care";
        isAnagram(stra, stra2);

        // Question 5 : Search and read about
        // a. intern( ) method in String
        // b. StringBuffer

    }
}
