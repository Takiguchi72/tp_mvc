package vues;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import classes.Division;
import dao.ConnexionPostgreSQL;
import dao.DAO;
import dao.DivisionDAO;


public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JPanelEleves panelEleve;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 491);
		
		//Addition of the MenuBar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		//Addition of the JMenu named "Division" to the JMenuBar
		JMenu mnDivision = new JMenu("Division");
		menuBar.add(mnDivision);
		//Addition of the JMenuEleves named "Élèves" to the JManuBar
		JMenuEleves mnEleves = new JMenuEleves("Élèves");
		menuBar.add(mnEleves);
		
		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		menuBar.add(mntmQuitter);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}//end Constructor
	
	private void initMenuItemEleve()
	{
		//récupérer toutes les divisions
		
		//pour chaque division, on va créér un JPanelEleve, on renseignera le text avec le libelle de la division, et le nom avec le code
		
		//on ajoute chaque nouveau JPanelEleve au menuitem mnEleves
	}

}
