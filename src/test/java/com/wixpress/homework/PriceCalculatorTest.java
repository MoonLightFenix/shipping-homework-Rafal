package com.wixpress.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceCalculatorTest {


    @Test
    public void testPriceCalculation() {
        final PriceCalculator priceCalculator = new PriceCalculator();

//        assertEquals("2021-07-15 S LP 1.23", priceCalculator.getPrice("2021-07-15 S LP")); //Happy flow
//        assertEquals("2021-07-15 M OM ERROR", priceCalculator.getPrice("2021-07-15 M OM")); //Bad Size for selected Provider
//        assertEquals("2021-02-30 M OM ERROR", priceCalculator.getPrice("2021-02-30 M OM")); //Bad Date
//        assertEquals("2021-02-01 S OM 1", priceCalculator.getPrice("2021-02-01 S OM")); //Happy flow
//        assertEquals("2021-02-31 S OM ERROR", priceCalculator.getPrice("2021-02-31 S OM")); //Bad Date
//        assertEquals("2021/02/31 S OM ERROR", priceCalculator.getPrice("2021/02/31 S OM")); //Bad Date format
//        assertEquals("2021-02-15 S OF ERROR", priceCalculator.getPrice("2021-02-15 S OF")); //Bad Provider
        //-------------------- New tests
//        assertEquals("2021-07-15 L LP 6.30 0.70", priceCalculator.getPrice("2021-07-15 L LP")); //Happy flow
//        assertEquals("2021-07-15 L LP 6.30 0.70", priceCalculator.getPrice("2021-07-15 L LP")); //Happy flow
//        assertEquals("2021-09-15 M LP 2.70 0.30", priceCalculator.getPrice("2021-09-15 M LP")); //Happy flow
//        assertEquals("2021-06-12 S OM 0.90 0.10", priceCalculator.getPrice("2021-06-12 S OM"));// Happy flow
//        assertEquals("2021-06-15 S OM 0.90 0.10", priceCalculator.getPrice("2021-06-15 S OM"));// Happy flow
//        assertEquals("2021-06-18 S OM 0 1", priceCalculator.getPrice("2021-06-18 S OM"));// Happy flow
//        assertEquals("2021-12-12 L LP 6.30 0.70", priceCalculator.getPrice("2021-12-12 L LP"));// Happy flow
//        assertEquals("2021-12-14 S LP 0.90 0.33", priceCalculator.getPrice("2021-12-14 S LP"));// Happy flow
//        assertEquals("2021-12-18 M LP 0 3", priceCalculator.getPrice("2021-12-18 M LP"));// Happy flow
//
//
//        assertEquals("2021-10-05 L LP 6.30 0.70", priceCalculator.getPrice("2021-10-05 L LP"));// Happy flow
//        assertEquals("2021-10-06 L LP 6.30 0.70", priceCalculator.getPrice("2021-10-06 L LP"));// Happy flow
//        assertEquals("2021-10-07 L LP 0 7", priceCalculator.getPrice("2021-10-07 L LP"));// Happy flow

//        assertEquals("2021-10-07 L LP 6.30 0.70", priceCalculator.getPrice("2021-10-07 L LP"));// Happy flow
//        assertEquals("2021-10-07 L LP 6.30 0.70", priceCalculator.getPrice("2021-10-07 L LP"));// Happy flow
//        assertEquals("2021-10-07 L LP 1.40 5.60", priceCalculator.getPrice("2021-10-07 L LP"));// Happy flow

        assertEquals("2021-11-07 S LP 0.90 0.33", priceCalculator.getPrice("2021-11-07 S LP"));// Happy flow
        assertEquals("2021-11-07 S LP 0.90 0.33", priceCalculator.getPrice("2021-11-07 S LP"));// Happy flow
        assertEquals("2021-11-07 S LP 1.00 0.23", priceCalculator.getPrice("2021-11-07 S LP"));// Happy flow

    }
}