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
import com.sdz.controler.JTableControler;
import com.sdz.model.FenetreInfoModel;
import com.sdz.vue.Renderer.SexeCellRenderer;

public class FenetreInfo extends JFrame{
	
	private PanelInfo panelInfo;
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
		this.model.addVue(this);
		initComposant();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	public void initComposant(){
		modeleTable = new ModelTable(model);
		this.panelInfo = new PanelInfo(this,model);
		initJTree();
		initJTable();
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
	
	private void initJTree(){
		this.listeClasseEleve = new TreeClasse(model,this).getJTree();
		this.listeClasseEleve.setPreferredSize(new Dimension(180,180));
	}
	
	private void initJTable(){
		this.tableClasse = new JTable(modeleTable);
		tableClasse.setDefaultRenderer(Boolean.class, new SexeCellRenderer());
		tableClasse.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel listSelectionModel = tableClasse.getSelectionModel();        
		listSelectionModel.addListSelectionListener(new JTableControler(tableClasse, this));
	}

}
