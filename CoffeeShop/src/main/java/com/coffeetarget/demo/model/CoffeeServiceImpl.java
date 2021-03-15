package com.coffeetarget.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoffeeServiceImpl implements CoffeeService {

    @Autowired
    private CoffeeShopRepository coffeeShopRepository;


    @Override
    public List<Coffee> getAllCoffees() {
        return coffeeShopRepository.findAll();
    }

    @Override
    public void saveCoffee(Coffee coffee) {
        this.coffeeShopRepository.save(coffee);
    }

    @Override
    public Coffee getCoffeeById(int id) {
        Optional<Coffee> optionalCoffee = coffeeShopRepository.findById(id);
        Coffee coffee;
        if (optionalCoffee.isPresent()) {
            coffee = optionalCoffee.get();
        } else {
            throw new RuntimeException("Coffee wasn't find for requested id");
        }
        return coffee;
    }

    @Override
    public void deleteCoffeeById(int id) {
        this.coffeeShopRepository.deleteById(id);
    }
}
