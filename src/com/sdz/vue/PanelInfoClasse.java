package com.sdz.vue;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.sdz.model.Classe;
import com.sdz.model.FenetreInfoModel;

public class PanelInfoClasse extends JPanel{
	
	private JLabel labelInfoClasse;
	private Font police = new Font("Serif", Font.PLAIN, 50);

	public PanelInfoClasse(PanelInfo panelInfo){
		labelInfoClasse = new JLabel();
		labelInfoClasse.setFont(police);
		labelInfoClasse.setHorizontalAlignment(SwingConstants.CENTER);
		labelInfoClasse.setVerticalAlignment(SwingConstants.CENTER);
		
		this.add(labelInfoClasse);
	}
	
	public void changeInfo(Classe c) {
		labelInfoClasse.setText(c.toString());
	}
}
