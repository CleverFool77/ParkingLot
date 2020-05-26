import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkPositionIndex;

public class CommandRegNumForColor implements Command {
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