package ru.malykh.da.lec1.impl;

import java.util.Random;

import ru.malykh.da.lec1.interfaces.ISensor;

public class Sensor implements ISensor
{
	private String _url;
	private Random _rnd;
	
	public Sensor( String url )
	{
		System.out.println( String.format(
			"Создан датчик температуры в точке %s.", url
		) );
		
		_url = url;
		_rnd = new Random( );
	}
	
	public double getTemperature( )
	{
		double rnd = _rnd.nextDouble( ) * 50.0f;
		
		System.out.println( String.format(
			"Текущее показание датчика температуры в точке %s - %f.",
			_url, rnd
		) );
		
		return rnd;
	}
}
