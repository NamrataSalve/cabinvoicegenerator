package org.example;
public class InvoiceGenerator {

    public static final int costTime=1;
    public static final double costPerKilometer=10;
    public static final double minFare=5;
    private final RideRepository rideRepository;

    public InvoiceGenerator(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    public double calculateFare(double distance, int time) {

        double totalFare=(distance*costPerKilometer)+(time*costTime);
        if (totalFare<minFare){
            return minFare;
        }
        return totalFare;
    }

    public InvoiceSummary calculateFare(int userId) {
        Rides[] rides = rideRepository.getRides(userId);
        double totalFare = 0;
        for (Rides ride : rides) {
            totalFare += calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }
    public double calculateFareForMultipleRides(Rides[] rides) {
        double totalFare = 0;
        for (Rides ride : rides) {
            totalFare += calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }

}