package dao;

import java.sql.Connection;
import java.sql.DriverManager;

import Program.DonneesConnexion;

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
	public static Connection getConnection()
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
	}//end makeConnection()
	
	/**
	 * Create a prepared connection to the postgresql database
	 * @return The preared connection [sql.Connection]
	 */
	public static Connection getPreparedConnection()
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
	}//Fin getPreparedConnection()
}
