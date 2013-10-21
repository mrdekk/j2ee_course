package ru.mrdekk.j2ee.lec3.jndi;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;
import javax.naming.StringRefAddr;

public class ComfortableTemperature implements Referenceable
{
	public static final String REF_ADDR_REF = "ref";
	public static final String REF_ADDR_TEMPERATURE = "temperature";
	
	private String _ref;
	private float _temperature;
	
	public ComfortableTemperature( String ref, float temperature )
	{
		_ref = ref;
		_temperature = temperature;
	}

	public Reference getReference( ) 
		throws NamingException
	{
		Reference ref = new Reference(
			ComfortableTemperature.class.getName( ),
			new StringRefAddr( "ref", _ref ),
			ComfortableTemperatureFactory.class.getName( ),
			null
		);
		
		ref.add( new StringRefAddr( "temperature", Float.toString( _temperature ) ) ); 
		
		return ref;
	}

	public String toString( )
	{
		return _ref;
	}
	
	public String getRef( )
	{
		return _ref;
	}
	
	public float getTemperature( )
	{
		return _temperature;
	}
}
