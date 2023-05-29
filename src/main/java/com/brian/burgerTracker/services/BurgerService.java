package com.brian.burgerTracker.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.brian.burgerTracker.models.Burger;
import com.brian.burgerTracker.repositories.BurgerRepository;



@Service
public class BurgerService {
	private final BurgerRepository burgerRepository;
	public BurgerService(BurgerRepository burgerRepository) {
		this.burgerRepository = burgerRepository;
	}
	public List<Burger> allBurgers() {
        return burgerRepository.findAll();
    }
	public Burger createBurger(Burger b) {
        return burgerRepository.save(b);
    }
	public Burger findBurger(Long id) {
        Optional<Burger> optionalBurger = burgerRepository.findById(id);
        if(optionalBurger.isPresent()) {
            return optionalBurger.get();
        } else {
            return null;
        }
    }
	 public Burger updateBurger(Long id, String name, String rest, Integer rating, String notes ) {
	    	Burger burger = this.findBurger(id);
	    	burger.setName(name);
	    	burger.setRestaurant(rest);
	    	burger.setRating(rating);
	    	burger.setNotes(notes);
	    	burgerRepository.save(burger);
	    	return burger;
	    }
	 public Burger updateBurger2(Burger burger) {
		 Optional<Burger> optionalBurger = burgerRepository.findById(burger.getId());
	        if(optionalBurger.isPresent()) {
	            return burgerRepository.save(burger);
	        } else {
	            return this.createBurger(burger);
	        }
	 }
	
}
