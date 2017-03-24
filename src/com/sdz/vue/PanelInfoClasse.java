package com.sdz.vue;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.sdz.model.Classe;

public class PanelInfoClasse extends JPanel{
	
	private JLabel labelInfoClasse;
	private Font police = new Font("Serif", Font.PLAIN, 50);

	public PanelInfoClasse(PanelInfo panelInfo){
		this.setLayout(new GridLayout());
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
