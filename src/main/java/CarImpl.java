import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;

import static com.google.common.base.Preconditions.checkNotNull;

public class CarImpl implements Car {
    private String registrationNum = null;
    private String color = null;

    @Inject
    public CarImpl(@Assisted("regNum") String registrationNum,@Assisted("color") String color) {
        this.registrationNum = registrationNum;
        this.color = color;
        //System.out.println("kdjhfjfhsjf");
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

