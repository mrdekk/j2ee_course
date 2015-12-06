package ru.malykh.da.supply.provider.jms.model.responses;

import java.util.ArrayList;
import java.util.List;

import ru.malykh.da.supply.provider.jms.model.entities.Product;

public class ProductsResponse extends Response
{
	private List< Product > _products = new ArrayList< Product >( );
	
	// @formatter:off
	public void setProducts( List< Product > products ) { _products = products; }
	public List< Product > getProducts( ) { return _products; }
	// @formatter:on
}
