
import com.google.inject.assistedinject.Assisted;

public interface CarFactory {
    Car create(@Assisted("regNum") String registrationNum,@Assisted("color") String color);
}
