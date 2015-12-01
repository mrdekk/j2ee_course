package ru.malykh.da.lec5.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.malykh.da.lec4.model.services.IIngredientService;
import ru.malykh.da.lec4.model.services.IRecipeService;
import ru.malykh.da.lec5.web.model.entities.Ingredient;
import ru.malykh.da.lec5.web.model.entities.Recipe;
import ru.malykh.da.lec5.web.model.requests.IngredientRequest;
import ru.malykh.da.lec5.web.model.requests.RecipeRequest;
import ru.malykh.da.lec5.web.model.responses.IdResponse;
import ru.malykh.da.lec5.web.model.responses.IngredientResponse;
import ru.malykh.da.lec5.web.model.responses.IngredientsResponse;
import ru.malykh.da.lec5.web.model.responses.RecipeResponse;
import ru.malykh.da.lec5.web.model.responses.RecipesResponse;
import ru.malykh.da.lec5.web.model.responses.Response;

@Controller
@RequestMapping( "/rest/recipes" )
public class RecipeController extends BaseController
{
	@Autowired
	@Qualifier( "recipeService" )
	private IRecipeService _recipeService;

	@Autowired
	@Qualifier( "ingredientService" )
	private IIngredientService _ingredientService;
	
	// Recipes

	@RequestMapping( value = "", method = RequestMethod.GET )
	public @ResponseBody RecipesResponse getRecipes( )
	{
		List< ru.malykh.da.lec4.model.entities.Recipe > dbRecipes = _recipeService.findAll( );
		
		RecipesResponse response = new RecipesResponse( );
		for ( ru.malykh.da.lec4.model.entities.Recipe dbRecipe : dbRecipes )
		{
			Recipe recipe = Recipe.map( dbRecipe );
			if ( null != recipe )
				response.getRecipes( ).add( recipe );
		}
		
		return response;
	}
	
	@RequestMapping( value = "", method = RequestMethod.POST )
	public @ResponseBody IdResponse createRecipe( @RequestBody RecipeRequest request )
	{
		ru.malykh.da.lec4.model.entities.Recipe dbRecipe = request.getRecipe( ).create( );
		
		dbRecipe = _recipeService.create( dbRecipe );
		
		IdResponse response = new IdResponse( );
		response.setId( dbRecipe.getId( ) );
		
		return response;
	}
	
	@RequestMapping( value = "/{id}", method = RequestMethod.GET )
	public @ResponseBody RecipeResponse getRecipe( @PathVariable( "id" ) Integer id )
		throws Exception
	{
		ru.malykh.da.lec4.model.entities.Recipe dbRecipe = _recipeService.findById( id );
		if ( null == dbRecipe )
			throw new Exception( String.format( "Рецепт с идентификатором %d не найден", id ) );
		
		Recipe recipe = Recipe.map( dbRecipe );
		if ( null == recipe )
			throw new Exception( String.format( "Не удалось преобразовать рецепт с идентификатором %d", id ) );
		
		RecipeResponse response = new RecipeResponse( );
		response.setRecipe( recipe );
		
		return response;
	}
	
	@RequestMapping( value = "/{id}", method = RequestMethod.PUT )
	public @ResponseBody Response updateRecipe( 
			@PathVariable( "id" ) Integer id, 
			@RequestBody RecipeRequest request )
		throws Exception
	{
		ru.malykh.da.lec4.model.entities.Recipe dbRecipe = _recipeService.findById( id );
		if ( null == dbRecipe )
			throw new Exception( String.format( "Рецепт с идентификатором %d не найден", id ) );
		
		request.getRecipe( ).update( dbRecipe );
		_recipeService.update( dbRecipe );
		
		return new Response( );
	}
	
	@RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
	public @ResponseBody Response deleteRecipe( @PathVariable( "id" ) Integer id )
		throws Exception
	{
		ru.malykh.da.lec4.model.entities.Recipe dbRecipe = _recipeService.findById( id );
		if ( null == dbRecipe )
			throw new Exception( String.format( "Рецепт с идентификатором %d не найден", id ) );

		_recipeService.delete( id );
		
		return new Response( );
	}
	
	// Ingredients
	
	@RequestMapping( value = "/{id}/ingredients", method = RequestMethod.GET )
	public @ResponseBody IngredientsResponse getRecipeIngredients( @PathVariable( "id" ) Integer id )
		throws Exception
	{
		ru.malykh.da.lec4.model.entities.Recipe dbRecipe = _recipeService.findById( id );
		if ( null == dbRecipe )
			throw new Exception( String.format( "Рецепт с идентификатором %d не найден", id ) );
		
		IngredientsResponse response = new IngredientsResponse( );
		for ( ru.malykh.da.lec4.model.entities.Ingredient dbIngredient : dbRecipe.getIngredient( ) )
		{
			Ingredient ingredient = Ingredient.map( dbIngredient );
			if ( null != ingredient )
				response.getIngredients( ).add( ingredient );
		}
		
		return response;
	}
	
	@RequestMapping( value = "/{id}/ingredients", method = RequestMethod.POST )
	public @ResponseBody IdResponse createRecipeIngredient( 
			@PathVariable( "id" ) Integer id,
			@RequestBody IngredientRequest request )
		throws Exception
	{
		ru.malykh.da.lec4.model.entities.Recipe dbRecipe = _recipeService.findById( id );
		if ( null == dbRecipe )
			throw new Exception( String.format( "Рецепт с идентификатором %d не найден", id ) );

		ru.malykh.da.lec4.model.entities.Ingredient dbIngredient = request.getIngredient( ).create( );
		dbIngredient.setRecipe( dbRecipe );
		dbIngredient = _ingredientService.create( dbIngredient );
		
		IdResponse response = new IdResponse( );
		response.setId( dbIngredient.getId( ) );
		
		return response;
	}
	
	@RequestMapping( value = "/{id}/ingredients/{ingrId}", method = RequestMethod.GET )
	public @ResponseBody IngredientResponse getRecipeIngredient(
			@PathVariable( "id" ) Integer id,
			@PathVariable( "ingrId" ) Integer ingrId )
		throws Exception
	{
		ru.malykh.da.lec4.model.entities.Ingredient dbIngredient = findIngredient( id, ingrId );
		
		Ingredient ingredient = Ingredient.map( dbIngredient );
		if ( null == ingredient )
			throw new Exception( String.format( "Не удалось отобразить ингредиент %d в рецепте %d не найден", ingrId, id ) );
		
		IngredientResponse response = new IngredientResponse( );
		response.setIngredient( ingredient );
		
		return response;
	}
	
	@RequestMapping( value = "/{id}/ingredients/{ingrId}", method = RequestMethod.PUT )
	public @ResponseBody Response updateRecipeIngredient(
			@PathVariable( "id" ) Integer id,
			@PathVariable( "ingrId" ) Integer ingrId,
			@RequestBody IngredientRequest request )
		throws Exception
	{
		ru.malykh.da.lec4.model.entities.Ingredient dbIngredient = findIngredient( id, ingrId );

		request.getIngredient( ).update( dbIngredient );
		_ingredientService.update( dbIngredient );
		
		return new Response( );
	}
	
	@RequestMapping( value = "/{id}/ingredients/{ingrId}", method = RequestMethod.DELETE )
	public @ResponseBody Response deleteRecipeIngredient(
			@PathVariable( "id") Integer id,
			@PathVariable( "ingrId" ) Integer ingrId )
		throws Exception
	{
		// Проверяем, что такое ингредиент действительно существует
		findIngredient( id, ingrId );

		_ingredientService.delete( ingrId );
		
		return new Response( );
	}
	
	// Вспомогательные функции
	
	private ru.malykh.da.lec4.model.entities.Ingredient findIngredient( Integer id, Integer ingrId )
		throws Exception
	{
		ru.malykh.da.lec4.model.entities.Recipe dbRecipe = _recipeService.findById( id );
		if ( null == dbRecipe )
			throw new Exception( String.format( "Рецепт с идентификатором %d не найден", id ) );

		ru.malykh.da.lec4.model.entities.Ingredient dbIngredient = null;
		for ( ru.malykh.da.lec4.model.entities.Ingredient iDbIngredient : dbRecipe.getIngredient( ) )
		{
			if ( iDbIngredient.getId( ).equals( ingrId ) )
			{
				dbIngredient = iDbIngredient;
				break;
			}
		}
		
		if ( null == dbIngredient )
			throw new Exception( String.format( "Ингредиент %d в рецепте %d не найден", ingrId, id ) );
		
		return dbIngredient;
	}
}
