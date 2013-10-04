package ru.mrdekk.j2ee;

import ru.mrdekk.j2ee.interfaces.IActuator;
import ru.mrdekk.j2ee.interfaces.ISensor;

public class IntellectualController
{	
	private ISensor _sensor;
	private IActuator _actuator;
	private double _limit;
	
	// @formatter:off
	public void setSensor( ISensor sensor ) { _sensor = sensor; }
	public ISensor getSensor( ) { return _sensor; }
	
	public void setActuator( IActuator actuator ) { _actuator = actuator; }
	public IActuator getActuator( ) { return _actuator; }
	
	public void setLimit( double limit ) { _limit = limit; }
	public double getLimit( ) { return _limit; }
	// @formatter:on
	
	public IntellectualController( String url )
	{
		
	}
	
	
	public void doTheWork( )
	{
		if ( _sensor.getTemperature( ) > _limit )
		{
			_actuator.start( );
		}
		else
		{
			_actuator.stop( );
		}
	}
}
