package org.example;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceGeneratorTest {
    InvoiceGenerator cab = new InvoiceGenerator();

    @Test
    public void calculateFare() {
        double distance = 2.0;
        int time = 5;
        double actualFare = cab.calculateFare(distance, time);
        double expectedFare = 25; // (2 * 10) + (5 * 1) = 20 + 5 = 25
        Assert.assertEquals(expectedFare, actualFare, 0);
    }

    @Test
    public void calculateFare2() {
        double distance = 0.5;
        int time = 2;
        double actualFare = cab.calculateFare(distance, time);
        double expectedFare = 5.0; // Minimum fare should be 5
        Assert.assertEquals(expectedFare, actualFare, 0);
    }

}
