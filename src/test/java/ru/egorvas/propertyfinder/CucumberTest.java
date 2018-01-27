package ru.egorvas.propertyfinder;

import com.google.common.io.Files;
import cucumber.api.junit.Cucumber;
import io.qameta.allure.Attachment;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;

@RunWith(Cucumber.class)
public class CucumberTest {

    @Attachment(type = "image/png")
    public static byte[] addScreenshotToAllure(String path) {
        byte[] screenshot = null;
        try{
            screenshot = Files.toByteArray(new File(path));
        }catch(IOException e){
            e.printStackTrace();
        }
        return screenshot;
    }

    @Attachment(type = "file/txt")
    public static byte[] addTxtToAllure(String path) {
        byte[] file = null;
        try{
            file = Files.toByteArray(new File(path));
        }catch(IOException e){
            e.printStackTrace();
        }
        return file;
    }

    @Attachment(type = "file/csv")
    public static byte[] addCsvToAllure(String path) {
        byte[] file = null;
        try{
            file = Files.toByteArray(new File(path));
        }catch(IOException e){
            e.printStackTrace();
        }
        return file;
    }
}
