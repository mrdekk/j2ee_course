package ru.mrdekk.j2ee.lec5.services;

import java.util.List;

import ru.mrdekk.j2ee.lec5.entities.Recipe;

public interface IRecipeService
{
	public Recipe create( Recipe recipe );
	public Recipe delete( int id ) throws Exception;
	public List< Recipe > findAll( );
	public Recipe update( Recipe recipe ) throws Exception;
	public Recipe findById( int id );
	
	// lecture 5
	public List< Recipe > findByName( String name );
}
