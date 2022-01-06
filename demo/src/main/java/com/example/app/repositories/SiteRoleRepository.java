package com.example.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.app.models.SiteRole;

import org.springframework.stereotype.Repository;

@Repository
public interface SiteRoleRepository extends JpaRepository<SiteRole, Long> {
    
}