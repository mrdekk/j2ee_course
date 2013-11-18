package ru.mrdekk.j2ee.lec7;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;

public class InListener implements MessageListener
{
	private static final Logger log = LoggerFactory.getLogger( InListener.class );

	private Producer _producer;
	
	// @formatter:off
	@Required public void setProducer( Producer producer ) { _producer = producer; }
	public Producer getProducer( ) { return _producer; }
	// @formatter:on
	
	@Override
	public void onMessage( Message message )
	{
		try
		{
			if ( ! ( message instanceof TextMessage ) )
				return ;
			
			TextMessage msg = ( TextMessage )message;
			String json = msg.getText( );
			
			ObjectMapper mapper = new ObjectMapper( );
			Obj obj = mapper.readValue( json, Obj.class );
			
			_producer.put( obj );
		}
		catch ( Exception exc )
		{
			// do nothing and don't bother
			log.error( "", exc );
		}
	}	
}
