import com.google.common.collect.HashBiMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/*
* @class ParkingLot helps in
* creating a parking lot
* */
@Singleton
public class ParkingLotImpl implements ParkingLot{
    private Integer capacitySize;
    private ArrayList<Integer> emptySlots;
    private HashBiMap<Integer, Car> assignCarToSlots;

    @Inject
    public ParkingLotImpl(Integer capacitySize) {
        this.capacitySize = capacitySize;
        this.emptySlots = Lists.newArrayList();
        this.assignCarToSlots =  HashBiMap.create();
    }

    @Override
    public int getCapacitySize() {
        return this.capacitySize;
    }

    @Override
    public ArrayList<Integer> getEmptySlots() {
        return this.emptySlots;
    }

    @Override
    public HashBiMap<Integer, Car> getAssignCarToSlots() {
        return this.assignCarToSlots;
    }

    @Override
    public void setCapacitySize(Integer capacitySize) {
        this.capacitySize = capacitySize;
    }

    @Override
    public void setEmptySlots(ArrayList<Integer> emptySlots) {
        this.emptySlots = emptySlots;
    }

    @Override
    public void setAssignCarToSlots(HashBiMap<Integer, Car> assignCarToSlots) {
        this.assignCarToSlots = assignCarToSlots;
    }

    @Override
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
    public Integer park(Car car) {
        if (this.capacitySize == 0) {
            System.out.println("Sorry, parking lot is not created yet");
        } else if (this.emptySlots.isEmpty()) {
            System.out.println("Sorry, parking lot is full");
        } else {
            return parkCar(car);
        }
        return -1;
    }

    @Override
    public Integer parkCar(Car car) {
        Collections.sort(this.emptySlots);
        Integer emptylot = this.emptySlots.get(0);
        Car newCar = car;
        if  (!this.assignCarToSlots.containsKey(emptylot)) {
            this.assignCarToSlots.put(emptylot, newCar);
            this.emptySlots.remove(0);
            return emptylot;
        }
        return -1;
    }

    @Override
    public Integer unParkCar(Integer slotNumber) {
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
                    return slotNumber;
                }
            } else {
                System.out.println("Slot Number is already unassigned or unempty");
            }

        }
        return -1;
    }

    @Override
    public ArrayList<String> registrationNumWithColor(String color) {
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
        return registrationNumList;
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
    public ArrayList<Integer> slotNumWithColor(String Color) {
        ArrayList<Integer> slotNumWithColorList = new ArrayList<>();
        this.assignCarToSlots.forEach((key, value) -> {
            if (value.getColor().equals(Color)) {
                slotNumWithColorList.add(key);
                // System.out.println("Registration Number" + key);
            }
        });
        return slotNumWithColorList;
    }

    @Override
    public ArrayList<String> checkStatus() {
        ArrayList<String> statusList = new ArrayList<>();
        if(this.assignCarToSlots.isEmpty()) {
            System.out.println("Empty Parking Lot !!");
        } else {
            for (Map.Entry<Integer, Car> assignedLot : this.assignCarToSlots.entrySet()) {
                statusList.add(assignedLot.getKey().toString() + " "
                        + assignedLot.getValue().getRegistrationNum() + " "
                        + assignedLot.getValue().getColor());
            }
        }

        return statusList;
    }

}

