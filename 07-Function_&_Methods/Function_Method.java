import java.util.Scanner;

public class Function_Method {

    public static void printHelloWorld() {
        System.out.println("Hello World!");
        return; // return empty value (returnType -> void)
    }

    public static int calculateSum(int a, int b) { // this a and b => parameters 
        int sum = a + b;
        return sum; // return integer value (returnType -> int)
    }

    public static int changeA(int a) {
        a = 10;
        System.out.println("changeA function : " + a);
        return a;
    }

    public static int multiply(int a, int b) {
        return a * b; // directly multiply a and b and return
    }

    public static int factorial(int n) {
        int factorial = 1;
        if (n == 0) {
            return factorial;
        } else {
            while (n > 0) {
                factorial = factorial * n;
                n--;
            }
        }
        return factorial;
    }

    public static int binCoefficient(int n, int r) {
        int fact_n = factorial(n);
        int fact_r = factorial(r);
        int fact_n_minus_r = factorial(n - r);
        int bin_coefficient = fact_n / (fact_r * fact_n_minus_r);
        return bin_coefficient;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Introduction to function --------------------------------
        // public static -> access modifier
        // function -> block of code / reusable

        // Syntax - function code --------------------------------
        // returnType name () {     // return type -> void (empty) , name -> functionName (printHelloWorld) 
        //     body
        //     return;              // statement 
        // }

        // printHelloWorld(); // call printHelloWorld function

        // Syntax with Parameters (input) --------------------------------
        // returnType name ( type param1, type param2){ // return type -> int , boolean , name -> functionName (calculateSum) 
        //     body
        //     return;              // statement with type value
        // }

        // System.out.println("Enter two numbers.");
        // System.out.print("Enter a : ");
        // int a = sc.nextInt();
        // System.out.print("Enter b : ");
        // int b = sc.nextInt();
        // int result = calculateSum(a, b); // call calculateSum function
        // System.out.println("Sum : " + result);

        // Parameter v/s Argument --------------------------------
        // Parameter or Formal parameters -> definition time
        // Arguments or Actual parameters -> call time
        // calculateSum(a, b) -> a and b => arguments

        // What happens in Memory --------------------------------
        // 1st run main function -> create variable (a , b) in memory (1st stack)
        // 2nd call calculateSum(a, b) -> create variable (sum) in memory (2nd stack)
        // 3rd return -> remove variable (sum) in memory (2rd stack)
        // 4th print result -> remove variable (a , b) in memory (1st stack)

        // Call by value --------------------------------
        // Java -> call by value (copy value)
        // C++ -> call by reference (original value)

        // Example :-
        // int a = 5;
        // System.out.println("return value : " + changeA(a)); // passing copy value
        // changeA(a);
        // System.out.println("main function : " + a); // original value not changed

        // Product of a & b --------------------------------
        // int product = multiply(3, 5);
        // System.out.println(product);

        // Find Factorial --------------------------------
        // System.out.print("Enter number : ");
        // int n = sc.nextInt();
        // System.out.println("Factorial : " + factorial(n));

        // Binomial coefficients --------------------------------
        System.out.print("Enter number of n : ");
        int n = sc.nextInt();
        System.out.print("Enter number of r : ");
        int r = sc.nextInt();
        System.out.println("Binomial coefficients : " + binCoefficient(n, r));

        sc.close(); // close the scanner
    }
}