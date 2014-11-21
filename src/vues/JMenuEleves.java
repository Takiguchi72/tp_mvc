package vues;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import dao.DivisionDAO;
import dao.DAO;
import classes.Division;

public class JMenuEleves extends JMenu {
	public JMenuEleves(String libelle)
	{
		super(libelle);
		DAO<Division> theDivisions = new DivisionDAO();
		List<Division> divisionList = new ArrayList<Division>(theDivisions.selectAll());
		
		for(Division oneDivision : divisionList)
		{
			JMenuItem newMenuItem = new JMenuItem(oneDivision.getLibelle());
			newMenuItem.setActionCommand(Integer.toString(oneDivision.getCode()));
			this.add(newMenuItem);
		}//enf foreach()
	}//end JMenuItemEleves()
}//end JMenuItemEleves