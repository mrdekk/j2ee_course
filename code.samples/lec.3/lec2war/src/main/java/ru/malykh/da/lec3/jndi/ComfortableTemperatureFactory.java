package ru.malykh.da.lec3.jndi;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.RefAddr;
import javax.naming.Reference;
import javax.naming.spi.ObjectFactory;

public class ComfortableTemperatureFactory implements ObjectFactory
{
	public Object getObjectInstance( Object obj, Name name, Context nameCtx, Hashtable< ?, ? > environment ) 
		throws Exception
	{
		if ( obj instanceof Reference ) 
		{
			Reference ref = ( Reference )obj;
			
			if ( ref.getClassName( ).equals( ComfortableTemperature.class.getName( ) ) )  
			{
				RefAddr addrRef = ref.get( ComfortableTemperature.REF_ADDR_REF );
				RefAddr addrTemperature = ref.get( ComfortableTemperature.REF_ADDR_TEMPERATURE );
				
				if ( null != addrRef && null != addrTemperature )
				{
					return new ComfortableTemperature( 
						addrRef.getContent( ).toString( ), 
						Float.parseFloat( addrTemperature.getContent( ).toString( ) ) 
					);
				}
			}
		}
		
		return null;	
	}
}
