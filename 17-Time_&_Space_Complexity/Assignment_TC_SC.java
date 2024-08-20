public class Assignment_TC_SC {
    public static void main(String[] args) {
        // Question 1 : Find the Time Complexity of the following:
        // int i, j, k = 0, n;
        // for (i = n / 2; i <= n; i++) {
        //     for (j = 2; j <= n; j = j * 2) {
        //         k = k + n / 2;
        //     }
        // }
        // Option :-
        // A. O(n)
        // B. O(N log N)
        // C. O(n^2)
        // D. O(n^2Logn)
        // Answer :- B = O(n * logn)

        // Question 2 : Find the Time Complexity of the following:
        // for(int i=0;i<n;i++)
        //     i*=k
        // }
        // Option :-
        // Here, k is some constant value
        // A. O(n)
        // B. O(k)
        // C. O(logkn) (= logn of base k)
        // D. O(lognk) (= logk of base n)
        // Answer :- C = O(logkn) (= logn of base k)

        // Question 3 : Algorithm A and B have a worst-case running time of O(n) and O(logn), respectively. Therefore, algorithm B always runs faster than algorithm A.
        // Option :-
        // A. True
        // B. False
        // Answer :- B = false (The Big-O notation provides an asymptotic comparison in the running time of algorithms. For n < n0, algorithm A might run faster than algorithm B, for instance.)

        // Question 4 : Find the time & space complexity of floorSqrt function in the following code to calculate square root of a number : 
        // static int floorSqrt(int x){
        //     if (x == 0 || x == 1) return x;
        //     int i = 1, result = 1;
        //     while (result <= x) {
        //         i++;
        //         result = i * i;
        //     }
        //     return i - 1;
        // }
        // main function--
        // int x = 11;
        // System.out.print(floorSqrt(x));
        // TC -> O(sq root of x)
        // SC -> O(1)

        // Question 5 : Find the time & space complexity of the following code:
        // int a = 0;
        // for (int i = 0; i < n; ++i) {
        //     for (int j = n; j > i; --j) {
        //         a = a + i + j;
        //     }
        // }
        // TC -> O(n^2)
        // SC -> O(1)

    }
}
