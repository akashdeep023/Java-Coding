import java.util.Scanner;

public class Assignment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Question 1 : How many times 'Hello' is printed?
        // for (int i = 0; i < 5; i++) {
        // System.out.println("Hello");
        // i += 2;
        // }
        // ans -> 2

        // Question 2 : Write a program that reads a set of integers, and then prints
        // the sum of the even and odd integers.
        // int number;
        // int choice;
        // int evenSum = 0;
        // int oddSum = 0;
        // do {
        // System.out.print("Enter the number : ");
        // number = sc.nextInt();
        // if (number % 2 == 0) {
        // evenSum += number;
        // } else {
        // oddSum += number;
        // }
        // System.out.print("Do you want to continue? Press 1 for yes or 0 for no : ");
        // choice = sc.nextInt();
        // } while (choice == 1);
        // System.out.println("Sum of even numbers: " + evenSum);
        // System.out.println("Sum of odd numbers: " + oddSum);

        // Question 3 : Write a program to find the factorial of any number entered by
        // the user.
        // System.out.print("Enter the factorial of any positive number : ");
        // int num = sc.nextInt();
        // if (num == 0) {
        // System.out.println("Factorial of 0 is 1");
        // } else {
        // int factorial = 1;
        // for (int i = 1; i <= num; i++) {
        // factorial *= i;
        // }
        // System.out.println("Factorial of " + num + " is " + factorial);
        // }

        // Question 4 : Write a program to print the multiplication table of a number N,
        // entered by the user.
        // System.out.print("Enter the number to print multiplication table for : ");
        // int N = sc.nextInt();
        // for (int i = 1; i <= 10; i++) {
        // System.out.println(N + " * " + i + " = " + (N * i));
        // }

        // Question 5 : What is wrong in the following program?
        // for (int i = 0; i <= 5; i++) {
        // System.out.println("i = " + i);
        // }
        // System.out.println("i after the loop = " + i); // Scope of variable is
        // referred to the part of the program where the variable can be used

        sc.close(); // close scanner

    }
}
