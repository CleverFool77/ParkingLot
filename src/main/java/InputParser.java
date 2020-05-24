import com.google.common.base.Splitter;
import com.google.inject.AbstractModule;

import java.util.List;
import javax.annotation.Nullable;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkPositionIndex;

public class InputParser {
    private List<String> wordsOfInput;
    private ParkingLot newLot = new ParkingLot(0);

    public void getTheInputWords(@Nullable String input) {
        this.wordsOfInput = Splitter.on(' ').trimResults().omitEmptyStrings().splitToList(input);
    }

    public void inputDataParser() {
        String query = checkNotNull(this.wordsOfInput.get(0), "Invalid command !! Enter command");
        switch (query) {
            case "create_parking_lot":
                checkPositionIndex(
                        1,
                        this.wordsOfInput.size(),
                        "IndexOufBound Error !!" + "Please provide the slot Number to create parking lot");
                Integer totalSlotNumbers = Integer.parseInt(this.wordsOfInput.get(1));
                this.newLot.createParkingLot(totalSlotNumbers);
                break;
            case "park":
                checkPositionIndex(
                        1,
                        this.wordsOfInput.size(),
                        "IndexOufBound Error !!" + "Please provide both registration Number and color");
                String registrationNum = this.wordsOfInput.get(1);
                String color = this.wordsOfInput.get(2);
                this.newLot.parkVehicle(registrationNum, color);
                break;
            case "leave":
                checkPositionIndex(
                        1,
                        this.wordsOfInput.size(),
                        "IndexOufBound Error !!" + "Please provide the slot Number to unpark");
                Integer unparkSlotNum = Integer.parseInt(this.wordsOfInput.get(1));
                this.newLot.unParkCar(unparkSlotNum);
                break;
            case "status":
                this.newLot.checkStatus();
                break;
            case "registration_numbers_for_cars_with_colour":
                checkPositionIndex(
                        1, this.wordsOfInput.size(), "IndexOufBound Error !!" + "Please provide the color");
                String colorForRegNum = this.wordsOfInput.get(1);
                this.newLot.registrationNumWithColor(colorForRegNum);
                break;
            case "slot_numbers_for_cars_with_colour":
                checkPositionIndex(
                        1, this.wordsOfInput.size(), "IndexOufBound Error !! " + "Please provide the color");
                String colorForSlotNum = this.wordsOfInput.get(1);
                this.newLot.slotNumWithColor(colorForSlotNum);
                break;
            case "slot_number_for_registration_number":
                checkPositionIndex(
                        1,
                        this.wordsOfInput.size(),
                        "IndexOufBound Error !! " + "Please provide registration Number");
                String regNumForSlotNum = this.wordsOfInput.get(1);
                this.newLot.slotNumsWithResistrationNum(regNumForSlotNum);
                break;
            case "exit":
                System.exit(1);
                break;
            default:
                System.out.println("Invalid Command !! GG");
        }
    }

    public static class CarModule extends AbstractModule {

        @Override
        protected void configure() {
            bind(Vehicle.class).to(Car.class);
        }
    }
}
