package vues;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import controleurs.ControleurPrincipal;
import java.awt.Rectangle;

public class MainFrame extends JFrame {
	public ControleurPrincipal controlleur;
	public JPanel contentPane;
	public JPanelEleves panelEleve;
	public JMenuItem mntmQuitter;

	/**
	 * Create the frame.
	 */
	public MainFrame(ControleurPrincipal controlleur) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 491);
		this.controlleur = controlleur;
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, 238, 150));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		//Addition of the MenuBar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		//Addition of the JMenu named "Division" to the JMenuBar
		JMenu mnDivision = new JMenu("Division");
		menuBar.add(mnDivision);
		//Addition of the JMenuEleves named "Élèves" to the JManuBar
		JMenuEleves mnEleves = new JMenuEleves("Élèves", this.controlleur);
		menuBar.add(mnEleves);
		//Addition of the JPanelEleve
		panelEleve = new JPanelEleves(this.controlleur);
		panelEleve.setVisible(false);
		contentPane.add(panelEleve);
		
		mntmQuitter = new JMenuItem("Quitter");
		mntmQuitter.addActionListener(this.controlleur);
		menuBar.add(mntmQuitter);
		
		this.setVisible(true);
	}//end Constructor
}//end Class
