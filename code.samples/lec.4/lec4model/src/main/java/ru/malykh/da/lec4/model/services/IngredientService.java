package ru.malykh.da.lec4.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ru.malykh.da.lec4.model.entities.Ingredient;
import ru.malykh.da.lec4.model.repositories.IngredientRepository;

public class IngredientService implements IIngredientService
{
	@Autowired
	private IngredientRepository ingredientRepository;

	@Override
	@Transactional( rollbackFor = Exception.class )
	public Ingredient create( Ingredient ingredient )
	{
		return ingredientRepository.save( ingredient );
	}

	@Override
	@Transactional( rollbackFor = Exception.class )
	public Ingredient delete( int id )
		throws Exception
	{
		Ingredient deletedIngredient = ingredientRepository.findOne( id );
		
		if ( null == deletedIngredient )
			throw new Exception( "Ingredient not found" );
		
		ingredientRepository.delete( deletedIngredient );
		return deletedIngredient;
	}

	@Override
	public List< Ingredient > findAll( )
	{
		return ingredientRepository.findAll( );
	}

	@Override
	@Transactional( rollbackFor = Exception.class )
	public Ingredient update( Ingredient ingredient ) 
		throws Exception
	{
		Ingredient updatedIngredient = ingredientRepository.findOne( ingredient.getId( ) );
		
		if ( null == updatedIngredient )
			throw new Exception( "Ingredient not found" );
		
		updatedIngredient.setComponent( ingredient.getComponent( ) );
		updatedIngredient.setQuantity( ingredient.getQuantity( ) );
		
		ingredientRepository.save( updatedIngredient );
		
		return updatedIngredient;
	}

	@Override
	public Ingredient findById( int id )
	{
		return ingredientRepository.findOne( id );
	}

}
