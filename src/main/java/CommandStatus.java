import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkPositionIndex;

public class CommandStatus implements Command {

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