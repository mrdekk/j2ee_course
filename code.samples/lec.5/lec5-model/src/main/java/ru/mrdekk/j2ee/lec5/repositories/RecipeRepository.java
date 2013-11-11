package ru.mrdekk.j2ee.lec5.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.mrdekk.j2ee.lec5.entities.Recipe;

public interface RecipeRepository extends JpaRepository< Recipe, Integer >
{
	
	// lecture 5
	
	@Query( "select r from Recipe r where r.name = :name " )
	public List< Recipe > getRecipeByName( @Param( "name" ) String name );
}
