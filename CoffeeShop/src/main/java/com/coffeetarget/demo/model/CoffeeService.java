package com.coffeetarget.demo.model;

import java.util.List;

public interface CoffeeService {
    List<Coffee> getAllCoffees();

    void saveCoffee(Coffee coffee);

    Coffee getCoffeeById(int id);

    void deleteCoffeeById(int id);
}
