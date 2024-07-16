

public class Assignment {
    public static void main(String[] args) {
        // Question : What will be the output of the following programs :
        // 1. ----------------------------------
        // int x = 2, y = 5;
        // int exp1 = (x * y / x);
        // int exp2 = (x * (y / x));
        // System.out.print(exp1 + " , ");
        // System.out.print(exp2); 
        // Output => 5 , 4

        // 2. ----------------------------------
        // int x = 200, y = 50, z = 100;
        // if(x > y && y > z){
        //     System.out.println("Hello");
        // }
        // if(z > y && z < x){
        //     System.out.println("Java");
        // }
        // if((y+200) < x && (y+150) < z){
        //     System.out.println("Hello Java");
        // }
        // Output =>  Java

        // 3. ----------------------------------
        // int x, y, z;
        // x = y = z = 2;
        // x += y;
        // y -= z;
        // z /= (x + y);
        // System.out.println(x + " " + y + " " + z); 
        // Output => 4 0 0

        // 4. ----------------------------------
        // int x = 9, y = 12;
        // int a = 2, b = 4, c = 6;
        // int exp = 4/3 * (x + 34) + 9 * (a + b * c) + (3 + y * (2 + a)) / (a + b*y);
        // System.out.println(exp); 
        // Output => 1 * 43 + 9 * 26 + 51 / 50 => 43 + 243 + 1 => 278

        // 5. ----------------------------------
        int x = 10, y = 5;
        int exp1 = (y * (x / y + x / y));   // 5 * (2 + 2) => 20
        int exp2 = (y * x / y + y * x / y); // 50 / 5 + 50 / 5 => 10 + 10 => 20
        System.out.println(exp1);
        System.out.println(exp2); 
        // Output => 20 , 20

    }
}
