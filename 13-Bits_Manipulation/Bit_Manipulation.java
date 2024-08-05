public class Bit_Manipulation {
    public static void oddOrEven(int n) {
        int bitMask = 1;
        if ((n & bitMask) == 0) {
            // even number
            System.out.println(n + " is Even Number");
        } else {
            // odd number
            System.out.println(n + " is Odd Number");
        }
    }

    public static int getIthBit(int n, int i) { // Ex-> n = 10, i = 2
        int bitMast = 1 << i; // 00000100(bi)
        return n & bitMast; // 1010 & 100 => 000(bi) => 0(dec)
    }

    public static int setIthBit(int n, int i) { // Ex-> n = 10, i = 2
        int bitMast = 1 << i; // 00000100(bi)
        return n | bitMast; // 1010 | 100 => 1110(bi) => 14(dec)
    }

    public static int clearIthBit(int n, int i) { // Ex-> n = 10, i = 2
        int bitMast = ~(1 << i); // 00000100(bi) => 11111011(bi)
        return n & bitMast; // 000001010 & 11111011 => 1010(bi) => 10(dec)
    }

    public static int updateIthBit(int n, int i, int newBit) { // Ex-> n = 10, i = 2, newBit  = 1
        // 1st method ---
        // if (newBit == 0) { 
        //     return clearIthBit(n, i); // 10(dec)
        // }
        // else{
        //     return setIthBit(n, i); // 14(dec)
        // }

        // 2nd method --- Ex-> n = 10, i = 2
        n = clearIthBit(n, i); // 10
        int bitMask = newBit << i; // 100
        return n | bitMask; // 1010 | 100 => 1110(bi) => 14(dec)
    }

    public static int clearLastIBit(int n, int i) { // Ex-> n = 10, i = 2
        int bitMast = ((~0) << i); // 11111100
        return n & bitMast; // 1010 & 11111100 => 1000(bi) => 8(dec)
    }

    public static int clearRangeOfBit(int n, int i, int j) { // Ex-> n = 10, i = 2, j = 4
        int a = (~0 << (j + 1)); // 11111111 << 5 => 11100000
        // int b = ~(~0 << i); // ~(11111111 << 2) => ~(11111100) => 00000011
        int b = (1 << i) - 1; // (00000001 << 2)(bi) - 1(dec) => 00000100(bi) - 1(dec) => 00000011(bi)
        int bitMast = a | b; // (11100000 | 0000011) => 11100011
        return n & bitMast; // 1010 & 11100011 => 010(bi) => 2(dec)
    }

    public static boolean powerOfTwo(int n) { // Ex-> n = 16 => 2^4 => true
        return (n & (n - 1)) == 0; // 10000 & 01111 == 0 => 00000(bi) == 0 => 0(dec) == 0 => true
    }

    public static int countSetBits(int n) { // TC -> O(log n)
        int count = 0;
        while (n != 0) {
            count += n & 1; // 1010 & 0001 => 0000 => 0(dec)  Check our LSB
            n = n >> 1; // 1010 >> 1 => n = 101(bi) (n>>=1) 
        }
        return count;
    }

    public static int fastExpo(int number, int power) { // TC -> O(log n)  EX-> 5^3 = 125
        int ans = 1;
        while (power > 0) { // 1st -> 3(dec) > 0 => true, 2nd -> 1(dec) > 0 => true, 3rd -> 0(dec) > 0 => false
            if ((power & 1) != 0) {
                ans = ans * number; // 1st -> ans = 1 * 5 = 5, 2nd -> ans = 5 * 25 = > 125
            }
            number = number * number; // 1st -> number = 5 * 5 = 25, 2nd -> number = 25 * 25 = 625
            power = power >> 1; // 1st -> power = 011 >> 1 => 001, 2nd -> power = 001 >> 1 => 000
        }
        return ans;
    }

    public static void main(String[] args) {
        // Introduction to Bit Manipulation --------------------------------
        // Binary Number System -> 0 & 1 (2 digit) Ex-> 111,1010110,1101
        // Decimal Number System -> 0,1,2,3,4,5,6,7,8,9 (10 digits) Ex-> 1,32,68,100

        // Binary Number System (0 & 1) --------------------------------
        // Decimal to Binary (4)  |  Binary to Decimal (100)
        // => 2|4| 0              |  => 1 x 2^2 + 0 x 2^1 + 0 x 2^0
        // => 2|2| 0              |  => 4 + 0 + 0
        // =>  |1|                |  => 4
        // => 100

        // Bit wise Operations --------------------------------
        // Binary And -> &
        // Binary Or -> |
        // Binary Xor -> ^
        // Binary One's complement -> ~
        // Binary Left Shift -> <<
        // Binary Right Shift -> >>

        // Binary And (&) --------------------------------
        // 1 & 1 => 1, Otherwise 0. 
        System.out.println("5 & 6 : " + (5 & 6)); // 101 & 110 => 100(bi) => 4(dec)

        // Binary Or (|) --------------------------------
        // 0 | 0 => 0, Otherwise 1.
        System.out.println("5 | 6 : " + (5 | 6)); // 101 & 110 => 111(bi) => 7(dec)

        // Binary Xor (^) --------------------------------
        // same bit (0 ya 1) => 0, Otherwise 1.
        System.out.println("5 ^ 6 : " + (5 ^ 6)); // 101 & 110 => 011(bi) => 3(dec)

        // Binary One's complement (~) (Not operator) --------------------------------
        // ~0 => 1, ~1 => 0
        System.out.println("~5 : " + (~5)); // ~101 => 010(bi) => 2(dec) wrong
        // 1st bit (Most significant bit -> value +ve ya -ve), 
        // last bit (Least significant bit)
        // ~5 => 00000101(bi) 
        // => 11111010(bi) -> 1's comp 
        // => 00000101(bi) -> 1's comp 
        // => 00000110(bi) -> +1 add  
        // => 6(dec)       -> 2's comp
        // => -6(dec) right

        // Binary Left Shift (<<)  --------------------------------
        // shift 'x' bits left to right --- formula  (a<<b => a x b^2)
        System.out.println("5 << 2 : " + (5 << 2)); // 5<<2 => 000101 => 010100(bi) => 20(dec), 5 x 2^2 => 20

        // Binary Right Shift (>>)  --------------------------------
        // shift 'x' bits left to right --- formula (a<<b => a / 2^b)
        System.out.println("6 >> 1 : " + (6 >> 1)); // 6>>1 => 000101 => 000011(bi) => 3(dec), 6 / 2^1 => 3
        System.out.println("5 >> 2 : " + (5 >> 2)); // 5>>2 => 000101 => 000001(bi) => 1(dec), 5 / 2^2 => 1

        // Question - Check if Odd or Even --------------------------------
        // LSB (Least significant bit) = 0 (Even number), 1 (Odd number) ---
        oddOrEven(3);
        oddOrEven(11);
        oddOrEven(14);

        // Get ith Bit --------------------------------
        System.out.println("getIthBit : " + getIthBit(10, 2));

        // Set ith Bit (ith bit = 1) --------------------------------
        System.out.println("setIthBit : " + setIthBit(10, 2));

        // Clear ith Bit (ith bit = 0)--------------------------------
        System.out.println("clearIthBit : " + clearIthBit(10, 2));

        // Update ith Bit --------------------------------
        System.out.println("updateIthBit : " + updateIthBit(10, 2, 1));

        // Clear Last i Bit --------------------------------
        System.out.println("clearLastIBit : " + clearLastIBit(10, 2));

        // Clear Range of Bit --------------------------------
        System.out.println("clearRangeOfBit : " + clearRangeOfBit(10, 2, 4));

        // Check if a number is a Power of two or Not --------------------------------
        System.out.println("powerOfTwo : " + powerOfTwo(16));

        // Count set Bits in a Number --------------------------------
        System.out.println("countSetBits : " + countSetBits(10));

        // Fast Exponentiation (Fast calculate power or a num) --------------------------------
        System.out.println("fastExpo : " + fastExpo(3, 5));
        System.out.println("fastExpo : " + fastExpo(5, 3));
    }
}