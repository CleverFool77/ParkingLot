import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkPositionIndex;

public class CommandSlotNumForColor implements Command {

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