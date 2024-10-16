package org.example;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InvoiceGeneratorTest {
    @Test
    public void testCalculateFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

        // Test case 1: Normal fare calculation
        double fare = invoiceGenerator.calculateFare(10, 5);
        assertEquals(105, fare, 0.0);

        // Test case 2: Minimum fare scenario
        fare = invoiceGenerator.calculateFare(0.2, 1);
        assertEquals(5, fare, 0.0);

        // Test case 3: Another normal fare calculation
        fare = invoiceGenerator.calculateFare(5, 2);
        assertEquals(52, fare, 0.0);
    }

    @Test
    public void testCalculateFareForMultipleRides() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

        InvoiceGenerator.Ride[] rides = {
                new InvoiceGenerator.Ride(10, 5),   // fare: 105
                new InvoiceGenerator.Ride(0.2, 1),  // fare: 5 (minimum fare)
                new InvoiceGenerator.Ride(3, 2)     // fare: 32
        };

        double totalFare = invoiceGenerator.calculateFareForMultipleRides(rides);
        assertEquals(142, totalFare, 0.0);

        // Additional test case with different rides
        InvoiceGenerator.Ride[] moreRides = {
                new InvoiceGenerator.Ride(2, 3),   // fare: 23
                new InvoiceGenerator.Ride(4, 5),   // fare: 45
                new InvoiceGenerator.Ride(1, 1)    // fare: 15
        };

        totalFare = invoiceGenerator.calculateFareForMultipleRides(moreRides);
        assertEquals(83, totalFare, 0.0);
    }

    @Test
    public void testInvoiceSummaryForTotalRidesTotalFareAndAvgFare() {
        // Test case: Create an invoice summary with total fare and number of rides
        InvoiceSummary summary = new InvoiceSummary(150, 3);  // Total fare = 150, Number of rides = 3

        // Check if total number of rides is correct
        assertEquals(3, summary.noOfRides, 0);

        // Check if total fare is correct
        assertEquals(150, summary.totalFare, 0);

        // Check if average fare per ride is correct
        double expectedAvgFare = 150 / 3.0;  // Expected average fare is 50
        assertEquals(expectedAvgFare, summary.avgFare, 0.0);
    }

    @Test
    public void testInvoiceSummaryForDifferentRides() {
        // Test case: Another set of rides, total fare = 240, number of rides = 4
        InvoiceSummary summary = new InvoiceSummary(240, 4);

        // Check total number of rides
        assertEquals(4, summary.noOfRides, 0);

        // Check total fare
        assertEquals(240, summary.totalFare, 0);

        // Check average fare per ride
        double expectedAvgFare = 240 / 4.0;  // Expected average fare = 60
        assertEquals(expectedAvgFare, summary.avgFare, 0.0);
    }

    @Test
    public void testInvoiceSummaryForSingleRide() {
        // Test case: Single ride, total fare = 50, number of rides = 1
        InvoiceSummary summary = new InvoiceSummary(50, 1);

        // Check total number of rides
        assertEquals(1, summary.noOfRides, 0);

        // Check total fare
        assertEquals(50, summary.totalFare, 0);

        // Check average fare per ride (since it's 1 ride, avgFare should be equal to total fare)
        assertEquals(50, summary.avgFare, 0.0);
    }



}
