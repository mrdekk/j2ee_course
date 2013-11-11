package ru.mrdekk.j2ee.lec5.serviceModel.response;

import java.util.List;

import ru.mrdekk.j2ee.lec5.entities.Recipe;

public class RecipesResponse extends Response
{
	private List< Recipe > _recipes;
	
	// @formatter:off
	public void setRecipes( List< Recipe > recipes ) { _recipes = recipes; }
	public List< Recipe > getRecipes( ) { return _recipes; }
	// @formatter:on
}
