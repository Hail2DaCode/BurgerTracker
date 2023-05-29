package com.brian.burgerTracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.brian.burgerTracker.models.Burger;
import com.brian.burgerTracker.services.BurgerService;

import jakarta.validation.Valid;



@Controller
public class BurgerController {
	@Autowired
	BurgerService burgerService;
	@GetMapping("/")
	public String dash(Model model, @ModelAttribute("burger") Burger burger) {
		List<Burger> burgers = burgerService.allBurgers();
		model.addAttribute("burgers", burgers);
		return "/dash.jsp";
	}
	@PostMapping("/new/Burger")
	public String create(
			@Valid @ModelAttribute("burger") Burger burger,
			BindingResult result) {
		if (result.hasErrors()) {
			return "dash.jsp";
		}
		else {
		burgerService.createBurger(burger);
		return "redirect:/";
	}
	}
	
}
