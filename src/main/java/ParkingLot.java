import com.google.common.collect.HashBiMap;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import java.util.ArrayList;

import static com.google.common.base.Preconditions.checkNotNull;

public abstract interface ParkingLot {

	public int getCapacitySize();

	public ArrayList<Integer> getEmptySlots();

	public HashBiMap<Integer, Car> getAssignCarToSlots();

	public void setCapacitySize(Integer capacitySize);

	public void setEmptySlots(ArrayList<Integer> emptySlots);

	public void setAssignCarToSlots(HashBiMap<Integer, Car> assignCarToSlots);

	public void createParkingLot(Integer capacitySize);

	public Integer park(Car car);

	public Integer parkCar(Car car);

	public Integer unParkCar(Integer slotNumber);

	public ArrayList<String> registrationNumWithColor(String color);

	public void slotNumsWithResistrationNum(String registrationNum);

	public ArrayList<Integer> slotNumWithColor(String Color);

	public ArrayList<String> checkStatus();

	class ParkingLotModule extends AbstractModule {

		@Override
		protected void configure() {}

		@Provides
		public ParkingLot provideParkingLot() {
			ParkingLot parkingLot = new ParkingLotImpl(0);
			return parkingLot;
		}
	}
}
