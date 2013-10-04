package ru.mrdekk.j2ee;

public class Main_1
{
	public static void main( String[ ] args )
	{
		Sensor sensor = new Sensor( "http://automation.local/sensor" );
		Actuator actuator = new Actuator( "http://automation.local/actuator" );
		
		IntellectualController controller = new IntellectualController( "Controller.1" );
		controller.setSensor( sensor );
		controller.setActuator( actuator );
		
		while ( true )
		{
			controller.doTheWork( );
		}
	}
}
