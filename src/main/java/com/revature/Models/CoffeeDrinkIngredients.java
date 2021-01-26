package com.revature.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "coffee_drink_ingredients")

public class CoffeeDrinkIngredients {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @JoinColumn(name = "id_coffee_drink")
    @ManyToOne
    CoffeeDrinkModel coffeeDrinkModel;

    @JoinColumn(name = "id_coffee_ingredients")
    @ManyToOne
    CoffeeIngredientsModel coffeeIngredientsModel;

}
