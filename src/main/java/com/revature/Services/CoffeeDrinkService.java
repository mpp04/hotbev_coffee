package com.revature.Services;

import com.revature.Models.CoffeeDrinkModel;
import com.revature.Models.CoffeeIngredientsModel;
import com.revature.Models.CoffeeDrinksHistoryModel;
import com.revature.Models.CoffeeVarietyModel;
import com.revature.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@EnableJpaRepositories
public class CoffeeDrinkService {

    CoffeeDrinkService() {
    }

    @Autowired
    CoffeeDrinksRepository coffeeDrinksRepository;

    @Autowired
    CoffeeVarietyRepository coffeeVarietyRepository;

    @Autowired
    CoffeeIngredientsRepository coffeeIngredientsRepository;

    @Autowired
    CoffeeFilterRepository coffeeFilterRepository;

    @Autowired
    CoffeeBrewingMethodRepository coffeeBrewingMethodRepository;

    @Autowired
    CoffeeDrinkIngredientsRepository coffeeDrinkIngredientsRepository;

    @Autowired
    CoffeeOrderHistoryRepository coffeeOrderHistoryRepository;

    public List findAllCoffeeDrinks() {
        List result = coffeeDrinksRepository.findAll();
        return result;

    }

    public List findAllCoffeeVarieties() {
        List result = coffeeVarietyRepository.findAll();
        return result;
    }

    public List findAllCoffeeIngredients() {
        List result = coffeeIngredientsRepository.findAll();
        return result;
    }

    public List findAllCoffeeFilter() {
        List result = coffeeFilterRepository.findAll();
        return result;
    }


    public List findAllCoffeeBrewingMethod() {
        List result = coffeeBrewingMethodRepository.findAll();
        return result;
    }


    public CoffeeDrinkModel makeNewCoffeeDrink(String coffeeVariety,
                                               String coffeeIngredients,
                                               String coffeeFilter,
                                               String coffeeBrewingMethod,
                                               String coffeeDrinkName,
                                               String coffeeDrinkDescription,
                                               String sessionID,
                                               String remoteAddress,
                                               Date date){

        CoffeeDrinkModel coffeeDrink = new CoffeeDrinkModel(
                coffeeVariety,
                coffeeIngredients,
                coffeeFilter,
                coffeeBrewingMethod,
                coffeeDrinkName,
                coffeeDrinkDescription,
                sessionID,
                remoteAddress,
                date
                );
        coffeeDrinksRepository.save(coffeeDrink);
        return coffeeDrink;
    }

    public CoffeeDrinksHistoryModel addOrderHistoryEntry(String coffeeVariety,
                                                         String coffeeIngredients,
                                                         String coffeeFilter,
                                                         String coffeeBrewingMethod,
                                                         String coffeeDrinkName,
                                                         String coffeeDrinkDescription,
                                                         String sessionID,
                                                         String remoteAddress,
                                                         Date date) {

        CoffeeDrinksHistoryModel orderHistoryEntry = new CoffeeDrinksHistoryModel(
                coffeeVariety,
                coffeeIngredients,
                coffeeFilter,
                coffeeBrewingMethod,
                coffeeDrinkName,
                coffeeDrinkDescription,
                sessionID,
                remoteAddress,
                date
        );
        coffeeOrderHistoryRepository.save(orderHistoryEntry);


        return orderHistoryEntry;

    }
    public CoffeeVarietyModel makeNewVariety(String coffeeVariety, String details) {

        CoffeeVarietyModel coffeeVarietyModel = new CoffeeVarietyModel(coffeeVariety, details);
        coffeeVarietyRepository.save(coffeeVarietyModel);
        return coffeeVarietyModel;
    }

    public CoffeeIngredientsModel addCoffeeIngredient(String ingredientName, String details) {
        CoffeeIngredientsModel coffeeIngredient = new CoffeeIngredientsModel(ingredientName, details);
        coffeeIngredientsRepository.save(coffeeIngredient);
        return coffeeIngredient;
    }


    public String deleteCoffeeDrink(Integer id) {
        coffeeDrinksRepository.deleteById(id);

        return "Deletion successful!";
    }

    public List getCoffeeDrinkIngredients() {
        List result = coffeeDrinkIngredientsRepository.findAll();
    return result;
    }

    public void deleteAllCoffeeDrinks() {

        coffeeDrinksRepository.deleteAll();
    }

}
