public class Trip {
    private String id;
    private String pickupLocation;
    private String dropOffLocation;
    private RideType rideType;
    private String status;
    private double fare;
    private double distance;
    private Rider rider;
    private Driver driver;
    private PaymentMethod paymentMethod;
    private NotificationStrategy notificationStrategy;

    public Trip(String id, String pickupLocation, String dropOffLocation, RideType rideType, String status,
                double distance, Rider rider, PaymentMethod paymentMethod,
                NotificationStrategy notificationStrategy) {
        this.id = id;
        this.pickupLocation = pickupLocation;
        this.dropOffLocation = dropOffLocation;
        this.rideType = rideType;
        this.status = status;
        this.distance = distance;
        this.rider = rider;
        this.paymentMethod = paymentMethod;
        this.notificationStrategy = notificationStrategy;
    }


    public void calculateFare() {
        fare = rideType.calculateFare(distance);
        System.out.println("Estimated fare for the trip: $" + fare);
    }

    public void assignDriver(Driver driver) {
        this.driver = driver;
        this.status = "DRIVER_ASSIGNED";
        System.out.println("Driver " + driver.getName() + " assigned to trip " + id);
        rider.getNotificationStrategy().sendNotification("Driver " + driver.getName() + " has been assigned to your trip!");
    }

    public void completeTrip() {
        this.status = "COMPLETED";
        System.out.println("Trip " + id + " has been completed.");
        paymentMethod.processPayment(fare);
        notificationStrategy.sendNotification("Trip " + id + " completed. Payment of $" + fare + " processed.");
    }

    public double getFare() {
        return fare;
    }
}
