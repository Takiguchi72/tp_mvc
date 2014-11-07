package classes;

/**
 * Class : Division
 * @author takiguchi
 * @version 1
 */

public class Division {
	/* **********
	 * Attributes
	 ************/
	private int code;
	private String libelle;
	
	/* ***************
	 * Getters/Setters
	 *****************/
	
	/**
	 * Getter of the attribute code
	 * @return The attribute code [integer]
	 */
	public int getCode()
	{
		return code;
	}//end getCode()
	
	/**
	 * Getter of the attribute libelle
	 * @return The attribute code [integer]
	 */
	public String getLibelle()
	{
		return libelle;
	}//end getLibelle
	
	/**
	 * Setter of the attribute libelle
	 * @param The sentence to set to the libelle [String]
	 */
	public void setLibelle(String libelle)
	{
		this.libelle = libelle;
	}//end setLibelle
	
	/* ************
	 * Constructors
	 **************/
	
	/**
	 * The default constructor, without parameters
	 */
	public Division()
	{
		code = 0;
		libelle = null;
	}//end Division()
	
	/**
	 * Constructor with parameters
	 * @param The Division code [integer]
	 * @param The Division libelle [String]
	 */
	public Division(int code, String libelle)
	{
		this.code = code;
		this.libelle = libelle;
	}//end Division(int, String)
	
	/* *******
	 * Methods
	 *********/
	
	/**
	 * Return a sentence with the object attributes
	 */
	public String toString()
	{
		return ("Code : " + code + ", Libelle : " + libelle);
	}//end toString()
}//end Class
