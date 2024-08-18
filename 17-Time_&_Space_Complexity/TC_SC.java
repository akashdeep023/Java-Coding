public class TC_SC {
    public static void main(String[] args) {
        // Time & Space Complexity ---------------------------------
        // Ex:- Car -> speed, price, capacity || Operations -> time, space

        // What is time complexity. --------------------------------
        // Order complexity analysis.
        // => Amount of Space & Time taken up by an algorithm/code as function of input size.

        // Big O Notation. --------------------------------
        // Upper bound -> O(n^2) (Worst case)
        // Note:- We always try to find worst case complexity.
        // 1st ignore constants -> 2nd largest term
        // Ex:- time -> an^2 + bn + c => n^2 + n + 1 => O(n^2)

        // Big Omega & Theta Notation. --------------------------------
        // program -> Omega(n^2) (Best case)
        // program -> Theta(n^2) (Average case)

        // Common Complexity. --------------------------------
        // O(1) -> Constant time (ex: array access)
        // O(log n) -> Logarithmic time (ex: binary search)
        // O(n) -> Linear time (ex: simple for loop)
        // O(n log n) -> Loglinear time (ex: merge sort)
        // O(n^2) -> Quadratic time (ex: bubble sort)
        // O(2^n) -> Exponential time (ex: Tower of Hanoi)

        // Space Complexity. --------------------------------
        // Memory / Space -> 1. Heep (Objects, variables), 2. Stack (Functions)
        // Merge sort -> Space Complexity = O(n), Tc = O(n*logn)
        // Quick sort -> Space Complexity = O(1), TC = O(n^2) ya O(n*logn)

        // Simple loop Analysis --------------------------------
        // for (int i = 0; i < n; i++) { // TC -> O(n)
        //     do something (some constant work) TC -> O(K)
        // }

        // Nested loop 1 Analysis --------------------------------
        // for (int i = 0; i < n; i++) { // TC -> O(n^2)
        //     for (int j = 0; j < n; j++) { // n times run
        //         do something 
        //     }
        // }
        // for (int i = 0; i < n; i++) { // TC -> O(n^2)
        //     for (int j = i + 1; j < n; j++) { // n-i times run
        //         do something 
        //     }
        // }

        // Nested loop 2 Analysis --------------------------------
        // for (int i = 0; i < n; i++) { // TC -> O(n^2)
        //     for (int j = 0; j < i; j++) { // i times run
        //         do something
        //     }
        // }

        // Nested loop 3 Analysis --------------------------------
        // some k < n
        // for (int i = 0; i < n; i = i + k) { // TC -> O(n^2)
        //     for (int j = i + 1; j < k; j++) { // i times run
        //         do something
        //     }
        // }

        // Linear search Analysis --------------------------------
        // Worst case -> TC = O(n) (itterate every element)

        // Bubble sort Analysis --------------------------------
        // Worst case -> TC = O(n^2) (outer loop n time & inner loop n time)
        // Best case -> TC = O(n)

        // Binary search Analysis --------------------------------
        // Worst case -> TC = O(log n) (n/2^k = 1 => n = 2^k => k = log n)

        // Recursive Complexity Analysis --------------------------------
        // Recursive Algorithm -> 1. Linear (F(n) = work + F(n-1)), 2. Divide & Conquer (F(n) = F(n/2) + F(n/2) + work)
        // Time Complexity = Total work done = no of calls * work in each call
        // Space Complexity = Max depth * memory in each call
        // Recurrence Equation

        // Fectorial Analysis --------------------------------
        // TC = total work done => n * k => O(n)
        // SC = max depth * memory in each call => n * k => O(n) 

        // Sum or N numbers Analysis --------------------------------
        // TC = SC = O(n)

        // Fibonacci Analysis (D & C) --------------------------------
        // Recurrence Equation -> f(n) = f(n-1) + f(n-2) + k
        // TC = O(2^n)
        // SC = O(n)

        // Merge sort Analysis (D & C) --------------------------------
        // Recurrence Equation -> f(n) = f(n/2) + f(n/2) + n + k
        // TC = O(n* logn)
        // SC = O(n)

        // Power function 1 Analysis --------------------------------
        // powerFunction(int a, int n){
        //     if(n==0){
        //         return 1;
        //     }
        //     return a * powerFunction(a,n-1);
        // }
        // TC = O(n) -> Work done = number of calls * time in each call => n * k => n
        // SC = O(n) -> Max depth(stack calls) * memory in each call => n * 1 => n

        // Power function 2 Analysis --------------------------------
        // powerFunction2(int a, int n){
        //     if(n==0){
        //         return 1;
        //     }
        //     int halfPowerSq =  powerFunction2(a,n/2) * powerFunction2(a,n/2);
        //     if(n%2!= 0){
        //         return a * halfPowerSq;
        //     }
        //     return halfPowerSq;
        // }
        // TC = O(n) -> two times recursion call inside a function
        // SC = O(n)

        // Power function 3 Analysis --------------------------------
        // powerFunction3(int a, int n){
        //     if(n==0){
        //         return 1;
        //     }
        //     int halfPower =  powerFunction3(a,n/2);
        //     int halfPowerSq = halfPower * halfPower;        
        //     if(n%2!= 0){
        //         return a * halfPowerSq;
        //     }
        //     return halfPowerSq;
        // }
        // TC = O(logn) -> only one time recursion call inside a function  
        // SC = O(logn) -> total stack calls * memory in each call  => logn * k => logn
    }
}