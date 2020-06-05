import java.util.List;

import static com.google.common.base.Preconditions.checkPositionIndex;

public class CommandUnPark implements Command {
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
