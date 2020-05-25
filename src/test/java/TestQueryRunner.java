import org.junit.jupiter.api.DisplayName;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

@DisplayName("Test on Query Runner")
public class TestQueryRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ParkingLotTester.class, CarTester.class, InputParserTester.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}

