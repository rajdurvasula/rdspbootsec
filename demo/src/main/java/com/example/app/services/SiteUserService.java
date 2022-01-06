package com.example.app.services;

import com.example.app.models.SiteUser;

public interface SiteUserService
{
    void save(SiteUser siteUser);
    SiteUser findByUserName(String userName);
}