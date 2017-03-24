package com.sdz.vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

import com.sdz.controler.FenetreControler;
import com.sdz.controler.JTableControler;
import com.sdz.model.FenetreInfoModel;
import com.sdz.vue.Renderer.SexeCellRenderer;

public class FenetreInfo extends JFrame{
	
	private PanelInfo panelInfo;
	private FenetreControler controler;
	private FenetreInfoModel model;
	private JTree listeClasseEleve;
	private JTable tableClasse;
	private ModelTable modeleTable;
	
	public FenetreInfo(FenetreInfoModel model){
		this.setTitle("Test JTree et JTable");
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(1080, 700);
		this.model = model;
		initComposant();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	private void initComposant(){
		modeleTable = new ModelTable(model);
		this.panelInfo = new PanelInfo();
		this.controler = new FenetreControler(this.model,this,this.panelInfo);
		this.listeClasseEleve = new TreeClasse(model,this).getJTree();
		this.listeClasseEleve.setPreferredSize(new Dimension(180,180));
		this.tableClasse = new JTable(modeleTable);
		tableClasse.setDefaultRenderer(Boolean.class, new SexeCellRenderer());
		ListSelectionModel listSelectionModel = tableClasse.getSelectionModel();        
		listSelectionModel.addListSelectionListener(new JTableControler(tableClasse, this));
		JPanel panelDroit = new JPanel();
		panelDroit.setLayout(new GridLayout(2,1));
		panelDroit.add(this.panelInfo);
		panelDroit.add(new JScrollPane(tableClasse));
		this.add(listeClasseEleve,BorderLayout.WEST);
		this.add(panelDroit, BorderLayout.CENTER);
	}
	
	public PanelInfo getPanelInfo(){
		return this.panelInfo;
	}

	public ModelTable getModeleTable(){
		return this.modeleTable;
	}
}
