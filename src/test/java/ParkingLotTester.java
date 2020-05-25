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
    @InjectMocks
    ParkingLot newLot = new ParkingLotImpl(1);

    @Mock
    Car car = new CarImpl("ABCD-EFGH-1234", "white");;


    @Test
    public void testCreateParkingLot() {
        newLot.createParkingLot(1);
        Assert.assertEquals(newLot.getCapacitySize(),1);
        Assert.assertEquals(newLot.getEmptySlots().size(), 1);
    }

    @Test
    public void testParkCar(){
        newLot.createParkingLot(1);
        Assert.assertEquals(car.getRegistrationNum(),"ABCD-EFGH-1234");
        newLot.park(car);
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

}
