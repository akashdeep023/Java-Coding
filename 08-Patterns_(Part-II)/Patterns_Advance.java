public class Patterns_Advance {
    public static void hollow_rectangle(int totRows, int totCols) {
        // outer loop
        for (int i = 1; i <= totRows; i++) {
            // inner loop
            for (int j = 1; j <= totCols; j++) {
                // cell(i,j) Boder print
                if (i == 1 || i == totRows || j == 1 || j == totCols) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            // next line
            System.out.println();

        }
    }

    public static void inverted_rotated_half_pyramid(int n) {
        // outer loop
        for (int i = 1; i <= n; i++) {
            // spaces print
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            // stars print
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            // next line
            System.out.println();
        }
    }

    public static void inverted_half_pyramid_withNumbers(int n) {
        // outer loop
        for (int i = 1; i <= n; i++) {
            // inner numbers
            for (int j = 1; j <= n + 1 - i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void floyds_triangle(int n) {
        int counter = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(counter + " ");
                counter++;
            }
            System.out.println();
        }
    }

    public static void zero_one_triangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) { // even
                    System.out.print("1 ");
                } else { // odd
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

    public static void butterfly(int n) {
        // 1st Half
        for (int i = 1; i <= n; i++) {
            // stars-i
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            // spaces-2*(n-1)
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print("  ");
            }
            // stars-i
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        // 2nd Half
        for (int i = n; i >= 1; i--) {
            // stars-i
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            // spaces-2*(n-1)
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print("  ");
            }
            // stars-i
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void solid_rhombus(int n) {
        for (int i = 1; i <= n; i++) {
            // spaces print
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            // stars print
            for (int j = 1; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void hollow_rhombus(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n - i; j >= 1; j--) {
                System.out.print("  ");
            }
            for (int j = 1; j <= n; j++) {
                if (j == 1 || j == n || i == 1 || i == n)
                    System.out.print("* ");
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void diamond(int n) {
        // 1st half
        for (int i = 1; i <= n; i++) {
            for (int j = n - i + 1; j >= 1; j--) { // this line created by AD
                // for (int j = n - i; j >= 1; j--) { // (ya) for(int j=1; j<=n-i; j++) (same code)
                System.out.print("  ");
            }
            for (int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // middle line -> this line created by AD
        for (int i = 1; i <= 2 * n + 1; i++) {
            System.out.print("* ");
        }
        System.out.println();

        // 2nd half
        for (int i = n; i >= 1; i--) {
            for (int j = n - i + 1; j >= 1; j--) { // this line created by AD
                // for (int j = n - i; j >= 1; j--) {
                System.out.print("  ");
            }
            for (int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }

    public static void numbers_pyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "   ");
            }
            System.out.println();
        }
    }

    public static void palindromic_withNumbers(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            for (int j = i; j >= 1; j--) {
                System.out.print(j + " ");
            }
            for (int j = 2; j < i + 1; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        // hollow_rectangle(5, 8);
        // inverted_rotated_half_pyramid(4);
        // inverted_half_pyramid_withNumbers(4);
        // floyds_triangle(5);
        // zero_one_triangle(5);
        // butterfly(5);
        // solid_rhombus(5);
        // hollow_rhombus(5);
        // diamond(5);
        // numbers_pyramid(5);
        palindromic_withNumbers(5);
    }
}