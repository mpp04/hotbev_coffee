package com.revature.Repositories;


import com.revature.Coffee;
import com.revature.Models.CoffeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CoffeeRepository extends JpaRepository<CoffeeModel, Integer> {


    @Query("SELECT c from CoffeeModel c")
    List<CoffeeModel> showAll();

    @Modifying
    @Query("Update CoffeeModel c Set c.name=:name where c.id= :id")
    Integer updateCoffees(@Param("name") String name, @Param("id") Integer id);


    @Modifying
    @Query("delete from CoffeeModel c where c.id = :id")
    Integer deleteCoffees(@Param("id") Integer id);


}
