package com.sdz.vue;

import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelInfo extends JPanel{
	
	private JPanel panelInfoEleve;
	private JPanel panelInfoClasse;
	
	private JLabel labelInfoEnfant;
	private JLabel labelInfoClasse;
	
	public PanelInfo(){
		this.setLayout(new CardLayout());
		
		panelInfoEleve = new JPanel();
		panelInfoClasse = new JPanel();
		
		Font police = new Font("Serif", Font.PLAIN, 50);
		
		labelInfoEnfant = new JLabel();
		labelInfoEnfant.setFont(police);
		labelInfoEnfant.setHorizontalAlignment(SwingConstants.CENTER);
		labelInfoEnfant.setVerticalAlignment(SwingConstants.CENTER);
		
		labelInfoClasse = new JLabel();
		labelInfoClasse.setFont(police);
		labelInfoClasse.setHorizontalAlignment(SwingConstants.CENTER);
		labelInfoClasse.setVerticalAlignment(SwingConstants.CENTER);
		
		panelInfoEleve.add(labelInfoEnfant);
		panelInfoClasse.add(labelInfoClasse);
		
		this.add("Eleve", panelInfoEleve);
		this.add("Classe", panelInfoClasse);
	}
	
	public void changeLabelEnfant (String str){
		labelInfoEnfant.setText(str);
		((CardLayout) this.getLayout()).show(this,"Eleve");
	}
	
	public void changeLabelClasse(String str) {
		labelInfoClasse.setText(str);
		((CardLayout) this.getLayout()).show(this,"Classe");
	}
}
