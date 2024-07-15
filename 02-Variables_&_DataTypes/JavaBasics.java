// Boilerplate Code --------------------------------
// public class Main {
//     public static void main(String[] args) {
//         ----------------------------------
//         ----------------------------------
//     }
// }
// Main -> Class name (Class name start with capital letter)
// main -> main function to execute our program
// String[] args or String args[] -> No difference Technically same thing

// How to run the program --------------------------------
// Save code -> ctrl + s
// Terminal
// cd path_name
// javac file_name.java -> file_name == public class name
// java file_name.java

// Output in java --------------------------------
// System.out.print("Hello, world!");   => print -> function & "Hello, world!" -> Output
// System.out.println("Hello, world!"); => println -> next line
// "\n" -> Next line

// Variable in java --------------------------------
// a = 5;  
// b = 'x';
// variable -> a,b

// Data types in java --------------------------------
// Primitive (Exists)           Non-Primitive
// 1.byte                       1.String
// 2.short                      2.Array
// 3.char                       3.class
// 4.boolean                    4.object
// 5.int                        5.Interface
// 6.long
// 7.float
// 8.double

// Size of data types --------------------------------
// byte     -> 1byte -> [-128 to 128] = 256
// short    -> 2byte -> [-32,768 to 32,767] 
// char     -> 2byte -> ['a' to 'z' , 'A' to 'Z , '@','%'...]
// boolean  -> 1byte -> [true or false]
// int      -> 4byte -> [-2B to 2B]
// long     -> 8byte -> [ int << long ]
// float    -> 4byte -> [ _._ , float == int]
// double   -> 8byte -> [float << double]

// Comments in java --------------------------------
// Hi there!        -> 1st method -> Single line (Double forword slash)
/*                  -> 2nd method -> Multiline (forword slash and star)
 Hi there !
 Hello!
 Bye
 */

//  Input in java --------------------------------
// next         -> single word
// nextLine     -> Paragraph / line
// nextInt      -> int type / sc.nextInt()
// nextByte     -> byte type / sc.nextByte()
// nextFloat    -> float type / sc.nextFloat()
// nextDouble   -> double type / sc.nextDouble()
// nextBoolean  -> boolean type / sc.nextBoolean()
// nextShort    -> short type / sc.nextShort()
// nextLong     -> long type / sc.nextLong()

// Type conversion --------------------------------
// Conversion happen when...
// 1. type compatible
// 2. destination type > source type
// byte -> short -> int -> float -> -> long -> double

// Type casting --------------------------------
// loss of data ---
// int marks = (int)(99.99f)

// Type promotion in Expression --------------------------------
// 1. Java automatically promotes each byte, short or char operand to int when evaluating an expression.
// 2. If one operand is log , float or double then whole expression is promoted to long , float or double respectively.

// How is our code running --------------------------------
// compilation -> execution
// sourceCode.java -> compiler -> byteCode.class -> java virtual machine (JVM) -> Native code



// ------------------------------------------------------------------------------------------------
import java.util.*; // Import All
// import java.util.Scanner; // Import Scanner

public class JavaBasics{
    public static void main(String[] args) {
        // Output in java --------------------------------
        // System.out.print("Hello, world!");
        // System.out.print("\n");
        // System.out.println("Hello, world!");
        // System.out.print("Hello, world! \n");

        // Variable in java --------------------------------
        // int a = 5;
        // int b = 10;
        // System.out.println(a);
        // System.out.println(b);

        // Sum of a & b --------------------------------
        // int a = 5;
        // int b = 10;
        // int sum = a + b;
        // System.out.println(sum);

        // Input in java --------------------------------
        Scanner sc = new Scanner(System.in);
        // single word ---
        // String input = sc.next();    // String type (Non-Primitive) User type => Hello World
        // System.out.println(input);   // output => Hello

        // paragraph ya line ---
        // String name = sc.nextLine(); // User type => Akash Deep
        // System.out.println(name);    // output => Akash Deep

        // int type number ---
        // int number = sc.nextInt();   // User type => 54
        // System.out.println(number);  // output => 54

        // Sum of a & b (Input by user) --------------------------------
        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // int sum = a+b;
        // System.out.println(sum);

        // Sum of a & b (Input by user) --------------------------------
        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // int product = a*b;
        // System.out.println(product);

        // Area of a circle --------------------------------
        // float r = sc.nextFloat();
        // float area = 3.14f * r * r; // 3.14 (by default double type) -> but area (float type) -> 3.14f (float type conversion)
        // System.out.println(area);

        // Type conversion --------------------------------
        // int a = 25;
        // long b = a;              // widening conversion or implicit conversion (int (4bytes) -> long (8bytes))
        // System.out.println(b);

        // long x = 20;
        // int y = x;               // Error -> lossy conversion
        
        // Type casting --------------------------------
        // float a = 25.12f;        // by default decimal number double type
        // int b = (int)a;          // Narrowing conversion or explicit conversion (float -> int)
        // System.out.println(b);

        // float x = 20.23f;
        // int y = x;               // Error -> lossy conversion

        // Type promotion in Expression --------------------------------
        // char a = 'a';
        // char b = 'b';
        // System.out.println((int)a);
        // System.out.println((int)b);
        // System.out.println(a);
        // System.out.println(b-a);

        // short a = 5;
        // byte b = 25;
        // char c = 'c';
        // // byte bt = a + b + c;  // Error can't convert int to byte
        // byte bt  = (byte)(a + b + c);
        // System.out.println(bt);

        byte x = 5;
        // x = x * 2; // Error
        x = (byte)(x * 2);
        System.out.println(x);


        sc.close(); // close Scanner
    }
}

