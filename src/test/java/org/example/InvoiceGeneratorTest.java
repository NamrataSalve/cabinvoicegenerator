package org.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class InvoiceGeneratorTest {
    private RideRepository rideRepository;
    private InvoiceGenerator invoiceGenerator;

    @Before
    public void setUp() {
        rideRepository = new RideRepository();
        invoiceGenerator = new InvoiceGenerator(rideRepository);
    }

    @Test
    public void testAddAndGetRides() {
        Rides[] rides = {
                new Rides(2.0, 5, "normal"),
                new Rides(3.0, 10, "premium")
        };
        rideRepository.addRides(1, rides);
        assertArrayEquals(rides, rideRepository.getRides(1));
    }

    @Test
    public void testCalculateFareForNormalRide() {
        double distance = 2.0;
        int time = 5;
        double expectedFare = 25.0; // (2 * 10) + (5 * 1)
        assertEquals(expectedFare, invoiceGenerator.calculateFare(distance, time, "normal"), 0.0);
    }

    @Test
    public void testCalculateFareForPremiumRide() {
        double distance = 2.0;
        int time = 5;
        double expectedFare = 40.0; // (2 * 15) + (5 * 2)
        assertEquals(expectedFare, invoiceGenerator.calculateFare(distance, time, "premium"), 0.0);
    }

    @Test
    public void testCalculateFareForMultipleRides() {
        Rides[] rides = {
                new Rides(2.0, 5, "normal"),
                new Rides(3.0, 10, "premium")
        };
        rideRepository.addRides(1, rides);

        double expectedFare = 25.0 + 65.0; // normal: 25, premium: 65
        InvoiceSummary summary = invoiceGenerator.calculateFare(1);

        assertEquals(2, summary.noOfRides, 0.0);
        assertEquals(expectedFare, summary.totalFare, 0.0);
        assertEquals(expectedFare / 2, summary.avgFare, 0.0);
    }

    @Test
    public void testMinimumFareForNormalRide() {
        double distance = 0.1;
        int time = 1;
        double expectedFare = 5.0; // minimum fare for normal ride
        assertEquals(expectedFare, invoiceGenerator.calculateFare(distance, time, "normal"), 0.0);
    }

    @Test
    public void testMinimumFareForPremiumRide() {
        double distance = 0.1;
        int time = 1;
        double expectedFare = 20.0; // minimum fare for premium ride
        assertEquals(expectedFare, invoiceGenerator.calculateFare(distance, time, "premium"), 0.0);
    }
}
