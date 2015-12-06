package ru.malykh.da.lec7.model.requests;

import ru.malykh.da.lec7.model.entities.RecipeHolder;

public class RecipesRequest extends Request
{
	private RecipeHolder _holder;
	
	// @formatter:off
	public void setHolder( RecipeHolder holder ) { _holder = holder; }
	public RecipeHolder getHolder( ) { return _holder; }
	// @formatter:on
}
