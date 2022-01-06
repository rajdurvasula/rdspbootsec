package com.example.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;

@Entity
@Table(name="cardetails")
public class CarDetails
{
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name="make")
    private String make;
    @Column(name="vin")
    private String vin;
    @Column(name="car_state")
    private String carState;
    @Column(name="car_cond")
    private String carCondition;
    @Column(name="odometer")
    private Integer odometer;
    @Column(name="color")
    private String color;
    @Column(name="interior")
    private String interior;
    @Column(name="seller")
    private String seller;
    @Column(name="mmr")
    private Integer mmr;
    @Column(name="sale_price")
    private Integer salePrice;
    @OneToOne(targetEntity=CarModel.class)
    private CarModel carModel;
    
    public CarDetails() {}
    
    public CarDetails(String make, String vin, String carState, String carCondition, Integer odometer, String color, String interior, String seller, Integer mmr, Integer salePrice) {
        this.make = make;
        this.vin = vin;
        this.carState = carState;
        this.carCondition = carCondition;
        this.odometer = odometer;
        this.color = color;
        this.interior = interior;
        this.seller = seller;
        this.mmr = mmr;
        this.salePrice = salePrice;
    }
    
    public void setId(Long id) { this.id = id; }
    public Long getId() { return this.id; }
    public void setMake(String make) { this.make = make; }
    public String getMake() { return this.make; }
    public void setVin(String vin) { this.vin = vin; }
    public String getVin() { return this.vin; }
    public void setCarState(String carState) { this.carState = carState; }
    public String getCarState() { return this.carState; }
    public void setCarCondition(String carCondition) { this.carCondition = carCondition; }
    public String getCarCondition() { return this.carCondition; }
    public void setOdometer(Integer odometer) { this.odometer = odometer; }
    public Integer getOdometer() { return this.odometer; }
    public void setColor(String color) { this.color = color; }
    public String getColor() { return this.color; }
    public void setInterior(String interior) { this.interior = interior; }
    public String getInterior() { return this.interior; }
    public void setSeller(String seller) { this.seller = seller; }
    public String getSeller() { return this.seller; }
    public void setMmr(Integer mmr) { this.mmr = mmr; }
    public Integer getMmr() { return this.mmr; }
    public void setSalePrice(Integer salePrice) { this.salePrice = salePrice; }
    public Integer getSalePrice() { return this.salePrice; }
    public void setCarModel(CarModel carModel) { this.carModel = carModel; }
    public CarModel getCarModel() { return this.carModel; }
    
}