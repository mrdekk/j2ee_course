package ru.malykh.da.supply.provider.jms.model.requests;

import ru.malykh.da.supply.provider.jms.model.entities.Warehouse;

public class ProductsRequest extends Request
{
	private Warehouse _warehouse;
	
	// @formatter:off
	public void setWarehouse( Warehouse warehouse ) { _warehouse = warehouse; }
	public Warehouse getWarehouse( ) { return _warehouse; }
	// @formatter:on
}
