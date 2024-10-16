package org.example;
public class InvoiceGenerator {

    public static final int costTime=1;
    public static final double costPerKilometer=10;
    public static final double minFare=5;

    //function for calculate total fare

    public double calculateFare(double distance, int time) {
        double totalFare=(distance*costPerKilometer)+(time*costTime);
        if (totalFare<minFare){
            return minFare;
        }
        return totalFare;
    }

    // Inner class to represent a single ride
    public static class Ride {
        double distance;
        int time;

        public Ride(double distance, int time) {
            this.distance = distance;
            this.time = time;
        }
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
