import java.util.*;
import ParkingManager.ParkingSpotManagerFactory;
import ParkingSpot.ParkingSpot;
import Vehicle.Vehicle;
import Vehicle.VehicleType;
import Ticket.Ticket;
import Gate.EntranceGate;
import Gate.ExitGate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize parking spots
        List<ParkingSpot> spots = new ArrayList<>();
        for (int i = 1; i <= 100; ++i) {
            if (i <= 50)
                spots.add(new ParkingSpot(i, 10)); // Two Wheeler spots
            else
                spots.add(new ParkingSpot(i, 20)); // Four Wheeler spots
        }

        // Create ParkingSpotManagerFactory
        ParkingSpotManagerFactory factory = new ParkingSpotManagerFactory();

        // Create EntranceGate and ExitGate objects
        EntranceGate entranceGate = new EntranceGate(factory);
        ExitGate exitGate = new ExitGate(factory, spots);

        // Map to store vehicle number to ticket mapping
        Map<Integer, Ticket> vehicleTicketMap = new HashMap<>();

        while (true) {
            System.out.println("\n1. Park Vehicle");
            System.out.println("2. Exit Vehicle");
            System.out.println("3. Show Parking Status");
            System.out.println("4. Exit Program");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    // User input for vehicle type
                    System.out.println("Enter vehicle number: ");
                    int vehicleNo = scanner.nextInt();

                    System.out.println("Enter vehicle type (1 for Two Wheeler, 2 for Four Wheeler): ");
                    int vehicleTypeInput = scanner.nextInt();
                    VehicleType vehicleType = (vehicleTypeInput == 1) ? VehicleType.TwoWheeler : VehicleType.FourWheeler;

                    // Create a vehicle
                    Vehicle vehicle = new Vehicle(vehicleNo, vehicleType);

                    // Find parking space
                    ParkingSpot spot = entranceGate.findParkingSpace(vehicle.vehicleType, spots);
                    if (spot == null) {
                        System.out.println("No parking space available.");
                        break;
                    }

                    // Generate a ticket and store it in the map
                    Ticket ticket = entranceGate.generateTicket(vehicle, spot);
                    vehicleTicketMap.put(vehicleNo, ticket);

                    System.out.println("Parking ticket generated: " + ticket);
                    System.out.println("Vehicle parked at spot: " + spot.id);
                    break;
                }

                case 2: {
                    // Exit a vehicle by vehicle number
                    System.out.println("Enter vehicle number to exit: ");
                    int vehicleNo = scanner.nextInt();

                    // Check if the vehicle is parked
                    if (!vehicleTicketMap.containsKey(vehicleNo)) {
                        System.out.println("No vehicle found with that number.");
                        break;
                    }

                    // Retrieve the ticket
                    Ticket ticket = vehicleTicketMap.get(vehicleNo);

                    // Simulate exit time
                    System.out.println("Enter exit time in seconds: ");
                    long exitTime = scanner.nextLong();

                    // Vehicle leaves, remove the vehicle and ticket from map
                    exitGate.removeVehicle(ticket);
                    vehicleTicketMap.remove(vehicleNo);

                    System.out.println("Vehicle removed from spot: " + ticket.parkingSpot.id);
                    System.out.println("Total time parked: " + (exitTime - ticket.entryTime) + " seconds");
                    break;
                }

                case 3: {
                    // Display total strength and occupied spaces
                    displayParkingStatus(spots);
                    break;
                }

                case 4: {
                    System.out.println("Exiting program.");
                    return;
                }

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // Method to display the total strength and occupied spaces
    private static void displayParkingStatus(List<ParkingSpot> spots) {
        int totalSpots = spots.size();
        int occupiedSpots = 0;

        // Count the number of occupied spots
        for (ParkingSpot spot : spots) {
            if (spot.vehicle != null) {
                occupiedSpots++;
            }
        }

        System.out.println("Total Parking Strength: " + totalSpots);
        System.out.println("Occupied Spaces: " + occupiedSpots);
        System.out.println("Available Spaces: " + (totalSpots - occupiedSpots));
    }
}
