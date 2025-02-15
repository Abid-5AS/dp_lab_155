public class LuxuryRide implements RideType{
    @Override
    public double calculateFare(double distance) {
        double basRate = 2.0;
        double luxuryTax = 5.0;
        return (distance*basRate) + luxuryTax;
    }
}
