package ru.mrdekk.j2ee.lec7;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class Producer
{
	private static final Logger log = LoggerFactory.getLogger( Producer.class );
	
	private JmsTemplate _jmsTemplate;
	private Destination _destination;
	
	// @formatter:off
	@Required public void setJmsTemplate( JmsTemplate jmsTemplate ) { _jmsTemplate = jmsTemplate; }
	public JmsTemplate getJmsTemplate( ) { return _jmsTemplate; }
	
	@Required public void setDestination( Destination destination ) { _destination = destination; }
	public Destination getDestination( ) { return _destination; }
	// @formatter:on
	
	public void put( Obj obj )
	{
		try
		{
			ObjectMapper mapper = new ObjectMapper( );
			final String json = mapper.writeValueAsString( obj );
			
			_jmsTemplate.send( _destination, new MessageCreator( )
			{
				@Override
				public Message createMessage( Session session ) 
					throws JMSException
				{
					TextMessage msg = session.createTextMessage( json );
					return msg;
				}				
			} );
		}
		catch ( Exception exc )
		{
			log.error( "", exc );
		}
	}
}
