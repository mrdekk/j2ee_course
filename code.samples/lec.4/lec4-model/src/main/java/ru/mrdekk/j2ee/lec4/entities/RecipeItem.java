package ru.mrdekk.j2ee.lec4.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "recipe_item" )
public class RecipeItem
{
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	@Column( name = "id" )
	private int id;
	
	@ManyToOne
	@JoinColumn( name = "id_recipe", nullable = false )
	private Recipe recipe;
	
	@Column( name = "ingredient", nullable = true, length = 100 )
	private String ingredient;
	
	@Column( name = "quantity", nullable = true )
	private float quantity;
	
	// @formatter:off
	public void setId( int id ) { this.id = id; }
	public int getId( ) { return id; }
	
	public void setRecipe( Recipe recipe ) { this.recipe = recipe; }
	public Recipe getRecipe( ) { return recipe; }
	
	public void setIngredient( String ingredient ) { this.ingredient = ingredient; }
	public String getIngredient( ) { return ingredient; }
	
	public void setQuantity( float quantity ) { this.quantity = quantity; }
	public float getQuantity( ) { return quantity; }
	// @formatter:on
}
