package ru.malykh.da.lec5.web.model.responses;

import ru.malykh.da.lec5.web.model.entities.Recipe;

public class RecipeResponse extends Response
{
	private Recipe _recipe;
	
	// @formatter:off
	public void setRecipe( Recipe recipe ) { _recipe = recipe; }
	public Recipe getRecipe( ) { return _recipe; }
	// @formatter:on
}
