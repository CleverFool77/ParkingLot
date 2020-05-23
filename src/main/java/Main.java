import com.google.common.base.Splitter;
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputParser inputParser = new InputParser();
        while (true) {
            String inputLine = scanner.nextLine();
            inputParser.getTheInputWords(inputLine);
            inputParser.inputDataParser();
        }

    }
}
