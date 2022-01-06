package com.example.app.models;

import java.util.List;

public class SearchCarModels
{
    private String maker;
    private List<String> modelTypes;
    
    public SearchCarModels() {}
    
    public SearchCarModels(String maker, List<String> modelTypes) {
        this.maker = maker;
        this.modelTypes = modelTypes;
    }
    
    public void setMaker(String maker) {
        this.maker = maker;
    }
    
    public String getMaker() {
        return this.maker;
    }
    
    public void setModelTypes(List<String> modelTypes) {
        this.modelTypes = modelTypes;
    }
    
    public List<String> getModelTypes() {
        return this.modelTypes;
    }
    
}