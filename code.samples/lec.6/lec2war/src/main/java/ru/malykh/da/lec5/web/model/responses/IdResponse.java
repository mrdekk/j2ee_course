package ru.malykh.da.lec5.web.model.responses;

public class IdResponse extends Response
{
	private Integer _id;
	
	// @formatter:off
	public void setId( Integer id ) { _id = id; }
	public Integer getId( ) { return _id; }
	// @formatter:on
}
