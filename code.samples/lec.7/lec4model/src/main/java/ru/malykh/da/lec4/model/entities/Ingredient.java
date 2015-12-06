package ru.malykh.da.lec4.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "ingredients" )
public class Ingredient
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "id" )
	private Integer id;
	
	@ManyToOne
	@JoinColumn( name = "id_recipe", nullable = false )
	private Recipe recipe;
	
	@Column( name = "component", nullable = true, length = 100 )
	private String component;
	
	@Column( name = "quantity", nullable = true )
	private float quantity;
	
	// @formatter:off
	public void setId( Integer id ) { this.id = id; }
	public Integer getId( ) { return id; }
	
	public void setRecipe( Recipe recipe ) { this.recipe = recipe; }
	public Recipe getRecipe( ) { return recipe; }
	
	public void setComponent( String component ) { this.component = component; }
	public String getComponent( ) { return component; }
	
	public void setQuantity( float quantity ) { this.quantity = quantity; }
	public float getQuantity( ) { return quantity; }
	// @formatter:on

}
