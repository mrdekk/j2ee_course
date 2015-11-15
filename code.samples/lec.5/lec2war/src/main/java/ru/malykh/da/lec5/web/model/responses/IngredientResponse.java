package ru.malykh.da.lec5.web.model.responses;

import ru.malykh.da.lec5.web.model.entities.Ingredient;

public class IngredientResponse extends Response
{
	private Ingredient _ingredient;
	
	// @formatter:off
	public void setIngredient( Ingredient ingredient ) { _ingredient = ingredient; }
	public Ingredient getIngredient( ) { return _ingredient; }
	// @formatter:on
}
