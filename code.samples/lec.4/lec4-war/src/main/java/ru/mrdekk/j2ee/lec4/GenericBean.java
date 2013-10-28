package ru.mrdekk.j2ee.lec4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.mrdekk.j2ee.lec4.entities.Recipe;
import ru.mrdekk.j2ee.lec4.entities.RecipeItem;
import ru.mrdekk.j2ee.lec4.services.IRecipeService;

public class GenericBean
{
	private static final Logger log = LoggerFactory.getLogger( GenericBean.class );
	
	private IRecipeService _recipeService;
	
	// @formatter:off
	public void setRecipeService( IRecipeService recipeService ) { _recipeService = recipeService; }
	public IRecipeService getRecipeService( ) { return _recipeService; }
	// @formatter:on
	
	public void init( )
	{
		Recipe recipe = new Recipe( );
		recipe.setName( "Салат \"рекурсивный\"" );
		
		RecipeItem item = new RecipeItem( );
		item.setIngredient( "Огурцы" );
		item.setQuantity( 1.0f );
		recipe.getItems( ).add( item );
		
		item = new RecipeItem( );
		item.setIngredient( "Помидоры" );
		item.setQuantity( 2.0f );
		recipe.getItems( ).add( item );
		
		item = new RecipeItem( );
		item.setIngredient( "Салат \"рекурсивный\"" );
		item.setQuantity( 3.0f );
		recipe.getItems( ).add( item );
		
		Recipe recipe2 = _recipeService.create( recipe );
		
		Recipe recipe3 = _recipeService.findById( recipe2.getId( ) );
		
		log.info( recipe3.toString( ) );
	}
}
