// Class name Start with Capital letter (Not mandatory) -> (OOPS, Pen, Animal, ...)
// Classes -> Group of these entities (Blueprint of Object)
// Objects -> Entities in the real world (Watch, Pen, Animal, ...)

// import java.util.Scanner; // Inbuilt Packages (import Scanner class)---
// import java.util.*; // Inbuilt Packages (import all)---

public class OOPS { // public -> Access Modifier, OOPS -> Class name, class -> must be public class 
    public static void main(String[] args) { // Execution Start with main function, main function -> must be public & static
        // Created Object --------------------------------
        Pen p1 = new Pen(); // Pen() => Construct, new -> keyword to create new object
        p1.setColor("Blue");
        p1.setTip(5);
        System.out.println(p1.color);
        System.out.println(p1.tip);
        p1.color = "Yellow";
        System.out.println(p1.color);

        // Access Modifiers (Specifiers)--------------------------------
        // Access Modifiers | with in class | with in package | outside package by subClass only | outside package |
        //    Private       |       Yes     |       No        |                 No               |       No        |
        //    Default       |       Yes     |       Yes       |                 No               |       No        |
        //    Protected     |       Yes     |       Yes       |                 Yes              |       No        |
        //    Public        |       Yes     |       Yes       |                 Yes              |       Yes       |

        BankAccount myAcc = new BankAccount();
        myAcc.username = "Jack";
        myAcc.setPassword("Jack123");
        System.out.println(myAcc.username); // myAcc.password -> not access (password -> private)

        // Getter & Setter --------------------------------
        // Get : to return the value (Getter)
        // Set : to modify the value (Setter)
        // this : this keyword is used to refer to the current object

        Marker m1 = new Marker();
        m1.setColor("Red");
        System.out.println(m1.getColor()); // m1.color -> direct not access
        m1.setTip(10);
        System.out.println(m1.getTip());

        // Four major parts of OOPS --------------------------------
        // 1. Encapsulation
        // 2. Inheritance
        // 3. Polymorphism
        // 4. Abstraction

        // #Encapsulation --------------------------------
        // => Encapsulation is defined as the wrapping up of data & methods under a single unit. It also implements data hiding.

        // Constructors --------------------------------
        // => Constructors is a special method which is invoked automatically at the time of object creation.
        // - Constructors have the same name as class or structure.
        // - Constructors don't havve a return type. (Not even void)
        // - Constructors are only called once, at object creation.
        // - Memory allocation happens when constructor is called 

        // Non-parameterized constructor (By default) ---
        Student student1 = new Student();
        student1.name = "Akash Deep";
        student1.roll = 10;
        student1.marks[0] = 100;
        student1.marks[1] = 80;
        student1.marks[2] = 70;
        System.out.println("student1: " + student1.name + ", " + student1.roll);

        // Parameterized constructors ---
        Student student2 = new Student("Jack");
        System.out.println("student2: " + student2.name + ", " + student2.roll);
        Student student3 = new Student(51);
        System.out.println("student3: " + student3.name + ", " + student3.roll);

        // Copy constructor --- (Shallow & Deep Copy)
        Student student4 = new Student(student1); // Copy constructor (Shallow copy constructor -> reference(change reflect), Deep copy constructor -> change don't reflect)
        student1.marks[2] = 100;
        System.out.println("student4: " + student4.name + ", " + student4.roll);
        for (int i = 0; i < 3; i++) {
            System.out.print(student4.marks[i] + " ");
        }
        System.out.println("\n");

        // Destructors --------------------------------
        // We don't write destructor in Java, because garbage collector in Java automatically deallocates the unused memory.

        // #Inheritance --------------------------------
        // => Inheritance is when properties & methods of base(parent) class are passed on to a derived(child) class.
        // - Inheritance is achieved through "extends" keyword.
        // - Four type of inheritance (Single level inheritance,Multi level inheritance, Hierarchical inheritance, Hybrid inheritance)

        // Single level inheritance---
        Fish jellyFish = new Fish();
        jellyFish.breathe(); // animal function inherited
        jellyFish.swim(); // fish function
        System.out.println();

        // Multi level inheritance---
        Dog tomy = new Dog();
        tomy.breathe(); // animal function inherited
        tomy.walk(); // mammal function inherited
        tomy.breed = "bullDog"; // dog function
        System.out.println(tomy.breed);
        System.out.println();

        // Hierarchical inheritance---
        Fish starFish = new Fish();
        starFish.breathe();
        starFish.swim();
        Mammal tiger = new Mammal();
        tiger.color = "white";
        System.out.println(tiger.color);
        tiger.breathe();
        tiger.walk();
        Bird eagle = new Bird();
        eagle.breathe();
        eagle.fly();
        System.out.println();

        // Hybrid inheritance---
        Shark shark1 = new Shark();
        shark1.breathe();
        shark1.swim();
        shark1.fins();
        Cat cat1 = new Cat();
        cat1.breathe();
        cat1.walk();
        cat1.eat();
        Peocock pic = new Peocock();
        pic.breathe();
        pic.fly();
        pic.eat();
        System.out.println();

        // #Polymorphism --------------------------------
        // Compile time polymorphism (Static) -> Method Overloading
        // Run time polymorphism (Dynamic) -> Method Overriding

        // Method Overloading ---
        // => Multiple functions with the same name but defferent parameters.
        Calculater calc = new Calculater();
        System.out.println(calc.sum(1, 2));
        System.out.println(calc.sum((float) 1.5, (float) 2.5));
        System.out.println(calc.sum(1, 2, 3));

        // Method Overriding ---
        // Parent and child classes both contain the same function with a defferent definition.
        Math mensurationBook = new Math();
        mensurationBook.price();
        System.out.println();

        // Package in Java --------------------------------
        // => Package is a group of similar types of classes, interfaces, and sub-packages.
        // Scanner sc = new Scanner(System.in); // Inbuilt Package (Scanner -> Class)
        // int a = sc.nextInt(); // nextInt -> Method of Scanner
        // System.out.println(a);

        // #Abstraction --------------------------------
        // => Hidding all the unnecessary details and showing only the important parts to the user.
        // - Two type of Abstraction (Abstract Class, Interfaces) 

        // Abstract Class ---
        // - Can't create an instance(object) of abstract class
        // - Can have abstract/non-abstract methods (abstract methods -> in abstract class)
        // - can have constructor (initialize base ya derived properties in constructor call)
        Car car1 = new Car();
        car1.speed();
        car1.price();
        Bike heroBike = new Bike();
        heroBike.speed();
        heroBike.price();
        System.out.println();

        System.out.println(car1.color); // initial color
        car1.changeColor(); // change color with function
        System.out.println(car1.color); // change color 
        System.out.println();

        Maruti marutiSuzuki = new Maruti(); // Constructor called hierarchy -> Vehicle -> Car -> Maruti
        marutiSuzuki.speed();
        marutiSuzuki.price();
        System.out.println();

        // Interfaces ---
        // => Interfaces ia a blueprint of a class.
        // - All methods are public, abstract & without implementation
        // - used to achive total abstraction (100%)
        // - multiple inheritance (5th inheritance)
        // - Variable in the interface are final, public and staties.

        // Total abstraction --
        Queen q = new Queen();
        q.move();
        King k = new King();
        k.move();
        System.out.println();

        // Multiple inheritance (5th) --
        // Two interfaces inherit a single class
        Bear br = new Bear();
        br.eat();
        br.speak();
        br.walk();

        // Static keyword --------------------------------
        // => Static keyword in java used to share the same variable or method of a given class.
        // - static created -> (Property(variable), function, Block, Nested Class)
        Teacher t1 = new Teacher();
        t1.setName("Jack sir");
        System.out.println(t1.name); // "Jack sir"
        System.out.println(t1.getName()); // "Jack sir"
        System.out.println(t1.monthlyIncome(20000, 2000, 1200));
        System.out.println();

        // Super keyword --------------------------------
        // => super keyword is used to refer immediate parent class object.
        // access -> parent's property, parent's function, parent's constructor
        SamsungTV sm1 = new SamsungTV();
        System.out.println(sm1.color);

        // Constructor channing (read itself) --------------------------------

    }
}

// Class creation below public class --------------------------------
class Pen { // Blueprint of Pen
    String color; // attribute name (property name)
    int tip;

    void setColor(String newColor) { // functions (behavior)
        color = newColor;
    }

    void setTip(int newTip) {
        tip = newTip;
    }
}

// Access Modifiers --------------------------------
class BankAccount {
    public String username;
    private String password;

    public void setPassword(String newPassword) {
        password = newPassword;
    }
}

// Getter & Setter --------------------------------
class Marker {
    private String color; // access only this class
    private int tip;

    // Getter ---
    String getColor() {
        return color;
    }

    int getTip() {
        return tip;
    }

    // Setter ---
    void setColor(String color) { // color -> newColor
        this.color = color; // this keyword is used to refer to the current object
    }

    void setTip(int tip) {
        this.tip = tip;
    }
}

// Constructors --------------------------------
class Student {
    String name;
    int roll;
    int marks[]; // copy constructor time -> copy of a marks array reference (addresses)

    // Many Types of constructor creation in class ---
    // Non-parameterized constructor---
    Student() { // -> By default Java created constructor
        marks = new int[3]; // marks array length = 3
        System.out.println("Constructor is called...");
    }

    // Parameterized constructor---
    Student(String name) { // constructor with parameter
        marks = new int[3];
        this.name = name; // constructor call time property initialization
        System.out.println("Constructor is called with String paramerter...");
    }

    // Parameterized constructor---
    Student(int roll) { // constructor with parameter
        marks = new int[3];
        this.roll = roll; // constructor call time property initialization
        System.out.println("Constructor is called with int paramerter...");
    }

    // Copy constructor (java -> create, c++ -> default)---
    // Shallow copy constructor (by default)---
    // Student(Student student) {
    //     marks = new int[3];
    //     this.name = student.name;
    //     this.roll = student.roll;
    //     this.marks = student.marks;
    //     System.out.println("Copy Constructor is called...");
    // }
    // Shallow copy constructor (by default)---
    Student(Student student) {
        marks = new int[3];
        this.name = student.name;
        this.roll = student.roll;
        for (int i = 0; i < marks.length; i++) {
            this.marks[i] = student.marks[i];
        }
        System.out.println("Copy Constructor is called...");
    }

}

// Inheritance --------------------------------
class Animal { // Base class (parent class)
    String color;

    void breathe() {
        System.out.println("breathes");
    }
}

// Single level inheritance---
class Fish extends Animal { // Derived class of Animal (child class), sub class of Animal
    void swim() {
        System.out.println("swim");
    }
}

class Mammal extends Animal { // Derived class of Animal
    void walk() {
        System.out.println("walk");
    }
}

// Multi level inheritance---
// Dog extends Mammal & Mammal extends Animal
class Dog extends Mammal { // Derived class of Mammal
    String breed;
}

// Hierarchial inheritance---
// Fish extends Animal...   // Derived class of Animal
// Mammal extends Animal... // Derived class of Animal
class Bird extends Animal { // Derived class of Animal
    void fly() {
        System.out.println("fly");
    }
}

// Hybrid inheritance---
// Animal class...                // Base class
//   Fish extends Animal...       // Derived class of Animal
//      Tuna extends Fish...      // Derived class of Fish
//      Shark extends Fish...     // Derived class of Fish
//   Mammal extends Animal...     // Derived class of Animal
//      Dog extends Mammal...     // Derived class of Mammal
//      Cat extends Mammal...     // Derived class of Mammal
//   Bird extends Animal...       // Derived class of Animal
//      Peocock extends Mammal... // Derived class of Bird
class Tuna extends Fish {
    void fins() {
        System.out.println("4 fins");
    }
}

class Shark extends Fish {
    void fins() {
        System.out.println("2 big fins & 2 small fins");
    }
}

class Cat extends Mammal {
    void eat() {
        System.out.println("eat fish & milk");
    }
}

class Peocock extends Bird {
    void eat() {
        System.out.println("eats kit");
    }
}

// Polymorphism --------------------------------
// Method Overloading---
class Calculater {
    int sum(int a, int b) {
        return a + b;
    }

    float sum(float a, float b) {
        return a + b;
    }

    int sum(int a, int b, int c) {
        return a + b + c;
    }
}

// Method Overriding---
class Book {
    void price() {
        System.out.println("Price anything");
    }
}

class Math extends Book {
    void price() {
        System.out.println("Price 120Rs");
    }
}

// Abstraction --------------------------------
// abstract class ---
abstract class Vehicle { // abstract class -> can't create object
    String color;

    void speed() {
        System.out.println("Min speed 30Km/h");
    }

    abstract void price(); // abstract method (idea -> every vehicle have price method) 

    Vehicle() {
        color = "Black"; // initial value added in constructor
        System.out.println("Vehicle constructor called");
    }
}

class Car extends Vehicle { // derived class of Vehicle
    void price() {
        System.out.println("Price 500000Rs");
    }
    // abstract void seat(); -> The abstract method seat in type Car can only be defined by an abstract class

    void changeColor() {
        color = "Red";
    }

    Car() {
        System.out.println("Car constructor called");
    }

}

class Maruti extends Car { // derived class of Car
    Maruti() {
        System.out.println("Maruti constructor called");
    }
}

class Bike extends Vehicle { // derived class of Vehicle
    void price() {
        System.out.println("Price 200000Rs");
    }

    void changeColor() {
        color = "Blue";
    }
}

// Interfaces ---
// Total abstraction (100%) --
interface ChassPlayer {
    void move(); // public, abstract, without implementation (by default)
}

class Queen implements ChassPlayer { // interface use 'implements' keyword
    public void move() { // method create -> public
        System.out.println("up,down,right,left,diagonal (in all 4 directions");
    }
}

class Rook implements ChassPlayer {
    public void move() {
        System.out.println("up,down,right,left");
    }
}

class King implements ChassPlayer {
    public void move() {
        System.out.println("up,down,right,left,diagonal (by 1 step)");
    }
}

// Multiple inheritance ---
interface Carnivore {
    // String color = "brown"; // final, public and staties

    void eat();

    void speak();
}

interface Herbivore {
    void eat();

    void walk();
}

class Bear implements Carnivore, Herbivore {
    public void eat() {
        System.out.println("Bear eats");
    }

    public void walk() {
        System.out.println("walking");
    }

    public void speak() {
        System.out.println("speak");
    }
}

// Static keyword --------------------------------
class Teacher {
    static int monthlyIncome(int month, int bonus, int pf) { // static -> Create a function in memory for all objects
        return (month + bonus + pf);
    }

    String name;
    int id;
    static String schoolName; // static -> Create a property in memory for all objects

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }
}

// Super keyword --------------------------------
class TV {
    String color;

    TV() {
        System.out.println("TV constructor colled");
    }
}

class SamsungTV extends TV {
    SamsungTV() {
        super(); // by default called in java
        super.color = "Black";
        System.out.println("SumsungTV constructor colled");
    }
}
