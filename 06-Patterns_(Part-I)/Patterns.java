public class Patterns {
    public static void main(String[] args) {
        // Intro to Nested Loops (Star pattern) --------------------------------
        // int n = 4;
        // for (int i = 1; i <= n; i++) { // outer loop -> n times
        // for (int j = 1; j <= i; j++) { // inner loop -> i times
        // System.out.print("* ");
        // }
        // System.out.println();
        // }

        // Inverted Star pattern --------------------------------
        // int n = 4;
        // for (int i = 1; i <= n; i++) { // outer loop -> n times
        // for (int j = 1; j <= n - i + 1; j++) { // inner loop -> i times
        // System.out.print("* ");
        // }
        // System.out.println();
        // }

        // Half pyramid pattern --------------------------------
        // int n = 4;
        // for (int i = 1; i <= n; i++) {
        // for (int j = 1; j <= i; j++) {
        // System.out.print(j + " ");
        // }
        // System.err.println();
        // }

        // Character pattern --------------------------------
        int n = 4;
        char ch = 'A';
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(ch + " ");
                ch++;
            }
            System.out.println();
        }

    }
}