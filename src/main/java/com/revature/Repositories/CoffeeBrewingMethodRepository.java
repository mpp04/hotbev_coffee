package com.revature.Repositories;

import com.revature.Models.CoffeeBrewingMethodModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface CoffeeBrewingMethodRepository extends JpaRepository<CoffeeBrewingMethodModel, Integer> {
}
