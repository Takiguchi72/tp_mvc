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
			theMainFrame.panelEleve.clear();
			theMainFrame.panelEleve.showUpdatingPart(false);
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
		//When the JPanelEleve Combobox selected index is changed
		else if(e.getSource() == theMainFrame.panelEleve.cbbEleve)
		{
			//If user selected the blank field into the combobox, it will be reinitialized
			if(theMainFrame.panelEleve.cbbEleve.getSelectedIndex() == 0)
			{
				theMainFrame.panelEleve.reinitialize();
			}//end if
			//If user selected an Eleve into the combobox, it will show the Updating part this the field filled with Eleve properties
			else if(theMainFrame.panelEleve.cbbEleve.getSelectedIndex() > 0)
			{
				//The adding part will be hidden
				theMainFrame.panelEleve.showAddingPart(false);
				//The text fields will be cleared
				theMainFrame.panelEleve.clear();
				System.out.println("L'eleve : " + theMainFrame.panelEleve.cbbEleve.getSelectedItem().toString());
				//The updating part will be shown
				theMainFrame.panelEleve.showUpdatingPart(true);
			}//end if
		}//end elseif
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
