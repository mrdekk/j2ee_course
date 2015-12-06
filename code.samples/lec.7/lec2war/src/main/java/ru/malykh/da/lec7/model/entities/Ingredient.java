package ru.malykh.da.lec7.model.entities;

public class Ingredient
{
	private String _component;
	private float _quantity;
	
	// @formatter:off
	public void setComponent( String component ) { _component = component; }
	public String getComponent( ) { return _component; }
	
	public void setQuantity( float quantity ) { _quantity = quantity; }
	public float getQuantity( ) { return _quantity; }
	// @formatter:on
	
	public ru.malykh.da.lec4.model.entities.Ingredient create( )
	{
		ru.malykh.da.lec4.model.entities.Ingredient ingr = new ru.malykh.da.lec4.model.entities.Ingredient( );
		
		ingr.setId( null ); // Потому что мы создаем новый, и хотим чтобы ID был сгенерирован в БД
		ingr.setComponent( _component );
		ingr.setQuantity( _quantity );

		return ingr;
	}
}
