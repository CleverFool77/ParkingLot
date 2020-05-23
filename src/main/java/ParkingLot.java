import com.google.common.collect.HashBiMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Lists;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;

public class ParkingLot {
    private Integer capacitySize;
    private ArrayList<String> emptySlots;
    private HashBiMap<String, Car> assignSlotsToCars;

    public ParkingLot(int capacitySize) {
        this.capacitySize = checkNotNull(capacitySize);
        this.emptySlots = Lists.newArrayList();
        this.assignSlotsToCars =  HashBiMap.create();
    }

    public int getCapacitySize() {
        return this.capacitySize;
    }

    public ArrayList<String> getEmptySlots() {
        return this.emptySlots;
    }

    public HashBiMap<String, Car> getAssignSlotsToCars() {
        return this.getAssignSlotsToCars();
    }

    public void setCapacitySize(Integer capacitySize) {
        this.capacitySize = checkNotNull(capacitySize);
    }

    public void setEmptySlots(ArrayList<String> emptySlots) {
        this.emptySlots = checkNotNull(emptySlots);
    }

    public void setAssignSlotsToCars(HashBiMap<String, Car> assignSlotsToCars) {
        this.assignSlotsToCars = checkNotNull(assignSlotsToCars);
    }


}
