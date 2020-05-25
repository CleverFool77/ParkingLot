import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.DisplayName;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ParkingLotTester {

    Injector injector = Guice.createInjector(new ParkingLotModule(),new CarModule());

    @InjectMocks
    ParkingLot newLot = injector.getInstance(ParkingLot.class);

    @Mock
    Car car = new CarImpl("ABCD-EFGH-1234", "white");
    //Car car = injector.getInstance(Car.class);

    @Test
    @DisplayName("Test to create parking lot")
    public void testCreateParkingLot() {
        newLot.createParkingLot(1);
        Assert.assertEquals(newLot.getCapacitySize(),1);
    }

    @Test
    @DisplayName("Test to Park")
    public void testParkCar(){
        newLot.createParkingLot(1);
        when(newLot.parkCar(car).toString()).thenReturn("Alloted at 1");
    }

    @Test
    @DisplayName("Test to Unpark")
    public void testUnPark(){
        newLot.createParkingLot(1);
        newLot.park(car);
        when(newLot.unParkCar(1).toString()).thenReturn("1");
    }

    @Test
    @DisplayName("Test to check status")
    public void teststatus() {
        newLot.createParkingLot(1);
        newLot.park(car);
        when(newLot.checkStatus().toString()).thenReturn("1 ABCD-EFGH-1234 white");
    }

    @Test
    @DisplayName("Test to return registration Num on given color")
    public void testRegistrationNumWithColor() {
        newLot.createParkingLot(1);
        newLot.park(car);
        String regNum = newLot.registrationNumWithColor("white").get(0);
        Assert.assertSame("1 ABCD-EFGH-1234 white", regNum);
    }

    @Test
    @DisplayName("Test to return Slot Number on given color")
    public void testSlotNumWithColor() {
        newLot.createParkingLot(1);
        newLot.park(car);
        System.out.println("skjhdjhjadkhd");
        ArrayList<Integer> slot = newLot.slotNumWithColor("white");
        System.out.println(slot.get(0));
        Assert.assertSame(1, slot.get(0));
    }

}
