package org.example;
public class InvoiceGenerator {

    public static final int costTime=1;
    public static final double costPerKilometer=10;
    public static final double minFare=5;

    // Inner class to represent a single ride
    public static class Ride {
        double distance;
        int time;

        public Ride(double distance, int time) {
            this.distance = distance;
            this.time = time;
        }
    }

    public double calculateFare(double distance, int time) {

        double totalFare=(distance*costPerKilometer)+(time*costTime);
        if (totalFare<minFare){
            return minFare;
        }
        return totalFare;
    }

    public InvoiceSummary calculateFare(Rides[] rides) {
        double totalFare=0;
        for (Rides ride : rides)
        {
            totalFare+=this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    // Method to calculate total fare for multiple rides
    public double calculateFareForMultipleRides(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }

}