package vues;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import controleurs.ControleurPrincipal;
import controleurs.ErrorManagement;
import controleurs.RegexTests;
import classes.Division;
import classes.Eleve;
import dao.EleveDAO;
import java.awt.Color;
import java.awt.Font;

public class JPanelEleves extends JPanel {
	public JTextField txbNom;
	public JTextField txbPrenom;
	public JTextField txbDateNaiss;
	public JComboBox<String> cbbEleve;
	public JButton btnAjouter;
	public JLabel lblError;
	public JLabel lblClasse;
	public JButton btnValider;
	public JButton btnModifier;
	public JButton btnSupprimer;
	public Division laDivision;
	private JSeparator separator;
	private JLabel lblNom;
	private JLabel lblPrenom;
	private JLabel lblDateNaiss;
	private JSeparator separator2;
	public List<Eleve> listeEleves;
	
	
	/**
	 * Constructor of JPanelEleves
	 */
	public JPanelEleves(ControleurPrincipal controlleur) {
		listeEleves = new ArrayList<Eleve>();
		//One variable
		setLayout(null);
		//Panel label
		JLabel lblTitle = new JLabel("Classe de ");
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 18));
		lblTitle.setBounds(209, 25, 117, 24);
		add(lblTitle);
		//Button ajouter
		btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(controlleur);
		
		lblClasse = new JLabel("SLAM");
		lblClasse.setFont(new Font("Dialog", Font.BOLD, 18));
		lblClasse.setBounds(315, 30, 170, 15);
		add(lblClasse);
		btnAjouter.setBounds(65, 70, 86, 24);
		add(btnAjouter);
		//Label between the button and the combobox
		JLabel lblSelect = new JLabel("ou sélectionner un nouvel élève :");
		lblSelect.setBounds(170, 75, 276, 15);
		add(lblSelect);
		//The comboBox which contains the Division Eleves
		cbbEleve = new JComboBox<String>();
		cbbEleve.setBounds(439, 70, 190, 24);
		cbbEleve.addActionListener(controlleur);
		add(cbbEleve);
		//First separator
		separator = new JSeparator();
		separator.setBounds(137, 121, 430, 2);
		separator.setVisible(false);
		add(separator);
		//Label "Nom"
		lblNom = new JLabel("Nom :");
		lblNom.setBounds(60, 150, 70, 15);
		lblNom.setVisible(false);
		add(lblNom);
		//Text bar "Nom"
		txbNom = new JTextField();
		txbNom.setName("Nom");
		txbNom.setBounds(120, 150, 114, 19);
		txbNom.setVisible(false);
		add(txbNom);
		txbNom.setColumns(10);
		//Label "Prenom"
		lblPrenom = new JLabel("Prénom :");
		lblPrenom.setBounds(280, 150, 70, 15);
		lblPrenom.setVisible(false);
		add(lblPrenom);
		
		txbPrenom = new JTextField();
		txbPrenom.setName("Prénom");
		txbPrenom.setBounds(360, 150, 114, 19);
		txbPrenom.setVisible(false);
		add(txbPrenom);
		txbPrenom.setColumns(10);
		
		lblDateNaiss = new JLabel("Date de naissance :");
		lblDateNaiss.setBounds(100, 190, 141, 15);
		lblDateNaiss.setVisible(false);
		add(lblDateNaiss);
		
		txbDateNaiss = new JTextField();
		txbDateNaiss.setName("Date de naissance");
		txbDateNaiss.setBounds(260, 190, 148, 19);
		txbDateNaiss.setVisible(false);
		add(txbDateNaiss);
		txbDateNaiss.setColumns(10);
		
		separator2 = new JSeparator();
		separator2.setBounds(137, 247, 430, 2);
		separator2.setVisible(false);
		add(separator2);
		
		btnValider = new JButton("Valider");
		btnValider.addActionListener(controlleur);
		btnValider.setBounds(150, 296, 96, 25);
		btnValider.setVisible(false);
		add(btnValider);
		
		btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(controlleur);
		btnModifier.setBounds(140, 296, 117, 25);
		btnModifier.setVisible(false);
		add(btnModifier);
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(460, 296, 117, 25);
		btnSupprimer.setVisible(false);
		add(btnSupprimer);
		
		lblError = new JLabel("Error :");
		lblError.setForeground(Color.RED);
		lblError.setBounds(32, 351, 648, 47);
		lblError.setVisible(false);
		add(lblError);
	}//end JPanelEleves()
	
	/**
	 * Initialize the Combobox with the Division Eleves
	 * @param codeDivision
	 */
	public void initComboBox()
	{
		lblClasse.setText(laDivision.getLibelle());
		showAddingPart(false);
		cbbEleve.removeAllItems();
		cbbEleve.addItem("");
		listeEleves = new ArrayList<Eleve>(new EleveDAO().selectAllOfOneDivision(laDivision.getCode()));
		for (Eleve OneEleve : listeEleves)
		{
			cbbEleve.addItem(OneEleve.getNom() +" "+ OneEleve.getPrenom());
		}//end for
	}//end initComboBox()
	
	/**
	 * Show or hide the Adding-Eleve elements of the JPanelEleve
	 * @param True : It shows this part ; False : It hides this part
	 */
	public void showAddingPart(boolean value)
	{
		this.separator.setVisible(value);
		this.separator2.setVisible(value);
		this.lblNom.setVisible(value);
		this.lblPrenom.setVisible(value);
		this.lblDateNaiss.setVisible(value);
		this.txbNom.setVisible(value);
		this.txbPrenom.setVisible(value);
		this.txbDateNaiss.setVisible(value);
		this.btnValider.setVisible(value);
		//if value is true, it means that user wants to add one Eleve, so the focus will be in the first text field
		if(value == true)
		{
			this.txbNom.requestFocus();
		}//end if
	}//end showAddingPart()
	
	/**
	 * Carry out the seizure controls of text field before the new Eleve insertion into database
	 * @param lesEleves
	 * @throws Exception
	 */
	public void addANewEleve() throws Exception
	{
		checkTextFields();
		
		EleveDAO lesEleves = new EleveDAO();
		//if there're no wrong seizures, a new Eleve is created into the database
		lesEleves.create(new Eleve(lesEleves.selectMaxCodeFromEleves(),
									txbNom.getText(),
									txbPrenom.getText(),
									txbDateNaiss.getText(),
									laDivision));
	}//end addANewEleve
	
	/**
	 * It check the text field, if any seizure is wrong, otherwise a new exception will be thrown
	 */
	private void checkTextFields() throws Exception
	{
		ErrorManagement.checkEmptyField(txbNom);
		//if the name seizure is wrong, an exception is thrown
		if(RegexTests.isOneWord(txbNom.getText()) == false)
		{
			//An intermediate String variable is created in order to initialize the new exeption after that clearing the text field
			String nomSaisi = txbNom.getText();
			//The field txbNom is cleared
			ErrorManagement.clearAndFocusField(txbNom);
			//A new exception is thrown
			throw new Exception("\"" + nomSaisi + "\" is not a valid name !<br />Ensure that it don't contain numbers or punctuation characters", new Throwable("format"));
		}//end if
		
		ErrorManagement.checkEmptyField(txbPrenom);
		//if the first name seizure is wrong, an exception is thrown
		if (RegexTests.isOneWord(txbPrenom.getText()) == false)
		{
			//An intermediate String variable is created in order to initialize the new exeption after that clearing the text field
			String prenomSaisi = txbPrenom.getText();
			//The field txbPrenom is cleared
			ErrorManagement.clearAndFocusField(txbPrenom);
			//A new exception is thrown
			throw new Exception("\"" + prenomSaisi + "\" is not a valid first name !<br />Ensure that it don't contain numbers or punctuation characters", new Throwable("format"));
		}//end else if
		
		ErrorManagement.checkEmptyField(txbDateNaiss);
		//if the date seizure is wrong, an exception is thrown
		if(RegexTests.isOneDate(txbDateNaiss.getText()) == false)
		{
			//An intermediate String variable is created in order to initialize the new exeption after that clearing the text field
			String dateSaisie = txbDateNaiss.getText();
			//The field txbPrenom is cleared
			ErrorManagement.clearAndFocusField(txbDateNaiss);
			//A new exception is thrown
			throw new Exception("\"" + dateSaisie + "\" is not a valid date !<br />Ensure you wrote a date in this format : \"YYYY-MM-DD\"", new Throwable("date"));
		}//end else if
	}//end chechTextFields
	
	/**
	 * Show or hide the Updating-Eleve elements of the JPanelEleve
	 * @param True : It shows this part ; False : It hides this part
	 */
	public void showUpdatingPart(boolean value)
	{
		separator.setVisible(value);
		lblNom.setVisible(value);
		txbNom.setVisible(value);
		lblPrenom.setVisible(value);
		txbPrenom.setVisible(value);
		lblDateNaiss.setVisible(value);
		txbDateNaiss.setVisible(value);
		separator2.setVisible(value);
		btnModifier.setVisible(value);
		btnSupprimer.setVisible(value);
		if(value == true)
		{
			fillTheTextFields(listeEleves.get(cbbEleve.getSelectedIndex() - 1));
			txbNom.requestFocus();
		}//end if
	}//end showUpdatingPart()
	
	/**
	 * Clear all the JTextField of the current panel
	 */
	public void clear()
	{
		txbNom.setText(null);
		txbPrenom.setText(null);
		txbDateNaiss.setText(null);
	}//end clear
	
	/**
	 * It fill the JTextFields in order to modify the name, the first name and the birthdate Eleve
	 * @param The Eleve to modify [Eleve]
	 */
	private void fillTheTextFields(Eleve theEleve)
	{
		txbNom.setText(theEleve.getNom());
		txbPrenom.setText(theEleve.getPrenom());
		txbDateNaiss.setText(theEleve.getDateNaiss());
	}//end fillTheTextFields
	
	/**
	 * It hides all parts of this panel
	 */
	public void reinitialize()
	{
		showAddingPart(false);
		showUpdatingPart(false);
	}//end reinitialize
}//end Class()
