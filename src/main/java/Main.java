import com.google.inject.Guice;
import com.google.inject.Injector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
* <h1> Hello <h1>
* Implementation of CarModule.ParkingLot problem using Java, Google guice,
* guava and tested using Junit-Mockito.
* @author Lekhika Dugtal
* */

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Injector injector = Guice.createInjector(new ParkingLotModule(), new CarModule());
		InputParser inputParser = injector.getInstance(InputParser.class);

		System.out.println("Hello !! \n" +
				"To Futher Continue Press 1 or 2 \n" +
				"1. File Method for input\n" +
				"2. Interfactive Method");

		while (true) {
			Integer option = Integer.parseInt(scanner.nextLine());
			switch (option) {
				case 1:
					File file = new File("src/test.txt");
					try {
						BufferedReader br = new BufferedReader(new FileReader(file));
						String line;
						while ((line = br.readLine()) != null) {
							System.out.println(line);
							inputParser.parseTheInputWords(line);
							inputParser.inputDataParser();
						}
						System.out.println("Done");
						System.exit(0);
					} catch (IOException e) {
						System.out.println(e);
					}
					break;
				case 2:
					while (true) {
						String inputLine = scanner.nextLine();
						inputParser.parseTheInputWords(inputLine);
						inputParser.inputDataParser();
					}
				default:
					System.out.println("Invalid command !! Continue !! ");

			}
		}
	}
}
