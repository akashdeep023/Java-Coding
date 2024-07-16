public class Operators {
    public static void main(String[] args){
        // Symbol that tell compiler to perform some operations
        // Types of Operators
        // 1. Arithmetic Operations
        // 2. Relational Operations
        // 3. Logical Operators
        // 4. Bitwise Operators
        // 5. Assignment Operators
        
        // 1. Arithmetic Operations --------------------------------
        // +,-,*,/,% (modulo)    => Binary operator (2 operands)
        // int A = 10,B = 5;
        // System.out.println(A + B);
        
        // ++,--                => Unary operator (1 operands)
        // ++a => pre increment , --a => pre decrement (Value change than value use)
        // int a = 5;
        // int b = ++a; // b = a + 1
        // System.out.println(a); // 6
        // System.out.println(b); // 6
        // int x = 5;
        // int y = --x; // y = x - 1
        // System.out.println(x); // 4
        // System.out.println(y); // 4

        // a++ => post increment, a-- => post decrement (Value use than value change)
        // int a = 5;
        // int b = a++; // b = a + 1
        // System.out.println(a); // 6
        // System.out.println(b); // 5
        // int x = 5;
        // int y = x--; // y = x - 1
        // System.out.println(x); // 4
        // System.out.println(y); // 5

        // 2. Relational Operations --------------------------------
        // ==,!=, <, >, <=, >=
        // int a = 10, b = 5;
        // System.out.println(a == b); // false
        // System.out.println(a!= b); // true
        // System.out.println(a < b); // false
        // System.out.println(a > b); // true
        // System.out.println(a <= b); // false
        // System.out.println(a >= b); // true

        // 3. Logical Operators --------------------------------
        // && (AND), || (OR),! (NOT)
        int a = 10, b = 5;
        System.out.println(a > b && a > b); // true (st1(true) && st2(ture) => true , else => false)
        System.out.println(a < b || a < b); // false (st1(false) && st2(false) => false , else => true)
        System.out.println(!(a > b)); // false (!true => false)

        // 4. Bitwise Operators --------------------------------
        // next class ---

        // 5. Assignment Operators --------------------------------
        // =, +=, -=, *=, /=, %=
        // int x = 10, y = 5;
        // x += y; // x = x + y => 10 + 5
        // System.out.println(x); // 15
        // x -= y; // x = x - y => 15 - 5
        // System.out.println(x); // 10
        // x *= y; // x = x * y => 10 * 5
        // System.out.println(x); // 50
        // x /= y; // x = x / y => 50 / 5
        // System.out.println(x); // 10
        // x %= y; // x = x % y => 10 % 5
        // System.out.println(x); // 0

    }    
}