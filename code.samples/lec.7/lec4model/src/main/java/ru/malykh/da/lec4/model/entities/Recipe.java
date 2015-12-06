package ru.malykh.da.lec4.model.entities;

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
@Table( name = "recipes" )
public class Recipe
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "id" )
	private Integer id;
	
	@Column( name = "name", nullable = false, length = 100 )
	private String name;
	
	@OneToMany( mappedBy = "recipe", cascade = CascadeType.ALL )
	private List< Ingredient > ingredients = new ArrayList< Ingredient >( );
	
	// @formatter:off
	public void setId( Integer id ) { this.id = id; }
	public Integer getId( ) { return id; }
	
	public void setName( String name ) { this.name = name; }
	public String getName( ) { return name; }
	
	public void setIngredients( List< Ingredient > ingredients ) { this.ingredients = ingredients; }
	public List< Ingredient > getIngredient( ) { return ingredients; }
	// @formatter:on
	
	@Override
	public String toString( )
	{
		StringBuilder bld = new StringBuilder( );
		
		bld.append( String.format( "\"%s\" = {", name ) );
		
		for ( Ingredient ingr : ingredients )
		{
			bld.append( String.format( " %s = %f, ", ingr.getComponent( ), ingr.getQuantity( ) ) );
		}
		
		bld.append( " } " );
		
		return bld.toString( );
	}

}
