package com.lizbaze.mealplan.controllers;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lizbaze.mealplan.entities.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

}
