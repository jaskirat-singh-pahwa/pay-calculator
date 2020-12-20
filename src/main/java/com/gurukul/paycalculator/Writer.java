package com.gurukul.paycalculator;

import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class Writer {
    private String filePath;

    public Writer(String filePath) {
        this.filePath = filePath;
    }

    public void addDataToCsv(List<String[]> rowsToBeWritten) {
        File file = new File(this.filePath);

        try{
            FileWriter output = new FileWriter(file);
            CSVWriter writer = new CSVWriter(output);

            // Adding header to CSV file
            String[] header = {"EmployeeId", "Pay"};
            writer.writeNext(header);
            for(String[] row: rowsToBeWritten) {
                writer.writeNext(row);
            }

            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
