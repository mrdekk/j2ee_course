package ru.malykh.da.lec5.web.model.responses;

public class ErrorResponse extends Response
{
	private String _message;
	private int _errorCode = -1;
	
	// @formatter:off
	public void setMessage( String message ) { _message = message; }
	public String getMessage( ) { return _message; }
	
	public void setErrorCode( int errorCode ) { _errorCode = errorCode; }
	public int getErrorCode( ) { return _errorCode; }
	// @formatter:on
	
	public ErrorResponse( )
	{
		setStatus( "fail" );
	}
}
