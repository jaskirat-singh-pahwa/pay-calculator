package com.gurukul.paycalculator;

import java.math.BigDecimal;


public class Money {
    private BigDecimal amount;
    private int precision;

    public Money(String amount, int precision) {
        this.precision = precision;
        this.amount = convertToPrecision(amount);
    }

    public BigDecimal convertToPrecision(String amountToBeConverted) {
        return getAmountWithPrecision(new BigDecimal(amountToBeConverted));
    }

    public BigDecimal getAmountWithPrecision(BigDecimal amount) {
        return amount.setScale(this.precision, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public Money multiply(String multiplier) {
        BigDecimal roundedMultiplier = getAmountWithPrecision(new BigDecimal(multiplier));
        BigDecimal multipliedResult = getAmountWithPrecision(this.amount.multiply(roundedMultiplier));

        return new Money(multipliedResult.toString(), this.precision);
    }

    public Money add(String numberToBeAdded) {
        BigDecimal roundedNumberToBeAdded = getAmountWithPrecision(new BigDecimal(numberToBeAdded));
        BigDecimal addedResult = getAmountWithPrecision(this.amount.add(roundedNumberToBeAdded));

        return new Money(addedResult.toString(), this.precision);
    }

    public boolean isLessThan(Money minimumBaseSalary) {
        return this.amount.compareTo(minimumBaseSalary.getAmount()) < 0;
    }
}
