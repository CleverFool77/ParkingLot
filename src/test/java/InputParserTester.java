import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Assert;
import org.junit.Test;
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
}
