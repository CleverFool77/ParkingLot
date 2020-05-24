import com.google.common.collect.HashBiMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class ParkingLot {
    private Integer capacitySize;
    private ArrayList<Integer> emptySlots;
    private HashBiMap<Integer, Car> assignCarsToSlots;

    @Inject
    public ParkingLot(Integer capacitySize) {
        this.capacitySize = checkNotNull(capacitySize);
        this.emptySlots = Lists.newArrayList();
        this.assignCarsToSlots =  HashBiMap.create();
    }

    public int getCapacitySize() {
        return this.capacitySize;
    }

    public ArrayList<Integer> getEmptySlots() {
        return this.emptySlots;
    }

    public HashBiMap<Integer, Car> getAssignSlotsToCars() {
        return this.getAssignSlotsToCars();
    }

    public void setCapacitySize(Integer capacitySize) {
        this.capacitySize = checkNotNull(capacitySize);
    }

    public void setEmptySlots(ArrayList<Integer> emptySlots) {
        this.emptySlots = checkNotNull(emptySlots);
    }

    public void setAssignSlotsToCars(HashBiMap<Integer, Car> assignSlotsToCars) {
        this.assignCarsToSlots = checkNotNull(assignSlotsToCars);
    }

    public void createParkingLot(Integer capacitySize) {
        if(capacitySize == 0 ) {
            System.out.println("parking Lot is already created");
        } else {
            this.capacitySize = capacitySize;
            for (int lotNum = 1; lotNum <= capacitySize; lotNum += 1) {
                this.emptySlots.add(lotNum);
            }
            System.out.println("Created a parking lot with " + this.capacitySize
                    + " slots");
        }
    }

    public void parkVehicle(String registrationNum, String color) {
        if (this.capacitySize == 0) {
            System.out.println("Sorry, parking lot is not created yet");
        } else if (this.emptySlots.isEmpty()) {
            System.out.println("Sorry, parking lot is full");
        } else {
            parkCar(registrationNum, color);
        }
    }

    public void parkCar(String registrationNum, String color) {
        Collections.sort(this.emptySlots);
        Integer emptylot = this.emptySlots.get(0);
        Car newCar = new Car(registrationNum, color);
        if  (!this.assignCarsToSlots.containsKey(emptylot)) {
            this.assignCarsToSlots.put(emptylot, newCar);
            System.out.println("Allocated slot number : " + emptylot);
            this.emptySlots.remove(0);
        }
    }

    public void unParkCar(Integer slotNumber) {
        System.out.println("I'm inside unpark");
        if (this.capacitySize == 0) {
            System.out.println("Parking lot is not created");
        } else if (this.assignCarsToSlots.size() == 0) {
            System.out.println("Parking lot is empty, LOL");
        } else { //  put one codntion to check if slot isnnot repsent in map at all
            if (this.assignCarsToSlots.containsKey(slotNumber)) {
                Car unparkthisCar = this.assignCarsToSlots.get(slotNumber);
                if (unparkthisCar != null) {
                    this.assignCarsToSlots.remove(slotNumber);
                    this.emptySlots.add(slotNumber);
                    System.out.println("Car at " + slotNumber + " is now unparked");
                }
            } else {
                System.out.println("Slot Number is already unassigned or unempty");
            }

        }
    }

    public void registrationNumWithColor(String color) {
        Collection<Car> carsList = this.assignCarsToSlots.values();
        ArrayList<String> registrationNumList = new ArrayList<>();
        for (Car oneCar : carsList) {
            if (oneCar.getColor().equals(color)) {
                registrationNumList.add(oneCar.getRegistrationNum());
            }
            if (registrationNumList.size() <= 0) {
                System.out.println("No car or registration Number with " +
                        "particular color is found");
            }
        }
        for (String oneRegNum : registrationNumList) {
            System.out.println(oneRegNum);
        }
    }

    public void slotNumsWithResistrationNum(String registrationNum) {
        this.assignCarsToSlots.forEach((key, value) -> {
            if (value.getRegistrationNum().equals(registrationNum)) {
                System.out.println("Slot Number " + key);
            }
        });
    }

    public void slotNumWithColor(String Color) {
        ArrayList<Integer> slotNumWithColorList = new ArrayList<>();
        this.assignCarsToSlots.forEach((key, value) -> {
            if (value.getColor().equals(Color)) {
                slotNumWithColorList.add(key);
                // System.out.println("Registration Number" + key);
            }
        });
        for (Integer oneslotNum : slotNumWithColorList) {
            System.out.println(oneslotNum);
        }
    }

    public void checkStatus() {
        for (Map.Entry<Integer, Car> assignedLot : this.assignCarsToSlots.entrySet()) {
            System.out.println(assignedLot.getKey() + " "
                    + assignedLot.getValue().getRegistrationNum() + " "
                    + assignedLot.getValue().getColor());
        }
        System.out.println("sjfhjfkhsk");
    }

}

