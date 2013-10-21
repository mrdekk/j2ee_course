package ru.mrdekk.j2ee.lec3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.mrdekk.j2ee.lec3.jndi.ComfortableTemperature;

public class GenericBean
{
	private static final Logger log = LoggerFactory.getLogger( GenericBean.class );
	
	private ComfortableTemperature _comfortableTemperature;
	
	// @formatter:off
	public void setComfortableTemperature( ComfortableTemperature comfortableTemperature ) { _comfortableTemperature = comfortableTemperature; }
	public ComfortableTemperature getComfortableTemperature( ) { return _comfortableTemperature; }
	// @formatter:on
	
	public void init( )
	{
		log.info( String.format(
			"Reference %s describes comfortable temperature as %f",
			_comfortableTemperature.getRef( ), _comfortableTemperature.getTemperature( )
		) );
	}
}
