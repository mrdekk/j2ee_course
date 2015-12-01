package ru.malykh.da.lec4.model.services;

import java.util.List;

import ru.malykh.da.lec4.model.entities.Ingredient;

public interface IIngredientService
{
	/**
	 * Сохраняет новый ингредиент в базу данных
	 * может выдать ошибку, если таковой уже есть
	 * 
	 * Возвращает объект, прошедший сохранение в базе данных 
	 * (у него например сгенерирован идентификатор)
	 */
	public Ingredient create( Ingredient ingredient );
	
	/**
	 * Удаляет ингредиент из базы данных по идентификатору, возвращает либо удаленный объект 
	 * (если таковой найден), либо null если объекта с таким идентификатором в базе не найдено 
	 */
	public Ingredient delete( int id ) throws Exception;
	
	/**
	 * Возвращает все ингредиенты из базы данных
	 */
	public List< Ingredient > findAll( );
	
	/**
	 * Сохраняет изменения в объекте в базу данных
	 * 
	 * Возвращает измененный объект из БД
	 * (у него могут быть другие значения полей)
	 */
	public Ingredient update( Ingredient ingredient ) throws Exception;
	
	/**
	 * Находит ингредиент по идентификатору
	 */
	public Ingredient findById( int id );

}
