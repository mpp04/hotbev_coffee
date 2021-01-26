package com.revature.Repositories;

import com.revature.Models.CoffeeDrinkModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface CoffeeDrinksRepository extends JpaRepository<CoffeeDrinkModel, Integer> {

}
