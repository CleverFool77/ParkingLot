import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
    public void testCreateParkingLot() {
        newLot.createParkingLot(1);
        Assert.assertEquals(newLot.getCapacitySize(),1);
        Assert.assertEquals(newLot.getEmptySlots().size(), 1);
    }

    @Test
    public void testParkCar(){
        newLot.createParkingLot(1);
        newLot.park(car);
        Assert.assertEquals(car.getRegistrationNum(),"ABCD-EFGH-1234");
        Assert.assertNotNull(newLot.getAssignCarToSlots());
    }

    @Test
    public void testUnPark(){
        newLot.createParkingLot(1);
        newLot.park(car);
        newLot.unParkCar(1);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expectedOutput  = "Car at 1 is  is now unparked";
        Assert.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void teststatus() {
        newLot.createParkingLot(1);
        newLot.park(car);
        newLot.checkStatus();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expectedOutput  = "1 ABCD-EFGH-1234 white";
        Assert.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testRegistrationNumWithColor() {
        newLot.createParkingLot(1);
        newLot.park(car);
        newLot.registrationNumWithColor("white");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expectedOutput  = "ABCD-EFGH-1234";
        Assert.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testSlotNumWithColor() {
        newLot.createParkingLot(1);
        newLot.park(car);
        newLot.slotNumWithColor("white");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expectedOutput  = "1";
        Assert.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testSlotNumsWithResistrationNum() {
        newLot.createParkingLot(1);
        newLot.park(car);
        newLot.slotNumsWithResistrationNum("ABCD-EFGH-1234");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expectedOutput  = "1";
        Assert.assertEquals(expectedOutput, outContent.toString());
    }


}
