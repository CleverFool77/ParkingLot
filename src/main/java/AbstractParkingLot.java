
public interface AbstractParkingLot {

    public void parkVehicle(String registrationNum, String color);

    public void parkCar(String registrationNum, String color);

    public void unParkCar(Integer slotNumber);

    public void registrationNumWithColor(String color);

    public void slotNumsWithResistrationNum(String registrationNum);

    public void slotNumWithColor(String Color);

    public void checkStatus();
}
