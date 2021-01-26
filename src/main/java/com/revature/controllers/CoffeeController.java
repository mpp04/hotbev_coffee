package com.revature.controllers;

import com.revature.Coffee;
import com.revature.Repositories.CoffeeRepository;
import com.revature.Services.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/Coffee")
public class CoffeeController {

    @Autowired
    CoffeeService CoffeeService;

    @Autowired
    CoffeeRepository coffeeRepository;

    @GetMapping
    public ResponseEntity<String> helloCoffee() {
        return ResponseEntity.status(HttpStatus.OK)
                .body("Hello World! This is Coffee!");
    }

//create

    @RequestMapping(
            value = "/create",
            method = RequestMethod.POST,
            consumes = "application/x-www-form-urlencoded",
            produces = "text/plain"
            )
    @ResponseBody
    public String newCoffee(@RequestParam String name, @RequestParam String description) {

        CoffeeService.newCoffee(name, description);
        return "You have just brewed a delicious: " + name;

        // public ResponseEntity<String> helloCoffee2 () {
        //return ResponseEntity.status(HttpStatus.OK).body("You hit me!");
    }


    //read
    @RequestMapping(
            value = "/getCoffees",
            method = RequestMethod.GET,
            consumes = "application/json",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List getCoffees() {

        return CoffeeService.findAllCoffees();
        //return coffeeRepository.findAll(); //ur amazing papito! it works!
    }

    //update

    @RequestMapping(
            value = "/updateCoffee",
            method = RequestMethod.POST,
            consumes = "application/x-www-form-urlencoded",
            produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    String updateCoffees(@RequestParam String name, @RequestParam Integer id) {
        return CoffeeService.updateCoffees(name, id);
    }


    // delete
    @RequestMapping(
            value = "/deleteCoffee",
            method = RequestMethod.POST,
            consumes = "application/x-www-form-urlencoded",
            produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    String deleteCoffees(@RequestParam Integer id) {
        return CoffeeService.deleteCoffees(id);
    }

}

