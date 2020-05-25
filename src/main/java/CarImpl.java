import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;

/*
* @class  Car helps us create
* an object of car that is
* being parked in parking lot
* */

public class CarImpl implements Car {
    private String registrationNum = null;
    private String color = null;

    @Inject
    public CarImpl(@Assisted("regNum") String registrationNum,@Assisted("color") String color) {
        this.registrationNum = registrationNum;
        this.color = color;
    }

    @Override
    public String getRegistrationNum() {
        return this.registrationNum;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public void setRegistrationNum(String registrationNum) {
        this.registrationNum = registrationNum;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

}

