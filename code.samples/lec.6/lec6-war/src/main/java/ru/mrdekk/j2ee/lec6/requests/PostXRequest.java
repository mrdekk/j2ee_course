package ru.mrdekk.j2ee.lec6.requests;

public class PostXRequest extends Request
{
	private String _str;
	
	// @formatter:off
	public void setStr( String str ) { _str = str; }
	public String getStr( ) { return _str; }
	// @formatter:on
}
