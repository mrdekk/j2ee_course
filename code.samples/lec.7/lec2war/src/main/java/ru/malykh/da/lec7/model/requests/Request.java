package ru.malykh.da.lec7.model.requests;

public class Request
{
	private String _type;
	private int _limit;
	
	// @formatter:off
	public void setType( String type ) { _type = type; }
	public String getType( ) { return _type; }
	
	public void setLimit( int limit ) { _limit = limit; }
	public int getLimit( ) { return _limit; }
	// @formatter:on
}
