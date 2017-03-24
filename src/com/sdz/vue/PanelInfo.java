package com.sdz.vue;

import java.awt.CardLayout;

import javax.swing.JPanel;

import com.sdz.model.Classe;
import com.sdz.model.Eleve;
import com.sdz.model.FenetreInfoModel;

public class PanelInfo extends JPanel{
	
	private PanelInfoEleve panelInfoEleve;
	private PanelInfoClasse panelInfoClasse;
	private FenetreInfo fenetreInfo;
	private FenetreInfoModel model;
	
	public PanelInfo(FenetreInfo fenetreInfo, FenetreInfoModel model){
		this.setLayout(new CardLayout());
		this.fenetreInfo = fenetreInfo;
		this.model = model;
		panelInfoClasse = new PanelInfoClasse(this,model);
		panelInfoEleve = new PanelInfoEleve(this);
		
		this.add("Classe", panelInfoClasse);
		this.add("Eleve", panelInfoEleve);
	}
	
	public void changeLabelEnfant (Eleve e){
		panelInfoEleve.changeInfo(e);
		((CardLayout) this.getLayout()).show(this,"Eleve");
	}
	
	public void changeLabelClasse(Classe c) {
		panelInfoClasse.changeInfo(c);
		((CardLayout) this.getLayout()).show(this,"Classe");
	}
	
	public void changementEffectuer(Object obj){
		if(obj instanceof Eleve){
			fenetreInfo.getModeleTable().reload();
		}
	}
}
