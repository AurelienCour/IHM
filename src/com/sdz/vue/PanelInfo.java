package com.sdz.vue;

import java.awt.CardLayout;

import javax.swing.JPanel;

import com.sdz.model.Classe;
import com.sdz.model.Eleve;

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
	
	public void changeLabelEnfant (Eleve e){
		panelInfoEleve.changeInfo(e);
		((CardLayout) this.getLayout()).show(this,"Eleve");
	}
	
	public void changeLabelClasse(Classe c) {
		panelInfoClasse.changeInfo(c);
		((CardLayout) this.getLayout()).show(this,"Classe");
	}
}
