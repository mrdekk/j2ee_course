package ru.malykh.da.lec5.web.model.responses;

import java.util.ArrayList;
import java.util.List;

import ru.malykh.da.lec5.web.model.entities.Ingredient;

public class IngredientsResponse extends Response
{
	private List< Ingredient > _ingredients = new ArrayList< Ingredient >( );
	
	// @formatter:off
	public void setIngredients( List< Ingredient > ingredients ) { _ingredients = ingredients; }
	public List< Ingredient > getIngredients( ) { return _ingredients; }
	// @formatter:on
}
