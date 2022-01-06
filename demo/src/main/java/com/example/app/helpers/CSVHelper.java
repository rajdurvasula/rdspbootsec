package com.example.app.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.models.CarModel;
import com.example.app.models.CarDetails;

public class CSVHelper
{
    public static String TYPE = "text/csv";
    static String[] HEADERS = { "year", "make", "model", "trim", "body", "transmission", "vin" };
    public static boolean hasCSVFormat(MultipartFile file) {
        System.out.format("\nFile Content Type: %s\n", file.getContentType());
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }
    
    public static List<CarModel> csvToCarModels(InputStream is) {
        List<CarModel> carModels = new ArrayList<CarModel>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            CSVParser csvParser = new CSVParser(br, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                CarModel carModel = new CarModel(
                    Integer.parseInt(csvRecord.get("year")),
                    csvRecord.get("make"),                    
                    csvRecord.get("model"),
                    csvRecord.get("trim"),
                    csvRecord.get("body"),
                    csvRecord.get("transmission"),
                    csvRecord.get("vin")
                );
                carModels.add(carModel);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            throw new RuntimeException("Failed to read CSV: "+ioe.getMessage());
        }
        return carModels;
    }
    
    public static List<CarDetails> csvToCarDetails(InputStream is) {
        List<CarDetails> carDetailsList = new ArrayList<CarDetails>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            CSVParser csvParser = new CSVParser(br, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                CarDetails carDetails = new CarDetails(
                    csvRecord.get("make"),
                    csvRecord.get("vin"),
                    csvRecord.get("state"),
                    csvRecord.get("condition"),
                    Integer.parseInt(fixNullEmpty(csvRecord.get("odometer"))),
                    csvRecord.get("color"),
                    csvRecord.get("interior"),
                    csvRecord.get("seller"),
                    Integer.parseInt(fixNullEmpty(csvRecord.get("mmr"))),
                    Integer.parseInt(fixNullEmpty(csvRecord.get("sellingprice")))
                );
                carDetailsList.add(carDetails);
            }            
        } catch (IOException ioe) {
            ioe.printStackTrace();
            throw new RuntimeException("Failed to read CSV: "+ioe.getMessage());
        }
        return carDetailsList;
    }
    
    private static String fixNullEmpty(String value) {
        if (null != value) {
            if (value.replaceAll("\\s", "").equals("")) {
                return "0";    
            }
        }
        return "0";
    }
}