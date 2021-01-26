package com.revature.Models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter

@Entity
@Table(name = "coffee_variety")
public class CoffeeVarietyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "coffee_variety_name")
    String coffeeVarietyName;

    @Column
    String details;


    public CoffeeVarietyModel(String coffeeVarietyName, String details) {
        this.coffeeVarietyName = coffeeVarietyName;
        this.details = details;
    }


    public CoffeeVarietyModel() {

    }
}
