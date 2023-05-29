package com.brian.burgerTracker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brian.burgerTracker.models.Burger;


@Repository
public interface BurgerRepository extends CrudRepository<Burger, Long> {
	List<Burger> findAll();
	List<Burger> findByRestaurantContaining(String search);
	Long countByNameContaining(String search);
	Long deleteByNameStartingWith(String search);

}
