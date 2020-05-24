import com.google.inject.AbstractModule;

public class VehicleModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(Vehicle.class).to(Car.class);
    }
}
