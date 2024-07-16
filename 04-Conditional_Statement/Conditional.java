import java.util.Scanner;

public class Conditional {
    public static void main(String[] args) {
        // if,else,elseif,ternary operator,switch
        // if-else statements -----------------------------------
        // if (condition) {
        // do something -> condition = true
        // }else{
        // do something -> condition = false
        // }

        // int age = 22;
        // if (age > 18) { // 22 > 18 -> true
        // System.out.println("Vote, Drive");
        // } else {
        // System.out.println("Not Adult");
        // }

        // Print the largest of 2 numbers
        // int A = 1, B = 3;
        // if (A >= B) {
        // System.out.println(A);
        // } else {
        // System.out.println(B);
        // }

        // Print if number is odd or even number
        // int num = 5;
        // if (num % 2 == 0) {
        // System.out.println(num + " is Even");
        // } else {
        // System.out.println(num + " is Odd");
        // }

        // else if statement --------------------------------
        // if (condition) {
        // do something -> condition = true
        // } else if(condition2) {
        // do something -> condition2 = true
        // }else{
        // do something -> condition or condition2 = false
        // }

        // Income Tax calculator
        // Scanner sc = new Scanner(System.in);
        // int income = sc.nextInt();
        // int tax = 0;
        // if (income < 500000) {
        // tax = 0;
        // } else if (income > 500000 && income < 1000000) {
        // tax = (int) (income * 0.2f);
        // } else {
        // tax = (int) (income * 0.3f);
        // }
        // System.out.println("Your tax : " + tax);
        // sc.close(); // Close Scanner

        // Print the largest of 3 numbers
        // int a = 1, b = 3, c = 6;
        // if (a >= b && a >= c) {
        // System.out.println(a);
        // } else if (b >= c) {
        // System.out.println(b);
        // } else {
        // System.out.println(c);
        // }

        // Ternary operator --------------------------------
        // int a = 10, b = 20;
        // int max = (a > b) ? a : b; // a > b => true -> a => false -> b
        // System.out.println("The largest number is: " + max);

        // Check if a student will pass or fail
        // int marks = 55;
        // String states = (marks >= 33) ? "pass" : "fail";
        // System.out.println(states);

        // switch statement --------------------------------
        // int number = 2;
        // switch (number) {
        // case 1:
        // System.out.println("Samosa");
        // break;
        // case 2:
        // System.out.println("Burger");
        // break;
        // case 3:
        // System.out.println("Mango shake");
        // break;

        // default:
        // System.out.println("We wake up");
        // break;
        // }

        // Calculate
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a : ");
        int a = sc.nextInt();
        System.out.print("Enter b : ");
        int b = sc.nextInt();
        System.out.print("Enter operator : ");
        char operator = sc.next().charAt(0);
        switch (operator) {
            case '+':
                System.out.println(a + b);
                break;
            case '-':
                System.out.println(a - b);
                break;
            case '*':
                System.out.println(a * b);
                break;
            case '/':
                System.out.println(a / b);
                break;
            case '%':
                System.out.println(a % b);
                break;
            default:
                System.out.println("Wrong operator " + operator);
                break;
        }
        sc.close(); // Close the scanner

    }
}