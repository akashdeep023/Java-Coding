import java.util.Scanner;

public class Strings {
    public static void printLetters(String name) {
        for (int i = 0; i < name.length(); i++) {
            System.out.print(name.charAt(i) + " ");
        }
        System.out.println();
    }

    public static boolean palindrome(String str) {
        for (int i = 0; i <= str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false; // not palindrome
            }
        }
        return true;
    }

    public static float getShortestPath(String str) {
        int x = 0, y = 0;
        for (int i = 0; i < str.length(); i++) {
            int direction = str.charAt(i);
            if (direction == 'N') {
                x++;
            } else if (direction == 'S') {
                x--;
            } else if (direction == 'E') {
                y++;
            } else {
                y--;
            }
        }
        return (float) Math.sqrt(x * x + y * y);
    }

    public static String subString(String str, int si, int ei) {
        String subStr = "";
        for (int i = si; i < ei; i++) {
            subStr += str.charAt(i); // concatenate
        }
        return subStr;
    }

    public static String toUpperCase(String str) { // TC -> O(n)
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0)); // uppercase 1st latter
        sb.append(ch);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i))); // uppercase 1st latter to each word
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString(); // StringBuilder to String conversion (Work only Object)
    }

    public static String compress(String str) { // TC -> O(n + String)
        String newStr = "";
        // aabbcccd
        for (int i = 0; i < str.length(); i++) {
            Integer count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            newStr += str.charAt(i);
            if (count > 1) {
                newStr += count.toString();
            }
        }
        return newStr;
    }

    public static String compress1(String str) { // TC -> O(n)
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            Integer count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if (count > 1) {
                sb.append(count.toString());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // Use 'String class' to create a string. -----------------------------
        // char arr[]={'a','b','c','d'}; // character array
        // String str="abcd"; // String
        // String str1=new String("xyz");

        // Strings are IMMUTABLE ---

        // Input | Output --------------------------------
        Scanner sc = new Scanner(System.in);
        // String name;
        // name = sc.next();    // Single Word   
        // name = sc.nextLine(); // Word ya Sentence 
        // System.out.println(name);

        // String length (The length is a function of the String) --------------------------------
        // String fullName = "Akash deep";
        // System.out.println(fullName.length());

        // String Concatenation
        // String firstName = "Akash";
        // String lastName = "Deep";
        // String fullName = firstName + " " + lastName;
        // System.out.println(fullName);

        // String charAt Method --------------------------------
        // String name = "Akash Deep";
        // printLetters(name);

        // Check if a String is Palindrome --------------------------------
        // String str = "madam";
        // System.out.println(palindrome(str));

        // Question Shortest Path --------------------------------
        // Given a route containing 4 direction (E,W,N,S). Find the shortest path to reach destination.
        // String path = "WNEENESENNN";
        // System.out.println(getShortestPath(path));

        // String Functions-Compare --------------------------------
        // String s1 = "Tony"; // value = "Tony" & let, location = 110
        // String s2 = "Tony"; // value = "Tony" & let, location = 110 (s1 location)
        // String s3 = new String("Tony"); // value = "Tony" & let, location = 240 (different location)
        // if (s1 == s2) { // '==' compares values & location
        //     System.out.println("String are equal");
        // } else {
        //     System.out.println("String are not equal");
        // }
        // if (s1 == s3) { // '==' compares values & location
        //     System.out.println("String are equal");
        // } else {
        //     System.out.println("String are not equal");
        // }
        // if (s1.equals(s3)) { // equals function compare only values
        //     System.out.println("String are equal");
        // } else {
        //     System.out.println("String are not equal");
        // }

        // String Function-Substring --------------------------------
        // String str = "HelloWorld";
        // System.out.println(subString(str, 0, 5)); // last index excluding (0-4)
        // System.out.println(str.substring(0, 5)); // last index excluding (0-4)

        // Print Largest String (Lexicographic order -> a,b,c ... z) --------------------------------
        // str1.compareTo(str2) -> str1 == str2 => 0, str1 > str2 => +ve, str1 < str2 => -ve (a != A)
        // str1.compareToIgnoreCase(str2) -> str1 == str2 => 0, str1 > str2 => +ve, str1 < str2 => -ve (a == A)
        // String fruits[] = { "apple", "mango", "banana" };
        // String largest = fruits[0];
        // for (int i = 1; i < fruits.length; i++) { // TC -> O(n X c)  c -> compare
        //     if (largest.compareToIgnoreCase(fruits[i]) < 0) { // largest < fruits[i]               
        //         largest = fruits[i];
        //     }
        // }
        // System.out.println("Largest String = " + largest);

        // String Builder --------------------------------
        // StringBuilder sb = new StringBuilder("");
        // for (char ch = 'a'; ch <= 'z'; ch++) { // StringBuilder => TC -> O(n) n -> loop iteration , String => O(n^2) n -> iteration or string length
        //     sb.append(ch);
        // }
        // System.out.println(sb);
        // System.out.println(sb.length());

        // Convert letters to Uppercase --------------------------------
        // String str = "hi, i am akash deep";
        // System.out.println(toUpperCase(str));

        // String Compression --------------------------------
        String strc = "aaabbcccdd";
        String strc2 = "abcd";
        // String ---
        System.out.println(compress(strc));
        System.out.println(compress(strc2));

        // StringBuilder ---
        System.out.println(compress1(strc));
        System.out.println(compress1(strc2));

        sc.close();
    }
}