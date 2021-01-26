package com.revature.Repositories;

import com.revature.Models.CoffeeIngredientsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface CoffeeIngredientsRepository extends JpaRepository<CoffeeIngredientsModel, Integer> {
}
