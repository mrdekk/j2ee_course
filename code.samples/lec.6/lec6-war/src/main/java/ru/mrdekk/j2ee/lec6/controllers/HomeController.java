package ru.mrdekk.j2ee.lec6.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController
{
	@RequestMapping( value = "/", method = RequestMethod.GET )
	public ModelAndView index( )
	{
		ModelAndView mav = new ModelAndView( "index" );
		
		mav.addObject( "title", "Hello, World! jsp-page" );
		mav.addObject( "greeting", "Hello, World!" );
		
		return mav;
	}
	
	@RequestMapping( value = "/greet", method = RequestMethod.GET )
	public String greetGet( )
	{
		return "greetget";
	}
	
	@RequestMapping( value = "/greet", method = RequestMethod.POST )
	public ModelAndView greetPost( @RequestParam( "name" ) String name )
	{
		ModelAndView mav = new ModelAndView( "greetpost" );
		
		mav.addObject( "name", name );
		mav.addObject( "greeting", "Hello: " + name );
		
		return mav;
	}
}
