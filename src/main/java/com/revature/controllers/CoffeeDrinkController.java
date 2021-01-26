package com.revature.controllers;


import com.revature.Models.CoffeeIngredientsModel;
import com.revature.Models.CoffeeVarietyModel;

import com.revature.Services.CoffeeDrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;


@CrossOrigin
@RequestMapping("/CoffeeDrinks")
@RestController
public class CoffeeDrinkController {

    @Autowired
    CoffeeDrinkService coffeeDrinkService;


    @RequestMapping(
            value = "/getAllCoffeeDrinks",
            method = RequestMethod.GET,
            consumes = "application/x-www-form-urlencoded",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List getCoffeesDrinks() {

        return coffeeDrinkService.findAllCoffeeDrinks();

    }

    @RequestMapping(
            value = "/getAllCoffeeVarieties",
            method = RequestMethod.GET,
            consumes = "text/plain",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List getAllCoffeeVarieties() {
        return coffeeDrinkService.findAllCoffeeVarieties();
    }


    @RequestMapping(
            value = "/getAllCoffeeIngredients",
            method = RequestMethod.GET,
            consumes = "text/plain",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List getAllCoffeeIngredients() {
        return coffeeDrinkService.findAllCoffeeIngredients();
    }

    @RequestMapping(
            value = "/getAllCoffeeFilters",
            method = RequestMethod.GET,
            consumes = "text/plain",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List getAllCoffeeFilters() {
        return coffeeDrinkService.findAllCoffeeFilter();
    }

    @RequestMapping(
            value = "/getAllCoffeeBrewingMethods",
            method = RequestMethod.GET,
            consumes = "text/plain",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List getAllCoffeeBrewingMethods() {
        return coffeeDrinkService.findAllCoffeeBrewingMethod();
    }


    @RequestMapping(
            value = "/makeCoffeeDrink",
            method = RequestMethod.POST,
            consumes = "application/x-www-form-urlencoded",
            produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String makeCoffeeDrink(
            @RequestParam String coffeeVariety,
            @RequestParam String coffeeIngredients,
            @RequestParam String coffeeFilter,
            @RequestParam String coffeeBrewingMethod,
            @RequestParam String coffeeDrinkName,
            @RequestParam String coffeeDrinkDescription,
            HttpSession httpSession,
            HttpServletRequest httpServletRequest


    ) {
        String sessionID = httpSession.getId();
        String remoteAddress = httpServletRequest.getRemoteAddr();
        Date date = new Date();

        coffeeDrinkService.makeNewCoffeeDrink(coffeeVariety,
                coffeeIngredients, coffeeFilter,
                coffeeBrewingMethod, coffeeDrinkName,
                coffeeDrinkDescription,
                sessionID,remoteAddress,date );

        return "Successfully made another delightful addition to the library of Custom Coffee Drinks!";
    }

    @RequestMapping(
            value = "/addCoffeeVariety",
            method = RequestMethod.POST,
            consumes = "application/x-www-form-urlencoded",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CoffeeVarietyModel makeCoffeeVariety(@RequestParam String CoffeeVarietyName, @RequestParam String Details) {
        return coffeeDrinkService.makeNewVariety(CoffeeVarietyName, Details);
    }

    @RequestMapping(
            value = "/addCoffeeIngredient",
            method = RequestMethod.POST,
            consumes = "application/x-www-form-urlencoded",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CoffeeIngredientsModel addCoffeeIngredient(
            @RequestParam String IngredientName,
            @RequestParam String details) {

        return coffeeDrinkService.addCoffeeIngredient(IngredientName, details);
    }


    @RequestMapping(
            value = "/deleteCoffeeDrink",
            method = RequestMethod.POST,
            consumes = "application/x-www-form-urlencoded",
            produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String deleteCoffees(@RequestParam Integer id) {
        return coffeeDrinkService.deleteCoffeeDrink(id);
    }


    //delete all

    @RequestMapping(
            value="/deleteAllCoffeeDrinks",
            method = RequestMethod.POST,
            consumes = "text/plain",
            produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public void deleteAllCoffeeDrinks() {

        coffeeDrinkService.deleteAllCoffeeDrinks();
    };




    @RequestMapping(
            value = "/getCoffeeDrinkIngredients",
            method = RequestMethod.GET,
            consumes = "application/x-www-form-urlencoded",
            produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public List getCoffeeDrinkIngredients() {

       return coffeeDrinkService.getCoffeeDrinkIngredients();


    }







    }


