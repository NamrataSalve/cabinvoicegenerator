package org.example;
public class InvoiceGenerator {

    public static final int costTime=1;
    public static final double costPerKilometer=10;
    public static final double minFare=5;
    public static final double premiumCostTime = 2;
    public static final double premiumCostPerKilometer = 15;
    public static final double premiumMinFare = 20;

   

    public double calculateFare(double distance, int time) {

        double totalFare=(distance*costPerKilometer)+(time*costTime);
        if (totalFare<minFare){
            return minFare;
        }
        return totalFare;
    }

    public InvoiceSummary calculateFare(Rides[] rides) {
        double totalFare=0;
        for (Rides ride : rides) {
            double fare = 0;
            if (ride.rideType.equalsIgnoreCase("Normal"))
                fare += this.calculateFare(ride.distance, ride.time);
            else if (ride.rideType.equalsIgnoreCase("Premium")) {
                fare += this.calculatePremiumFare(ride.distance, ride.time);
            }
            totalFare += fare;
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    public double calculatePremiumFare(double distance, int time) {
        double totalFare = distance * premiumCostPerKilometer + time * premiumCostTime;
        return Math.max(totalFare, premiumMinFare);
    }

}