import java.util.Scanner;

public class Assignment {
    public static double average(double x, double y, double z) {
        return (x + y + z) / 3;
    }

    public static boolean isEven(int x) {
        return x % 2 == 0;
    }

    public static boolean isPalindrome(int num) {
        int palindrome = num;
        int reverse = 0;
        while (palindrome != 0) {
            int digit = palindrome % 10;
            reverse = reverse * 10 + digit;
            palindrome /= 10;
        }
        if (reverse == num) {
            return true;
        } else {
            return false;
        }

    }

    public static int sumDigits(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit;
            num = num / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Question 1 : Write a Java method to compute the average of three numbers..
        // System.out.print("Input the first number: ");
        // double x = sc.nextDouble();
        // System.out.print("Input the second number: ");
        // double y = sc.nextDouble();
        // System.out.print("Input the third number: ");
        // double z = sc.nextDouble();
        // System.out.print("The average value is " + average(x, y, z) + "\n");

        // Question 2 : Write a method named isEven that accepts an int argument. The
        // method should return true if the argument is even, or false otherwise. Also
        // write a program to test your method.
        // System.out.print("Enter a number: ");
        // int num = sc.nextInt();
        // System.out.println("Is the number even? : " + isEven(num));

        // Question 3 : Write a Java program to check if a number is a palindrome in
        // Java? ( 121 is a palindrome, 321 is not)
        // System.out.print("Enter a number : ");
        // int num = sc.nextInt();
        // boolean isPalindrome = isPalindrome(num);
        // if (isPalindrome) {
        //     System.out.println("Number " + num + " is a palindrome");
        // } else {
        //     System.out.println("Number " + num + " is not a palindrome");
        // }

        // Question 4 : READ & CODE EXERCISE
        // Search about(Google) & use the following methods of the Math class in Java:
        // a. Math.min( )
        // b. Math.max( )
        // c. Math.sqrt( )
        // d. Math.pow( )
        // e. Math.avg( )
        // f. Math.abs( )
        // Free reading resource (https://www.javatpoint.com/java-math)
        // double x = 28;
        // double y = 4;
        // System.out.println("Minmum number of x and y is: " + Math.min(x, y)); //
        // return the minmum of two numbers
        // System.out.println("Maximum number of x and y is: " + Math.max(x, y)); //
        // return the maximum of two numbers
        // System.out.println("Square root of y is: " + Math.sqrt(y)); // return the
        // square root of y
        // System.out.println("Power of x and y is: " + Math.pow(x, y)); //returns 28
        // power of 4 i.e. 28*28*28*28

        // Question 5 : Write a Java method to compute the sum of the digits in an
        // integer
        System.out.print("Enter number : ");
        int number = sc.nextInt();
        System.out.println("Sum of the digits : " + sumDigits(number));

        sc.close();
    }
}
