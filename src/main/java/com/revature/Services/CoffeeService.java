package com.revature.Services;

import com.revature.Models.CoffeeModel;
import com.revature.Repositories.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.List;


@EnableJpaRepositories
@Service
public class CoffeeService {


    @Autowired
    CoffeeRepository coffeeRepository;


    CoffeeService() {
    }


    public CoffeeModel newCoffee(String name, String description) {

        System.out.println("Coffee SERVICE: name is" + name + " description is: " + description);
        CoffeeModel coffee = new CoffeeModel(name, description);
        coffeeRepository.save(coffee);
        //SoupModel soup2 = SoupRepository.save(soup);
        return coffee;
    }

    public List findAllCoffees() {
        List result = coffeeRepository.findAll();
        return result;
    }


    public String updateCoffees(String name, Integer id) {
        Integer i = coffeeRepository.updateCoffees(name, id);
        if (i > 1) {
            return "You have updated more than 1 entry! " +
                    "Hint: check for duplicate primary key values in DB!";
        } else if (i == 0) {
            return "You have not made any updates to the DB!" +
                    "Hint: check if entry is the DB!";
        }
        return "Your update has been successfully recorded in the Database!";
    }


    public String deleteCoffees(Integer id) {
        Integer i = coffeeRepository.deleteCoffees(id);
        if (i == 0) {
            return "You attempted to delete one entry but affected none. " +
                    "Hint: Check if iD is correct!";
        } else if (i > 1) {
            return "You attempted to delete one entry but affected " + i
                    + "Hint: Check for ID duplicates or cascades!";
        }
        return "Your deletion has been successful!";
    }


}