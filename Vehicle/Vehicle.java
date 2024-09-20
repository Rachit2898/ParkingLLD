
package Vehicle;

public class Vehicle {
    public int vehicleNo;
    public VehicleType vehicleType;

    public Vehicle(int vehicleNo, VehicleType vehicleType) {
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "vehicleNo=" + vehicleNo + ", vehicleType=" + vehicleType + '}';
    }
}
