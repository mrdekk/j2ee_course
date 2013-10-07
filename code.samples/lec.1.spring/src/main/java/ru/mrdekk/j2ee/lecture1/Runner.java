package ru.mrdekk.j2ee.lecture1;

// import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner
{
	public static void main( String[ ] args ) 
	{
		/* ApplicationContext ctx = */ new ClassPathXmlApplicationContext( "/beans.xml" );
	}
}
