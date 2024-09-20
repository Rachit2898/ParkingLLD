package Ticket;

import ParkingSpot.ParkingSpot;
import Vehicle.Vehicle;

public class Ticket {
    public long entryTime;
    public ParkingSpot parkingSpot;
    public Vehicle vehicle;

    public Ticket(long entryTime, ParkingSpot parkingSpot, Vehicle vehicle) {
        this.entryTime = entryTime;
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Ticket{" + "entryTime=" + entryTime + ", parkingSpot=" + parkingSpot + ", vehicle=" + vehicle + '}';
    }
}
