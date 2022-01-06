package com.example.app.services;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.app.models.SiteRole;
import com.example.app.models.SiteUser;
import com.example.app.repositories.SiteUserRepository;
import com.example.app.repositories.SiteRoleRepository;

@Service
public class SiteUserServiceImpl implements SiteUserService
{
    @Autowired
    private SiteUserRepository userRepo;
    @Autowired
    private SiteRoleRepository roleRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public void save(SiteUser siteUser) {
        siteUser.setPassword(passwordEncoder.encode(siteUser.getPassword()));
        List<SiteRole> siteRoles = roleRepo.findAll();
        Set<SiteRole> siteRoleSet = new HashSet<SiteRole>(siteRoles);
        siteRoleSet.addAll(siteRoles);
        siteUser.setRoles(siteRoleSet);
        userRepo.save(siteUser);
    }
    
    @Override
    public SiteUser findByUserName(String userName) {
        return userRepo.findByUserName(userName);
    }
}
