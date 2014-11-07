package tests;

import classes.Division;;

public class TestsDivision {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// A default division test
		Division aDefaultDivision = new Division();
		System.out.println(aDefaultDivision.toString());
		aDefaultDivision.setLibelle("An other libelle");
		System.out.println("code : " + aDefaultDivision.getCode());
		System.out.println("libelle : " + aDefaultDivision.getLibelle());
		
		Division myDivision = new Division(2, "the division");
		System.out.println(myDivision.toString());
	}//end main
}//end class
