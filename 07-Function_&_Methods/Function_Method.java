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

    // function overloading using no of parameters
    public static int sum(int a, int b) {
        return a + b;
    }

    public static int sum(int a, int b, int c) {
        return a + b + c;
    }

    // function overloading using data type of parameters
    public static int product(int a, int b) {
        return a * b;
    }

    public static float product(float a, float b) {
        return a * b;
    }

    public static boolean isPrime(int n) {
        if (n == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) { // loop run -> n-1 times, optimized -> Math.sqrt(n) times
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void primesIsRange(int n) {
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void binToDec(int binNum) {
        int myNum = binNum;
        int pow = 0;
        int decNum = 0;
        while (binNum > 0) {
            int lastDigit = binNum % 10;
            decNum = decNum + (lastDigit * (int) Math.pow(2, pow));
            pow++;
            binNum = binNum / 10;
        }
        System.out.println("Binary to Decimal " + myNum + " = " + decNum);
    }

    public static void decToBin(int decNum) {
        int myNum = decNum;
        int pow = 0;
        int binNum = 0;
        while (decNum > 0) {
            int rem = decNum % 2;
            binNum = binNum + (rem * (int) Math.pow(10, pow));
            pow++;
            decNum = decNum / 2;
        }
        System.out.println("Decimal to Binary " + myNum + " = " + binNum);

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
        // System.out.print("Enter number of n : ");
        // int n = sc.nextInt();
        // System.out.print("Enter number of r : ");
        // int r = sc.nextInt();
        // System.out.println("Binomial coefficients : " + binCoefficient(n, r));

        // Inbuilt v/s user defined Methods --------------------------------
        // user defined functions / methods -> sum(), product(), factorial()
        // inbuilt methods -> sc.nextInt(), Math.sqrt(), Math.power(), Math.max() etc.

        // Function Overloading --------------------------------
        // Multiple function with the same name but 'different parameters'. (no of parameter, data type of parameter)

        // Function Overloading  using no of parameters --------------------------------
        // int a = 2, b = 3, c = 4;
        // System.out.println(sum(a, b));
        // System.out.println(sum(a, b, c));

        // Function Overloading  using data type of parameter --------------------------------
        // int x = 3, y = 5;
        // System.out.println(product(x, y));
        // float p = 3.4f, q = 5.2f;
        // System.out.println(product(p, q));

        // Check if a number is Prime or Not --------------------------------
        // System.out.println(isPrime(3));
        // System.out.println(isPrime(12));

        // Prime in range --------------------------------
        // System.out.print("Enter positive number : ");
        // int n = sc.nextInt();
        // primesIsRange(n);

        // Binary to Decimal --------------------------------
        // Binary number system -> 2 digits (0,1)
        // Decimal number system -> 10 digits (0,1,2,3,4,5,6,7,8,9)

        // Convert from Binary to Decimal n = 101 
        binToDec(101);

        // Decimal to Binary --------------------------------
        // Convert from Binary to Decimal n = 7 
        decToBin(7);

        // Method scope --------------------------------
        // define a variable in function -> access only this function && access after defined, not access before defined
        // Example :-
        // System.out.println(num); // not access before defined
        int num = 10;
        System.out.println(num); // access after defined

        // Block scope --------------------------------
        // {
        //     body -> access only this block { } 
        // }
        // Example :-
        // for (int i = 0; i < args.length; i++) {
        //    i -> access only this for loop, not outside loop
        // }

        sc.close(); // close the scanner
    }
}