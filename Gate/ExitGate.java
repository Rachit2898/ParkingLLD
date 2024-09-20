package Gate;

import ParkingManager.ParkingSpotManagerFactory;
import ParkingSpot.ParkingSpot;
import Ticket.Ticket;
import Vehicle.Vehicle;
import ParkingManager.ParkingSpotManager;

import java.util.List;

public class ExitGate {
    ParkingSpotManagerFactory factory;
    List<ParkingSpot> spots;

    public ExitGate(ParkingSpotManagerFactory factory, List<ParkingSpot> spots) {
        this.factory = factory;
        this.spots = spots;
    }

    public void removeVehicle(Ticket ticket) {
        ParkingSpotManager manager = factory.getParkingSpotManager(ticket.vehicle.vehicleType, spots);
        manager.removeVehicle(ticket.vehicle);
    }
}
