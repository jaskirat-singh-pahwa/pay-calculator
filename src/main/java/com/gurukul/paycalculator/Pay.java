package com.gurukul.paycalculator;

import java.math.BigDecimal;


public class Pay {
    final private int precision = 2;
    final private Money minimumBaseSalary = new Money("8.00", precision);
    final private int maxWorkingHoursAllowed = 60;
    final private int normalPayHoursLimit = 40;
    final private String overtimeFactor = "1.50";
    private int hoursWorked;
    private Money basePay;

    public Pay(int hoursWorked, String basePay) {
        this.hoursWorked = hoursWorked;
        this.basePay = new Money(basePay, precision);
    }

    public boolean isBasePayLessThanMinimumBaseSalary() {
        return this.basePay.isLessThan(minimumBaseSalary);
    }

    public boolean isHoursWorkedMoreThanMaxWorkingHoursAllowed() {
        return this.hoursWorked > maxWorkingHoursAllowed;
    }

    public int getOvertimeHours() {
        return this.hoursWorked - normalPayHoursLimit;
    }

    public boolean checkIfAllConditionsSatisfied() {
        return !isHoursWorkedMoreThanMaxWorkingHoursAllowed() && !isBasePayLessThanMinimumBaseSalary();
    }

    public BigDecimal getPay() {

        if (!checkIfAllConditionsSatisfied()) {
            return new BigDecimal("-1.00");
        }

        int overtimeHours = getOvertimeHours();
        if(overtimeHours > 0) {
            Money normalPay = this.basePay.multiply(String.valueOf(normalPayHoursLimit));
            Money overtimePay = this.basePay.multiply(overtimeFactor);
            Money overtime = overtimePay.multiply(String.valueOf(overtimeHours));

            return normalPay.add(overtime.getAmount().toString()).getAmount();
        }
        else {
            return this.basePay.multiply(String.valueOf(this.hoursWorked)).getAmount();
        }
    }
}
