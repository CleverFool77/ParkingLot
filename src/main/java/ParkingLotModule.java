import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class ParkingLotModule extends AbstractModule {

	@Override
	protected void configure() {}

	@Provides
	public ParkingLot provideParkingLot() {
		ParkingLot parkingLot = new ParkingLotImpl(0);
		return parkingLot;
	}
}