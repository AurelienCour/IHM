package com.sdz.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.tree.DefaultMutableTreeNode;

import com.sdz.controler.FenetreInfoControler;
import com.sdz.model.Classe;
import com.sdz.model.Eleve;
import com.sdz.model.FenetreInfoModel;


public class FenetreInfo extends JFrame{
	
	private JLabel labelInfo;
	private JPanel panelFormulaire;
	
	private FenetreInfoControler controler;
	private FenetreInfoModel model;
	
	public FenetreInfo(FenetreInfoControler controler, FenetreInfoModel model){
		this.setTitle("Test JTree et JTable");
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.pack();
		this.controler = controler;
		this.model = model;
		initComposant();
		try {
			//On utilise le look and feel : NimbusLookAndFeel
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			// On applique le look and feel a notre fenetre
			SwingUtilities.updateComponentTreeUI(this);
		}
		catch (InstantiationException e) {}
		catch (ClassNotFoundException e) {}
		catch (UnsupportedLookAndFeelException e) {}
		catch (IllegalAccessException e) {}
		this.setVisible(true);
		
	}
	
	private void initComposant(){
		Font police = new Font("Arial", Font.BOLD, 20);
		this.labelInfo = new JLabel();
		this.labelInfo.setFont(police);
		this.labelInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.labelInfo.setHorizontalAlignment(SwingConstants.CENTER);
		
		this.panelFormulaire = new JPanel();
		this.panelFormulaire.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		//Création d'une racine
		DefaultMutableTreeNode racine = new DefaultMutableTreeNode("Classes");
		for (Classe cl : model.getClasses()) {
			DefaultMutableTreeNode classe = new DefaultMutableTreeNode(cl);
			for (Eleve el : cl.getListeEleve()) {
				DefaultMutableTreeNode eleve = new DefaultMutableTreeNode(el);
				classe.add(eleve);
			}
			racine.add(classe);
		}
		
		JTree listeClasseEleve = new JTree(racine);
		JPanel panelDroit = new JPanel();
		panelDroit.setLayout(new GridLayout(2,1));
		panelDroit.add(this.panelFormulaire);
		panelDroit.add(this.labelInfo);
		
		this.add(listeClasseEleve,BorderLayout.WEST);
		this.add(panelDroit, BorderLayout.CENTER);
	}
}
