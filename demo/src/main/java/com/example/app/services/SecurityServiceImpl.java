package com.example.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

@Service
public class SecurityServiceImpl implements SecurityService
{
    @Autowired
    private AuthenticationManager authManager;
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    public boolean isAuthenticated() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (null == auth || AnonymousAuthenticationToken.class.isAssignableFrom(auth.getClass())) {
            return false;
        }
        return auth.isAuthenticated();
    }
    
    @Override
    public void autoLogin(String userName, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
        UsernamePasswordAuthenticationToken userNamePasswordAuthToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        authManager.authenticate(userNamePasswordAuthToken);
        if (userNamePasswordAuthToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(userNamePasswordAuthToken);
            System.out.format("\nAuto login for %s successful\n", userName);
        }
    }
}