package ru.mrdekk.j2ee.lec5.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "recipe" )
public class Recipe
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "id" )
	private Integer id;
	
	@Column( name = "name", nullable = false, length = 100 )
	private String name;
	
	@OneToMany( mappedBy = "recipe", cascade = CascadeType.ALL )
	private List< RecipeItem > items = new ArrayList< RecipeItem >( );
	
	// @formatter:off
	public void setId( Integer id ) { this.id = id; }
	public Integer getId( ) { return id; }
	
	public void setName( String name ) { this.name = name; }
	public String getName( ) { return name; }
	
	public void setItems( List< RecipeItem > items ) { this.items = items; }
	public List< RecipeItem > getItems( ) { return items; }
	// @formatter:on
	
	@Override
	public String toString( )
	{
		StringBuilder bld = new StringBuilder( );
		
		bld.append( String.format( "\"%s\" = {", name ) );
		
		for ( RecipeItem item : items )
		{
			bld.append( String.format( " %s = %f, ", item.getIngredient( ), item.getQuantity( ) ) );
		}
		
		bld.append( " } " );
		
		return bld.toString( );
	}
	
	public static void connect( Recipe recipe, RecipeItem item )
	{
		recipe.getItems( ).add( item );
		item.setRecipe( recipe );
	}
}
