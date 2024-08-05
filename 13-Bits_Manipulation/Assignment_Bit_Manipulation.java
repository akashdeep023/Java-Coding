public class Assignment_Bit_Manipulation {
    public static void main(String[] args) {
        // Question 1 : What is the value of x^x for any value of x?
        int x = 4;
        System.out.println(x ^ x); // 010 ^ 010 => 000(bi) => 0(dec)

        // Question 2 : Swap two numbers without using any third variable.
        int n = 5, m = 3; // 0100, 0011
        System.out.println("n = " + n + " m = " + m);
        n = n ^ m; // 0100 ^ 0011 => 0111
        m = n ^ m; // 0111 ^ 0011 => 0100
        n = n ^ m; // 0111 ^ 0100 => 0011
        System.out.println("n = " + n + " m = " + m);

        // Question 3 : Add 1 to an integer using Bit Manipulation.
        // (Hint : try using Bitwise NOT Operator)
        int k = 6;
        System.out.println(k + " + " + 1 + " is " + -~k);
        k = -4;
        System.out.println(k + " + " + 1 + " is " + -~k);
        k = 0;
        System.out.println(k + " + " + 1 + " is " + -~k);

        // Question 4 : This question is based on a trick, please directly look at the solution. Convert uppercase characters to lowercase using bits.
        // Convert uppercase character to lowercase
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.print((char) (ch | ' ') + " ");
            // prints abcdefghijklmnopqrstuvwxyz
        }

        System.out.println(' ' | 1); // 10000 | 00001 => 10001(bi) => 33(dec)

        // Question 5 : A Good read of hacks using bits (you can check this out in your free time) :
        // http://graphics.stanford.edu/~seander/bithacks.html
    }
}
