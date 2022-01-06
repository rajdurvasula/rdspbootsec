package com.example.app.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.models.CarModel;
import com.example.app.models.CarDetails;
import com.example.app.helpers.CSVHelper;
import com.example.app.repositories.CarModelRepository;
import com.example.app.repositories.CarDetailsRepository;

@Service
public class CSVService
{
    @Autowired
    CarModelRepository carModelRepo;
    @Autowired
    CarDetailsRepository carDetailsRepo;
    
    public void saveCarModels(MultipartFile file) {
        try {
            List<CarModel> carModels = CSVHelper.csvToCarModels(file.getInputStream());
            carModelRepo.saveAll(carModels);
        } catch (IOException ioe) {
            throw new RuntimeException("Failed to store CSV data: "+ioe.getMessage());
        }
    }
    
    public void saveCarDetails(MultipartFile file) {
        try {
            List<CarDetails> carDetailsList = CSVHelper.csvToCarDetails(file.getInputStream());
            carDetailsRepo.saveAll(carDetailsList);
        } catch (IOException ioe) {
            throw new RuntimeException("Failed to store CSV data: "+ioe.getMessage());
        }
    }
    
    public List<CarModel> getCarModels() {
        return carModelRepo.findAll();
    }
}