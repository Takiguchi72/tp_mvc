package controleurs;

import java.awt.event.ActionEvent;
import classes.Division;
import classes.Eleve;
import dao.DAO;
import dao.DivisionDAO;
import dao.EleveDAO;
import vues.MainFrame;

public class ControleurPrincipal {
	private MainFrame theMainFrame;
	private DAO<Division> laDivision = new DivisionDAO(); 
	private DAO<Eleve> lEleve = new EleveDAO();

	// Constructeur
	public ControleurPrincipal(DAO<Division> modeleD, DAO<Eleve> modeleE)
	{
		this.laDivision=modeleD;
		this.lEleve=modeleE;
	}//end ControleurPrincipal()

	public void actionPerformed(ActionEvent e) // Méthode qu'il faut implémenter
	{
		// quand on clique sur Quitter
		/*if (e.getSource() == theMainFrame.mntmFermer)
		{
			Quitter();
		}
		// Quand on clique sur Visualiser du menu Division
		else if (e.getSource() == theMainFrame.mntmVisualiser) {
			theMainFrame.AfficherVisualiserDivision(laDivision.selectAll());
		}
		// Quand on clique sur Modifier pour modifier le libellé d'une division 
		else if (e.getSource() == theMainFrame.btnModifier) {
			theMainFrame.jpPrincipal.modifDivision();
		}
		// Quand on Valide la modification
		else if (e.getSource() == theMainFrame.jpPrincipal.btnValider) { */
	}//end actionPerformed()
}//end Class
