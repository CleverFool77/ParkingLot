import java.util.List;

import static com.google.common.base.Preconditions.checkPositionIndex;

public class CommandSlotNumForRegNum implements Command {

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