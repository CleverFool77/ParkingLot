import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

public class InputParserTester {

    Injector injector = Guice.createInjector(new ParkingLotModule(),new CarModule());

    @Mock
    InputParser inputParser = injector.getInstance(InputParser.class);

    @Test
    public void testInputToWordsFunction() {
        inputParser.parseTheInputWords("Hello World");
        List<String> words = inputParser.getTheInputWords();
        Assert.assertEquals("Hello", words.get(0));
        Assert.assertEquals("World", words.get(1));

    }

    @Nested
    @DisplayName("test for switch cases of commands")
    class SwitchCaseCommandTester {

        @InjectMocks
        ParkingLot newLot = injector.getInstance(ParkingLot.class);

        @Mock
        Car car = new CarImpl("ABCD-EFGH-1234", "white");

        @Test
        void testCreateCommand() {
            inputParser.parseTheInputWords("create_parking_lot 1");
            inputParser.inputDataParser();
            Assert.assertEquals(newLot.getCapacitySize(),1);
        }
    }
}
