package com.sdz.vue;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sdz.controler.PanelInfoControler;
import com.sdz.model.Eleve;
import com.sdz.model.FenetreInfoModel;

public class PanelInfoEleve extends JPanel{

	private JLabel imageEnfant;

	private JPanel panelNom;
	private JPanel panelPrenom;
	private JPanel panelAge;

	private JLabel nomEnfant;
	private JLabel prenomEnfant;
	private JLabel ageEnfant;
	private JLabel sexe;

	private JTextField nom;
	private JTextField prenom;
	private JTextField age;

	private Eleve eleveActuel;
	private PanelInfo panelInfo;
	private Font police = new Font("Serif", Font.PLAIN, 20);

	public PanelInfoEleve(PanelInfo panelInfo){
		this.setLayout(new GridLayout(5,1));
		this.panelInfo = panelInfo;
		panelNom = new JPanel();
		nomEnfant = new JLabel("Nom : ");
		nomEnfant.setFont(police);
		nom = new JTextField();
		nom.setColumns(25);
		panelNom.add(nomEnfant);
		panelNom.add(nom);

		panelPrenom = new JPanel();
		prenomEnfant = new JLabel("Prenom : ");
		prenomEnfant.setFont(police);
		prenom = new JTextField();
		prenom.setColumns(25);
		panelPrenom.add(prenomEnfant);
		panelPrenom.add(prenom);

		panelAge = new JPanel();
		ageEnfant = new JLabel("Age : ");
		ageEnfant.setFont(police);
		age = new JTextField();
		age.setColumns(3);
		panelAge.add(ageEnfant);
		panelAge.add(age);

		imageEnfant = new JLabel("");
		imageEnfant.setFont(police);

		JButton button = new JButton("VALIDER");
		button.addActionListener(new PanelInfoControler(this,"modif"));

		this.add(imageEnfant);
		this.add(panelNom);
		this.add(panelPrenom);
		this.add(panelAge);
		this.add(button);
	}

	public void changeInfo(Eleve e) {
		eleveActuel = e;
		nom.setText(e.getNom());
		prenom.setText(e.getPrenom());
		age.setText(""+e.getAge());
	}
	
	public JTextField getFieldNom(){
		return nom;
	}
	
	public JTextField getFieldPrenom(){
		return prenom;
	}
	
	public JTextField getFieldAge(){
		return age;
	}

	public Eleve getEleveActuel() {
		return eleveActuel;
	}
	
	public void actionEffectuer(){
		this.panelInfo.changementEffectuer(getEleveActuel());
	}
}
