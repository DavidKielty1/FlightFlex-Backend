package com.example.FlightFlex.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "alternative_dates")
public class Alternatives {
    
    @Id
    private int userId;

    @Column(name = "suggested_date")
    private String suggestedDate;

    @Column(name = "price")
    private String price;

    @Column(name = "availability")
    private String availability;

    //Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public String getSuggestedDate() {
        return suggestedDate;
    }

    public void setSuggestedDate(String suggestedDate) {
        this.suggestedDate = suggestedDate;
    }
    
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
    public String getAvailability() {
        return availability;
    }

    public void getAvailability(String availability) {
        this.availability = availability;
    }
    
}