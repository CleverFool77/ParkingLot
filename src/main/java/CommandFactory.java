public class CommandFactory {
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
				System.out.println("Invalid Command.Command !!");
		}

		return null;
	}
}

