import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class ParkingLotTester {

    Injector injector = Guice.createInjector(new ParkingLot.ParkingLotModule(),new InputParser.CarModule());
    @InjectMocks
    private ParkingLot newLot = injector.getInstance(ParkingLot.class);

    @Spy
    private Car car = new CarImpl("ABCD-EFGH-1234", "white");

    public ParkingLotTester() {}

    @Test
    @DisplayName("Test to create parking lot")
    public void testCreateParkingLot() {
        newLot.createParkingLot(1);
        Assert.assertEquals(this.newLot.getCapacitySize(),1);
    }

    @Test
    @DisplayName("Test to Park")
    public void testParkCar(){
        this.newLot.createParkingLot(1);
        String actualOutput = this.newLot.parkCar(this.car).toString();
        Assert.assertEquals(actualOutput, "1");
    }

    @Test
    @DisplayName("Test to Unpark")
    public void testUnPark(){
        this.newLot.createParkingLot(1);
        this.newLot.park(this.car);
        String actualOutput = this.newLot.unParkCar(1).toString();
        Assert.assertEquals(actualOutput, "1");
    }

    @Test
    @DisplayName("Test to check status")
    public void teststatus() {
        newLot.createParkingLot(1);
        newLot.park(car);
        String actualOutput = this.newLot.checkStatus().get(0).toString();
        String expectedOutput = "1 ABCD-EFGH-1234 white";
        Assert.assertEquals(actualOutput, expectedOutput);
    }

    @Test
    @DisplayName("Test to return registration Num on given color")
    public void testRegistrationNumWithColor() {
        newLot.createParkingLot(1);
        newLot.park(this.car);
        String regNum = newLot.registrationNumWithColor("white").get(0);
        Assert.assertEquals("ABCD-EFGH-1234", regNum);
    }

    @Test
    @DisplayName("Test to return Slot Number on given color")
    public void testSlotNumWithColor() {
        newLot.createParkingLot(1);
        newLot.park(this.car);
        ArrayList<Integer> slot = newLot.slotNumWithColor("white");
        System.out.println(slot.get(0));
        Assert.assertEquals(slot.get(0).toString(), "1");
    }

}
