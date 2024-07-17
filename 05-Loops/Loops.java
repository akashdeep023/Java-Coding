import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Loop -> Repeat --------------------------------
        // 1. while loop
        // 2. for loop
        // 3. do-while loop

        // while loop -----------------------------------
        // while (condition) {
        // do something -> condition = true
        // }

        // int i = 0;
        // while (i < 10) {
        // System.out.println(i);
        // i++;
        // }

        // Print number from 1 to n.
        // System.out.print("Enter number : ");
        // int n = sc.nextInt();
        // int i = 1;
        // while (i <= n) {
        // System.out.println(i);
        // i++;
        // }

        // Print sum of first n natural numbers
        // System.out.print("Enter number : ");
        // int n = sc.nextInt();
        // int counter = 1;
        // int sum = 0;
        // while (counter <= n) {
        // sum += counter;
        // counter++;
        // }
        // System.out.println("Sum of 1 to " + n + " numbers : " + sum);

        // for loop -----------------------------------
        // for (initialization; condition; updation) {
        // do something -> condition = true
        // }

        // for (int i = 0; i < 10; i++) {
        // System.out.println(i);
        // }

        // Print square pattern
        // for (int i = 0; i < 4; i++) {
        // System.out.println("* * * *");
        // }

        // Print reverse of a number
        // int n = 10899;
        // while (n > 0) {
        // int digit = n % 10;
        // System.out.print(digit);
        // n /= 10; // n = n / 10
        // }

        // Reverse the given number
        // int n = 10899;
        // int reverse = 0;
        // while (n > 0) {
        // int digit = n % 10;
        // reverse = reverse * 10 + digit;
        // n /= 10; // n = n / 10
        // }
        // System.out.println(reverse);

        // do-while loop --------------------------------
        // do{
        // do something -> condition = true (1st iteration allways run)
        // }
        // while (condition)

        // int i = 0;
        // do {
        // System.out.println("Hello world!");
        // i++;
        // } while (i < 10);

        // break statement --------------------------------
        // break -> to exit the loop
        // for (int i = 1; i < 5; i++) {
        // if (i == 3) {
        // break;
        // }
        // System.out.println(i);
        // }
        // System.out.println("I am out of loop");

        // Keep entering numbers until user enters a multiple of 10.
        // while (true) {
        // System.out.print("Enter number : ");
        // int n = sc.nextInt();
        // if (n % 10 == 0) {
        // break;
        // }
        // }

        // continue statement --------------------------------
        // continue -> to skip an iteration
        // for (int i = 1; i <= 5; i++) {
        // if (i == 3) {
        // continue;
        // }
        // System.out.println(i);
        // }

        // Display all numbers entered by user except multiples of 10.
        // do {
        // System.out.print("Enter number : ");
        // int n = sc.nextInt();
        // if (n % 10 == 0) {
        // continue;
        // }
        // System.out.println(n);
        // } while (true);

        // Check if a number is prime or not.
        System.out.print("Enter a number : ");
        int n = sc.nextInt();
        if (n == 2) {
            System.out.println(n + " is prime");
        } else {
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(n); i++) { // loop run -> n-1 ya sqrt(n)
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(n + " is prime");
            } else {
                System.out.println(n + " is not prime");
            }
        }

        sc.close(); // Close scanner
    }

}