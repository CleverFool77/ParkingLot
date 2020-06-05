import java.util.List;

import static com.google.common.base.Preconditions.checkPositionIndex;

public class CommandCreate implements Command {

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