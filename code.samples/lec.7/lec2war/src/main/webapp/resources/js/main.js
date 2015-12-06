$( document ).ready( function( )
{
	var baseUrl = $( "#baseUrl" ).text( );
	
	function Recipe( data )
	{
		this.id = ko.observable( data.id );
		this.name = ko.observable( data.name );
	}
	
	function Ingredient( data )
	{
		this.id = ko.observable( data.id );
		this.component = ko.observable( data.component );
		this.quantity = ko.observable( data.quantity );
	}
	
	function Controller( )
	{
		var self = this;
		
		self.recipes = ko.observableArray( [ ] );
		self.ingredients = ko.observableArray( [ ] );
		
		$.getJSON( baseUrl + "/rest/recipes", function( response ) 
		{
			var mapped = $.map( response.recipes, function( item ) 
			{
				return new Recipe( item );
			} );
			
			self.recipes( mapped );
		} );
		
		self.viewRecipe = function( recipe )
		{
			$.getJSON( baseUrl + "/rest/recipes/" + recipe.id() + "/ingredients", function( response )
			{
				var mapped = $.map( response.ingredients, function( item )
				{
					return new Ingredient( item );
				} );
				
				self.ingredients( mapped );
			} );
		}
	}
	
	
	ko.applyBindings( new Controller( ) );
} );