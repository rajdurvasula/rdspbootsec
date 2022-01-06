package com.example.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name="favorites")
public class FavoriteCar
{
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name="user_name")
    private String userName;
    @Column(name="vin")
    private String vin;
    @Column(name="make")
    private String make;
    @Column(name="model")
    private String model;
    @Column(name="model_trim")
    private String modelTrim;
    @Column(name="cr_date")
    private Timestamp crDate;
    @Column(name="color")
    private String color;
    @Column(name="sale_price")
    private Integer salePrice;

    public FavoriteCar() {}
    
    public FavoriteCar(Long id, String userName, String vin, String make, String model, String modelTrim, Timestamp crDate, String color, Integer salePrice) {
        this.id = id;
        this.userName = userName;
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.modelTrim = modelTrim;
        this.crDate = crDate;
        this.color = color;
        this.salePrice = salePrice;
    }
    
    public void setId(Long id) { this.id = id; }
    public Long getId() { return this.id; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getUserName() { return this.userName; }
    public void setVin(String vin) { this.vin = vin; }
    public String getVin() { return this.vin; }
    public void setMake(String make) { this.make = make; }
    public String getMake() { return make; }
    public void setModel(String model) { this.model = model; }
    public String getModel() { return this.model; }
    public void setModelTrim(String modelTrim) { this.modelTrim = modelTrim; }
    public String getModelTrim() { return this.modelTrim; }
    public void setCrDate(Timestamp crDate) { this.crDate = crDate; }
    public Timestamp getCrDate() { return this.crDate; }
    public void setColor(String color) { this.color = color; }
    public String getColor() { return this.color; }
    public void setSalePrice(Integer salePrice) { this.salePrice = salePrice; }
    public Integer getSalePrice() { return this.salePrice; }
}
