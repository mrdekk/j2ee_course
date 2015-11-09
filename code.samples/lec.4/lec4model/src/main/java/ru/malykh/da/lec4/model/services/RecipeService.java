package ru.malykh.da.lec4.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ru.malykh.da.lec4.model.entities.Recipe;
import ru.malykh.da.lec4.model.repositories.RecipeRepository;

public class RecipeService implements IRecipeService
{
	@Autowired
	private RecipeRepository recipeRepository;

	@Override
	@Transactional( rollbackFor = Exception.class )
	public Recipe create( Recipe recipe )
	{
		return recipeRepository.save( recipe );
	}

	@Override
	@Transactional( rollbackFor = Exception.class )
	public Recipe delete( int id ) 
		throws Exception
	{
		Recipe deletedRecipe = recipeRepository.findOne( id );
		
		if ( null == deletedRecipe )
			throw new Exception( "Recipe not found" );
		
		recipeRepository.delete( deletedRecipe );
		return deletedRecipe;
	}

	@Override
	public List< Recipe > findAll( )
	{
		return recipeRepository.findAll( );
	}

	@Override
	@Transactional( rollbackFor = Exception.class )
	public Recipe update( Recipe recipe ) 
		throws Exception
	{
		Recipe updatedRecipe = recipeRepository.findOne( recipe.getId( ) );
		
		if ( null == updatedRecipe )
			throw new Exception( "Recipe not found" );
		
		updatedRecipe.setName( recipe.getName( ) );
		updatedRecipe.setIngredients( recipe.getIngredient( ) );
		
		recipeRepository.save( updatedRecipe );
		
		return updatedRecipe;
	}

	@Override
	public Recipe findById( int id )
	{
		return recipeRepository.findOne( id );
	}

}
