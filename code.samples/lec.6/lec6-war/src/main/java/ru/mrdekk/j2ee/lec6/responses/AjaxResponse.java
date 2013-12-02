package ru.mrdekk.j2ee.lec6.responses;

public class AjaxResponse extends Response
{
	private String _str;
		
	// @formatter:off
	public void setStr( String str ) { _str = str; }
	public String getStr( ) { return _str; }
	// @formatter:on
}
