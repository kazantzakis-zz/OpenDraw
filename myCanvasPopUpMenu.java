import javax.swing.JPopupMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

import java.awt.event.*;

public class myCanvasPopUpMenu extends JPopupMenu implements ActionListener {
	
	JMenuItem delete;
	JMenuItem cutBtn,copyBtn,toFront,toBack;
	JMenu order;
	
	myCanvas myCanvasHandle;
	
	public myCanvasPopUpMenu(myCanvas myCanvasHandle) {		
		
		this.myCanvasHandle = myCanvasHandle;
		
		delete = new JMenuItem("delete");
		delete.addActionListener(this);
		add(delete);
		addSeparator();
		cutBtn = new JMenuItem(myCanvasHandle.myframehandle.menuBar.cutAction);
		add(cutBtn);
		copyBtn = new JMenuItem(myCanvasHandle.myframehandle.menuBar.copyAction);
		add(copyBtn);
		addSeparator();
		
		order = new JMenu("Order");
		toFront = new JMenuItem(myCanvasHandle.myframehandle.menuBar.tofrontAction);
		toBack =new JMenuItem(myCanvasHandle.myframehandle.menuBar.toBackAction);
		order.add(toFront);
		order.add(toBack);
		add(order);
	}
	
	public void actionPerformed(ActionEvent e) {
		myCanvasHandle.deleteObjects(myCanvasHandle.selectedObjectID);
	}
}