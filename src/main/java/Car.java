import static com.google.common.base.Preconditions.checkNotNull;

public interface Car {
    public String getRegistrationNum();

    public String getColor();

    public void setRegistrationNum(String registrationNum);

    public void setColor(String color);

}
