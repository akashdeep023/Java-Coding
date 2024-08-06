import java.util.Scanner;

public class Assignment_Conditional {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Question 1 : Write a Java program to get a number from the user and print
        // whether it is positive or negative.
        // System.out.print("Enter a number : ");
        // int n = sc.nextInt();
        // if (n >= 0) {
        // System.out.println("Number is positive");
        // } else {
        // System.out.println("Number is negative");
        // }

        // Question 2 : Finish the following code so that it prints You have a fever if
        // your temperature is above 100 and otherwise prints You don't have a fever.
        // double temp = 103.5;
        // if (temp > 100) {
        // System.out.println("You have a fever");
        // } else {
        // System.out.println("You don't have a fever");
        // }

        // Question 3 : Write a Java program to input week number(1-7) and print day of
        // week name using switch case.
        // System.out.println("Enter a week number 1 to 7");
        // int day = sc.nextInt();
        // switch (day) {
        // case 1:
        // System.out.println("Monday");
        // break;
        // case 2:
        // System.out.println("Tuesday");
        // break;
        // case 3:
        // System.out.println("Wednesday");
        // break;
        // case 4:
        // System.out.println("Thursday");
        // break;
        // case 5:
        // System.out.println("Friday");
        // break;
        // case 6:
        // System.out.println("Saturday");
        // break;
        // case 7:
        // System.out.println("Sunday");
        // break;
        // default:
        // System.out.println("Invalid input! Please enter week number between 1 to 7");
        // break;
        // }

        // Question 4 : What will be the value of x & y in the following program:
        // int a = 63, b = 36;
        // boolean x = (a < b) ? true : false;
        // int y = (a > b) ? a : b;
        // System.out.println(x + " , " + y); // false , 63

        // Question 5 : Write a Java program that takes a year from the user and print
        // whether that year is a leap year or not.
        // 1nd Method
        System.out.print("Enter year : ");
        int year = sc.nextInt();
        if (year % 4 == 0) {
            if (year % 100 != 0) {
                System.out.println("A leap year");
            } else if (year % 400 == 0) {
                System.out.println("A leap year");
            } else {
                System.out.println("Not a leap year");
            }
        } else {
            System.out.println("Not a leap year");
        }

        // 2nd Method
        boolean x = (year % 4) == 0;
        boolean y = (year % 100) != 0;
        boolean z = ((year % 100 == 0) && (year % 400 == 0));
        if (x && (y || z)) {
            System.out.println(year + " is a leap year");
        } else {
            System.out.println(year + " is not a leap year");
        }

        sc.close(); // close scanner
    }
}
