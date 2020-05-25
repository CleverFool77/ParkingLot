import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.when;

public class InputParserTester {

    Injector injector = Guice.createInjector(new ParkingLotModule(), new CarModule());

    @InjectMocks
    InputParser inputParser = injector.getInstance(InputParser.class);

    @Mock
    ParkingLot newLot = injector.getInstance(ParkingLot.class);

    @Test
    @DisplayName("test on InputCommand function of parser")
    public void testInputToWordsFunction() {
        inputParser.parseTheInputWords("Hello World");
        List<String> words = inputParser.getTheInputWords();
        Assert.assertEquals("Hello", words.get(0));
        Assert.assertEquals("World", words.get(1));
    }


 /*   @Test
    @DisplayName("test for switch cases of commands")
    public void testCreateCommand() {
        inputParser.parseTheInputWords("create_parking_lot 1");
        inputParser.inputDataParser();
        Assert.assertEquals(newLot.getCapacitySize(), 1);

    }*/
}
