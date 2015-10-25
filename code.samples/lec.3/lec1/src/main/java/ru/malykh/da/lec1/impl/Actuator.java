package ru.malykh.da.lec1.impl;

import ru.malykh.da.lec1.interfaces.IActuator;

public class Actuator implements IActuator
{
	private String _url;
	
	public Actuator( String url )
	{
		System.out.println( String.format( 
			"Создали исполнительное устройство в точке %s.", url 
		) );
		
		_url = url;
	}
	
	public void start( )
	{
		System.out.println( String.format(
			"Запущено исполнительное устройство в точке %s.", _url
		) );
	}
	
	public void stop( )
	{
		System.out.println( String.format(
			"Исполнительное устройство остановлено в точке %s.", _url
		) );		
	}
}
