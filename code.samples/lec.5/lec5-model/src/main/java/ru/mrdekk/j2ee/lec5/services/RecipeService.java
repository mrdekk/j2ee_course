package ru.mrdekk.j2ee.lec5.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ru.mrdekk.j2ee.lec5.entities.Recipe;
import ru.mrdekk.j2ee.lec5.repositories.RecipeRepository;

public class RecipeService implements IRecipeService
{
	@Autowired
	private RecipeRepository recipeRepository;
	
	@Transactional
	public Recipe create( Recipe recipe )
	{
		Recipe createdRecipe = recipe;
		return recipeRepository.save( createdRecipe );
	}

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

	@Transactional
	public List< Recipe > findAll( )
	{
		return recipeRepository.findAll( );
	}

	@Transactional( rollbackFor = Exception.class )
	public Recipe update( Recipe recipe ) 
		throws Exception
	{
		Recipe updatedRecipe = recipeRepository.findOne( recipe.getId( ) );
		
		if ( null == updatedRecipe )
			throw new Exception( "Recipe not found" );
		
		updatedRecipe.setName( recipe.getName( ) );
		updatedRecipe.setItems( recipe.getItems( ) );
		recipeRepository.save( updatedRecipe );
		
		return updatedRecipe;
	}

	@Transactional
	public Recipe findById( int id )
	{
		return recipeRepository.findOne( id );
	}
	
	// lecture 5
	
	@Transactional
	public List< Recipe > findByName( String name )
	{
		return recipeRepository.getRecipeByName( name );
	}
}