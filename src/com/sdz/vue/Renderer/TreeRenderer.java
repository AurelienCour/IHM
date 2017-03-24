package com.sdz.vue.Renderer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;

import com.sdz.model.Classe;
import com.sdz.model.Eleve;
import com.sdz.vue.FenetreInfo;

public class TreeRenderer implements TreeCellRenderer{

	
	private JPanel renderer = new JPanel();
	private JLabel name = new JLabel();
	private JLabel iconEleve = new JLabel();
	private DefaultTreeCellRenderer defaultRenderer = new DefaultTreeCellRenderer();
	private Color backgroundSelectionColor;
	private Color backgroundNonSelectionColor;

	public TreeRenderer() {
		backgroundSelectionColor = defaultRenderer.getBackgroundSelectionColor();
	    backgroundNonSelectionColor = defaultRenderer.getBackgroundNonSelectionColor();
		renderer.add(iconEleve);
		renderer.add(name);
		renderer.setBackground(Color.WHITE);
	}

	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected,
			boolean expanded, boolean leaf, int row, boolean hasFocus) {
		Component returnValue = null;
		if ((value != null) && (value instanceof DefaultMutableTreeNode)) {
			Object userObject = ((DefaultMutableTreeNode) value).getUserObject();
			if (userObject instanceof Eleve) {
				Eleve e = (Eleve) userObject;
				URL url;
				ImageIcon imageIcon;
				if(e.getSexe()){
					url = FenetreInfo.class.getResource("Image/garcon.png");
					imageIcon = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(14, 14, Image.SCALE_DEFAULT));
				}else{
					url = FenetreInfo.class.getResource("Image/fille.png");
					imageIcon = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(13, 15, Image.SCALE_DEFAULT));
				}
				if (selected) {
		          renderer.setBackground(backgroundSelectionColor);
		        } else {
		          renderer.setBackground(backgroundNonSelectionColor);
		        }
				iconEleve.setIcon(imageIcon);
				name.setText(e.toString());
				returnValue = renderer;
			}
			else if(userObject instanceof Classe){
				if (selected) {
		          renderer.setBackground(backgroundSelectionColor);
		        } else {
		          renderer.setBackground(backgroundNonSelectionColor);
		        }
				iconEleve.setIcon(null);
				Classe e = (Classe) userObject;
				name.setText(e.toString());
				returnValue = renderer;
			}
		}
		if (returnValue == null) {
			returnValue = defaultRenderer.getTreeCellRendererComponent(tree, value, selected, expanded,
					leaf, row, hasFocus);
		}
		return returnValue;
	}
}
