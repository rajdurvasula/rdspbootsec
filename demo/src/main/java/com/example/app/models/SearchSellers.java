package com.example.app.models;

import java.util.List;

public class SearchSellers
{
    
    private String make;
    private List<String> sellers;
    
    public SearchSellers() {}
    
    public void setMake(String make) { this.make = make; }
    public String getMake() { return this.make; }
    public void setSellers(List<String> sellers) { this.sellers = sellers; }
    public List<String> getSellers() { return this.sellers; }
    
}