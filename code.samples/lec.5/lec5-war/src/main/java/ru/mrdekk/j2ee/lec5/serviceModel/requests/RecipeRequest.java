package ru.mrdekk.j2ee.lec5.serviceModel.requests;

import ru.mrdekk.j2ee.lec5.entities.Recipe;

public class RecipeRequest extends Request
{
	private Recipe _recipe;
	
	// @formatter:off
	public void setRecipe( Recipe recipe ) { _recipe = recipe; }
	public Recipe getRecipe( ) { return _recipe; }
	// @formatter:on
}
