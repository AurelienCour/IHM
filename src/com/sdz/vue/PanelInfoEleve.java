package com.sdz.vue;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.sdz.model.Eleve;

public class PanelInfoEleve extends JPanel{

	private JLabel labelInfoEnfant;
	
	public PanelInfoEleve(){
		Font police = new Font("Serif", Font.PLAIN, 50);
		
		labelInfoEnfant = new JLabel();
		labelInfoEnfant.setFont(police);
		labelInfoEnfant.setHorizontalAlignment(SwingConstants.CENTER);
		labelInfoEnfant.setVerticalAlignment(SwingConstants.CENTER);
		this.add(labelInfoEnfant);
	}

	public void changeInfo(Eleve e) {
		labelInfoEnfant.setText(e.toString());
	}
}
