package com.gurukul.paycalculator;

import org.junit.Test;
import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;


public class PayTest {
    @Test
    public void itShouldReturn_ZeroPayWhenHoursWorkedIsZero() {
        Pay pay = new Pay(0, "8.00");

        assertEquals(pay.getPay(), new BigDecimal("0.00"));

    }

    @Test
    public void itShouldReturn_EightPayWhenHoursWorkedIsOneAndBasePayIsEight() {
        Pay pay = new Pay(1, "8.00");

        assertEquals(pay.getPay(), new BigDecimal("8.00"));

    }

    @Test
    public void itShouldReturn_320PayWhenHoursWorkedIsFortyAndBasePayIsEight() {
        Pay pay = new Pay(40, "8.00");

        assertEquals(pay.getPay(), new BigDecimal("320.00"));
    }

    @Test
    public void itShouldReturn_328PayWhenHoursWorkedIsFortyAndBasePayIsEightPointTwo() {
        Pay pay = new Pay(40, "8.20");

        assertEquals(pay.getPay(), new BigDecimal("328.00"));
    }

    @Test
    public void itShouldReturn_332PayWhenHoursWorkedIsFortyOneAndBasePayIsEight() {
        Pay pay = new Pay(41, "8.00");

        assertEquals("After 40 hours, they get overtime = (base pay) × 1.5 for each hour.",
                pay.getPay(), new BigDecimal("332.00"));
    }

    @Test
    public void itShouldReturn_() {
        Pay pay = new Pay(45, "9.45");

        assertEquals("After 40 hours, they get overtime = (base pay) × 1.5 for each hour.",
                pay.getPay(), new BigDecimal("448.90"));
    }

    @Test
    public void itShouldThrowErrorWhenHoursWorkedIsMoreThanSixty() {
        Pay pay = new Pay(61, "9.00");

        assertEquals("It Should return -1 when hours worked is more than 60",
                pay.getPay(), new BigDecimal("-1.00"));
    }

    @Test
    public void itShouldThrowErrorWhenBasePayIsLessThanEight() {
        Pay pay = new Pay(40, "7.00");

        assertEquals("It should return -1 when base pay is less than 8$",
                pay.getPay(), new BigDecimal("-1.00"));
    }
}


/*
    Red: Write a failing test for one atomic requirement.
    Green: Write the minimum code to get the failing test(s) to pass.
    Refactor: Refactor your code.

*/
