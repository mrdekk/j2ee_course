package ru.malykh.da.lec5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;

import ru.malykh.da.lec4.model.entities.Ingredient;
import ru.malykh.da.lec4.model.entities.Recipe;
import ru.malykh.da.lec4.model.services.IIngredientService;
import ru.malykh.da.lec4.model.services.IRecipeService;

public class RunnerBean
{
	private static final Logger log = LoggerFactory.getLogger( RunnerBean.class );
	
	private IRecipeService _recipeService;
	private IIngredientService _ingredientService;
	
	// @formatter:off
	@Required public void setRecipeService( IRecipeService recipeService ) { _recipeService = recipeService; }
	public IRecipeService getRecipeService( ) { return _recipeService; }
	
	@Required public void setIngredientService( IIngredientService ingredientService ) { _ingredientService = ingredientService; }
	public IIngredientService getIngredientService( ) { return _ingredientService; }
	// @formatter:on
	
	public void init( )
	{
		try
		{
			Recipe recipe = new Recipe( );
			recipe.setName( "Бутерброд" );
			recipe = _recipeService.create( recipe );
			
			Ingredient item = new Ingredient( );
			item.setComponent( "Хлеб" );
			item.setQuantity( 1.0f );		
			item.setRecipe( recipe );
			item = _ingredientService.create( item ); 
			
			item = new Ingredient( );
			item.setComponent( "Сыр" );
			item.setQuantity( 1.0f );
			item.setRecipe( recipe );
			item = _ingredientService.create( item );
					
			Recipe found = _recipeService.findByName( "Бутерброд" );
			if ( null == found )
				log.info( "Рецепт не найден - это плохо - что-то работает не так" );
			else
				log.info( found.toString( ) );
		}
		catch ( Exception exc )
		{
			log.error( "Error", exc );
		}
	}

}
