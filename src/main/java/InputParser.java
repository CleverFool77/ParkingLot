import com.google.common.base.Splitter;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.assistedinject.FactoryModuleBuilder;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkPositionIndex;

/* This class deals with further parsing of the input and
 *  and cals object to run command */

public class InputParser {
	private List<String> wordsOfInput;
	private ParkingLot newLot;
	private CarFactory factory;
	@Inject
	InputParser(ParkingLot newLot, CarFactory factory) {
		this.newLot = newLot;
		this.factory = factory;
	}

	public void parseTheInputWords(String input) {
		this.wordsOfInput = Splitter.on(' ').trimResults().omitEmptyStrings().splitToList(input);
	}

	public List<String> getTheInputWords() {
		return this.wordsOfInput;
	}

	public void inputDataParser() {
		try {
			String query = checkNotNull(this.wordsOfInput.get(0), "Invalid command !! Enter command");
			CommandFactory commandFactory = new CommandFactory(factory);
			Command command = commandFactory.getCommand(query.toLowerCase());
			command.runCommand(this.newLot, this.wordsOfInput);
		} catch (NullPointerException e) {
      		System.out.println(e);
		}
	}
}
