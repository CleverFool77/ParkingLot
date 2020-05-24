import com.google.common.base.Preconditions.*;
import com.google.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public interface Vehicle {

    public String getRegistrationNum();

    public String getColor();

    public void setRegistrationNum(String registrationNum);

    public void setColor(String color);
}
