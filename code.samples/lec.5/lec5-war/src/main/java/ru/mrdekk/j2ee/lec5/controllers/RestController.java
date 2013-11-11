package ru.mrdekk.j2ee.lec5.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.mrdekk.j2ee.lec5.entities.Recipe;
import ru.mrdekk.j2ee.lec5.entities.RecipeItem;
import ru.mrdekk.j2ee.lec5.serviceModel.requests.RecipeRequest;
import ru.mrdekk.j2ee.lec5.serviceModel.response.ErrorResponse;
import ru.mrdekk.j2ee.lec5.serviceModel.response.RecipesResponse;
import ru.mrdekk.j2ee.lec5.serviceModel.response.Response;
import ru.mrdekk.j2ee.lec5.services.IRecipeService;

@Controller
@RequestMapping( "/rest" )
public class RestController
{
	@Autowired
	@Qualifier( "recipeService" )
	private IRecipeService _recipeService;
	
	@RequestMapping( value = "/search/{name}", method = RequestMethod.GET )
	public @ResponseBody Response searchRecipeByName( @PathVariable( "name" ) String name )
	{
		try
		{
			List< Recipe > recipes = _recipeService.findByName( name );
			
			RecipesResponse response = new RecipesResponse( );
			response.setRecipes( recipes );
			
			return response;
		}
		catch ( Exception exc )
		{
			ErrorResponse response = new ErrorResponse( );
			response.setStatus( "fail" );
			response.setMessage( exc.getMessage( ) );
			
			return response;
		}
	}
	
	@RequestMapping( value = "/add", method = RequestMethod.POST )
	public @ResponseBody Response addNewRecipe( @RequestBody RecipeRequest request )
	{
		try
		{
			Recipe recipe = request.getRecipe( );
			List< RecipeItem > items = recipe.getItems( );
			
			recipe.setItems( new ArrayList< RecipeItem >( ) );
			_recipeService.create( recipe );
			
			for ( RecipeItem item : items )
			{
				Recipe.connect( recipe, item );
			}
			_recipeService.update( recipe );
			
			return new Response( );
		}
		catch ( Exception exc )
		{
			ErrorResponse response = new ErrorResponse( );
			response.setStatus( "fail" );
			response.setMessage( exc.getMessage( ) );
			
			return response;
		}
	}
}
