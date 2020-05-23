import com.google.common.base.Preconditions.*;

import static com.google.common.base.Preconditions.checkNotNull;

public class Vehicle {
    private String registrationNum = null;
    private String color = null;

    public Vehicle(String registrationNum, String color) {
        this.registrationNum = checkNotNull(registrationNum);
        this.color = color;
    }
    public void setRegistrationNum(String registrationNum) {
        this.registrationNum = checkNotNull(registrationNum);
    }
    public void setColor(String color) {
        this.color = checkNotNull(color);
    }
    public String getRegistrationNum() {
        return this.registrationNum;
    }
    public String getColor() {
        return this.color;
    }
}
