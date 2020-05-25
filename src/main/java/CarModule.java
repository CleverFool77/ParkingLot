import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
public class CarModule extends AbstractModule {

    @Override
    protected void configure() {
        //bind(Car.class).to(CarImpl.class);
        install(new FactoryModuleBuilder()
                .implement(Car.class, CarImpl.class)
                .build(CarFactory.class));
    }
}
