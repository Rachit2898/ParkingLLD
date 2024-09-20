package Gate;

import ParkingManager.ParkingSpotManagerFactory;
import ParkingSpot.ParkingSpot;
import Ticket.Ticket;
import Vehicle.Vehicle;
import Vehicle.VehicleType;
import ParkingManager.ParkingSpotManager;

import java.util.List;

public class EntranceGate {
    ParkingSpotManagerFactory factory;

    public EntranceGate(ParkingSpotManagerFactory factory) {
        this.factory = factory;
    }

    public ParkingSpot findParkingSpace(VehicleType vehicleType, List<ParkingSpot> spots) {
        ParkingSpotManager manager = factory.getParkingSpotManager(vehicleType, spots);
        return manager.findParkingSpace();
    }

    public Ticket generateTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        long entryTime = System.currentTimeMillis() / 1000;
        parkingSpot.parkVehicle(vehicle);
        return new Ticket(entryTime, parkingSpot, vehicle);
    }
}
