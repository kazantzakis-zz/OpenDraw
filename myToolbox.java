import javax.swing.JDialog;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import javax.swing.KeyStroke;

import java.awt.Dimension;


import java.awt.event.*;

public class myToolbox extends JToolBar implements ActionListener, MouseListener {
	
	//The buttons of the Toolbox
	JButton pickBtn,zoomBtn,freeHandBtn,rectangleBtn,ovalBtn,textBtn,eyeDropperBtn,fillBtn,outlineBtn;
	
	//Some icons
	Icon pickImage,zoomImage,freehandImage,rectangleImage,ovalImage,textImage,eyeDropperImage,fillImage,outlineImage;
	
	//xeroulaki...
  	myFrame myframehandle;
  	
	public myToolbox(myFrame myframehandle) {
		
		super("Toolbox");
		this.myframehandle = myframehandle;
		
		setOrientation(JToolBar.VERTICAL);
		setFloatable(true);
   		setRollover(true);
   		setOpaque(true);
   		addMouseListener(this);
   		//setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
   		
   		pickImage=new ImageIcon("icons/Pick.gif");
   		zoomImage=new ImageIcon("icons/zoom.gif");
   		freehandImage = new ImageIcon("icons/Freehand.gif");
   		rectangleImage = new ImageIcon("icons/Rectangle.gif");
   		ovalImage = new ImageIcon("icons/Oval.gif");	
   		textImage = new ImageIcon("icons/Text.gif");
   		eyeDropperImage = new ImageIcon("icons/eyedropper.gif");
   		fillImage = new ImageIcon("icons/Fill.gif");
   		outlineImage = new ImageIcon("icons/Outline.gif");
   		
   		pickBtn = new JButton(pickImage);
   		pickBtn.setMaximumSize(new Dimension(25,25));
   		pickBtn.setPreferredSize(new Dimension(25,25));
   		pickBtn.addActionListener(this);
   		pickBtn.setToolTipText("Pick Tool");
   		zoomBtn = new JButton(zoomImage);
   		zoomBtn.setMaximumSize(new Dimension(25,25));
   		zoomBtn.setPreferredSize(new Dimension(25,25));
   		zoomBtn.addActionListener(this);
   		zoomBtn.setToolTipText("Zoom Tool");
   		freeHandBtn = new JButton(freehandImage);
   		freeHandBtn.setMaximumSize(new Dimension(25,25));
   		freeHandBtn.setPreferredSize(new Dimension(25,25));
   		freeHandBtn.addActionListener(this);
   		freeHandBtn.setToolTipText("Freehand Tool");
   		rectangleBtn = new JButton(rectangleImage);
   		rectangleBtn.setMaximumSize(new Dimension(25,25));
   		rectangleBtn.setPreferredSize(new Dimension(25,25));
   		rectangleBtn.addActionListener(this);
		rectangleBtn.setToolTipText("Rectangle Tool");
   		ovalBtn = new JButton(ovalImage);
   		ovalBtn.setMaximumSize(new Dimension(25,25));
   		ovalBtn.setPreferredSize(new Dimension(25,25));
   		ovalBtn.addActionListener(this);
   		ovalBtn.setToolTipText("Oval Tool");
   		textBtn = new JButton(textImage);
   		textBtn.setMaximumSize(new Dimension(25,25));
   		textBtn.setPreferredSize(new Dimension(25,25));
   		textBtn.addActionListener(this);
   		textBtn.setToolTipText("Text Tool");
   		eyeDropperBtn = new JButton(eyeDropperImage);
   		eyeDropperBtn.setMaximumSize(new Dimension(25,25));
   		eyeDropperBtn.setPreferredSize(new Dimension(25,25));
   		eyeDropperBtn.addActionListener(this);
   		eyeDropperBtn.setToolTipText("Eyedropper Tool");
   		outlineBtn = new JButton(outlineImage);
   		outlineBtn.setMaximumSize(new Dimension(25,25));
   		outlineBtn.setPreferredSize(new Dimension(25,25));
   		outlineBtn.addActionListener(this);
   		outlineBtn.setToolTipText("Outline Tool");
   		fillBtn = new JButton(fillImage);
   		fillBtn.setMaximumSize(new Dimension(25,25));
   		fillBtn.setPreferredSize(new Dimension(25,25));
   		fillBtn.addActionListener(this);
   		fillBtn.setToolTipText("Fill Tool");
   		
   		add(pickBtn);
   		add(zoomBtn);
   		add(freeHandBtn);
		add(rectangleBtn);
   		add(ovalBtn);
   		add(textBtn);
   		addSeparator();
   		add(eyeDropperBtn);
   		add(outlineBtn);
   		add(fillBtn);
   		addSeparator();
   		
   		disableToolbox();	
	}
	
	private void toolboxSelection() {
		pickBtn.setSelected(false);
   		zoomBtn.setSelected(false);
       	freeHandBtn.setSelected(false);
       	rectangleBtn.setSelected(false);
       	ovalBtn.setSelected(false);
       	textBtn.setSelected(false);
       	eyeDropperBtn.setSelected(false);
   	}
   	
   	private void disableToolbox() {
   		pickBtn.setEnabled(false);
   		zoomBtn.setEnabled(false);
       	freeHandBtn.setEnabled(false);
       	rectangleBtn.setEnabled(false);
       	ovalBtn.setEnabled(false);
       	textBtn.setEnabled(false);
       	eyeDropperBtn.setEnabled(false);
       	outlineBtn.setEnabled(false);
       	fillBtn.setEnabled(false);
   	}
   	
   	public void enableToolbox() {
   		pickBtn.setEnabled(true);
   		zoomBtn.setEnabled(true);
       	freeHandBtn.setEnabled(true);
       	rectangleBtn.setEnabled(true);
       	ovalBtn.setEnabled(true);
       	textBtn.setEnabled(true);
       	eyeDropperBtn.setEnabled(true);
       	outlineBtn.setEnabled(true);
       	fillBtn.setEnabled(true);
   	}
   	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == pickBtn) {
       		myFrame.ActiveTool = "Pick";
       		myframehandle.statusBar.setMessage1("Active Tool: "+myFrame.ActiveTool);
       		toolboxSelection();
       		pickBtn.setSelected(true);
		}
        else if(e.getSource() == zoomBtn) {
       		myFrame.ActiveTool = "Zoom";
       		myframehandle.statusBar.setMessage1("Active Tool: "+myFrame.ActiveTool);
       		toolboxSelection();
       		zoomBtn.setSelected(true);
		}
		else if(e.getSource() == freeHandBtn) {
       		myFrame.ActiveTool = "Freehand";
       		myframehandle.statusBar.setMessage1("Active Tool: "+myFrame.ActiveTool);
       		toolboxSelection();
       		freeHandBtn.setSelected(true);
		}
		else if(e.getSource() == rectangleBtn) {
       		myFrame.ActiveTool = "Rectangle";
       		myframehandle.statusBar.setMessage1("Active Tool: "+myFrame.ActiveTool);
       		toolboxSelection();
       		rectangleBtn.setSelected(true);
		}
		else if(e.getSource() == ovalBtn) {
       		myFrame.ActiveTool = "Oval";
       		myframehandle.statusBar.setMessage1("Active Tool: "+myFrame.ActiveTool);
       		toolboxSelection();
       		ovalBtn.setSelected(true);
		}
		else if(e.getSource() == textBtn) {
       		myFrame.ActiveTool = "Text";
       		myframehandle.statusBar.setMessage1("Active Tool: "+myFrame.ActiveTool);
       		toolboxSelection();
       		textBtn.setSelected(true);
		}
		else if(e.getSource() == eyeDropperBtn) {
       		myFrame.ActiveTool = "EyeDropper";
       		myframehandle.statusBar.setMessage1("Active Tool: "+myFrame.ActiveTool);
       		toolboxSelection();
       		eyeDropperBtn.setSelected(true);
		}
		else if(e.getSource() == fillBtn) {
      		//shapeColor=JColorChooser.showDialog(this,"Choose Color",Color.BLACK);
		}
		else if(e.getSource() == outlineBtn) {
			
      		myDialog dialog = new myDialog(myframehandle,"Outline Pen",true);
			dialog.setSize(460,400);
			dialog.setLocationRelativeTo(null);
			dialog.setResizable(false);
			dialog.setVisible(true);
			dialog.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
	
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