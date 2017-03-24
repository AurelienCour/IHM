package com.sdz.controler;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.sdz.vue.FenetreInfo;
import com.sdz.vue.ModelTable;

/**
 * Classe permettant de controler les intéractions avec la JTable
 * @author Aurelien
 *
 */
public class JTableControler implements ListSelectionListener{

	private JTable tableClasse;
	private FenetreInfo fenetreInfo;

	/**
	 * Constructeur de notre classe
	 * @param tableClasse La JTable concerner par les intéractions
	 * @param fenetreInfo	La JFrame principal
	 */
	public JTableControler(JTable tableClasse, FenetreInfo fenetreInfo){
		this.tableClasse = tableClasse;
		this.fenetreInfo = fenetreInfo;
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		ModelTable modelTable = (ModelTable) tableClasse.getModel();
		if (arg0.getValueIsAdjusting())
			return;
		ListSelectionModel lsm = (ListSelectionModel)arg0.getSource();
		if (!lsm.isSelectionEmpty()) {
			int selectedRow = lsm.getMinSelectionIndex();
			fenetreInfo.getPanelInfo().changeLabelEnfant(modelTable.getEleveRow(selectedRow));
		}
	}

}
