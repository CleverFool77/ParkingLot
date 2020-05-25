import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

public class CarTester {

    @Mock
    Car car = new CarImpl("ABCD-EFGH-1234", "white");

    @Test
    @DisplayName("test on Get registration Num")
    public void testGetRegistrationNum() {
        String actualOutput = car.getRegistrationNum();
        String expectedOutput = "ABCD-EFGH-1234";
        Assert.assertEquals(actualOutput, expectedOutput);
    }

    @Test
    @DisplayName("test on Get Color")
    public void testGetColor() {
        String actualOutput = car.getColor();
        String expectedOutput = "white";
        Assert.assertEquals(actualOutput, expectedOutput);
    }

    @Test
    @DisplayName("test on Set Color")
    public void testSetColor() {
        car.setColor("red");
        final String color = car.getColor();
        Assert.assertEquals("red", color);
    }

    @Test
    @DisplayName("test Set registration number")
    public void testSetRegNum() {
        car.setRegistrationNum("ABCD-EFGH-1234");
        final String registrationNum = car.getRegistrationNum();
        Assert.assertEquals("ABCD-EFGH-1234", registrationNum);
    }

}
