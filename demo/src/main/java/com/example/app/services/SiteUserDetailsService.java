package com.example.app.services;

import java.util.Set;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.example.app.models.SiteUser;
import com.example.app.models.SiteRole;
import com.example.app.repositories.SiteUserRepository;

@Service
public class SiteUserDetailsService implements UserDetailsService
{
    @Autowired
    private SiteUserRepository userRepo;
    
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String userName) {
        System.out.println("UserDetails of User: "+userName);
        SiteUser siteUser = userRepo.findByUserName(userName);
        if (null == siteUser) {
            throw new UsernameNotFoundException(userName);
        }
        //Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        //for (SiteRole role: siteUser.getRoles()) {
        //    grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        //}
        //return new User(siteUser.getUserName(), siteUser.getPassword(), grantedAuthorities);
        UserDetails userDetails = User.withUsername(siteUser.getUserName()).password(siteUser.getPassword()).authorities("USER").build();
        return userDetails;
    }
    
}