package ru.malykh.da.lec5.web.model.requests;

import ru.malykh.da.lec5.web.model.entities.Ingredient;

public class IngredientRequest extends Request
{
	private Ingredient _ingredient;
	
	// @formatter:off
	public void setIngredient( Ingredient ingredient ) { _ingredient = ingredient; }
	public Ingredient getIngredient( ) { return _ingredient; }
	// @formatter:on
}
