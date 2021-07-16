package com.wixpress.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceCalculatorTest {


    @Test
    public void testPriceCalculation() {
        final PriceCalculator priceCalculator = new PriceCalculator();

        assertEquals("2021-07-15 S LP 1.23", priceCalculator.getPrice("2021-07-15 S LP"));
    }
}