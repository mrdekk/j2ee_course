package ru.malykh.da.lec5.web.model.entities;

import ru.malykh.da.lec5.utils.Comparer;

public class Recipe
{
	private Integer _id;
	private String _name;
	
	// @formatter:off
	public void setId( Integer id ) { _id = id; }
	public Integer getId( ) { return _id; }
	
	public void setName( String name ) { _name = name; }
	public String getName( ) { return _name; }
	// @formatter:on

	public static Recipe map( ru.malykh.da.lec4.model.entities.Recipe rec )
	{
		Recipe r = new Recipe( );
		
		r.setId( rec.getId( ) );
		r.setName( rec.getName( ) );
		
		/**
		 * ВАЖНО!
		 * Мы не занимаемся здесь отражением зависимых сущностей (Ingredient)
		 * Это задача для контроллера в зависимости от типа метода
		 */
		
		return r;
	}
	
	public ru.malykh.da.lec4.model.entities.Recipe create( )
	{
		ru.malykh.da.lec4.model.entities.Recipe rec = new ru.malykh.da.lec4.model.entities.Recipe( );
		
		rec.setId( null ); // Потому что мы создаем новый, и хотим чтобы ID был сгенерирован в БД
		rec.setName( _name );
		
		/**
		 * ВАЖНО!
		 * Мы не занимаемся здесь отражением зависимых сущностей (Ingredient)
		 * Это задача для контроллера в зависимости от типа метода
		 */
		
		return rec;
	}
	
	public void update( ru.malykh.da.lec4.model.entities.Recipe rec )
	{
		if ( ! Comparer.equals( _name, rec.getName( ) ) )
			rec.setName( _name );
		
		/**
		 * ВАЖНО!
		 * Мы не занимаемся здесь отражением зависимых сущностей (Ingredient)
		 * Это задача для контроллера в зависимости от типа метода
		 */
	}
}
