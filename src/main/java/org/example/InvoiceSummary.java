package org.example;

public class InvoiceSummary {

    public double noOfRides;
    public double totalFare;
    public double avgFare;

    public InvoiceSummary(int fare, double rides) {
        this.noOfRides = rides;
        this.totalFare = fare;
        this.avgFare=this.totalFare/this.noOfRides;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        InvoiceSummary summary = (InvoiceSummary) obj;
        return Double.compare(summary.noOfRides,noOfRides)==0 && totalFare==summary.totalFare && Double.compare(summary.avgFare,avgFare)==0;
    }
}
