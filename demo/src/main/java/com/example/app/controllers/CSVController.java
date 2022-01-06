package com.example.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.models.CarModel;

import com.example.app.helpers.CSVHelper;
import com.example.app.messages.ResponseMessage;
import com.example.app.services.CSVService;

@Controller
@RequestMapping("/api/csv")
public class CSVController
{
    @Autowired
    CSVService csvService;
    
    @PostMapping(path="/upload_carmodels", consumes="multipart/form-data")
    public ResponseEntity<ResponseMessage> uploadCarModels(@RequestParam("file") MultipartFile file) {
        System.out.println("Uploading CSV file ..");
        String message = "";
        if (CSVHelper.hasCSVFormat(file)) {
            try {
                csvService.saveCarModels(file);
                message = "Data uploaded from File "+file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "File "+file.getOriginalFilename()+"upload failed: "+e.getMessage();
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }
        message = "Invalid CSV file";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }
    
    @PostMapping(path="/upload_cardetails", consumes="multipart/form-data")
    public ResponseEntity<ResponseMessage> uploadCarDetails(@RequestParam("file") MultipartFile file) {
        System.out.println("Uploading CSV file ..");
        String message = "";
        if (CSVHelper.hasCSVFormat(file)) {
            try {
                csvService.saveCarDetails(file);
                message = "Data uploaded from File "+file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "File "+file.getOriginalFilename()+"upload failed: "+e.getMessage();
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }
        message = "Invalid CSV file";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }
    
}