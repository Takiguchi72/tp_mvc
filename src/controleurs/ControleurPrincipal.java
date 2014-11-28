package controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import classes.Division;
import classes.Eleve;
import dao.DAO;
import dao.DivisionDAO;
import dao.EleveDAO;
import vues.MainFrame;

public class ControleurPrincipal implements ActionListener {
	private MainFrame theMainFrame;
	private DAO<Division> lesDivision = new DivisionDAO(); 
	private DAO<Eleve> lesEleves = new EleveDAO();

	// Constructor
	public ControleurPrincipal()
	{
		super();
	}//end ControleurPrincipal()

	public void actionPerformed(ActionEvent e)
	{
		System.out.println(e.getSource().toString());
		// When the Quitter menuitem is clicked
		if (e.getSource() == theMainFrame.mntmQuitter)
		{
			System.exit(0);
		}//end if
		// When the JPanelEleve Ajouter button is clicked
		else if(e.getSource() == theMainFrame.panelEleve.btnAjouter)
		{
			theMainFrame.panelEleve.showAddingPart(true);
		}//end elseif
		//When the JPanelEleve Valider button is clicked
		else if(e.getSource() == theMainFrame.panelEleve.btnValider)
		{
			try{
				theMainFrame.panelEleve.addANewEleve();
			} catch (Exception ex){
				ErrorManagement.showError(theMainFrame.panelEleve.lblError, ex.getMessage(), 1);
			}//end catch
		}//end elseif
		else if(e.getSource() == theMainFrame.panelEleve.cbbEleve)
		{
			if(theMainFrame.panelEleve.cbbEleve.getSelectedIndex() > 0)
			{
				
				System.out.print("Voici l'eleve choisi : " + theMainFrame.panelEleve.listeEleves.get(theMainFrame.panelEleve.cbbEleve.getSelectedIndex() - 1));
			}
			
		}
		//When the JMenuEleve menuitem is clicked
		else if (e.getSource() instanceof JMenuItem)
		{
			theMainFrame.panelEleve.laDivision = new Division(lesDivision.read(Integer.parseInt(e.getActionCommand())));
			theMainFrame.panelEleve.initComboBox();
			theMainFrame.panelEleve.setVisible(true);
		}//end elseif
	}//end actionPerformed()
	
	/**
	 * Initialize theMainFrame of the controller
	 * @param The frame which will initialize the Controller-theMainFrame
	 */
	public void addFrame(MainFrame frame)
	{
		this.theMainFrame = frame;
	}//end addFrame
}//end Class
