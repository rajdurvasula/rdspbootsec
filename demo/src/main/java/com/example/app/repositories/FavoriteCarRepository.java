package com.example.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.app.models.FavoriteCar;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteCarRepository extends JpaRepository<FavoriteCar, Long> {
    
    List<FavoriteCar> findByUserName(String userName);
}
