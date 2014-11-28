package vues;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import classes.Division;
import controleurs.ControleurPrincipal;
import dao.DAO;
import dao.DivisionDAO;

public class JMenuEleves extends JMenu {
	public JMenuEleves(String libelle, ControleurPrincipal controlleur)
	{
		super(libelle);
		DAO<Division> theDivisions = new DivisionDAO();
		List<Division> divisionList = new ArrayList<Division>(theDivisions.selectAll());
		
		for(Division oneDivision : divisionList)
		{
			JMenuItem newMenuItem = new JMenuItem(oneDivision.getLibelle());
			newMenuItem.addActionListener(controlleur);
			newMenuItem.setActionCommand(Integer.toString(oneDivision.getCode()));
			this.add(newMenuItem);
		}//enf foreach()
	}//end JMenuItemEleves()
}//end JMenuItemEleves