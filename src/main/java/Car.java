import com.google.inject.Inject;
import com.google.inject.Singleton;

import static com.google.common.base.Preconditions.checkNotNull;

@Singleton
public class Car implements Vehicle {

    private String registrationNum = null;
    private String color = null;

    @Inject
    public Car(String registrationNum, String color) {
        this.registrationNum = checkNotNull(registrationNum);
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
        this.registrationNum = checkNotNull(registrationNum);
    }

    @Override
    public void setColor(String color) {
        this.color = checkNotNull(color);
    }
}

