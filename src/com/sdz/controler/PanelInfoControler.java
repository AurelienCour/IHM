package com.sdz.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.sdz.vue.PanelInfoEleve;

public class PanelInfoControler implements ActionListener{
	
	private PanelInfoEleve panelInfoEleve;
	private String idAction;

	public PanelInfoControler(PanelInfoEleve panelInfoEleve, String idAction) {
		this.panelInfoEleve = panelInfoEleve;
		this.idAction = idAction;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(idAction == "modif"){
			panelInfoEleve.getEleveActuel().changeInfo(panelInfoEleve.getFieldNom().getText(),
									panelInfoEleve.getFieldPrenom().getText(),
									Integer.parseInt(panelInfoEleve.getFieldAge().getText()));
			panelInfoEleve.actionEffectuer();
		}
	}

}
