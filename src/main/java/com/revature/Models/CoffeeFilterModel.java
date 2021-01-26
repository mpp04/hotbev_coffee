package com.revature.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "coffee_filters")
public class CoffeeFilterModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "filter_types")
    String FilterTypes;

    @Column
    String details;

    public CoffeeFilterModel() {
    }


}
