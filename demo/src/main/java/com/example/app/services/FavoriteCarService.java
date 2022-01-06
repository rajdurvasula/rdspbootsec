package com.example.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.models.CarModel;
import com.example.app.models.CarDetails;
import com.example.app.models.FavoriteCar;
import com.example.app.repositories.FavoriteCarRepository;
import com.example.app.repositories.CarModelRepository;
import com.example.app.repositories.CarDetailsRepository;

import java.util.Date;
import java.util.Optional;
import java.sql.Timestamp;

@Service
public class FavoriteCarService
{
    @Autowired
    FavoriteCarRepository favoriteCarRepo;
    @Autowired
    CarModelRepository carModelRepo;
    @Autowired
    CarDetailsRepository carDetailsRepo;
    
    public List<FavoriteCar> getFavoriteCars() {
        return favoriteCarRepo.findAll();
    }
    
    public FavoriteCar save(String vin, String userName) {
        CarModel carModel = carModelRepo.findByVin(vin);
        CarDetails carDetails = carDetailsRepo.findByVin(vin);
        FavoriteCar favCar = new FavoriteCar();
        favCar.setUserName(userName);
        favCar.setVin(carModel.getVin());
        favCar.setMake(carModel.getMaker());
        favCar.setModel(carModel.getModelName());
        favCar.setModelTrim(carModel.getModelTrim());
        Date now = new Date();
        favCar.setCrDate(new Timestamp(now.getTime()));
        favCar.setColor(carDetails.getColor());
        favCar.setSalePrice(carDetails.getSalePrice());
        return favoriteCarRepo.save(favCar);
    }
    
    public void delete(Long id) {
        Optional<FavoriteCar> optionalResult = favoriteCarRepo.findById(id);
        if (optionalResult.isPresent()) {
            favoriteCarRepo.delete(optionalResult.get());
        }
        
    }
    
    public List<FavoriteCar> getByUserName(String userName) {
        return favoriteCarRepo.findByUserName(userName);
    }
}

