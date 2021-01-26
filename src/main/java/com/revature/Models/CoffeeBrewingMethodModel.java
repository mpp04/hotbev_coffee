package com.revature.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "coffee_brewing_method")
public class CoffeeBrewingMethodModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;


    @Column(name = "method_name")
    String MethodName;

    @JsonProperty("Brewing_Details")
    @Column
    String details;

    public CoffeeBrewingMethodModel() {
    }

}
