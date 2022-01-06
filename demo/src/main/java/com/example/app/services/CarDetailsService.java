package com.example.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import com.example.app.models.CarDetails;
import com.example.app.repositories.CarDetailsRepository;

@Service
public class CarDetailsService
{
    @Autowired
    CarDetailsRepository carDetailsRepo;
    
    public List<String> getMakes() {
        return carDetailsRepo.findMakes();
    }
    
    public Page<CarDetails> getByMake(String make, int pageNum, int pageSize, String sortBy, String asc) {
        Sort sort = null;
        if (asc.equals("desc")) {
            sort = Sort.by(sortBy).descending();
        } else {
            sort = Sort.by(sortBy).ascending();
        }
        Pageable pageable = PageRequest.of(pageNum -1, pageSize, sort);
        return carDetailsRepo.findByMake(make, pageable);
    }
    
    public List<CarDetails> getCarsBySeller(String seller) {
        return carDetailsRepo.findCarsBySeller(seller);
    }
    
    public List<CarDetails> getCarsByPrice(Integer min, Integer max) {
        return carDetailsRepo.findCarsByPrice(min, max);
    }
    
}