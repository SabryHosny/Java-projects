package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CSV {

    // this function will read data from CSV File and return a list
    public static List<String[]> readCSV(String filePath) {
        List<String[]> data = new LinkedList<String[]>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String dataRow;

            while ((dataRow = br.readLine()) != null) {
                String[] newRecord = dataRow.split(",");
                data.add(newRecord);
            }

        } catch (FileNotFoundException e) {
            System.out.println("COULD NOT FIND THE FILE!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("COULD NOT READ THE FILE!");
            e.printStackTrace();
        }

        return data;
    }
}
