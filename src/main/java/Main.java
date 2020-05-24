import com.google.common.base.Splitter;
import com.google.inject.Guice;
import com.google.inject.Injector;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Injector injector = Guice.createInjector(new ParkingLotModule(), new VehicleModule());
        InputParser inputParser = injector.getInstance(InputParser.class);
        while (true) {
            String inputLine = scanner.nextLine();
            inputParser.getTheInputWords(inputLine);
            inputParser.inputDataParser();
        }

    }
}
