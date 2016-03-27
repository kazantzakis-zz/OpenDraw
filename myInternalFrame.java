import javax.swing.*;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Color;

public class myInternalFrame extends JInternalFrame
{
	static int internalFramenum = 0;
  	static final int xOffset = 30, yOffset = 30;
  	myCanvas DrawingArea;
  	JScrollPane internalFrameScrollPane;
  	Rule columnView,rowView;
  	
  	myFrame myframehandle;

  	public myInternalFrame(myFrame myframehandle) {
  		super("Drawing" + (++internalFramenum),
             	true, //resizable
             	true, //closable
             	true, //maximizable
             	true);//iconifiable
	
		this.myframehandle = myframehandle;
	
    	//...Create the GUI and put it in the window...
    	Container cp1 = getContentPane();
    	DrawingArea = new myCanvas(myframehandle);
    	DrawingArea.setPreferredSize(new Dimension(10000,10000));
    	//DrawingArea.setSize(new Dimension (800,600));
    	DrawingArea.setBackground(Color.WHITE);
    	DrawingArea.setOpaque(true);
    
    	columnView = new Rule(Rule.HORIZONTAL,true);
    	rowView = new Rule(Rule.VERTICAL,true);
    	rowView.setPreferredHeight(10);
    	columnView.setPreferredWidth(0);

    	internalFrameScrollPane = new JScrollPane(DrawingArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    	internalFrameScrollPane.setPreferredSize(new Dimension(800,500));
		internalFrameScrollPane.setColumnHeaderView(columnView);
		internalFrameScrollPane.setRowHeaderView(rowView);
    	cp1.add(internalFrameScrollPane,BorderLayout.CENTER);
       

    	//...Then set the window size or call pack...
    	setSize(800,600);

    	//Set the window's location.
    	setLocation(xOffset*internalFramenum, yOffset*internalFramenum);
	}
}

