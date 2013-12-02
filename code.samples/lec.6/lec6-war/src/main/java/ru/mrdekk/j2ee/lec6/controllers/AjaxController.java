package ru.mrdekk.j2ee.lec6.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.mrdekk.j2ee.lec6.requests.PostXRequest;
import ru.mrdekk.j2ee.lec6.responses.AjaxResponse;
import ru.mrdekk.j2ee.lec6.responses.ErrorResponse;
import ru.mrdekk.j2ee.lec6.responses.Response;

@Controller
@RequestMapping( "/ajax" )
public class AjaxController
{
	@RequestMapping( value = "/index", method = RequestMethod.GET )
	public String index( )
	{
		return "ajaxindex";
	}
	
	@RequestMapping( value = "/postx", method = RequestMethod.POST )
	public @ResponseBody Response postX( @RequestBody PostXRequest request )
	{
		try
		{
			AjaxResponse resp = new AjaxResponse( );
			resp.setStr( new StringBuilder( request.getStr( ) ).reverse( ).toString( ) );
			
			return resp;
		}
		catch ( Exception exc )
		{
			ErrorResponse resp = new ErrorResponse( );
			resp.setStatus( "fail" );
			resp.setMessage( exc.getMessage( ) );
			
			return resp;
		}
	}
}
