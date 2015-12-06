package ru.malykh.da.supply.provider.processing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.jms.BytesMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;

import com.fasterxml.jackson.databind.ObjectMapper;

import ru.malykh.da.supply.provider.jms.model.entities.Product;
import ru.malykh.da.supply.provider.jms.model.requests.ProductsRequest;
import ru.malykh.da.supply.provider.jms.model.responses.ProductsResponse;

public class ReqListener implements MessageListener
{
	private static final Logger log = LoggerFactory.getLogger( ReqListener.class );
	
	private static List< String > s_categories;
	private static List< String > s_names;
	private static List< String > s_descriptions;
	private static Random _rnd;
	
	static 
	{
		s_categories = new ArrayList< String >( );
		s_categories.add( "Фрукты" );
		s_categories.add( "Овощи" );
		s_categories.add( "Парфюмерия" );
		s_categories.add( "Бакалея" );
		s_categories.add( "Электроника" );
		
		s_names = new ArrayList< String >( );
		s_names.add( "Яблоки" );
		s_names.add( "Груши" );
		s_names.add( "Тыква" );
		s_names.add( "Морковь" );
		s_names.add( "Картофель" );
		s_names.add( "Chanel 5" );
		s_names.add( "Тройной одеколон" );
		s_names.add( "Гречка" );
		s_names.add( "Перловка" );
		s_names.add( "Овсянка" );
		s_names.add( "Компьютер" );
		s_names.add( "iPhone" );
		s_names.add( "iPad" );
		s_names.add( "Утюг" );
		
		s_descriptions = new ArrayList< String >( );
		s_descriptions.add( "Вкусные вкусные яблоки из краснодарского края" );
		s_descriptions.add( "Очень сочные груши из Китая" );
		s_descriptions.add( "Большая тыква - свежий урожай" );
		s_descriptions.add( "Морковка - вкусный вкусный, мамой клянусь" );
		s_descriptions.add( "Картошечка из Беларуси, то что батька прописал" );
		s_descriptions.add( "Оригинальный шинель номер 5, только у нас" );
		s_descriptions.add( "Тройной одеколон, даже занозы обрабатывать можно" );
		s_descriptions.add( "Гречка - натуральный продукт" );
		s_descriptions.add( "Перловка, супер каша, можно и в суп" );
		s_descriptions.add( "Овсянка, сэр! Опять овсянка, сэр!" );
		s_descriptions.add( "Быстрый быстрый, новый процессор, 5 гигов" );
		s_descriptions.add( "125s, экран высотой с трехэтажный дом" );
		s_descriptions.add( "Super-Light-Air толщиной меньше волоса" );
		s_descriptions.add( "Для криптоанализа самое то" );
		
		_rnd = new Random( System.currentTimeMillis( ) );
	}
	
	private Sender _sender;
	
	// @formatter:off
	@Required public void setSender( Sender sender ) { _sender = sender; }
	public Sender getSender( ) { return _sender; }
	// @formatter:on

	@Override
	public void onMessage( Message message )
	{
		try
		{
			String json = null;
			if ( message instanceof TextMessage )
				json = ( ( TextMessage )message ).getText( );
			else if ( message instanceof BytesMessage )
			{
				BytesMessage msg = ( BytesMessage )message;
				byte[ ] data = new byte[ ( int )msg.getBodyLength( ) ]; // Только для демонстрации, в реальной жизни так делать не стоит
				int read = msg.readBytes( data );
				json = new String( data, 0, read, "UTF-8" );
			}
			
			if ( null == json )
				throw new Exception( "Неправильное сообщение!" );
			
			ObjectMapper jsonMapper = new ObjectMapper( );
			ProductsRequest request = jsonMapper.readValue( json, ProductsRequest.class );
			
			ProductsResponse response = new ProductsResponse( );
			
			for ( int i = 0; i < request.getLimit( ); ++i )
			{
				Product product = new Product( );
				
				int catcount = _rnd.nextInt( s_categories.size( ) );
				for ( int j = 0; j < catcount; ++j )
				{
					product.getCategories( ).add( s_categories.get( _rnd.nextInt( s_categories.size( ) ) ) );
				}
				
				product.setName( s_names.get( _rnd.nextInt( s_names.size( ) ) ) );
				product.setDescription( s_descriptions.get( _rnd.nextInt( s_descriptions.size( ) ) ) );
				product.setPrice( _rnd.nextFloat( ) );
				product.setQuantity( _rnd.nextFloat( ) * 100.0f );
				
				response.getProducts( ).add( product );
			}
			
			_sender.send( response );
		}
		catch ( Exception exc )
		{
			log.info( "oops", exc );
		}
	}

}
