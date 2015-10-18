package ru.malykh.da.lec2;

import org.springframework.beans.factory.annotation.Required;

import ru.malykh.da.lec1.services.IntellectualController;

public class RunnerBean
{
	private IntellectualController _controller;
	
	// @formatter:off
	@Required public void setController( IntellectualController controller ) { _controller = controller; }
	public IntellectualController getController( ) { return _controller; }
	// @formatter:on
	
	public void init( ) 
	{
		_controller.doTheWork( );
	}
}
