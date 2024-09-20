package ParkingSpot;

import Vehicle.Vehicle;

public class ParkingSpot {
    public int id;
    public boolean isEmpty;
    public Vehicle vehicle;
    public int price;

    public ParkingSpot(int id, int price) {
        this.id = id;
        this.isEmpty = true;
        this.vehicle = null;
        this.price = price;
    }

    public void parkVehicle(Vehicle v) {
        this.vehicle = v;
        this.isEmpty = false;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.isEmpty = true;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" + "id=" + id + ", isEmpty=" + isEmpty + ", vehicle=" + vehicle + ", price=" + price + '}';
    }
}
