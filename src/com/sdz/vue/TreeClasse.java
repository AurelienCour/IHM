package com.sdz.vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeSelectionModel;

import com.sdz.controler.JTreeControler;
import com.sdz.model.Classe;
import com.sdz.model.Eleve;
import com.sdz.model.FenetreInfoModel;
import com.sdz.model.Professeur;
import com.sdz.vue.Renderer.TreeRenderer;

public class TreeClasse {
	
	private FenetreInfoModel model;
	private FenetreInfo fenetreInfo;
	private JTree tree;
	
	public TreeClasse(FenetreInfoModel model, FenetreInfo fenetreInfo){
		this.model = model;
		this.fenetreInfo = fenetreInfo;
		buildTree();
	}

	private void buildTree() {
		DefaultMutableTreeNode racine = new DefaultMutableTreeNode("Classes");
		for (Professeur pr : model.getProf()){
			for (Classe cl : pr.getClasses()) {
				DefaultMutableTreeNode classe = new DefaultMutableTreeNode(cl);
				for (Eleve el : cl.getListeEleve()) {
					DefaultMutableTreeNode eleve = new DefaultMutableTreeNode(el);
					classe.add(eleve);
				}
				racine.add(classe);
			}
		}
		tree = new JTree(racine);
		tree.setRootVisible(true);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.addTreeSelectionListener(new JTreeControler(this,this.model));
		tree.setCellRenderer(new TreeRenderer());

	}
	
	public JTree getJTree(){
		return this.tree;
	}

	public FenetreInfo getFenetreInfo(){
		return this.fenetreInfo;
	}

}
