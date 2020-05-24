
public abstract interface ParkingLot {

    public void createParkingLot(Integer capacitySize);

    public void park(Car car);

    public void parkCar(Car car);

    public void unParkCar(Integer slotNumber);

    public void registrationNumWithColor(String color);

    public void slotNumsWithResistrationNum(String registrationNum);

    public void slotNumWithColor(String Color);

    public void checkStatus();
}
