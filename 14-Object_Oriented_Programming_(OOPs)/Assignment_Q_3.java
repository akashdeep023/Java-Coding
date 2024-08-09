// Question 3 : Look at the following code and choose the right option for the word:
public class Assignment_Q_3 {
    public static void main(String[] args) {
        // Option -----------------
        // a. Only protected can be used.
        // B. public and protected both can be used.
        // C. public, protected, and private can be used.
        // d. Only public can be used.

        // Answer ----------------
        // B. public and protected both can be used.
        // You can provide only a less restrictive or same-access modifier when overriding a method.
    }
}

// Shape.java
class Shape {
    protected void display() {
        System.out.println("Display-base");
    }
}

// Circle.java
class Circle extends Shape {
    public void display() { // 
        System.out.println("Display-derived");
    }
}
