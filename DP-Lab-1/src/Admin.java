import java.util.ArrayList;
import java.util.List;

public class Admin {
    private String id;
    private String name;
    private String role;
    private List<Driver> drivers;
    private List<Rider> riders;
    private List<Trip> tripHistory;

    public Admin(String id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
        drivers = new ArrayList<>();
        riders = new ArrayList<>();
        tripHistory = new ArrayList<>();
    }

    public void addDriver(Driver driver) {
        drivers.add(driver);
        System.out.println("Admin added driver: " + driver.getName());
    }

    public void addRider(Rider rider) {
        riders.add(rider);
        System.out.println("Admin added rider: " + rider.getName());
    }

    public void recordTrip(Trip trip) {
        tripHistory.add(trip);
        System.out.println("Admin recorded trip with ID: " + trip);
    }

    public void viewTripHistory() {
        System.out.println("Trip History:");
        for (Trip trip : tripHistory) {
            System.out.println(trip);
        }
    }

    public void handleDispute(String disputeDetails) {
        System.out.println("Admin handling dispute: " + disputeDetails);
    }

    public void manageDriver(Driver driver) {
        System.out.println("Admin managing driver: " + driver.getName());
    }

    public void manageRider(Rider rider) {
        System.out.println("Admin managing rider: " + rider.getName());
    }
}
