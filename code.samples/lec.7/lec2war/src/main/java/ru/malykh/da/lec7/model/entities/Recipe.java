package ru.malykh.da.lec7.model.entities;

import java.util.ArrayList;
import java.util.List;

public class Recipe
{
	private String _name;
	private List< Ingredient > _ingredients = new ArrayList< Ingredient >( );
	
	// @formatter:off
	public void setName( String name ) { _name = name; }
	public String getName( ) { return _name; }
	
	public void setIngredients( List< Ingredient > ingredients ) { _ingredients = ingredients; }
	public List< Ingredient > getIngredients( ) { return _ingredients; }
	// @formatter:on
	
	public ru.malykh.da.lec4.model.entities.Recipe create( )
	{
		ru.malykh.da.lec4.model.entities.Recipe rec = new ru.malykh.da.lec4.model.entities.Recipe( );
		
		rec.setId( null ); // Потому что мы создаем новый, и хотим чтобы ID был сгенерирован в БД
		rec.setName( _name );

		/**
		 * Пока не мапим ингредиенты, сделаем это позже
		 */
		
		return rec;
	}
}
