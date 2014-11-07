package classes;

/**
 * Class : Eleve
 * @author takiguchi
 * @version 1
 */

public class Eleve {
	/* **********
	 * Attributes
	 ************/
	private int code;
	private String nom;
	private String prenom;
	private String dateNaiss;
	private Division saDivision;
	
	/* ***************
	 * Getters/Setters
	 *****************/
	/**
	 * Return the attribute code
	 * @return The attribute code [integer]
	 */
	public int getCode()
	{
		return code;
	}//end getCode()
	
	/**
	 * Return the attribute nom
	 * @return The attribute nom [String]
	 */
	public String getNom()
	{
		return nom;
	}//end getNom()
	
	/**
	 * Return the attribute Prenom
	 * @return The attribute Prenom [String]
	 */
	public String getPrenom()
	{
		return prenom;
	}//end getPrenom()
	
	/**
	 * Return the attribute dateNaiss
	 * @return The attribute dateNaiss [String]
	 */
	public String getDateNaiss()
	{
		return dateNaiss;
	}//end getDateNaiss()
	
	/**
	 * Return the attribute saDivision
	 * @return The attribute saDivision [Division]
	 */
	public Division getSaDivision()
	{
		return saDivision;
	}
	
	/**
	 * Setter of the attribute nom
	 * @param The new name to set to nom [String]
	 */
	public void setNom(String nom)
	{
		this.nom = nom;
	}//end setNom(String)
	
	/**
	 * Setter of the attribute prenom
	 * @param The new name to set to prenom [String]
	 */
	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}//end setPrenom(String)
	
	/**
	 * Setter of the attribute dateNaiss
	 * @param The new name to set to dateNaiss [String]
	 */
	public void setDateNaiss(String dateNaiss)
	{
		this.dateNaiss = dateNaiss;
	}//end setNom(String)
	
	/* ************
	 * Constructors
	 **************/
	
	/**
	 * The default constructor, without parameters
	 */
	public Eleve()
	{
		code = 0;
		nom = null;
		prenom = null;
		dateNaiss = null;
		saDivision = new Division();
	}//end Eleve()
	
	/**
	 * Constructor with parameters
	 * @param The Eleve code [integer]
	 * @param The Eleve name [String]
	 * @param The Eleve last name [String]
	 * @param The Eleve birthday date [String]
	 */
	public Eleve(int code, String nom, String prenom, String dateNaiss, Division saDivision)
	{
		this.code = code;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaiss = dateNaiss;
		this.saDivision = new Division(saDivision.getCode(), saDivision.getLibelle());
	}//end Eleve(code, String, String, String)
	
	/* *******
	 * Methods
	 *********/
	
	/**
	 * Return a sentence with the object attributes
	 */
	public String toString()
	{
		return ("Code : " + code + ", Nom : " + nom + ", Prénom : " + prenom + ", Date de naissance : " + dateNaiss);
	}//end toString()
	
	
}//end Class
