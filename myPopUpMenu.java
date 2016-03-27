import javax.swing.JPopupMenu;
import javax.swing.JCheckBoxMenuItem;

//import java.awt.event.*;

public class myPopUpMenu extends JPopupMenu {// implements ActionListener {
	
	JCheckBoxMenuItem popUpMenuItem1,popUpMenuItem2,popUpMenuItem3,popUpMenuItem4;
	
	myFrame myframehandle;
	
	public myPopUpMenu(myFrame myframehandle) {
		this.myframehandle = myframehandle;
		
		
		popUpMenuItem1 = new JCheckBoxMenuItem(myframehandle.menuBar.standardAction);
    	popUpMenuItem1.setSelected(true);
    	//popUpMenuItem1.addActionListener(this);
    	popUpMenuItem2 = new JCheckBoxMenuItem(myframehandle.menuBar.toolboxAction);
    	popUpMenuItem2.setSelected(true);
    	//popUpMenuItem2.addActionListener(this);
    	popUpMenuItem3 = new JCheckBoxMenuItem(myframehandle.menuBar.statusbarAction);
    	popUpMenuItem3.setSelected(true);
    	//popUpMenuItem3.addActionListener(this);
    	popUpMenuItem4 = new JCheckBoxMenuItem(myframehandle.menuBar.colorPaletteAction);
    	popUpMenuItem4.setSelected(true);
    	//popUpMenuItem4.addActionListener(this);    	
    	add(popUpMenuItem1);
    	add(popUpMenuItem2);
    	add(popUpMenuItem3);
    	add(popUpMenuItem4);
	}
	/*
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == popUpMenuItem1) {
			if (!popUpMenuItem1.isSelected())
				myframehandle.toolbar.setVisible(false);
			else 
				myframehandle.toolbar.setVisible(true);
		}
		else if(e.getSource() == popUpMenuItem2) {
			if (!popUpMenuItem2.isSelected())
				myframehandle.toolbox.setVisible(false);
			else 
				myframehandle.toolbox.setVisible(true);
		}
		else if(e.getSource() == popUpMenuItem3) {
			if (!popUpMenuItem3.isSelected())
				myframehandle.statusBar.setVisible(false);
			else 
				myframehandle.statusBar.setVisible(true);
		}
		else if(e.getSource() == popUpMenuItem4) {
			if (!popUpMenuItem4.isSelected())
				myframehandle.colorPalette.setVisible(false);
			else 
				myframehandle.colorPalette.setVisible(true);
		}
		
	}*/
}