package dao;

/**
 * Class : ConnexionPostgreSQL
 * @author takiguchi
 * @version 1
 */

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Class : ConnexionPostgreSQL
 * @author takiguchi
 * @version 1
 */

public class ConnexionPostgreSQL {
	/**
	 * Create a simple connection to the postgresql database
	 * @return The connection [sql.Connection]
	 */
	public static Connection getInstance()
	{
		//Localisation du driver JDBC
    	try{
    		Class.forName("org.postgresql.Driver");
    	} catch (Exception e) {
    		System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
    	}//Fin catch
    	//Création d'un objet de type Connection
    	Connection theConnection = null;
    	try{
    		//Connexion à la basse
    		theConnection = DriverManager.getConnection("jdbc:postgresql://" + DonneesConnexion.getAddress() + "/fthierry", DonneesConnexion.getLogin(), DonneesConnexion.getMdp());
    	} catch (Exception e) {
    		System.out.println("Erreur lors de la connexion à la base de donnée :\n" + e);
    	}//Fin catch		
		return theConnection;
	}//end getInstance()
	
	/**
	 * Create a prepared connection to the postgresql database
	 * @return The preared connection [sql.Connection]
	 */
	public static Connection getPreparedInstance()
	{
		//Localisation du driver JDBC
    	try{
    		Class.forName("org.postgresql.Driver");
    	} catch (Exception e) {
    		System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
    	}//Fin catch
    	//Création d'un objet de type Connection
    	Connection theConnection = null;
    	try{
    		//Connexion à la basse
    		theConnection = DriverManager.getConnection("jdbc:postgresql://" + DonneesConnexion.getAddress() + "/fthierry", DonneesConnexion.getLogin(), DonneesConnexion.getMdp());
    	} catch (Exception e) {
    		System.out.println("Erreur lors de la connexion à la base de donnée :\n" + e);
    	}//Fin catch
    	return theConnection;
	}//Fin getPreparedInstance()
}//end class
