import com.google.common.collect.HashBiMap;

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

    public void park(Car car);

    public void parkCar(Car car);

    public void unParkCar(Integer slotNumber);

    public void registrationNumWithColor(String color);

    public void slotNumsWithResistrationNum(String registrationNum);

    public void slotNumWithColor(String Color);

    public void checkStatus();
}
