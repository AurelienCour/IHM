package Etape4_ProgJTree_JTable;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class Actions implements TreeSelectionListener {
	
	private MenuJtree menuTree;
	private JTree tree;

	public Actions(MenuJtree menuJtree,JTree tree) {
		this.menuTree = menuJtree;
		this.tree = tree;
	}

	@Override
	public void valueChanged(TreeSelectionEvent arg0) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                tree.getLastSelectedPathComponent();
		if (node == null) return;
		
		Object nodeInfo = node.getUserObject();
		menuTree.afficheInfo(nodeInfo);
	}

}
