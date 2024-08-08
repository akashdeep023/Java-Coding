public class Practice_OOPS {
    public static void main(String[] args) {
        // 1. Question -> Find out the correct statement to assign name to object? --------------------------------
        // Option -> a. s->name = "jack", b. Student.name = "jack", c. s.name = "jack"
        // Answer -> c (s.name = "jack)
        // Student s = new Student();
        // s.name = "Jack"; // objectName.name = "Jack" (used dot operator)
        // System.out.println(s.name);

        // 2. Question -> Which variable (s) can the class Person access in the following code? --------------------------------
        // Option -> a. name, b. weight, c. rollNumber, d. schoolName
        // Answer -> a or b (name or weight access  only Person object)
        // Person p = new Person();
        // p.name = "Jack"; // name
        // p.weight = 50; // weight

        // 3. Question -> Which of the following modifiers are not allowed in the front of class? --------------------------------
        // Option -> a. private, b. protected, c. public, d. default
        // Answer -> a or b (private or protected are not allowed in the front of class in java because unused classes)

        // 4. Question -> Which of the following in s correct statement? (both classes in same package)--------------------------------
        // Option -> a. Car c = new Car();, b. Vehicle v = new Vehicle();, c. Vehicle v = new Car();, d. Car c = new Vehicle();
        // Answer -> a,b or c (Car c = new Vehicle() wrong answer -> Car  have Vehicle or Car properties, Vehicle have only Vehicle properties then Car not access Car properties -> run time error)

        // 5. Question -> What will be output of this code? (both classes in same package) --------------------------------
        // Vehicle obj1 = new Car();
        // obj1.print(); // Answer -> Derived class Car (function overriding)
        // Vehicle obj2 = new Vehicle();
        // obj2.print(); // Answer -> Base class Vehicle

        // 6. Question -> What will be output of this code? (both classes in same package) --------------------------------
        // Vehicle obj1 = new Car();
        // obj1.print1(); // Answer -> Error (Vehicle cannot access print1 method)
        // Vehicle obj2 = new Vehicle();
        // obj2.print(); // Answer -> Base class Vehicle

        // 7. Which of the following is not an OOPS component? --------------------------------
        // Option -> a. Inheritance, b. Encapsulation, c. Polymorphism, d. Aggregations
        // Answer -> Aggregations (Aggregations not OOPS concept)

        // 8. What will be the output of this code? --------------------------------
        System.out.println(Book.count); // static variables directe access to Class name
        Book b1 = new Book(10);
        Book b2 = new Book(20);
        System.out.println(Book.count);

        // 9. Which line has error?
        // Answer -> No error
        // Test t = new Test();
        // t.set_marks(98); // line-2
        // System.out.println(Test.marks); // line-3

        // 10. What would be the output of the following code? --------------------------------
        Test t = new Test();
        t.changeB();
        System.out.println(Test.a + Test.b); // 10 + 30 => 40
    }
}

// 1. Question --------------------------------
// class Student {
//     String name;
//     int marks;
// }

// 2. Question --------------------------------
// class Person {
//     String name;
//     int weight;
// }

// class Student extends Person {
//     int rollNumber;
//     String schoolName;
// }

// 5. Question --------------------------------
// class Vehicle {
//     void print() {
//         System.out.println("Base class Vehicle");
//     }
// }

// class Car extends Vehicle {
//     void print() {
//         System.out.println("Derived class Car");
//     }
// }

// 6. Question --------------------------------
class Vehicle {
    void print() {
        System.out.println("Base class Vehicle");
    }
}

class Car extends Vehicle {
    void print1() {
        System.out.println("Derived class Car");
    }
}

// 8. Question --------------------------------
class Book {
    int print;
    static int count; // by default -> 0

    public Book(int price) {
        this.print = price;
        count++;
    }
}

// 9. Question --------------------------------
// class Test{
//     static int marks;
//     void set_marks(int marks){
//         this.marks = marks; // line-1
//     }
// }

// 10. Question --------------------------------
class Test {
    static int a = 10;
    static int b; // by default null (0)

    static void changeB() {
        b = a * 3;
    }
}