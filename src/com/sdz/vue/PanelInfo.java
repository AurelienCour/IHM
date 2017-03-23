package com.sdz.vue;

import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelInfo extends JPanel{
	
	private PanelInfoEleve panelInfoEleve;
	private PanelInfoClasse panelInfoClasse;
	
	public PanelInfo(){
		this.setLayout(new CardLayout());
		
		panelInfoEleve = new PanelInfoEleve();
		panelInfoClasse = new PanelInfoClasse();

		this.add("Eleve", panelInfoEleve);
		this.add("Classe", panelInfoClasse);
	}
	
	public void changeLabelEnfant (String str){
		panelInfoEleve.changeInfo(str);
		((CardLayout) this.getLayout()).show(this,"Eleve");
	}
	
	public void changeLabelClasse(String str) {
		panelInfoClasse.changeInfo(str);
		((CardLayout) this.getLayout()).show(this,"Classe");
	}
}
