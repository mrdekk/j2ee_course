package ru.mrdekk.j2ee.lec4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.mrdekk.j2ee.lec4.entities.Recipe;

public interface RecipeRepository extends JpaRepository< Recipe, Integer >
{

}
