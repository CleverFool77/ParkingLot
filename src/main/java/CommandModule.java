import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class CommandModule extends AbstractModule {
	@Override
	protected void configure() {}

	@Provides
	public Command providesCreateCommand() {
		Command command = new CommandCreate();
		return command;
	}
}
