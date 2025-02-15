public class BikeRide implements RideType{
    @Override
    public double calculateFare(double distance) {
        double baseRate = 0.75;
        return distance*baseRate;
    }
}
