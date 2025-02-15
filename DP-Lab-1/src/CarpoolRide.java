public class CarpoolRide implements RideType{
    @Override
    public double calculateFare(double distance) {
        double baseRate = 1.0;
        return (distance*baseRate)/2;
    }
}
