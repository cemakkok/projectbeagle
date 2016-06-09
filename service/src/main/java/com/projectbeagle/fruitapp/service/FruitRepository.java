package com.projectbeagle.fruitapp.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FruitRepository extends CrudRepository<Fruit, Integer> {

	

}
