package com.revature.Repositories;

import com.revature.Models.CoffeeDrinksHistoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeOrderHistoryRepository extends JpaRepository<CoffeeDrinksHistoryModel, Integer> {
}
