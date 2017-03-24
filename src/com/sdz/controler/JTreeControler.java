package com.sdz.controler;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import com.sdz.model.Classe;
import com.sdz.model.Eleve;
import com.sdz.model.FenetreInfoModel;
import com.sdz.vue.TreeClasse;

public class JTreeControler implements TreeSelectionListener {
	
	private TreeClasse tree;
	private FenetreInfoModel model;
	
	public JTreeControler(TreeClasse tree, FenetreInfoModel model){
		this.tree=tree;
		this.model=model;
	}

	@Override
	public void valueChanged(TreeSelectionEvent arg0) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode)
				tree.getJTree().getLastSelectedPathComponent();
		if (node == null) return;
		Object nodeInfo = node.getUserObject();
		if(nodeInfo instanceof Eleve){
			tree.getFenetreInfo().getPanelInfo().changeLabelEnfant((Eleve) nodeInfo);
			tree.getFenetreInfo().getModeleTable().initDonnees(model.getClasseEnfant((Eleve) nodeInfo));
		}
		else if(nodeInfo instanceof Classe){
			tree.getFenetreInfo().getPanelInfo().changeLabelClasse((Classe) nodeInfo);
			tree.getFenetreInfo().getModeleTable().initDonnees((Classe) nodeInfo);
		}
	}

}
