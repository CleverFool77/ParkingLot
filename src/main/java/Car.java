import com.google.inject.Inject;

public class Car extends Vehicle {

    @Inject
    public Car(String registrationNum, String color) {
        super(registrationNum, color);
    }
}

