package ru.malykh.da.lec5.web.model.responses;

import java.util.ArrayList;
import java.util.List;

import ru.malykh.da.lec5.web.model.entities.Recipe;

public class RecipesResponse
{
	private List< Recipe > _recipes = new ArrayList< Recipe >( );
	
	// @formatter:off
	public void setRecipes( List< Recipe > recipes ) { _recipes = recipes; }
	public List< Recipe > getRecipes( ) { return _recipes; }
	// @formatter:on
}
