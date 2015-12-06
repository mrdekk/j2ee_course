package ru.malykh.da.lec7.jms;

import javax.jms.BytesMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;

import com.fasterxml.jackson.databind.ObjectMapper;

import ru.malykh.da.lec4.model.services.IIngredientService;
import ru.malykh.da.lec4.model.services.IRecipeService;
import ru.malykh.da.lec7.model.entities.Ingredient;
import ru.malykh.da.lec7.model.entities.Recipe;
import ru.malykh.da.lec7.model.responses.RecipesResponse;

public class RecipesListener implements MessageListener
{
	private static final Logger log = LoggerFactory.getLogger( RecipesListener.class );
	
	private IRecipeService _recipeService;
	private IIngredientService _ingredientService;
	
	// @formatter:off
	@Required public void setRecipeService( IRecipeService recipeService ) { _recipeService = recipeService; }
	public IRecipeService getRecipeService( ) { return _recipeService; }
	
	@Required public void setIngredientService( IIngredientService ingredientService ) { _ingredientService = ingredientService; }
	public IIngredientService getIngredientService( ) { return _ingredientService; }
	// @formatter:on

	@Override
	public void onMessage( Message message )
	{
		try
		{
			String json = null;
			if ( message instanceof TextMessage )
				json = ( ( TextMessage )message ).getText( );
			else if ( message instanceof BytesMessage )
			{
				BytesMessage msg = ( BytesMessage )message;
				byte[ ] data = new byte[ ( int )msg.getBodyLength( ) ]; // Только для демонстрации, в реальной жизни так делать не стоит
				int read = msg.readBytes( data );
				json = new String( data, 0, read, "UTF-8" );
			}
			
			if ( null == json )
				throw new Exception( "Неправильное сообщение!" );
			
			ObjectMapper jsonMapper = new ObjectMapper( );
			RecipesResponse resp = jsonMapper.readValue( json, RecipesResponse.class );
			
			for ( Recipe recipe : resp.getRecipes( ) )
			{
				ru.malykh.da.lec4.model.entities.Recipe r = recipe.create( );
				if ( null != r )
				{
					r = _recipeService.create( r );
					
					for ( Ingredient ingr : recipe.getIngredients( ) )
					{
						ru.malykh.da.lec4.model.entities.Ingredient i = ingr.create( );
						if ( null != i )
						{
							i.setRecipe( r );
							_ingredientService.create( i );
						}
					}
				}
			}
		}
		catch ( Exception exc )
		{
			log.info( "oops", exc );
		}
	}

}
