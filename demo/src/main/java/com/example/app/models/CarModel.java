package com.example.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="carmodels")
public class CarModel
{
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name="make_year")
    private Integer makeYear;
    @Column(name="maker")
    private String maker;
    @Column(name="model_name")
    private String modelName;
    @Column(name="model_trim")
    private String modelTrim;
    @Column(name="model_type")
    private String modelType;
    @Column(name="transmission")
    private String transmission;
    @Column(name="vin")
    private String vin;
    
    public CarModel() {}
    
    public CarModel(Integer makeYear, String maker, String modelName, String modelTrim, String modelType, String transmission, String vin) {
        this.makeYear = makeYear;
        this.maker = maker;
        this.modelName = modelName;
        this.modelTrim = modelTrim;
        this.modelType = modelType;
        this.transmission = transmission;
        this.vin = vin;
    }
    
    public void setId(Long id) { this.id = id; }
    public Long getId() { return this.id; }
    public void setMakeYear(Integer makeYear) { this.makeYear = makeYear; }
    public Integer getMakeYear() { return this.makeYear; }
    public void setMaker(String maker) { this.maker = maker; }
    public String getMaker() { return this.maker; }
    public void setModelName(String modelName) { this.modelName = modelName; }
    public String getModelName() { return this.modelName; }
    public void setModelTrim(String modelTrim) { this.modelTrim = modelTrim; }
    public String getModelTrim() { return this.modelTrim; }
    public void setModelType(String modelType) { this.modelType = modelType; }
    public String getModelType() { return this.modelType; }
    public void setTransmission(String transmission) { this.transmission = transmission; }
    public String getTransmission() { return this.transmission; }
    public void setVin(String vin) { this.vin = vin; }
    public String getVin() { return this.vin; }
    
    public String toString() {
        return String.format("\n%CarModel: \nId: %o\nMake Year: %o\nModel Name: %s\nModel Trim: %s\nModel Type: %s\nTransmission: %s\nVin: %s\n",
        this.id, this.makeYear, this.modelName, this.modelTrim, this.modelType, this.transmission, this.vin);
    }
}