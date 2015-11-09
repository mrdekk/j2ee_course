package ru.malykh.da.lec4.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.malykh.da.lec4.model.entities.Ingredient;

public interface IngredientRepository extends JpaRepository< Ingredient, Integer >
{

}
