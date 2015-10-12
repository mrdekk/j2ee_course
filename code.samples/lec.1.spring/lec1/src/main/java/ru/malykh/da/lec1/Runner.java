package ru.malykh.da.lec1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner
{
	@SuppressWarnings( "resource" )
	public static void main( String[ ] args ) 
	{
		/* ApplicationContext ctx = */ new ClassPathXmlApplicationContext( "classpath:beans.xml" );
	}
}
