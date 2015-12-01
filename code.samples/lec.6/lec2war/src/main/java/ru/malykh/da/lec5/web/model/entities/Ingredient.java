package ru.malykh.da.lec5.web.model.entities;

import ru.malykh.da.lec5.utils.Comparer;

public class Ingredient
{
	private Integer _id;
	private String _component;
	private float _quantity;
	
	// @formatter:off
	public void setId( Integer id ) { _id = id; }
	public Integer getId( ) { return _id; }
	
	public void setComponent( String component ) { _component = component; }
	public String getComponent( ) { return _component; }
	
	public void setQuantity( float quantity ) { _quantity = quantity; }
	public float getQuantity( ) { return _quantity; }
	// @formatter:on

	public static Ingredient map( ru.malykh.da.lec4.model.entities.Ingredient ingr )
	{
		Ingredient i = new Ingredient( );
		
		i.setId( ingr.getId( ) );
		i.setComponent( ingr.getComponent( ) );
		i.setQuantity( ingr.getQuantity( ) );
		
		/**
		 * ВАЖНО!
		 * Мы не занимаемся здесь отражением родительской сущности (Recipe)
		 * Это задача для контроллера в зависимости от типа метода
		 */
		
		return i;
	}
	
	public ru.malykh.da.lec4.model.entities.Ingredient create( )
	{
		ru.malykh.da.lec4.model.entities.Ingredient ingr = new ru.malykh.da.lec4.model.entities.Ingredient( );
		
		ingr.setId( null ); // Потому что мы создаем новый, и хотим чтобы ID был сгенерирован в БД
		ingr.setComponent( _component );
		ingr.setQuantity( _quantity );
		
		/**
		 * ВАЖНО!
		 * Мы не занимаемся здесь отражением родительской сущности (Recipe)
		 * Это задача для контроллера в зависимости от типа метода
		 */

		return ingr;
	}
	
	public void update( ru.malykh.da.lec4.model.entities.Ingredient ingr )
	{
		if ( ! Comparer.equals( _component, ingr.getComponent( ) ) )
			ingr.setComponent( _component );
		
		if ( ! Comparer.equals( _quantity, ingr.getQuantity( ) ) )
			ingr.setQuantity( _quantity );
		
		/**
		 * ВАЖНО!
		 * Мы не занимаемся здесь отражением родительской сущности (Recipe)
		 * Это задача для контроллера в зависимости от типа метода
		 */
	}
}
