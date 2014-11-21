package tests;

import classes.Division;
import dao.*;

public class testDAO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* *************************************
		 * T E S T   O F   D i v i s i o n D A O
		 ***************************************/
		//test of .read()
		DAO<Division> laDivision = new DivisionDAO();
		//We initialize oneDivision with the 0th division into the db thanks to the ".read" DivisionDAO method
		System.out.println("Reading :");
		Division oneDivision = new Division(laDivision.read(0).getCode(), laDivision.read(0).getLibelle());
		System.out.println(oneDivision.toString());
		
		//test of .create
		//Modification of oneDivision code, to insert it into db later
		oneDivision.setCode(10);
		//insertion into db of the new division
		laDivision.create(oneDivision);
		System.out.println("Insertion :");
		Division tampon = new Division(laDivision.read(10).getCode(), laDivision.read(10).getLibelle());
		System.out.println(tampon.toString());
		//updating of the division which had the code 10
		laDivision.update(oneDivision);
		
		
		
		
		/* *******************************
		 * T E S T   O F   E l e v e D A O
		 *********************************/
		
	}

}
