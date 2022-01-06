package com.example.app.controllers;

import java.io.IOException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.app.services.CSVService;

@Controller
@RequestMapping("/carsales")
public class UploadController
{
    @Autowired
    CSVService csvService;
    
    @PostMapping(path="/csv/upload_carmodels")
    public String uploadCarModels(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {
        csvService.saveCarModels(file);
        redirectAttributes.addFlashAttribute("message", "File "+file.getOriginalFilename()+" uploaded");
        return "redirect:/carsales/uploadcarmodels";
    }
    
    @PostMapping(path="/csv/upload_cardetails")
    public String uploadCarDetails(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {
        csvService.saveCarDetails(file);
        redirectAttributes.addFlashAttribute("message", "File "+file.getOriginalFilename()+" uploaded");
        return "redirect:/carsales/uploadcardetails";
    }
    
}
