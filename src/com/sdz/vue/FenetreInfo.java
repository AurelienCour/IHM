package com.sdz.vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import com.sdz.controler.FenetreControler;
import com.sdz.model.Classe;
import com.sdz.model.Eleve;
import com.sdz.model.FenetreInfoModel;
import com.sdz.model.Professeur;
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
