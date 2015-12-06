package ru.malykh.da.lec4.model.services;

import java.util.List;

import ru.malykh.da.lec4.model.entities.Recipe;

public interface IRecipeService
{
	/**
	 * Сохраняет новый рецепт в базу данных
	 * может выдать ошибку, если таковой уже есть
	 * 
	 * Возвращает объект, прошедший сохранение в базе данных 
	 * (у него например сгенерирован идентификатор)
	 */
	public Recipe create( Recipe recipe );
	
	/**
	 * Удаляет рецепт из базы данных по идентификатору, возвращает либо удаленный объект 
	 * (если таковой найден), либо null если объекта с таким идентификатором в базе не найдено 
	 */
	public Recipe delete( int id ) throws Exception;
	
	/**
	 * Возвращает все рецепты из базы данных
	 */
	public List< Recipe > findAll( );
	
	/**
	 * Сохраняет изменения в объекте в базу данных
	 * 
	 * Возвращает измененный объект из БД
	 * (у него могут быть другие значения полей)
	 */
	public Recipe update( Recipe recipe ) throws Exception;
	
	/**
	 * Находит рецепт по идентификатору
	 */
	public Recipe findById( int id );
	
	// Lecture 5
	
	/**
	 * Найти рецепт по имени
	 */
	public Recipe findByName( String name );
}
