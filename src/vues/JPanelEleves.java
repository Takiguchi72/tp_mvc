package vues;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class JPanelEleves extends JPanel {
	private int codeDivision;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtDateNaiss;
	
	/**
	 * Constructor of JPanelEleves
	 */
	public JPanelEleves(int codeDivision) {
		super();
		//One variable
		this.codeDivision = codeDivision;
		setLayout(null);
		//Panel label
		JLabel lblClasse = new JLabel("Classe de ");
		lblClasse.setBounds(40, 35, 117, 24);
		add(lblClasse);
		//Button ajouter
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(40, 70, 86, 24);
		add(btnAjouter);
		//Label between the button and the combobox
		JLabel lblSelect = new JLabel("ou sélectionner un nouvel élève :");
		lblSelect.setBounds(145, 75, 276, 15);
		add(lblSelect);
		
		JComboBox cbbEleve = new JComboBox();
		cbbEleve.setBounds(405, 75, 126, 24);
		add(cbbEleve);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(90, 120, 430, 2);
		add(separator);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(60, 150, 70, 15);
		add(lblNom);
		
		txtNom = new JTextField();
		txtNom.setBounds(120, 150, 114, 19);
		add(txtNom);
		txtNom.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prénom :");
		lblPrenom.setBounds(280, 150, 70, 15);
		add(lblPrenom);
		
		txtPrenom = new JTextField();
		txtPrenom.setBounds(360, 150, 114, 19);
		add(txtPrenom);
		txtPrenom.setColumns(10);
		
		JLabel lblDateNaiss = new JLabel("Date de naissance :");
		lblDateNaiss.setBounds(100, 190, 141, 15);
		add(lblDateNaiss);
		
		txtDateNaiss = new JTextField();
		txtDateNaiss.setBounds(260, 190, 148, 19);
		add(txtDateNaiss);
		txtDateNaiss.setColumns(10);
		
		JSeparator separator2 = new JSeparator();
		separator2.setBounds(90, 240, 430, 2);
		add(separator2);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(100, 261, 96, 25);
		add(btnValider);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(60, 261, 117, 25);
		add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(220, 261, 117, 25);
		add(btnSupprimer);
	}//end JPanelEleves()
}//end Class()
