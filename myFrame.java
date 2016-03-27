import javax.swing.*;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.Color;
import java.awt.Stroke;
import java.awt.event.MouseEvent;

public class myFrame extends JFrame {
	
	//some variables that will be used as object references...
  	
  	//The menubar
  	myMenubar menuBar;
  	
  	//The toolbar
  	myToolbar toolbar;
  	
  	//The toolbox
  	myToolbox toolbox;
  	
  	//The statusBar
  	static myStatusBar statusBar;
  	
  	//The color Palette
  	myColorPalette colorPalette;
  	
   	//The Desktop pane
  	JDesktopPane desktop;
  	
  	//The Internal frame
  	myInternalFrame internalFrame;
  	
  	//The PopUpMenu
  	myPopUpMenu popUpMenu;
  	
  	//The file chooser
  	JFileChooser fc;
  	
  	//The Active tool
  	static String ActiveTool = "none";
  	
  	//An array with the looks
  	UIManager.LookAndFeelInfo looks[];	
		
	public myFrame() {
  		super("OpenDraw ver.01");
  		buildGUI();

	}
	
	private void buildGUI() {
		Container cp = getContentPane();
			
    	//Contsruct The Menu Bar
    	//****************************************************************
    	menuBar = new myMenubar(this);
    	
    	//Add the MenuBar into the Frame
    	//****************************************************************
    	this.setJMenuBar(menuBar);
		
		//Construct the Toolbar
   		//****************************************************************
   		toolbar = new myToolbar(this);
   		cp.add(toolbar, BorderLayout.NORTH); //PAGE_START
		
		//Construct the Toolbox
   		//****************************************************************
   		toolbox = new myToolbox(this);
   		cp.add(toolbox, BorderLayout.WEST); //PAGE_START
		
		//Construct the status bar
		//****************************************************************
		statusBar = new myStatusBar("Active Tool","Coordinates","Fill Color","Mouse Position","Info Line","Outline Color",this);
		cp.add(statusBar,BorderLayout.SOUTH);
		
		//Contsruct the Color Palette
   		//****************************************************************
   		colorPalette = new myColorPalette(this);
   		cp.add(colorPalette, BorderLayout.EAST);

		//Contsruct the DesktopPane
   		//****************************************************************
    	desktop = new JDesktopPane();
    	desktop.setOpaque(true);
    	desktop.setBackground(Color.GRAY);
    	desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
    	cp.add(desktop, BorderLayout.CENTER);
    	
		//Contsruct the Pallete
   		//****************************************************************
    	JInternalFrame palette = new JInternalFrame();//getString("InternalFrameDemo.palette_label")
 		palette.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE); 
 		palette.getContentPane().setLayout(new BorderLayout()); 
 		palette.setBounds(375, 20, 30, 300); 
 		palette.setResizable(false); 
 		palette.setIconifiable(false); 
 		desktop.add(palette, new Integer(2));
 		palette.setVisible(true);
    		
		//Contsruct The PopupMenu Menu
    	//****************************************************************
    	popUpMenu = new myPopUpMenu(this);
		
		//Construct the JFilechooser
		//****************************************************************
		fc = new JFileChooser();
    					
		//Get the installed look and Feels
		//****************************************************************
		looks = UIManager.getInstalledLookAndFeels();    	
	}
	
	public void changeLookAndFeel(int i) {
		try {
			UIManager.setLookAndFeel(looks[i].getClassName());
			SwingUtilities.updateComponentTreeUI(this);
			fc.updateUI();
			colorPalette.colorPalleteChooser.updateUI();
			
		}
		catch(Exception e) {
      		e.printStackTrace();
    	}	
	}
	
	public void createNewDocument() {
		 
		 internalFrame = new myInternalFrame(this);
         //internalFrame.setOpaque(true);
         internalFrame.pack();
         desktop.add(internalFrame,new Integer(1));
         internalFrame.setVisible(true);
         Icon internalFrameIcon = new ImageIcon("icons/internalframeIcon.png");
         internalFrame.setFrameIcon(internalFrameIcon);
         toolbox.enableToolbox();
	}
		
	public void showFileChooser(int type) {
		fc.setMultiSelectionEnabled(true);
		fc.setControlButtonsAreShown(true);
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		if (type == 1) {
			int returnvalue = fc.showOpenDialog(myFrame.this);
			
			if (returnvalue == JFileChooser.APPROVE_OPTION) {
           			String  s = fc.getSelectedFile().getPath();
           			statusBar.setMessage5("Selected File"+s);
         	}
		}
		else
            fc.showSaveDialog(myFrame.this);
	}
	
	public void showColorChooser() {
		JColorChooser.showDialog(this,"Choose Color",Color.BLACK);
		//return myColor;
	}
	
	public void showAboutDialog() {
		String message = "**********************************************\n"
       					+"OpenDraw ver.0.1\n"
       					+"----------------------------------------------\n"
       					+"OpenDraw is an open source Drawing Programm.	\n"
       					+"It is still in early development stage so if	\n"
       					+"you want to contribute please contact with me	\n"
       					+"Any contribution would be valuable			\n"
       					+"----------------------------------------------\n"
       					+"Name	:	Kazantzakis Nikos					\n"
       					+"E-mail	:	mis049@uom.gr					\n"
       					+"**********************************************";
		JOptionPane.showMessageDialog(this,message,"About OpenDraw",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void showPopUpMenu(MouseEvent e) {
		popUpMenu.show(e.getComponent(),e.getX(),e.getY());
	}
	
	public void showAllToolbars() {
		toolbar.setVisible(true);
		toolbox.setVisible(true);
		statusBar.setVisible(true);
		colorPalette.setVisible(true);
		
		menuBar.Standard.setSelected(true);
		menuBar.Toolbox.setSelected(true);
		menuBar.StatusBar.setSelected(true);
		menuBar.ColorPalette.setSelected(true);
		
		popUpMenu.popUpMenuItem1.setSelected(true);
		popUpMenu.popUpMenuItem2.setSelected(true);
		popUpMenu.popUpMenuItem3.setSelected(true);
		popUpMenu.popUpMenuItem4.setSelected(true);
		
		menuBar.showAllAction.setEnabled(false);
		menuBar.hideAllAction.setEnabled(true);
	}
	
	public void hideAllToolbars() {
		toolbar.setVisible(false);
		toolbox.setVisible(false);
		statusBar.setVisible(false);
		colorPalette.setVisible(false);
		
		menuBar.Standard.setSelected(false);
		menuBar.Toolbox.setSelected(false);
		menuBar.StatusBar.setSelected(false);
		menuBar.ColorPalette.setSelected(false);
		
		popUpMenu.popUpMenuItem1.setSelected(false);
		popUpMenu.popUpMenuItem2.setSelected(false);
		popUpMenu.popUpMenuItem3.setSelected(false);
		popUpMenu.popUpMenuItem4.setSelected(false);
		
		menuBar.showAllAction.setEnabled(true);
		menuBar.hideAllAction.setEnabled(false);
	}
	//skoupidia
    //contsruct the Panel and the rest components
   	//****************************************************************
   	/*
   	pnl1=new JPanel();
   	pnl1.setOpaque(true);
   pnl1.setBackground(Color.CYAN);
   pnl1.setCursor( Cursor.getPredefinedCursor( Cursor.CROSSHAIR_CURSOR));
   pnl1.addMouseListener(this);
   //cp.add(pnl1,BorderLayout.CENTER);
   bt5=new JButton("Simple Button");
   pnl1.add(bt5);
   bt6=new JButton("<html>this is<strong>also</strong><br><font color=red>a test</font> button with <u>HTML</u> code</html>");
   pnl1.add(bt6);
   bt7=new JButton("I am a disabled button");
   bt7.setEnabled(false);
   pnl1.add(bt7);
   bt8=new JButton("I have a Keyboard Shortcut! Press D to find out.");
   pnl1.add(bt8);
   bt8.setMnemonic(KeyEvent.VK_D);
   img5=new ImageIcon("parthenon.jpg");
   bt9=new JButton("A button with a picture",img5);
   bt9.setVerticalTextPosition(AbstractButton.TOP);
   bt9.setHorizontalTextPosition(AbstractButton.CENTER);
   pnl1.add(bt9);
   bt10=new JButton("I am the default Button");
   pnl1.add(bt10);
   getRootPane().setDefaultButton(bt10);
   tf1=new JTextField(20);
   pnl1.add(tf1);
   psw1=new JPasswordField(20);
   psw1.setForeground(Color.GREEN);
   psw1.setBackground(Color.YELLOW);
   psw1.setSelectedTextColor(Color.RED);
   psw1.setSelectionColor(Color.BLUE);
   psw1.setCaretColor(Color.CYAN);//Cursor Color
   pnl1.add(psw1);
   ftf=new JFormattedTextField("test");
   pnl1.add(ftf);
   txtArea1=new JTextArea();
   //txtArea1.setColumns(20);
   areaScrollPane= new JScrollPane(txtArea1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
   //areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
   areaScrollPane.setPreferredSize(new Dimension(250, 250));
   //columnView = new Rule(Rule.HORIZONTAL, true);
   //rowView = new Rule(Rule.VERTICAL, true);
   txtArea1.setEditable(true);
   //txtArea1.setLineWrap(true);
   txtArea1.setWrapStyleWord(true);
   txtArea1.setText("Hello I am textArea but you can't edit me. Try this out");
   //pnl1.add(txtArea1);
   pnl1.add(areaScrollPane);
   lb2=new JLabel("Hello i am a Label with a Compount Border");
   lb2.setBorder(
   BorderFactory.createCompoundBorder(
   BorderFactory.createTitledBorder("The title of the Border "),
   BorderFactory.createEtchedBorder()
                )
                );
  lb2.setOpaque(true);
  lb2.setBackground(Color.LIGHT_GRAY);
  pnl1.add(lb2);
*/
}
