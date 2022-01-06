package com.example.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.app.models.CarModel;
import com.example.app.repositories.CarModelRepository;

@Service
public class CarModelService
{
    @Autowired
    CarModelRepository carModelRepo;
    
    public List<String> getCarMakers() {
        return carModelRepo.findCarMakers();
    }
    
    public Page<CarModel> getModelsByMaker(String maker, int pageNum, int pageSize, String sortBy, String asc) {
        Sort sort = null;
        if (asc.equals("desc")) {
            sort = Sort.by(sortBy).descending();
        } else {
            sort = Sort.by(sortBy).ascending();
        }
        Pageable pageable = PageRequest.of(pageNum -1, pageSize, sort);
        return carModelRepo.findModelsByMaker(maker, pageable);
    }
    
    public List<CarModel> getModelsByModelType(String modelType) {
        return carModelRepo.findModelsByModelType(modelType);
    }
    
    public List<CarModel> getModelsByMakerModelType(String maker, String modelType) {
        return carModelRepo.findModelsByMakerModelType(maker, modelType);
    }
}