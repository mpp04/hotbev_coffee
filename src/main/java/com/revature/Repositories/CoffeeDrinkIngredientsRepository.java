package com.revature.Repositories;

import com.revature.Models.CoffeeDrinkIngredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository

public interface CoffeeDrinkIngredientsRepository extends JpaRepository<CoffeeDrinkIngredients, Integer> {



}
