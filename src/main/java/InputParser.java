import com.google.common.base.Splitter;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.assistedinject.FactoryModuleBuilder;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkPositionIndex;

/* This class deals with further parsing of the input and
 *  helps in envking method based on command */

public class InputParser {
	private List<String> wordsOfInput;
	private ParkingLot newLot;
	private CarFactory factory;
	@Inject
	InputParser(ParkingLot newLot, CarFactory factory) {
		this.newLot = newLot;
		this.factory = factory;
	}

	public void parseTheInputWords(String input) {
		this.wordsOfInput = Splitter.on(' ').trimResults().omitEmptyStrings().splitToList(input);
	}

	public List<String> getTheInputWords() {
		return this.wordsOfInput;
	}

	public void inputDataParser() {
		try {
			String query = checkNotNull(this.wordsOfInput.get(0), "Invalid command !! Enter command");
			CommandFactory commandFactory = new CommandFactory(factory);
			Command command = commandFactory.getCommand(query.toLowerCase());
			command.runCommand(this.newLot, this.wordsOfInput);
		} catch (NullPointerException e) {
      		System.out.println(e);
		}
	}

	public static class CarModule extends AbstractModule {

		@Override
		protected void configure() {
			install(
					new FactoryModuleBuilder().implement(Car.class, CarImpl.class).build(CarFactory.class));
		}
	}

	public static interface Command {
		void runCommand(ParkingLot newLot, List<String> wordsOfInput);
	}

	public static class CommandCreate implements Command {

		@Override
		public void runCommand(ParkingLot newLot, List<String> wordsOfInput) {
			checkPositionIndex(
					1,
					wordsOfInput.size(),
					"IndexOufBound Error !!" + "Please provide the slot Number to create parking lot");
			Integer totalSlotNumbers = Integer.parseInt(wordsOfInput.get(1));
			newLot.createParkingLot(totalSlotNumbers);
		}
	}

	public static class CommandFactory {
		CarFactory factory;

		CommandFactory(CarFactory factory){
			this.factory = factory;
		}

		public Command getCommand(String command) {

			switch (command) {

				case "create_parking_lot":
					return new CommandCreate();
				case "park":
					return new CommandPark(factory);
				case "leave":
					return new CommandUnPark();
				case "status":
					return new CommandStatus();
				case "registration_numbers_for_cars_with_colour":
					return new CommandRegNumForColor();
				case "slot_numbers_for_cars_with_colour":
					return new CommandSlotNumForColor();
				case "slot_number_for_registration_number":
					return new CommandSlotNumForRegNum();
				case "exit":
					System.exit(0);
				default:
					System.out.println("Invalid InputParser.Command !!");
			}

			return null;
		}
	}

	public static class CommandPark implements Command {
		private CarFactory factory;

		CommandPark(CarFactory factory) {
			this.factory = factory;
		}

		@Override
		public void runCommand(ParkingLot newLot, List<String> wordsOfInput) {
			checkPositionIndex(
					2,
					wordsOfInput.size(),
					"IndexOufBound Error !!" + "Please provide both registration Number and color");
			String registrationNum = wordsOfInput.get(1);
			String color = wordsOfInput.get(2);
			Car car = factory.create(registrationNum, color);
			Integer allotedSlot = newLot.park(car);
			if (!allotedSlot.equals(-1)) {
				System.out.println("Alloted at " + allotedSlot);
			}
		}
	}

	public static class CommandRegNumForColor implements Command {
		@Override
		public void runCommand(ParkingLot newLot, List<String> wordsOfInput) {
			checkPositionIndex(
					1, wordsOfInput.size(), "IndexOufBound Error !!" + "Please provide the color");
			String colorForRegNum = wordsOfInput.get(1);
			ArrayList<String> registrationNumList =
					newLot.registrationNumWithColor(colorForRegNum);
			if (!registrationNumList.isEmpty()) {
				for (String oneRegNum : registrationNumList) {
					System.out.println(oneRegNum);
				}
			}
		}
	}

	public static class CommandSlotNumForColor implements Command {

		@Override
		public void runCommand(ParkingLot newLot, List<String> wordsOfInput) {
			checkPositionIndex(
					1, wordsOfInput.size(), "IndexOufBound Error !! " + "Please provide the color");
			String colorForSlotNum = wordsOfInput.get(1);
			ArrayList<Integer> slotNumWithColorList = newLot.slotNumWithColor(colorForSlotNum);
			if (!slotNumWithColorList.isEmpty()) {
				for (Integer oneslotNum : slotNumWithColorList) {
					System.out.println(oneslotNum);
				}
			}
		}
	}

	public static class CommandSlotNumForRegNum implements Command {

		@Override
		public void runCommand(ParkingLot newLot, List<String> wordsOfInput) {
			checkPositionIndex(
					1,
					wordsOfInput.size(),
					"IndexOufBound Error !! " + "Please provide registration Number");
			String regNumForSlotNum = wordsOfInput.get(1);
			newLot.slotNumsWithResistrationNum(regNumForSlotNum);
		}
	}

	public static class CommandStatus implements Command {

		@Override
		public void runCommand(ParkingLot newLot, List<String> wordsOfInput) {
			ArrayList<String> statusList = newLot.checkStatus();
			if (!statusList.isEmpty()) {
				for (String oneStatus : statusList) {
					System.out.println(oneStatus);
				}
			}
		}
	}

	public static class CommandUnPark implements Command {
		@Override
		public void runCommand(ParkingLot newLot, List<String> wordsOfInput) {
			checkPositionIndex(
					1,
					wordsOfInput.size(),
					"IndexOufBound Error !!" + "Please provide the slot Number to unpark");
			Integer unparkSlotNum = Integer.parseInt(wordsOfInput.get(1));
			Integer slotNumber = newLot.unParkCar(unparkSlotNum);
			if (!slotNumber.equals(-1)) {
				System.out.println("Car at " + slotNumber + " is now unparked");
			}
		}
	}
}
