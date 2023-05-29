package com.brian.burgerTracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	@GetMapping("/burgers/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Burger burger = burgerService.findBurger(id);
		model.addAttribute("burger",burger);
		return "edit.jsp";
	}
	@RequestMapping(value = "/burgers/{id}", method = RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("burger") Burger burger,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("burger", burger);
			return "edit.jsp";
		}
		else {
			burgerService.updateBurger2(burger);
			return "redirect:/";
		}
	}
	
}
