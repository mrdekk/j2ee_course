package ru.mrdekk.j2ee.lecture1.impl;

import java.util.Random;

import ru.mrdekk.j2ee.lecture1.interfaces.ISensor;

public class Sensor implements ISensor
{
	private String _url;
	private Random _rnd;
	
	public Sensor( String url )
	{
		System.out.println( String.format(
			"Sensor on %s created.", url
		) );
		
		_url = url;
		_rnd = new Random( );
	}
	
	public double getTemperature( )
	{
		double rnd = _rnd.nextDouble( ) * 50.0f;
		
		System.out.println( String.format(
			"Sensor on %s current value is %f.",
			_url, rnd
		) );
		
		return rnd;
	}
}
