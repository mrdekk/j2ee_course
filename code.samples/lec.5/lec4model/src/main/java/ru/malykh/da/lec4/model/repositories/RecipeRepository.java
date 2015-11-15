package ru.malykh.da.lec4.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.malykh.da.lec4.model.entities.Recipe;

public interface RecipeRepository extends JpaRepository< Recipe, Integer >
{
	
	// Lecture 5
	
	@Query( "select r from Recipe r where r.name = :name" )
	public List< Recipe > getRecipeByName( @Param( "name" ) String name );
}
