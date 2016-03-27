import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.JInternalFrame;

public class myColorPalette extends JToolBar implements ActionListener, MouseListener, ChangeListener {
  	
  	//The button of the colorPalette
  	JButton show_hide_Btn;	
	
	//Some icons
  	Icon showImage,hideImage;
  	
  	//The colorChooser
  	JColorChooser colorPalleteChooser;

	//xeroulaki...
  	myFrame myframehandle;
  	
	public myColorPalette(myFrame myframehandle) {
		
		super("Color Palette");
		this.myframehandle = myframehandle;
		
		setOrientation(JToolBar.VERTICAL);//SwingConstants.VERTICAL
		setFloatable(true);
   		setRollover(true);
   		setOpaque(true);
   		addMouseListener(this);
   		
   		colorPalleteChooser = new JColorChooser();	
   		colorPalleteChooser.setPreviewPanel(new JPanel());
   		//AbstractColorChooserPanel[] panels = colorPalleteChooser.getChooserPanels();
    	//colorPalleteChooser.removeChooserPanel(panels[1]);
   		colorPalleteChooser.getSelectionModel().addChangeListener(this);
   		showImage = new ImageIcon("icons/show.gif");
   		hideImage = new ImageIcon("icons/hide.gif");
   		show_hide_Btn = new JButton(showImage);
   		show_hide_Btn.setMaximumSize(new Dimension(15,15));
   		show_hide_Btn.setPreferredSize(new Dimension(15,15));
   		show_hide_Btn.setToolTipText("Expand Docker");
   		show_hide_Btn.addActionListener(this);
   		add(show_hide_Btn);
	}
	
	public void stateChanged(ChangeEvent e) {
		myShape.defaultFillColor = colorPalleteChooser.getColor();
		// JInternalFrame[] allFrames = myframehandle.desktop.getAllFrames();
		/* 
		myFrame.statusBar.setMessage6(String.valueOf(allFrames.length));
		myFrame.statusBar.setMessage4(String.valueOf());	
		
		if (e.getSource() == colorPalleteChooser) {
			
			if(myCanvas.selecting){
					myCanvas.myShapes.elementAt(myCanvas.selectedShapeID).fillColor=colorPalleteChooser.getColor();
					myInternalFrame.DrawingArea.repaint();
				}
		}
		*/
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == show_hide_Btn && show_hide_Btn.getIcon() == showImage) {//!this.contains(colorPalleteChooser)
			add(colorPalleteChooser);
       		show_hide_Btn.setIcon(hideImage);
       		show_hide_Btn.setToolTipText("Collapse Docker");
       		revalidate();
       		repaint();
		}
		else {
			remove(colorPalleteChooser);
			show_hide_Btn.setIcon(showImage);
       		show_hide_Btn.setToolTipText("Expand Docker");
       		revalidate();
       		repaint();
       	}
	}

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