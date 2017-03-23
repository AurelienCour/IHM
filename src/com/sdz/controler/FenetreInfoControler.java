package com.sdz.controler;

import java.util.ArrayList;
import com.sdz.model.Classe;
import com.sdz.model.Eleve;
import com.sdz.model.FenetreInfoModel;
import com.sdz.vue.FenetreInfo;

public class FenetreInfoControler {
	
	private FenetreInfoModel model;
	private FenetreInfo fenetre;

	public FenetreInfoControler(FenetreInfoModel model, FenetreInfo fenetreInfo){
		this.model=model;
		this.fenetre = fenetreInfo;
	}

	public void getInfo(Object obj){
		if(obj instanceof Eleve)
			fenetre.changeLabel(obj.toString());
		else if(obj instanceof Classe){
			fenetre.afficheTableEnfant((Classe) obj);
		}
			
	}
}
