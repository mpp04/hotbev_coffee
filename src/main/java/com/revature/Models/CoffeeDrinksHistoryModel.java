package com.revature.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(name="coffee_drinks_history")
public class CoffeeDrinksHistoryModel {



    public CoffeeDrinksHistoryModel() {
    }


    public CoffeeDrinksHistoryModel(
            String coffeeVariety,
            String coffeeIngredients,
            String coffeeFilter,
            String coffeeBrewingMethod,
            String coffeeDrinkName,
            String coffeeDrinkDescription,
            String SessionID,
            String remoteAddress,
            Date date
    ) {

        this.coffeeVariety = coffeeVariety;
        this.coffeeIngredients = coffeeIngredients;
        this.coffeeFilter = coffeeFilter;
        this.coffeeBrewingMethod = coffeeBrewingMethod;
        this.coffeeDrinkName = coffeeDrinkName;
        this.coffeeDrinkDescription = coffeeDrinkDescription;
        this.SessionID= SessionID;
        this.remoteAddress= remoteAddress;
        this.date=date;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "coffee_variety")
    String coffeeVariety;

    @Column(name = "coffee_ingredients")
    String coffeeIngredients;

    @Column(name = "coffee_filter")
    String coffeeFilter;

    @Column(name = "coffee_brewing_method")
    String coffeeBrewingMethod;

    @Column(name = "coffee_drink_name")
    String coffeeDrinkName;

    @Column(name = "coffee_drink_description")
    String coffeeDrinkDescription;

    @Column(name = "session_id")
    String SessionID;

    @Column(name="remote_address")
    String remoteAddress;

    @Column(name = "date")
    Date date;
}
