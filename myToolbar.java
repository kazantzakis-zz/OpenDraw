import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.event.*;
import javax.swing.*;


public class myToolbar extends JToolBar implements MouseListener {
	
	//The buttons of the Toolbar
  	JButton newBtn,openBtn,saveBtn,printBtn,
  			cutBtn,copyBtn,pasteBtn,
  			undoBtn,redoBtn,
  			importBtn,exportBtn,
  			orderFrontBtn,orderBackBtn,
  			groupBtn,ungroupBtn,ungroupAllBtn,
  			weldBtn,trimBtn,intersectBtn,simplifyBtn;

	//xeroulaki...
  	myFrame myframehandle;
  	
	public myToolbar(myFrame myframehandle) {
		
		super("Toolbar");
		this.myframehandle = myframehandle;
		
		setOrientation(JToolBar.HORIZONTAL);
		setFloatable(true);
   		setRollover(true);
   		setOpaque(true);
   		addMouseListener(this);
    	
    	newBtn = new JButton(myframehandle.menuBar.newDocAction);
   		newBtn.setMaximumSize(new Dimension(25,25));
   		newBtn.setPreferredSize(new Dimension(25,25));
   		newBtn.setText("");
   		
   		openBtn = new JButton(myframehandle.menuBar.openDocAction);
   		openBtn.setMaximumSize(new Dimension(25,25));
   		openBtn.setPreferredSize(new Dimension(25,25));
		openBtn.setText("");
   		
   		saveBtn = new JButton(myframehandle.menuBar.saveDocAction);
   		saveBtn.setMaximumSize(new Dimension(25,25));
   		saveBtn.setPreferredSize(new Dimension(25,25));
		saveBtn.setText("");
   		
   		printBtn = new JButton(myframehandle.menuBar.printDocAction);
   		printBtn.setMaximumSize(new Dimension(25,25));
   		printBtn.setPreferredSize(new Dimension(25,25));
		printBtn.setText("");
   		
   		cutBtn = new JButton(myframehandle.menuBar.cutAction);
   		cutBtn.setMaximumSize(new Dimension(25,25));
   		cutBtn.setPreferredSize(new Dimension(25,25));
		cutBtn.setText("");
   		
   		copyBtn = new JButton(myframehandle.menuBar.copyAction);
   		copyBtn.setMaximumSize(new Dimension(25,25));
   		copyBtn.setPreferredSize(new Dimension(25,25));
		copyBtn.setText("");
   		
		pasteBtn = new JButton(myframehandle.menuBar.pasteAction);
   		pasteBtn.setMaximumSize(new Dimension(25,25));
   		pasteBtn.setPreferredSize(new Dimension(25,25));
		pasteBtn.setText("");
		
		undoBtn = new JButton(myframehandle.menuBar.undoAction);
   		undoBtn.setMaximumSize(new Dimension(25,25));
   		undoBtn.setPreferredSize(new Dimension(25,25));
		undoBtn.setText("");
		
		redoBtn = new JButton(myframehandle.menuBar.redoAction);
   		redoBtn.setMaximumSize(new Dimension(25,25));
   		redoBtn.setPreferredSize(new Dimension(25,25));
		redoBtn.setText("");
   		
   		importBtn = new JButton(myframehandle.menuBar.importAction);
   		importBtn.setMaximumSize(new Dimension(25,25));
   		importBtn.setPreferredSize(new Dimension(25,25));
		importBtn.setText("");
		   		
   		exportBtn = new JButton(myframehandle.menuBar.exportAction);
   		exportBtn.setMaximumSize(new Dimension(25,25));
   		exportBtn.setPreferredSize(new Dimension(25,25));
		exportBtn.setText("");
		   		
   		orderFrontBtn = new JButton(myframehandle.menuBar.tofrontAction);
   		orderFrontBtn.setMaximumSize(new Dimension(25,25));
   		orderFrontBtn.setPreferredSize(new Dimension(25,25));
		orderFrontBtn.setText("");
		   		
   		orderBackBtn = new JButton(myframehandle.menuBar.toBackAction);
   		orderBackBtn.setMaximumSize(new Dimension(25,25));
   		orderBackBtn.setPreferredSize(new Dimension(25,25));
		orderBackBtn.setText("");
		
		groupBtn = new JButton(myframehandle.menuBar.groupAction);
   		groupBtn.setMaximumSize(new Dimension(25,25));
   		groupBtn.setPreferredSize(new Dimension(25,25));
		groupBtn.setText("");
		
		ungroupBtn = new JButton(myframehandle.menuBar.ungroupAction);
   		ungroupBtn.setMaximumSize(new Dimension(25,25));
   		ungroupBtn.setPreferredSize(new Dimension(25,25));
		ungroupBtn.setText("");
		
		ungroupAllBtn = new JButton(myframehandle.menuBar.ungroupAllAction);
   		ungroupAllBtn.setMaximumSize(new Dimension(25,25));
   		ungroupAllBtn.setPreferredSize(new Dimension(25,25));
		ungroupAllBtn.setText("");
		
		weldBtn = new JButton(myframehandle.menuBar.weldAction);
   		weldBtn.setMaximumSize(new Dimension(25,25));
   		weldBtn.setPreferredSize(new Dimension(25,25));
		weldBtn.setText("");
		
		trimBtn = new JButton(myframehandle.menuBar.trimAction);
   		trimBtn.setMaximumSize(new Dimension(25,25));
   		trimBtn.setPreferredSize(new Dimension(25,25));
		trimBtn.setText("");
		
		intersectBtn = new JButton(myframehandle.menuBar.intersectAction);
   		intersectBtn.setMaximumSize(new Dimension(25,25));
   		intersectBtn.setPreferredSize(new Dimension(25,25));
		intersectBtn.setText("");
		
		simplifyBtn = new JButton(myframehandle.menuBar.simplifyAction);
   		simplifyBtn.setMaximumSize(new Dimension(25,25));
   		simplifyBtn.setPreferredSize(new Dimension(25,25));
		simplifyBtn.setText("");
		
   		add(newBtn);
   		add(openBtn);
   		add(saveBtn);
   		add(printBtn);
   		addSeparator(new Dimension(7,25));
   		add(cutBtn);
   		add(copyBtn);
   		add(pasteBtn);
   		addSeparator(new Dimension(7,25));
   		add(undoBtn);
   		add(redoBtn);
   		addSeparator(new Dimension(7,25));
   		add(importBtn);
   		add(exportBtn);
   		addSeparator(new Dimension(7,25));
   		add(orderFrontBtn);
   		add(orderBackBtn);
   		addSeparator(new Dimension(7,25));
   		add(groupBtn);
   		add(ungroupBtn);
   		add(ungroupAllBtn);
   		addSeparator(new Dimension(7,25));
   		add(weldBtn);
   		add(trimBtn);
   		add(intersectBtn);
   		add(simplifyBtn);
   		addSeparator(new Dimension(7,25));
	}
	/*
	public void actionPerformed(ActionEvent e) {
		//if (e.getSource() == newBtn)
			//myframehandle.createNewDocument();
		if (e.getSource() == openBtn)
			myframehandle.showFileChooser(1);
		else if (e.getSource() == saveBtn)
			myframehandle.showFileChooser(2);
		else if (e.getSource() == outColor)
			myframehandle.showColorChooser();
		else if (e.getSource() == fillColor)
			myframehandle.showColorChooser();		
	}
	*/
	public void mouseClicked(MouseEvent e) {
		
	}
	
	public void mousePressed(MouseEvent e) {
		
	}
	
	public void mouseReleased(MouseEvent e) {
		if (e.isPopupTrigger()) {
        	myframehandle.showPopUpMenu(e);
        }
	}
	
	public void mouseEntered(MouseEvent e) {
		
	}
	
	public void mouseExited(MouseEvent e) {
		
	}
}