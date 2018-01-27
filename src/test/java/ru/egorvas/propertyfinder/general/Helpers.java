package ru.egorvas.propertyfinder.general;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;

/**
 * Created by egorvas on 27.01.2018.
 */
public class Helpers {

    public static String saveToCSV(Map<String, String> map, String filename, String firstTitle, String secondTitle){
        Writer writer;
        try{
            writer = new FileWriter(filename);
            CSVWriter csvWriter = new CSVWriter(writer);

            String[] headerRecord = {firstTitle, secondTitle};
            csvWriter.writeNext(headerRecord);

            for (Map.Entry<String, String> entry : map.entrySet())
            {
                csvWriter.writeNext(new String[]{entry.getKey(), entry.getValue()});
            }
            csvWriter.close();
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return new File(filename).getAbsolutePath();
    }

    public static String saveToFile(List<String> data, String filename){
        try {
            File file = new File(filename);
            FileWriter fileWriter = new FileWriter(file);
            for (String string : data){
                fileWriter.write(string);
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new File(filename).getAbsolutePath();
    }

}
