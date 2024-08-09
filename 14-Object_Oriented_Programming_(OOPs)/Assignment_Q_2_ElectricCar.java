// Question 2 : What is the output of the following program?
public class Assignment_Q_2_ElectricCar extends Car {
    @Override
    public final String drive() {
        return "Driving electric car";
    }

    public static void main(String[] wheels) {
        final Car car = new Assignment_Q_2_ElectricCar();
        System.out.print(car.drive()); // Method Overriding 

        // Option 
        // A. Driving vehicle
        // B. Driving electric car
        // C. Driving car
        // D. The code does not compile

        // Answer -> Driving electric car

    }
}

// default Class creation below public Class 
class Automobile {
    private String drive() {
        return "Driving vehicle";
    }
}

class Car extends Automobile {
    protected String drive() {
        return "Driving car";
    }
}