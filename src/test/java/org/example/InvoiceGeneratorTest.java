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
}
