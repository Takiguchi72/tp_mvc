package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classes.Division;
import classes.Eleve;

public class EleveDAO extends DAO<Eleve> {

		/**
		 * Execute an insert query into the database to create a new Eleve
		 * @param The Eleve object to create into the database [Eleve]
		 * @return The new Eleve object created into the database [Eleve]
		 */
		public Eleve create(Eleve obj) {
			try {
					//It create a prepared statement to insert into the db
				 	PreparedStatement prepare = this.connect
	                                                .prepareStatement("INSERT INTO \"mvc\".eleve VALUES(?, ?, ?, ?, ?)"
	                                                		);
				 	//We assign values to the preparedStatement variables
					prepare.setInt(1,obj.getCode());
					prepare.setString(2, obj.getNom());
					prepare.setString(3, obj.getPrenom());
					prepare.setString(4, obj.getDateNaiss());
					prepare.setInt(5, obj.getSaDivision().getCode());
					//We execute the insertion
					prepare.executeUpdate();
					//We create a new object thanks to the new db insertion
					obj = this.read(obj.getCode());	
				}//end try
		    catch (SQLException e) {
		            e.printStackTrace();
		    }//end catch
		    return obj;
		}//end create(Division)
		
		/**
		 * Get a division thanks to the code that sent into parameters
		 * @param The code of the Division to get [integer]
		 * @return The Division which had the code sent into parameters [Division]
		 */
		public Eleve read(int code) {
			//We create an empty division
			Eleve lEleve = new Eleve();
			try {
				//We create a statement to get the Division from the code
	            ResultSet result = this .connect
	                                    .createStatement(
	                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
	                                                ResultSet.CONCUR_UPDATABLE)
	                                    .executeQuery("SELECT * FROM \"mvc\".eleve WHERE code = '" + code +"'");
	            	//if the result isn't empty, we initialise the Division object thanks to the result
		            if(result.first())
		            {
		            	DAO<Division> laDivision = new DivisionDAO();
		            	lEleve = new Eleve(code, result.getString("nom"), result.getString("prenom"), result.getString("dateNaiss"), laDivision.read(result.getInt("division"))); 
		            }//end if()
			    } catch (SQLException e) {
			            e.printStackTrace();
			    }//end Catch()
			   return lEleve;
		}//end read(Division)
		
		/**
		 * Update an Eleve into the db thanks to the object of parameters
		 * @param The Eleve object that will permit to modify the Eleve into the db [Eleve]
		 * @return The Eleve updated [Eleve]
		 */
		public Eleve update(Eleve obj) {
			try {
				
	                this .connect	
	                     .createStatement(
	                    	ResultSet.TYPE_SCROLL_INSENSITIVE, 
	                        ResultSet.CONCUR_UPDATABLE
	                     ).executeUpdate(
	                    	"UPDATE \"mvc\".eleve SET nom = '" + obj.getNom() + "', prenom = '" + obj.getPrenom() + "', date_naiss = '" + obj.getDateNaiss() + 
	                    	"', division = " + obj.getSaDivision().getCode() + 
	                    	" WHERE code = '" + obj.getCode()+"';"
	                     );
				
				obj = this.read(obj.getCode());
		    } catch (SQLException e) {
		            e.printStackTrace();
		    }//end Catch
		    return obj;
		}//end update(Division)

		/**
		 * Delete one Division thanks to the parameter division code
		 * @param The Division to delete into the db [Division]
		 */
		public void delete(Eleve obj) {
			try {
	                this    .connect
	                    	.createStatement(
	                             ResultSet.TYPE_SCROLL_INSENSITIVE, 
	                             ResultSet.CONCUR_UPDATABLE
	                        ).executeUpdate(
	                             "DELETE FROM \"mvc\".eleve WHERE code = '" + obj.getCode()+"'"
	                        );
				
		    } catch (SQLException e) {
		            e.printStackTrace();
		    }//end Catch
		}//end delete(Division)
		
		/**
		 * Get all the Eleves into the database
		 */
		public List<Eleve> selectAll()
		{
			List<Eleve> list = new ArrayList<Eleve>();
			
			try {
				// We create a new DivisionDAO objet in order to get the division in db which had the division code into the Eleve
				DAO<Division> laDivision = new DivisionDAO();
				// We execute the SQL query
				ResultSet result = this.connect.createStatement().executeQuery("select * from \"mvc\".eleve");
				// For each Eleve, who was returned from the query, we'll add a new Eleve instance to the Eleve list
				while(result.next())
    			{
					list.add(new Eleve(result.getInt("code"), 
										result.getString("nom"), 
										result.getString("prenom"), 
										result.getString("date_naiss"), 
										new Division(laDivision.read(Integer.getInteger(result.getString("division"))))));
    			}//end while()
			} catch (Exception ex) {
				ex.printStackTrace();
			}//end catch
			return list;
		}//end selectAll()
}//end Class