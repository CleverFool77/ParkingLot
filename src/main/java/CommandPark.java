import java.util.List;

import static com.google.common.base.Preconditions.checkPositionIndex;

public class CommandPark implements Command{
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
