package com.revature.Models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter

@Entity
@Table(name = "coffee_ingredients")
public class CoffeeIngredientsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "ingredient_name")
    String ingredientName;

    @Column
    String details;

    public CoffeeIngredientsModel() {
    }

    public CoffeeIngredientsModel(String ingredientName, String details) {
        this.ingredientName = ingredientName;
        this.details = details;
    }


}
