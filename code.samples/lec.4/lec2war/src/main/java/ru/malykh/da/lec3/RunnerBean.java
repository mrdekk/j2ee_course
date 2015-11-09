package ru.malykh.da.lec3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;

import ru.malykh.da.lec3.jndi.ComfortableTemperature;

public class RunnerBean
{
	private static final Logger log = LoggerFactory.getLogger( RunnerBean.class );
	
	private ComfortableTemperature _comfortableTemperature;
	
	// @formatter:off
	@Required public void setComfortableTemperature( ComfortableTemperature comfortableTemperature ) { _comfortableTemperature = comfortableTemperature; }
	public ComfortableTemperature getComfortableTemperature( ) { return _comfortableTemperature; }
	// @formatter:on
	
	public void init( )
	{
		log.info( String.format(
			"Ссылка %s описывает комфортную температуру как %f ",
			_comfortableTemperature.getRef( ), _comfortableTemperature.getTemperature( )
		) );
	}

}
