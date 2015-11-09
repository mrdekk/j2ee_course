package ru.malykh.da.lec4.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.malykh.da.lec4.model.entities.Recipe;

public interface RecipeRepository extends JpaRepository< Recipe, Integer >
{

}
