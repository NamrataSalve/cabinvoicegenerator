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
}
