// FourWheelerManager.java
package ParkingManager;

import ParkingSpot.ParkingSpot;
import java.util.List;

public class FourWheelerManager extends ParkingSpotManager {
    public FourWheelerManager(List<ParkingSpot> spots) {
        super(spots);
    }

    @Override
    public ParkingSpot findParkingSpace() {
        for (ParkingSpot spot : spots) {
            if (spot.isEmpty && spot.price == 20) { 
                return spot;
            }
        }
        return null;
    }
}
