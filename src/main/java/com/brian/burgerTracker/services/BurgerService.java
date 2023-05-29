package com.brian.burgerTracker.services;


import java.util.List;

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
	
}
