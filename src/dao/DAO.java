package dao;

/**
 * Class : DAO
 * @author takiguchi
 * @version 1
 */

import java.sql.Connection;

public abstract class DAO<T> {
	/* **********
	 * Attributes
	 ************/
	public Connection connection;
	
	/* ************
	 * Constructors
	 **************/
	
	/**
	 * The default constructor
	 */
	public DAO<T>()
	{
		connection = ConnexionPostgreSQL.getInstance();
	}//end DAO<T>()

	/* *******
	 * Methods
	 *********/
	
	/**
	 * Abstract method to create a new <T> object
	 * @param The new <T> object to create [T]
	 * @return The new <T> object
	 */
	public abstract T create(T obj);
	
	/**
	 * Abstract method to read a <T> object
	 * @param The <T> object to read [T]
	 * @return Return the object code [integer]
	 */
	public abstract int read(T obj);
	
	/**
	 * Abstract method to update a <T> object
	 * @param The <T> object to update [T]
	 * @return Return 0 if there was no any problem
	 */
	public abstract int update(T obj);
	
	/**
	 * Abstract method to delete a <T> object
	 * @param Return 0 if there was no any problem
	 */
	public abstract int delete(T obj);
	
}//end Class
