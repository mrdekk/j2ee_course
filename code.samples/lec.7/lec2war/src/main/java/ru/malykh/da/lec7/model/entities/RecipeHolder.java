package ru.malykh.da.lec7.model.entities;

import java.net.InetAddress;

public class RecipeHolder
{
	private String _hostname;
	
	// @formatter:off
	public void setHostname( String hostname ) { _hostname = hostname; }
	public String getHostname( ) { return _hostname; }
	// @formatter:on
	
	public RecipeHolder( )
	{
		try
		{
			_hostname = InetAddress.getLocalHost( ).getHostName( );
		}
		catch ( Exception exc )
		{
			_hostname = "UNKNOWN";
		}
	}
}
