package tests;

import classes.Eleve;
import classes.Division;

public class TestsEleve {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Default Eleve
		Eleve aDefaultEleve = new Eleve();
		System.out.println(aDefaultEleve.toString());
		aDefaultEleve.setNom("Un nouveau nom");
		aDefaultEleve.setPrenom("un nouveau prénom");
		aDefaultEleve.setDateNaiss("09/11/2014");
		System.out.println("code : " + aDefaultEleve.getCode());
		System.out.println("nom : " + aDefaultEleve.getNom());
		System.out.println("prenom : " + aDefaultEleve.getPrenom());
		System.out.println("date naissance : " + aDefaultEleve.getDateNaiss());
		
		Eleve anEleve = new Eleve(2, "TAYSSE", "Géraldine", "00/00/0000", new Division());
		System.out.println(anEleve.toString());
	}//end Main
}//end Class