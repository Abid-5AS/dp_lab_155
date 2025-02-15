public class RideSharingApplication {
    public static void main(String[] args) {
        PaymentMethod creditCard = new CreditCardPayment();
        PaymentMethod payPal = new PayPalPayment();
        PaymentMethod digitalWallet = new DigitalWalletPayment();
        RideType carpool = new CarpoolRide();
        RideType luxury = new LuxuryRide();
        RideType bike = new BikeRide();

        NotificationStrategy smsNotification = new SMSNotification();
        NotificationStrategy emailNotification = new EmailNotification();
        NotificationStrategy inAppNotification = new InAppNotification();

        Admin admin = new Admin("A1", "AdminUser", "SuperAdmin");

        Driver driver1 = new Driver("D1", "Alice", "Sedan", "Downtown", 4.5, true, smsNotification);
        admin.addDriver(driver1);

        Rider rider1 = new Rider("R1", "Bob", "Uptown", 4.0, creditCard, emailNotification);
        admin.addRider(rider1);


        double distance = 10.0;
        Trip trip = rider1.requestRide("Uptown", "Downtown", luxury, distance);

        trip.calculateFare();

        driver1.acceptRide(trip);

        driver1.startTrip();

        trip.completeTrip();

        rider1.rateDriver(driver1, 5.0);
        driver1.rateRider(rider1, 4.5);

        rider1.makePayment(creditCard, trip.getFare());

        admin.recordTrip(trip);
        admin.viewTripHistory();
        admin.handleDispute("Issue with trip ID: " + trip);
    }
}
