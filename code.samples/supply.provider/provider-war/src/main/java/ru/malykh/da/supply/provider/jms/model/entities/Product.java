package ru.malykh.da.supply.provider.jms.model.entities;

import java.util.ArrayList;
import java.util.List;

public class Product
{
	private List< String > _categories = new ArrayList< String >( );
	private String _name;
	private String _description;
	private float _price;
	private float _quantity;
	
	// @formatter:off
	public void setCategories( List< String > categories ) { _categories = categories; }
	public List< String > getCategories( ) { return _categories; }
	
	public void setName( String name ) { _name = name; }
	public String getName( ) { return _name; }
	
	public void setDescription( String description ) { _description = description; }
	public String getDescription( ) { return _description; }
	
	public void setPrice( float price ) { _price = price; }
	public float getPrice( ) { return _price; }
	
	public void setQuantity( float quantity ) { _quantity = quantity; }
	public float getQuantity( ) { return _quantity; }
	// @formatter:on
}
