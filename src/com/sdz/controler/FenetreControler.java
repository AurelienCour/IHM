package com.sdz.controler;

import com.sdz.model.Classe;
import com.sdz.model.Eleve;
import com.sdz.model.FenetreInfoModel;
import com.sdz.vue.FenetreInfo;
import com.sdz.vue.PanelInfo;

public class FenetreControler {
	
	private FenetreInfoModel model;
	private FenetreInfo fenetre;
	private PanelInfo panelInfo;

	public FenetreControler(FenetreInfoModel model, FenetreInfo fenetreInfo, PanelInfo panelInfo){
		this.model=model;
		this.fenetre = fenetreInfo;
		this.panelInfo = panelInfo;
	}

	/*public void getInfo(Object obj){
		if(obj instanceof Eleve){
			panelInfo.changeLabelEnfant(obj.toString());
			fenetre.afficheTableEnfant(model.getClasseEnfant((Eleve) obj));
		}
		else if(obj instanceof Classe){
			panelInfo.changeLabelClasse(obj.toString());
			fenetre.afficheTableEnfant((Classe) obj);
		}
	}*/
}
