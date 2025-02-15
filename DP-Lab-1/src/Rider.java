import java.util.UUID;

public class Rider {
    private String id;
    private String name;
    private String location;
    private double rating;
    private PaymentMethod preferredPaymentMethod;
    private NotificationStrategy notificationStrategy;

    public Rider(String id, String name, String location, double rating,
                 PaymentMethod preferredPaymentMethod, NotificationStrategy notificationStrategy) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.rating = rating;
        this.preferredPaymentMethod = preferredPaymentMethod;
        this.notificationStrategy = notificationStrategy;
    }

    public Trip requestRide(String pickupLocation, String dropOffLocation, RideType rideType,
                            double distance) {
        System.out.println(name + " is requesting a ride from " + pickupLocation + " to " + dropOffLocation);
        return new Trip(UUID.randomUUID().toString(), pickupLocation, dropOffLocation,
                rideType, "REQUESTED", distance, this,
                preferredPaymentMethod, notificationStrategy);
    }

    public void rateDriver(Driver driver, double rating) {
        System.out.println(name + " rated driver " + driver.getName() + " with " + rating + " stars.");
    }

    public void makePayment(PaymentMethod paymentMethod, double amount) {
        System.out.println(name + " is making a payment of $" + amount);
        paymentMethod.processPayment(amount);
    }

    public String getName() {
        return name;
    }

    public NotificationStrategy getNotificationStrategy() {
        return notificationStrategy;
    }
}
