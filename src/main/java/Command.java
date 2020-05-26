import java.util.List;


public interface Command {
	void runCommand(ParkingLot newLot, List<String> wordsOfInput);
}
