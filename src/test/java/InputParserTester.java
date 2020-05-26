import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

@DisplayName("Test on Input Parser Tester")
public class InputParserTester {

    Injector injector = Guice.createInjector(new CarModule.ParkingLot.ParkingLotModule(), new InputParser.CarModule());

    @InjectMocks
    InputParser inputParser = injector.getInstance(InputParser.class);

    @Mock
    CarModule.ParkingLot newLot = injector.getInstance(CarModule.ParkingLot.class);

    @Test
    @DisplayName("test on InputCommand function of parser")
    public void testInputToWordsFunction() {
        inputParser.parseTheInputWords("Hello World");
        List<String> words = inputParser.getTheInputWords();
        Assert.assertEquals("Hello", words.get(0));
        Assert.assertEquals("World", words.get(1));
    }
}
