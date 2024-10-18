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
                new Rides(2.0, 5,"uber"),
                new Rides(3.0, 10,"ola")
        };
        rideRepository.addRides(1, rides);
        assertArrayEquals(rides, rideRepository.getRides(1));
    }
    @Test
    public void testCalculateFareForSingleRide() {
        double distance = 2.0;
        int time = 5;
        double expectedFare = 25.0; // (2 * 10) + (5 * 1)
        assertEquals(expectedFare, invoiceGenerator.calculateFare(distance, time), 0.0);
    }
    @Test
    public void testCalculateFareForMultipleRides() {
        Rides[] rides = {
                new Rides(2.0, 5,"aa"),
                new Rides(3.0, 10,"bbb")
        };
        rideRepository.addRides(1, rides);

        double expectedFare = 65.0; // 25.0 + 40.0
        InvoiceSummary summary = invoiceGenerator.calculateFare(1);

        assertEquals(2, summary.noOfRides, 0.0);
        assertEquals(expectedFare, summary.totalFare, 0.0);
        assertEquals(expectedFare / 2, summary.avgFare, 0.0);
    }

}
