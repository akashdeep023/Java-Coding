import java.util.Scanner;

public class Assignment {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // Question 1 : In a program, input 3 numbers : A, B and C. You have to output the average of these 3 numbers.
        // System.out.print("Inter 3 numbers : \nA : ");
        // int A = sc.nextInt();
        // System.out.print("B : ");
        // int B = sc.nextInt();
        // System.out.print("C : ");
        // int C = sc.nextInt();
        // int sum = A + B + C;
        // double average = (double) sum / 3;
        // System.out.println("Average : " + average);        

        // Question 2: In a program, input the side of a square. You have to output the area of the square.
        // System.out.print("Inter Side : ");
        // int side = sc.nextInt();
        // int area = side * side;
        // System.out.println("Area : "+ area);

        // Question 3: Enter cost of 3 items from the user (using float data type) - a pencil, a pen and an eraser. You have to output the total cost of the items back to the user as their bill.
        // System.out.print("Enter Cost of Pencil : ");
        // float pencilCost = sc.nextFloat();
        // System.out.print("Enter Cost of Pen : ");
        // float penCost = sc.nextFloat();
        // System.out.print("Enter Cost of Eraser : ");
        // float eraserCost = sc.nextFloat();
        // float totalCost = pencilCost + penCost + eraserCost;
        // System.out.println("Total Cost : " + totalCost);

        // (Add on : You can also try adding 18% gst tax to the items in the bill as an advanced problem)
        // float totalCostWithGst = totalCost * 1.18f;
        // System.out.println("Total Cost with GST : "+totalCostWithGst);

        // Question 4: What will be the type of result in the following Java code?
        // byte b = 4;
        // char c = 'a';
        // short s = 512;
        // int i = 1000;
        // float f = 3.14f;
        // double d = 99.9954;
        // double result = (f * b) + (i % c) + (d * s); // double type -> type conversion
        // System.out.println(result);

        // Question 5: (Advanced) Will the following statement give any error in Java? int $ = 24;
        int $ = 24;
        System.out.println($); // 24
        // No, the statement will not give any error.
        // Names of variables are called identifiers in Java. Identifier rule says, identifiers can start with
        // any alphabet or underscore (“_”) or dollar (“$”).
        // According to the rule the given variable name is a valid identifier

        sc.close(); // Close Scanner
    }
}
