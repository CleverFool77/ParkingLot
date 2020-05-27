import java.util.List;

/* @Class Command is the interface for all
* classes of all commnads
* */
public interface Command {
	void runCommand(ParkingLot newLot, List<String> wordsOfInput);
}
