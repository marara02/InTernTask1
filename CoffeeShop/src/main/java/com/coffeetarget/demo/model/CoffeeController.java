package com.coffeetarget.demo.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CoffeeController {

    @Autowired
    private CoffeeService coffeeService;


    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listCoffee", coffeeService.getAllCoffees());
        return "index";
    }

    @GetMapping("/showNewCoffeeForm")
    public String showNewCoffeeForm(Model model) {
        Coffee coffee = new Coffee();
        model.addAttribute("coffee", coffee);
        return "new_coffee";
    }

    @PostMapping("/saveCoffee")
    public String saveCoffee(@ModelAttribute("coffee") Coffee coffee) {
        coffeeService.saveCoffee(coffee);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {
        Coffee coffee = coffeeService.getCoffeeById(id);
        model.addAttribute("coffee", coffee);
        return "update_coffee";
    }

    @GetMapping("/deleteCoffee/{id}")
    public String deleteCoffee(@PathVariable(value = "id") int id) {
        this.coffeeService.deleteCoffeeById(id);
        return "redirect:/";
    }
}
