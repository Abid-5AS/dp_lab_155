public class Driver {
    private String id;
    private String name;
    private String vehicleType;
    private String location;
    private double rating;
    private boolean available;
    private NotificationStrategy notificationStrategy;

    public Driver(String id, String name, String vehicleType, String location, double rating,
                  boolean available, NotificationStrategy notificationStrategy) {
        this.id = id;
        this.name = name;
        this.vehicleType = vehicleType;
        this.location = location;
        this.rating = rating;
        this.available = available;
        this.notificationStrategy = notificationStrategy;
    }

    public void acceptRide(Trip trip) {
        if (available) {
            trip.assignDriver(this);
            System.out.println(name + " accepted the ride request.");
            notificationStrategy.sendNotification("Driver " + name + " is on the way!");
            available = false;
        } else {
            System.out.println(name + " is not available to take the ride.");
        }
    }

    public void rateRider(Rider rider, double rating) {
        System.out.println(name + " rated rider " + rider.getName() + " with " + rating + " stars.");
    }

    public void updateLocation(String newLocation) {
        this.location = newLocation;
        System.out.println(name + "'s location updated to " + newLocation);
    }

    public void startTrip() {
        System.out.println(name + " started the trip.");
        notificationStrategy.sendNotification("Trip has started!");
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return available;
    }
}
