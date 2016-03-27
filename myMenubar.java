import javax.swing.*;
import java.awt.event.*;


public class myMenubar extends JMenuBar implements MouseListener {
	
	//Components of the menu bar
  	JMenu menuFile;
  	JMenu menuEdit;
  	JMenu menuView;
  	JMenu menuToolbars;
  	JMenu menuArrange;
  	JMenu menuHelp;
  	JMenu menuLook_Feel;
  	JMenu subMenu;
  	
  	JMenuItem FileItemNew;
  	JMenuItem FileItemOpen;
  	JMenuItem FileItemSave;
  	JMenuItem FileItemPrint;
  	JMenuItem FileItemImport;
  	JMenuItem FileItemExport;
  	JMenuItem FileItemExit;
  	
  	JMenuItem EditItemUndo;
  	JMenuItem EditItemRedo;
  	JMenuItem EditItemCut;
  	JMenuItem EditItemCopy;
  	JMenuItem EditItemPaste;
  	
  	JMenuItem ViewItemShowAll;
  	JMenuItem ViewItemHideAll;
  	JCheckBoxMenuItem Standard;
	JCheckBoxMenuItem Toolbox;
	JCheckBoxMenuItem StatusBar;
	JCheckBoxMenuItem ColorPalette;
  	
  	JMenuItem ArrangeItemtoFront;
  	JMenuItem ArrangeItemtoBack;
  	JMenuItem ArrangeItemGroup;
  	JMenuItem ArrangeItemUngroup;
  	JMenuItem ArrangeItemUngroupAll;
  	JMenuItem ArrangeItemWeld;
  	JMenuItem ArrangeItemTrim;
  	JMenuItem ArrangeItemIntersect;
  	JMenuItem ArrangeItemSimplify;  	
  	
  	JMenuItem HelpItemAbout;
  	
  	JMenuItem Look_FeelItemSystem;
  	JMenuItem Look_FeelItemMetal;
  	JMenuItem Look_FeelItemMotif;
  	
  	JMenuItem subMenuItem1,subMenuItem2,subMenuItem3,subMenuItem4;
  	JCheckBoxMenuItem menuChechBox;
  	JRadioButtonMenuItem menuRadioButton;
  	
  	//Some icons
  	ImageIcon	newImage,openImage,saveImage,printImage,
  				importImage,exportImage,
  				undoImage,redoImage,
  				cutImage,copyImage,pasteImage,
  				orderFrontImage,orderBackImage,
  				groupImage,ungroupImage,ungroupAllImage,
  				weldImage,trimImage,intersectImage,simplifyImage;
  	
  	//Actions
  	Action 	newDocAction,openDocAction,saveDocAction,printDocAction,
  			importAction,exportAction,
  			undoAction,redoAction,
  			cutAction,copyAction,pasteAction,
  			showAllAction,hideAllAction,
  			standardAction,toolboxAction,statusbarAction,colorPaletteAction,
  			tofrontAction,toBackAction,
  			groupAction,ungroupAction,ungroupAllAction,
  			weldAction,trimAction,intersectAction,simplifyAction,
  			showAboutAction,
  			system_lookAction,metal_lookAction,motif_lookAction;
  							
  	//xeroulaki...
  	myFrame myframehandle;
  	
  	public myMenubar(myFrame myframehandle) {
  		
  		this.myframehandle = myframehandle;
  		addMouseListener(this);
  		setOpaque(true);
  		
  		newImage = new ImageIcon("icons/new.gif");
    	openImage = new ImageIcon("icons/open.gif");
    	saveImage = new ImageIcon("icons/save.gif");
    	printImage = new ImageIcon("icons/print.gif");
  		importImage = new ImageIcon("icons/import.gif");
   		exportImage = new ImageIcon("icons/export.gif");
  		undoImage = new ImageIcon("icons/undo.gif");
   		redoImage = new ImageIcon("icons/redo.gif");
		cutImage = new ImageIcon("icons/cut.gif");
		copyImage = new ImageIcon("icons/copy.gif");
		pasteImage = new ImageIcon("icons/paste.gif");
   		orderFrontImage = new ImageIcon("icons/orderfront.gif");
   		orderBackImage = new ImageIcon("icons/orderback.gif");
   		groupImage = new ImageIcon("icons/group.gif");
   		ungroupImage = new ImageIcon("icons/ungroup.gif");
   		ungroupAllImage = new ImageIcon("icons/ungroup_all.gif");
   		weldImage = new ImageIcon("icons/weld.gif");
   		trimImage = new ImageIcon("icons/trim.gif");
   		intersectImage = new ImageIcon("icons/intersect.gif");
   		simplifyImage = new ImageIcon("icons/simplify.gif");
		
		//Create the actions shared by the toolbar and the menu.
        newDocAction = new myAction("New",newImage,
        							"Create a new document",
        							new Integer(KeyEvent.VK_N));
        
        openDocAction = new myAction("Open",openImage,
        							"Open an excisting document",
        							new Integer(KeyEvent.VK_O));

        saveDocAction = new myAction("Save",saveImage,
        							"Save a document",
        							new Integer(KeyEvent.VK_S));

        printDocAction = new myAction("Print",printImage,
        							"Print a document",
        							new Integer(KeyEvent.VK_P));

        importAction = new myAction("Import",importImage,
        							"Import a bitmap file",
        							new Integer(KeyEvent.VK_I));          

        exportAction = new myAction("Export",exportImage,
        							"Export in bitmap",
        							new Integer(KeyEvent.VK_E));

        undoAction = new myAction("Undo",undoImage,
        							"Undo action",
        							new Integer(KeyEvent.VK_U));

        redoAction = new myAction("Redo",redoImage,
        							"Redo action",
        							new Integer(KeyEvent.VK_R));
        
        cutAction = new myAction("Cut",cutImage,
        							"Cut",
        							new Integer(KeyEvent.VK_X));
        
        copyAction = new myAction("Copy",copyImage,
        							"Copy",
        							new Integer(KeyEvent.VK_C));
        
        pasteAction = new myAction("Paste",pasteImage,
        							"Paste",
        							new Integer(KeyEvent.VK_V));
        							
        showAllAction = new myAction("Show all",null,
        							"Show all toolbars",
        							new Integer(KeyEvent.VK_S));
        
        hideAllAction  = new myAction("Hide all",null,
        							"Hide all toolbars",
        							new Integer(KeyEvent.VK_H));
        
        standardAction = new myAction("Standard",null,
        							"Toggle visibility of this command bar",
        							null);
        
        toolboxAction = new myAction("Toolbox",null,
        							"Toggle visibility of this command bar",
        							null);
        
        statusbarAction = new myAction("Status Bar",null,
        							"Toggle visibility of this command bar",
        							null);
        
        colorPaletteAction = new myAction("Color Palette",null,
        							"Toggle visibility of this command bar",
        							null);
        
        tofrontAction = new myAction("To Front",orderFrontImage,
        							"Move an object in front of all other objects",
        							new Integer(KeyEvent.VK_F));
        
        toBackAction = new myAction("To Back",orderBackImage,
        							"Move an object in back of all other objects",
        							new Integer(KeyEvent.VK_B));
        
        groupAction = new myAction("Group",groupImage,
        							"Group",
        							new Integer(KeyEvent.VK_G));
        
        ungroupAction = new myAction("Ungroup",ungroupImage,
        							"Ungroup",
        							new Integer(KeyEvent.VK_U));        						        							

        ungroupAllAction = new myAction("Ungroup All",ungroupAllImage,
        							"Ungroup All",
        							new Integer(KeyEvent.VK_N));

        weldAction = new myAction("Weld",weldImage,
        							"Weld",
        							new Integer(KeyEvent.VK_W));

        trimAction = new myAction("Trim",trimImage,
        							"Trim",
        							new Integer(KeyEvent.VK_T));

        intersectAction = new myAction("Intersect",intersectImage,
        							"Intersect",
        							new Integer(KeyEvent.VK_I));

        simplifyAction = new myAction("Simplify",simplifyImage,
        							"Simplify",
        							new Integer(KeyEvent.VK_S));
        							        							        							        							        			        							
        showAboutAction = new myAction("About...",null,
        							"About this application",
        							new Integer(KeyEvent.VK_A));
        							
		system_lookAction = new myAction("System",null,
        							"System look & Feel",
        							new Integer(KeyEvent.VK_S));

		metal_lookAction = new myAction("Metal",null,
        							"Metal look & Feel",
        							new Integer(KeyEvent.VK_M));

		motif_lookAction = new myAction("Motif",null,
        							"Motif look & Feel",
        							new Integer(KeyEvent.VK_O));
  		//disalble all actions
  		disableActions();
  		
  		//Contsruct The File Menu
    	//****************************************************************
    	menuFile = new JMenu();
    	menuFile.setText("  File  ");
    	menuFile.setMnemonic(KeyEvent.VK_F);
    	
    	FileItemNew = new JMenuItem(newDocAction);
    	FileItemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));

    	FileItemOpen = new JMenuItem(openDocAction);
    	FileItemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));

    	FileItemSave = new JMenuItem(saveDocAction);
    	FileItemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
    	
    	FileItemPrint = new JMenuItem(printDocAction);
    	FileItemPrint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
    	
    	FileItemImport = new JMenuItem(importAction);
    	FileItemImport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
    	
    	FileItemExport = new JMenuItem(exportAction);
    	FileItemExport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
    	
    	FileItemExit = new JMenuItem();
    	FileItemExit.setText("Exit");
    	//FileItemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
    	
    	subMenu=new JMenu("Submenu");
    	subMenuItem1 = new JMenuItem("submenu1");
    	subMenu.add(subMenuItem1);
    	menuFile.add(FileItemNew);
    	menuFile.add(FileItemOpen);
    	menuFile.add(FileItemSave);
    	menuFile.addSeparator();
    	menuFile.add(FileItemPrint);
    	menuFile.addSeparator();
    	menuFile.add(FileItemImport);
    	menuFile.add(FileItemExport);
    	menuFile.addSeparator();
    	menuFile.add(subMenu);
    	menuFile.addSeparator();
    	menuChechBox = new JCheckBoxMenuItem("this is a JCheckBoxMenuItem");
    	menuChechBox.setSelected(true);
    	menuFile.add(menuChechBox);
    	menuRadioButton = new JRadioButtonMenuItem("this is a JRadioButtonMenuItem");
    	menuRadioButton.setSelected(true);
    	menuFile.add(menuRadioButton);
    	menuFile.addSeparator();
    	menuFile.add(FileItemExit);
		add(menuFile);
		
	    //Contsruct The Edit Menu
	    //****************************************************************
	    menuEdit = new JMenu();
	    menuEdit.setText("  Edit  ");
	    menuEdit.setMnemonic(KeyEvent.VK_E);
	    
	    EditItemUndo = new JMenuItem(undoAction);
    	EditItemUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
    	
    	EditItemRedo = new JMenuItem(redoAction);
    	EditItemRedo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
    	
    	EditItemCut = new JMenuItem(cutAction);
    	EditItemCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
    	
    	EditItemCopy = new JMenuItem(copyAction);
    	EditItemCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
    	
    	EditItemPaste = new JMenuItem(pasteAction);
    	EditItemPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
    	
    	menuEdit.add(EditItemUndo);
    	menuEdit.add(EditItemRedo);
    	menuEdit.addSeparator();
    	menuEdit.add(EditItemCut);
    	menuEdit.add(EditItemCopy);
    	menuEdit.add(EditItemPaste);
    	
    	add(menuEdit);
	    
	    //Contsruct The View Menu
	    //****************************************************************
	    menuView = new JMenu();
	    menuView.setText("  View  ");
	    menuView.setMnemonic(KeyEvent.VK_V);
	    
	    ViewItemShowAll = new JMenuItem(showAllAction);
	    ViewItemShowAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
		ViewItemHideAll = new JMenuItem(hideAllAction);
	    ViewItemHideAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
	    
	    menuToolbars = new JMenu("Toolbars");
	    menuToolbars.setMnemonic(KeyEvent.VK_T);
	    
	    Standard = new JCheckBoxMenuItem(standardAction);
	    Standard.setSelected(true);
		Toolbox = new JCheckBoxMenuItem(toolboxAction);
		Toolbox.setSelected(true);
		StatusBar = new JCheckBoxMenuItem(statusbarAction);
		StatusBar.setSelected(true);
		ColorPalette = new JCheckBoxMenuItem(colorPaletteAction);
	    ColorPalette.setSelected(true);

	    menuToolbars.add(Standard);
	    menuToolbars.add(Toolbox);
	    menuToolbars.add(StatusBar);
	    menuToolbars.add(ColorPalette);
	    menuToolbars.addSeparator();
		menuToolbars.add(ViewItemShowAll);
		menuToolbars.add(ViewItemHideAll);
		
	    menuView.add(menuToolbars);

		add(menuView);
		
		//Contsruct The Arrange Menu
	    //****************************************************************
		menuArrange = new JMenu();
	    menuArrange.setText("  Arrange  ");
	    menuArrange.setMnemonic(KeyEvent.VK_A);
	    
	    ArrangeItemtoFront = new JMenuItem(tofrontAction);
    	ArrangeItemtoFront.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
		
		ArrangeItemtoBack = new JMenuItem(toBackAction);
    	ArrangeItemtoBack.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
    	
	    ArrangeItemGroup = new JMenuItem(groupAction);
    	ArrangeItemGroup.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
		
		ArrangeItemUngroup = new JMenuItem(ungroupAction);
    	ArrangeItemUngroup.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
    	
    	ArrangeItemUngroupAll = new JMenuItem(ungroupAllAction);
    	ArrangeItemWeld = new JMenuItem(weldAction);
    	ArrangeItemTrim = new JMenuItem(trimAction);
    	ArrangeItemIntersect = new JMenuItem(intersectAction);
    	ArrangeItemSimplify = new JMenuItem(simplifyAction);
    	  	
    	menuArrange.add(ArrangeItemtoFront);
    	menuArrange.add(ArrangeItemtoBack);
    	menuArrange.addSeparator();
    	menuArrange.add(ArrangeItemGroup);
    	menuArrange.add(ArrangeItemUngroup);
    	menuArrange.add(ArrangeItemUngroupAll);
    	menuArrange.addSeparator();
    	menuArrange.add(ArrangeItemWeld);
    	menuArrange.add(ArrangeItemTrim);
    	menuArrange.add(ArrangeItemIntersect);
    	menuArrange.add(ArrangeItemSimplify);
		add(menuArrange);
		
		//Contsruct The Help Menu
    	//****************************************************************
    	menuHelp = new JMenu();
    	menuHelp.setText("  Help  ");
    	menuHelp.setMnemonic(KeyEvent.VK_H);
    	
    	HelpItemAbout = new JMenuItem(showAboutAction);
    	HelpItemAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.SHIFT_MASK));
    	
    	menuHelp.add(HelpItemAbout);
    	add(menuHelp);
		
		//Contsruct The Look&Feel Menu
    	//****************************************************************
    	menuLook_Feel = new JMenu();
    	menuLook_Feel.setText("  Look & Feel  ");
    	menuLook_Feel.setMnemonic(KeyEvent.VK_L);
    	
    	Look_FeelItemSystem = new JMenuItem(system_lookAction);
    	Look_FeelItemSystem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.SHIFT_MASK));

    	Look_FeelItemMetal = new JMenuItem(metal_lookAction);
    	Look_FeelItemMetal.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.SHIFT_MASK));

    	Look_FeelItemMotif = new JMenuItem(motif_lookAction);
    	Look_FeelItemMotif.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.SHIFT_MASK));

    	menuLook_Feel.add(Look_FeelItemSystem);
    	menuLook_Feel.add(Look_FeelItemMetal);
    	menuLook_Feel.add(Look_FeelItemMotif);
    	add(menuLook_Feel);
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
	
	public void disableActions() {
		saveDocAction.setEnabled(false);
  		printDocAction.setEnabled(false);
  		cutAction.setEnabled(false);
  		copyAction.setEnabled(false);
  		pasteAction.setEnabled(false);
  		undoAction.setEnabled(false);
  		redoAction.setEnabled(false);
  		importAction.setEnabled(false);
  		exportAction.setEnabled(false);
  		tofrontAction.setEnabled(false);
  		toBackAction.setEnabled(false);
  		groupAction.setEnabled(false);
  		ungroupAction.setEnabled(false);
  		ungroupAllAction.setEnabled(false);
  		weldAction.setEnabled(false);
  		trimAction.setEnabled(false);
  		intersectAction.setEnabled(false);
  		simplifyAction.setEnabled(false);
	}
	
	/*	Nested class for Action Handling	 */
	
	public class myAction extends AbstractAction {
		public myAction(String text, ImageIcon icon,
                          String desc, Integer mnemonic) {
            super(text, icon);
            putValue(SHORT_DESCRIPTION, desc);
            putValue(MNEMONIC_KEY, mnemonic);
        }
        public void actionPerformed(ActionEvent e) {
        	
        	if (e.getSource() == FileItemNew || e.getSource() == myframehandle.toolbar.newBtn)
        		myframehandle.createNewDocument();
        		
        	else if(e.getSource() == FileItemOpen  || e.getSource() == myframehandle.toolbar.openBtn)
        		myframehandle.showFileChooser(1);
        		
        	else if(e.getSource() == FileItemSave  || e.getSource() == myframehandle.toolbar.saveBtn)
        		myframehandle.showFileChooser(2);
        		
        	else if(e.getSource() == Standard) {
        		if (!Standard.isSelected()) {
        			myframehandle.toolbar.setVisible(false);
        			myframehandle.popUpMenu.popUpMenuItem1.setSelected(false);
        		}
				else {
					myframehandle.toolbar.setVisible(true);
					myframehandle.popUpMenu.popUpMenuItem1.setSelected(true);
				}
        	}
        	
        	else if(e.getSource() == myframehandle.popUpMenu.popUpMenuItem1) {
        		if (!myframehandle.popUpMenu.popUpMenuItem1.isSelected()) {
        			myframehandle.toolbar.setVisible(false);
        			Standard.setSelected(false);
        		}
				else {
					myframehandle.toolbar.setVisible(true);
					Standard.setSelected(true);
				}	
        	}
        	
        	else if(e.getSource() == Toolbox) {
        		if (!Toolbox.isSelected()) {
        			myframehandle.toolbox.setVisible(false);
        			myframehandle.popUpMenu.popUpMenuItem2.setSelected(false);
        		}
				else {
					myframehandle.toolbox.setVisible(true);
					myframehandle.popUpMenu.popUpMenuItem2.setSelected(true);
				}
        	}
        	
        	else if(e.getSource() == myframehandle.popUpMenu.popUpMenuItem2) {
        		if (!myframehandle.popUpMenu.popUpMenuItem2.isSelected()) {
        			myframehandle.toolbox.setVisible(false);
        			Toolbox.setSelected(false);
        		}
				else {
					myframehandle.toolbox.setVisible(true);
					Toolbox.setSelected(true);
				}
        	}
        	
       		else if(e.getSource() == StatusBar) {
        		if (!StatusBar.isSelected()) {
        			myframehandle.statusBar.setVisible(false);
        			myframehandle.popUpMenu.popUpMenuItem3.setSelected(false);
        		}
				else {
					myframehandle.statusBar.setVisible(true);
					myframehandle.popUpMenu.popUpMenuItem3.setSelected(true);
				}
        	}
        	
        	else if(e.getSource() == myframehandle.popUpMenu.popUpMenuItem3) {
        		if (!myframehandle.popUpMenu.popUpMenuItem3.isSelected()) {
        			myframehandle.statusBar.setVisible(false);
        			StatusBar.setSelected(false);
        		}
				else {
					myframehandle.statusBar.setVisible(true);
					StatusBar.setSelected(true);
				}
        	}
        	
        	else if(e.getSource() == ColorPalette) {
        		if (!ColorPalette.isSelected()) {
        			myframehandle.colorPalette.setVisible(false);
        			myframehandle.popUpMenu.popUpMenuItem4.setSelected(false);
        		}	
				else {
					myframehandle.colorPalette.setVisible(true);
					myframehandle.popUpMenu.popUpMenuItem4.setSelected(true);
				}
        	}
        	
        	else if(e.getSource() == myframehandle.popUpMenu.popUpMenuItem4) {
        		if (!myframehandle.popUpMenu.popUpMenuItem4.isSelected()) {
        			myframehandle.colorPalette.setVisible(false);
        			ColorPalette.setSelected(false);
        		}	
				else {
					myframehandle.colorPalette.setVisible(true);
					ColorPalette.setSelected(true);
				}
        	}
        	
        	else if(e.getSource() == ViewItemShowAll)
  				myframehandle.showAllToolbars();   	
        	
        	else if(e.getSource() == ViewItemHideAll)
  				myframehandle.hideAllToolbars();
        	
        	else if(e.getSource() == HelpItemAbout)
  				myframehandle.showAboutDialog();
       		
       		else if(e.getSource() == Look_FeelItemSystem) 
       			myframehandle.changeLookAndFeel(2);
       		
      		else if(e.getSource() == Look_FeelItemMetal) 
           		myframehandle.changeLookAndFeel(0);
       		
       		else if(e.getSource() == Look_FeelItemMotif)
           		myframehandle.changeLookAndFeel(1);
           	
           	else if(e.getSource() == ArrangeItemtoBack || e.getSource() == myframehandle.toolbar.orderBackBtn || e.getSource() == myframehandle.internalFrame.DrawingArea.popUpMenu.toBack)
           		myframehandle.internalFrame.DrawingArea.orderObject(0,myframehandle.internalFrame.DrawingArea.selectedObjectID);
       		
           	else if(e.getSource() == ArrangeItemtoFront || e.getSource() == myframehandle.toolbar.orderFrontBtn || e.getSource() == myframehandle.internalFrame.DrawingArea.popUpMenu.toFront)
           		myframehandle.internalFrame.DrawingArea.orderObject(1,myframehandle.internalFrame.DrawingArea.selectedObjectID);

       		//else if(e.getSource() == FileItemImport)	
       		
       		//else if(e.getSource() == FileItemExport)
                 	
        	}
    }

}