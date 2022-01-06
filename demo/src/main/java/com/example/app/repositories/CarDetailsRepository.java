package com.example.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.app.models.CarDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDetailsRepository extends JpaRepository<CarDetails, Long> {
    
    @Query("select distinct(cd.make) from CarDetails cd")
    List<String> findMakes();
    
    @Query("select cd from CarDetails cd where cd.make = :make")
    Page<CarDetails> findByMake(String make, Pageable pageable);
    
    @Query("select cd from CarDetails cd where cd.seller = :seller")
    List<CarDetails> findCarsBySeller(String seller);
    
    @Query("select cd from CarDetails cd where cd.salePrice between :min and :max")
    List<CarDetails> findCarsByPrice(Integer min, Integer max);
    
    CarDetails findByVin(String vin);
}
