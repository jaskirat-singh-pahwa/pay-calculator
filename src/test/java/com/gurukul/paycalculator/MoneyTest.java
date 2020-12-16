package com.gurukul.paycalculator;

import org.junit.Test;
import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;


public class MoneyTest {
    @Test
    public void itShouldReturn_2Point56WhenPrecision2AndStringAmount2Point555() {
        Money money = new Money("2.555", 2);

        assertEquals(money.getAmount(), new BigDecimal("2.56"));
    }

    @Test
    public void itShouldReturn_2Point506WhenPrecision3AndStringAmount2Point5055() {
        Money money = new Money("2.5055", 3);

        assertEquals(money.getAmount(), new BigDecimal("2.506"));
    }

    @Test
    public void itShouldReturnMultipliedResult() {
        Money multiplier = new Money("8.56", 2);
        Money multiplicand = new Money("4.55", 2);
        Money actual = multiplier.multiply(multiplicand.getAmount().toString());

        Money expected = new Money("38.95", 2);

        assertEquals("It should return 38.95 as result when we multiplied 8.56 and 4.55",
                actual.getAmount(), expected.getAmount());
    }

    @Test
    public void itShouldReturnAddedResultForTwoNumbers() {
        Money number1 = new Money("3.53", 2);
        Money number2 = new Money("2.01", 2);
        Money actual = number1.add(number2.getAmount().toString());

        Money expected = new Money("5.54", 2);

        assertEquals("It should return 5.54 as result when added 3.53 and 2.01",
                actual.getAmount(), expected.getAmount());
    }

    @Test
    public void itShouldReturnAddedResult() {
        Money number1 = new Money("3.53", 2);
        Money number2 = new Money("2.01", 2);
        Money sum1 = number1.add(number2.getAmount().toString());
        Money number3 = new Money("1.06", 2);
        Money actual = sum1.add(number3.getAmount().toString());
        Money expected = new Money("6.60", 2);

        assertEquals("It should return 5.54 as result when added 3.53 and 2.01",
                actual.getAmount(), expected.getAmount());
    }
}
