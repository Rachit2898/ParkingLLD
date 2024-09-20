// TwoWheelerManager.java
package ParkingManager;

import ParkingSpot.ParkingSpot;
import java.util.List;

public class TwoWheelerManager extends ParkingSpotManager {
    public TwoWheelerManager(List<ParkingSpot> spots) {
        super(spots);
    }

    @Override
    public ParkingSpot findParkingSpace() {
        for (ParkingSpot spot : spots) {
            if (spot.isEmpty && spot.price == 10) { 
                return spot;
            }
        }
        return null;
    }
}
