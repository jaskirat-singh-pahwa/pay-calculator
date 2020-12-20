package com.gurukul.paycalculator;

import java.math.BigDecimal;


public class Pay {
    final private int precision = 2;
    final private Money minimumBaseSalary = new Money("8.00", precision);

    private int hoursWorked;
    private Money basePay;

    public Pay(int hoursWorked, String basePay) {
        this.hoursWorked = hoursWorked;
        this.basePay = new Money(basePay, precision);
    }

    public boolean isBasePayLessThanMinimumBaseSalary() {
        return this.basePay.isLessThan(minimumBaseSalary);
    }

    public boolean isHoursWorkedMoreThanMaxWorkingHoursAllowed(int hoursWorked) {
        int maxWorkingHoursAllowed = 60;
        return hoursWorked > maxWorkingHoursAllowed;
    }

    public BigDecimal getPay() {

        if (isHoursWorkedMoreThanMaxWorkingHoursAllowed(this.hoursWorked)) {
            return new BigDecimal("-1.00");
        }

        if (isBasePayLessThanMinimumBaseSalary()) {
            return new BigDecimal("-1.00");
        }

        int normalPayHoursLimit = 40;
        if (this.hoursWorked <= normalPayHoursLimit) {
            return this.basePay.multiply(String.valueOf(this.hoursWorked)).getAmount();
        }

        int overtimeHours = this.hoursWorked - normalPayHoursLimit;

        Money normalPay = this.basePay.multiply(String.valueOf(normalPayHoursLimit));

        String overtimeFactor = "1.50";
        Money overtimePay = this.basePay.multiply(overtimeFactor);

        Money overtime = overtimePay.multiply(String.valueOf(overtimeHours));

        return normalPay.add(overtime.getAmount().toString()).getAmount();
    }
}
