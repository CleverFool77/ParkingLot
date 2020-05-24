import com.google.common.collect.HashBiMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class ParkingLotImpl implements ParkingLot{
    private Integer capacitySize;
    private ArrayList<Integer> emptySlots;
    private HashBiMap<Integer, Car> assignCarToSlots;

    @Inject
    public ParkingLotImpl(Integer capacitySize) {
        this.capacitySize = checkNotNull(capacitySize);
        this.emptySlots = Lists.newArrayList();
        this.assignCarToSlots =  HashBiMap.create();
    }

    public int getCapacitySize() {
        return this.capacitySize;
    }

    public ArrayList<Integer> getEmptySlots() {
        return this.emptySlots;
    }

    public HashBiMap<Integer, Car> getAssignCarToSlots() {
        return this.assignCarToSlots;
    }

    public void setCapacitySize(Integer capacitySize) {
        this.capacitySize = checkNotNull(capacitySize);
    }

    public void setEmptySlots(ArrayList<Integer> emptySlots) {
        this.emptySlots = checkNotNull(emptySlots);
    }

    public void setAssignCarToSlots(HashBiMap<Integer, Car> assignCarToSlots) {
        this.assignCarToSlots = checkNotNull(assignCarToSlots);
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

    @Override
    public void park(Car car) {
        if (this.capacitySize == 0) {
            System.out.println("Sorry, parking lot is not created yet");
        } else if (this.emptySlots.isEmpty()) {
            System.out.println("Sorry, parking lot is full");
        } else {
            parkCar(car);
        }
    }

    @Override
    public void parkCar(Car car) {
        Collections.sort(this.emptySlots);
        Integer emptylot = this.emptySlots.get(0);
        Car newCar = car;
        if  (!this.assignCarToSlots.containsKey(emptylot)) {
            this.assignCarToSlots.put(emptylot, newCar);
            System.out.println("Allocated slot number : " + emptylot);
            this.emptySlots.remove(0);
        }
    }

    @Override
    public void unParkCar(Integer slotNumber) {
        System.out.println("I'm inside unpark");
        if (this.capacitySize == 0) {
            System.out.println("Parking lot is not created");
        } else if (this.assignCarToSlots.size() == 0) {
            System.out.println("Parking lot is empty, LOL");
        } else {
            if (this.assignCarToSlots.containsKey(slotNumber)) {
                Car unparkthisCar = this.assignCarToSlots.get(slotNumber);
                if (unparkthisCar != null) {
                    this.assignCarToSlots.remove(slotNumber);
                    this.emptySlots.add(slotNumber);
                    System.out.println("Car at " + slotNumber + " is now unparked");
                }
            } else {
                System.out.println("Slot Number is already unassigned or unempty");
            }

        }
    }

    @Override
    public void registrationNumWithColor(String color) {
        Collection<Car> carList = this.assignCarToSlots.values();
        ArrayList<String> registrationNumList = new ArrayList<>();
        for (Car oneCar : carList) {
            if (oneCar.getColor().equals(color)) {
                registrationNumList.add(oneCar.getRegistrationNum());
            }
        }
        if (registrationNumList.size() <= 0) {
            System.out.println("No Car or registration Number with " +
                    "particular color is found");
        }
        for (String oneRegNum : registrationNumList) {
            System.out.println(oneRegNum);
        }
    }

    @Override
    public void slotNumsWithResistrationNum(String registrationNum) {
        this.assignCarToSlots.forEach((key, value) -> {
            if (value.getRegistrationNum().equals(registrationNum)) {
                System.out.println("Slot Number " + key);
            }
        });
    }

    @Override
    public void slotNumWithColor(String Color) {
        ArrayList<Integer> slotNumWithColorList = new ArrayList<>();
        this.assignCarToSlots.forEach((key, value) -> {
            if (value.getColor().equals(Color)) {
                slotNumWithColorList.add(key);
                // System.out.println("Registration Number" + key);
            }
        });
        for (Integer oneslotNum : slotNumWithColorList) {
            System.out.println(oneslotNum);
        }
    }

    @Override
    public void checkStatus() {
        for (Map.Entry<Integer, Car> assignedLot : this.assignCarToSlots.entrySet()) {
            System.out.println(assignedLot.getKey() + " "
                    + assignedLot.getValue().getRegistrationNum() + " "
                    + assignedLot.getValue().getColor());
        }
        System.out.println("sjfhjfkhsk");
    }

}

