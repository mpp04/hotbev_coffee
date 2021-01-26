package com.revature.Repositories;

import com.revature.Models.CoffeeVarietyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface CoffeeVarietyRepository extends
        JpaRepository<CoffeeVarietyModel, Integer> {

    CoffeeVarietyModel getAllBy();


}
