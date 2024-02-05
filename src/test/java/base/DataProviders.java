package base;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DataProviders {

    @DataProvider(name = "items list")
    public Object[][] getItems(){
        return new Object[][]{
                {"onesie"},
                {"backpack"}
        };
    }

    @DataProvider(name = "wrongUsers")
    public Object[][] readWrongUsers(){
        //way to read from csv
        try {
            CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/wrongUsers.csv"));
            List<String[]> csvData = csvReader.readAll(); //reads all rows from the CSV file and saves them to a list of string arrays
            Object[][] csvDataObj = new Object[csvData.size()][2];

            for (int i = 0; i < csvData.size(); i++){ //casts the data from the list csvData into the two-dimensional array csvDataObj
                csvDataObj[i] = csvData.get(i);
            }

            return csvDataObj;

        }catch (IOException e){
            //code handling an exception
            System.out.println(e);
            return null; //failed to read a CSV file, and the method returns null
        } catch (CsvException e) {
            //code handling another exception
            System.out.println(e);
            return null;
        }
    }
}
