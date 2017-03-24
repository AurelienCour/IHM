package com.sdz.vue;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.sdz.model.Classe;
import com.sdz.model.FenetreInfoModel;

public class PanelInfoClasse extends JPanel{
	
	private Font police = new Font("Serif", Font.PLAIN, 20);
	
	private JPanel panelNiveau;
	private JPanel panelProf;
	private JPanel panelNombre;
	
	private JLabel labelNiveau;
	private JLabel labelProfesseur;
	private JLabel labelNombreEleve;
	
	private FenetreInfoModel model;

	public PanelInfoClasse(PanelInfo panelInfo, FenetreInfoModel model){
		this.model = model;
		this.setLayout(new GridLayout(3,1));
		JLabel niveau = new JLabel("   Niveau : ");
		niveau.setFont(police);
		JLabel prof = new JLabel("   Professeur : ");
		prof.setFont(police);
		JLabel eleve = new JLabel("   Nombre d'élève : ");
		eleve.setFont(police);
		
		labelNiveau = new JLabel();
		labelNiveau.setFont(police);
		labelProfesseur = new JLabel();
		labelProfesseur.setFont(police);
		labelNombreEleve = new JLabel();
		labelNombreEleve.setFont(police);
		
		panelNiveau = new JPanel();
		panelNiveau.add(niveau);
		panelNiveau.add(labelNiveau);
		panelProf = new JPanel();
		panelProf.add(prof);
		panelProf.add(labelProfesseur);
		panelNombre = new JPanel();
		panelNombre.add(eleve);
		panelNombre.add(labelNombreEleve);
		
		this.add(panelNiveau);
		this.add(panelProf);
		this.add(panelNombre);
		
		/*labelInfoClasse = new JLabel();
		labelInfoClasse.setFont(police);
		
		labelInfoClasse.setVerticalAlignment(SwingConstants.CENTER);
		
		this.add(labelInfoClasse);*/
	}
	
	public void changeInfo(Classe c) {
		labelNiveau.setText(c.getNiveau());
		labelProfesseur.setText(model.getProfClasse(c).toString());
		labelNombreEleve.setText(""+c.getNombreEleve());
	}
}
