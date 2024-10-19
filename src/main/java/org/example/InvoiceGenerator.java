package org.example;

public class InvoiceGenerator {

    // Normal ride rates
    public static final int NORMAL_COST_TIME = 1;
    public static final double NORMAL_COST_PER_KILOMETER = 10;
    public static final double NORMAL_MIN_FARE = 5;

    // Premium ride rates
    public static final int PREMIUM_COST_TIME = 2;
    public static final double PREMIUM_COST_PER_KILOMETER = 15;
    public static final double PREMIUM_MIN_FARE = 20;

    private final RideRepository rideRepository;

    public InvoiceGenerator(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    // Calculate fare based on ride type (Normal or Premium)
    public double calculateFare(double distance, int time, String rideType) {
        double totalFare;

        if (rideType.equalsIgnoreCase("premium")) {
            totalFare = (distance * PREMIUM_COST_PER_KILOMETER) + (time * PREMIUM_COST_TIME);
            return totalFare < PREMIUM_MIN_FARE ? PREMIUM_MIN_FARE : totalFare;
        } else {
            totalFare = (distance * NORMAL_COST_PER_KILOMETER) + (time * NORMAL_COST_TIME);
            return totalFare < NORMAL_MIN_FARE ? NORMAL_MIN_FARE : totalFare;
        }
    }

    public InvoiceSummary calculateFare(int userId) {
        Rides[] rides = rideRepository.getRides(userId);
        double totalFare = 0;
        for (Rides ride : rides) {
            totalFare += calculateFare(ride.distance, ride.time, ride.rideType);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    public double calculateFareForMultipleRides(Rides[] rides) {
        double totalFare = 0;
        for (Rides ride : rides) {
            totalFare += calculateFare(ride.distance, ride.time, ride.rideType);
        }
        return totalFare;
    }
}
