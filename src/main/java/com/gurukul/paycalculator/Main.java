package com.gurukul.paycalculator;

import java.util.List;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        List<Pay> wages = new ArrayList<>();
        wages.add(new Pay(40, "8.0"));
        wages.add(new Pay(50, "8.5"));
        wages.add(new Pay(45, "7.99"));
        wages.add(new Pay(40, "15.00"));
        wages.add(new Pay(60, "16.00"));
        wages.add(new Pay(41, "11.0"));
        wages.add(new Pay(61, "10"));

        List<String[]> employeePays = new ArrayList<>();

        for(Pay wage : wages) {
           employeePays.add(new String[]{"EmployeeId", wage.getPay().toString()});
            System.out.println(wage.getPay());
        }

        Writer writer = new Writer("/Users/jaskiratsinghp/Desktop/outputPayCalculator.csv");
        writer.addDataToCsv(employeePays);
    }
}
