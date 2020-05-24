import com.google.inject.AbstractModule;

public class ParkingLotModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(AbstractParkingLot.class).to(ParkingLot.class);
    }
}
