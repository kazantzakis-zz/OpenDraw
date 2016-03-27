import javax.swing.*;
import java.awt.GridLayout;

import java.awt.event.*;

public class myStatusBar extends JComponent implements MouseListener {
	JLabel msg1,msg2,msg3,msg4,msg5,msg6;
	
	myFrame myframehandle;
	
	public myStatusBar(String s1,String s2,String s3,String s4,String s5,String s6,myFrame myframehandle) {
		
		this.myframehandle = myframehandle;
		addMouseListener(this);
		setOpaque(true);
		
		setLayout(new GridLayout(2,3));
		
		msg1=new JLabel();
		msg1.setOpaque(true);
		msg1.addMouseListener(this);
		msg1.setBorder (BorderFactory.createEtchedBorder());
		
		msg2=new JLabel();
		msg2.setOpaque(true);
		msg2.addMouseListener(this);
		msg2.setBorder (BorderFactory.createEtchedBorder());
		
		msg3=new JLabel();
		msg3.setOpaque(true);
		msg3.addMouseListener(this);
		msg3.setBorder (BorderFactory.createEtchedBorder());
		
		msg4=new JLabel();
		msg4.setOpaque(true);
		msg4.addMouseListener(this);
		msg4.setBorder (BorderFactory.createEtchedBorder());
		
		msg5=new JLabel();
		msg5.setOpaque(true);
		msg5.addMouseListener(this);
		msg5.setBorder (BorderFactory.createEtchedBorder());
		
		msg6=new JLabel();
		msg6.setOpaque(true);
		msg6.addMouseListener(this);
		msg6.setBorder (BorderFactory.createEtchedBorder());
		
		add(msg1);
		add(msg2);
		add(msg3);
		add(msg4);
		add(msg5);
		add(msg6);
		msg1.setText(s1);
		msg2.setText(s2);
		msg3.setText(s3);
		msg4.setText(s4);
		msg5.setText(s5);
		msg6.setText(s6);
	}
	
	public void setMessage1(String s) {
		msg1.setText(s);
	}
	
	public void setMessage2(String s) {
		msg2.setText(s);
	}
	
	public void setMessage3(String s) {
		msg3.setText(s);
	}
	
	public void setMessage4(String s) {
		msg4.setText(s);
	}
	
	public void setMessage5(String s) {
		msg5.setText(s);
	}
	
	public void setMessage6(String s) {
		msg6.setText(s);
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