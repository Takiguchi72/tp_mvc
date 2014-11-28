package tests;

import controleurs.RegexTests;

public class testRegexTests {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("\n\nTEST : One sentence without any number");
		String uneChaine = "azerty";
		if(RegexTests.containNumber(uneChaine) == true)
		{ 
			System.out.println("La chaine " + uneChaine + " contient des numéros !\n");
		}//end if
		else
		{
			System.out.println("La chaine " + uneChaine + "  NE contient PAS de numéro !\n");
		}//end else
		
		uneChaine = "1245715184qsdza4d894zd'fezsef564";
		if(RegexTests.containNumber(uneChaine) == true)
		{ 
			System.out.println("La chaine " + uneChaine + "  contient des numéros !\n");
		}//end if
		else
		{
			System.out.println("La chaine " + uneChaine + "  NE contient PAS de numéro !\n");
		}//end else
		
		
		System.out.println("\n\nTEST : One Word like a name");
		uneChaine = "Azerty";
		if(RegexTests.isOneWord(uneChaine) == true)
		{ 
			System.out.println("La chaine " + uneChaine + " est un mot !\n");
		}//end if
		else
		{
			System.out.println("La chaine " + uneChaine + " N'est PAS un mot  !\n");
		}//end else
		
		uneChaine = "azert&é12*$^";
		if(RegexTests.isOneDate(uneChaine) == true)
		{ 
			System.out.println("La chaine " + uneChaine + " est un mot !\n");
		}//end if
		else
		{
			System.out.println("La chaine " + uneChaine + "  N'est PAS un mot !\n");
		}//end else
		
		System.out.println("\n\nTEST : One Date");
		uneChaine = "1994-01-18";
		if(RegexTests.isOneDate(uneChaine) == true)
		{ 
			System.out.println("La chaine " + uneChaine + " est une Date !\n");
		}//end if
		else
		{
			System.out.println("La chaine " + uneChaine + " N'est PAS une date !\n");
		}//end else
		uneChaine = "18-01-1994";
		if(RegexTests.isOneDate(uneChaine) == true)
		{ 
			System.out.println("La chaine " + uneChaine + " est une Date !\n");
		}//end if
		else
		{
			System.out.println("La chaine " + uneChaine + " N'est PAS une date !\n");
		}//end else
		uneChaine = "1994-01-18abcd";
		if(RegexTests.isOneDate(uneChaine) == true)
		{ 
			System.out.println("La chaine " + uneChaine + " est une Date !\n");
		}//end if
		else
		{
			System.out.println("La chaine " + uneChaine + " N'est PAS une date !\n");
		}//end else
	}//end main
}//end class
