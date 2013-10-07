package ru.mrdekk.j2ee.lecture1.impl;

import ru.mrdekk.j2ee.lecture1.interfaces.IActuator;

public class Actuator implements IActuator
{
	private String _url;
	
	public Actuator( String url )
	{
		System.out.println( String.format(
			"Actuator on %s created.",url 
		) );
		
		_url = url;
	}
	
	public void start( )
	{
		System.out.println( String.format(
			"Actuator on %s started.", _url
		) );
	}
	
	public void stop( )
	{
		System.out.println( String.format(
			"Actuator on %s stoped.", _url
		) );		
	}
}
