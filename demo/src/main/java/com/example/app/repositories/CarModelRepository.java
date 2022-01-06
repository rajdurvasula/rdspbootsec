package com.example.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.app.models.CarModel;
import org.springframework.stereotype.Repository;

@Repository
public interface CarModelRepository extends JpaRepository<CarModel, Long> {
    
    @Query("select DISTINCT(cm.maker) from CarModel cm")
    List<String> findCarMakers();
    
    @Query("select cm from CarModel cm where cm.maker = :maker")
    Page<CarModel> findModelsByMaker(String maker, Pageable pageable);
    
    @Query("select cm from CarModel cm where cm.modelType = :modelType")
    List<CarModel> findModelsByModelType(String modelType);
    
    @Query("select cm from CarModel cm where cm.maker = :maker and cm.modelType = :modelType")
    List<CarModel> findModelsByMakerModelType(String maker, String modelType);
    
    CarModel findByVin(String vin);
}