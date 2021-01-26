package com.revature.Repositories;

import com.revature.Models.CoffeeFilterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface CoffeeFilterRepository extends JpaRepository<CoffeeFilterModel, Integer> {
}
