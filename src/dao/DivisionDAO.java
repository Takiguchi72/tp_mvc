package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classes.Division;

public class DivisionDAO extends DAO<Division> {

		/**
		 * Execute an insert query into the database to create a new Division
		 * @param The Division object to create into the database [Division]
		 * @return The new Division object created into the database [Division]
		 */
		public Division create(Division obj) {
			try {
					//It create a prepared statement to insert into the db
				 	PreparedStatement prepare = this.connect
	                                                .prepareStatement("INSERT INTO \"mvc\".Division VALUES(?, ?)"
	                                                    );
				 	//We assign values to the preparedStatement variables
					prepare.setInt(1,obj.getCode());
					prepare.setString(2, obj.getLibelle());
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
		public Division read(int code) {
			//We create an empty division
			Division laDivision = new Division();
			try {
				//We create a statement to get the Division from the code
	            ResultSet result = this .connect
	                                    .createStatement(
	                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
	                                                ResultSet.CONCUR_UPDATABLE)
	                                    .executeQuery("SELECT * FROM \"mvc\".Division WHERE code = '" + code +"'");
	            //if the result isn't empty, we initialise the Division object thanks to the result
	            if(result.first())
	            		laDivision = new Division(code, result.getString("libelle"));   
			    } catch (SQLException e) {
			            e.printStackTrace();
			    }
			   return laDivision;
		}//end read(Division)
		
		/**
		 * Update a Division into the db thanks to the object of parameters
		 * @param The Division object that will permit to modify the Division into the db [Division]
		 * @return The Division updated [Division]
		 */
		public Division update(Division obj) {
			try {
				
	                this .connect	
	                     .createStatement(
	                    	ResultSet.TYPE_SCROLL_INSENSITIVE, 
	                        ResultSet.CONCUR_UPDATABLE
	                     ).executeUpdate(
	                    	"UPDATE \"mvc\".Division SET libelle = '" + obj.getLibelle() + "'"+
	                    	" WHERE code = '" + obj.getCode()+"'"
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
		public void delete(Division obj) {
			try {
	                this    .connect
	                    	.createStatement(
	                             ResultSet.TYPE_SCROLL_INSENSITIVE, 
	                             ResultSet.CONCUR_UPDATABLE
	                        ).executeUpdate(
	                             "DELETE FROM \"mvc\".Division WHERE code = '" + obj.getCode()+"'"
	                        );
				
		    } catch (SQLException e) {
		            e.printStackTrace();
		    }//end Catch
		}//end delete(Division)
}//end Class