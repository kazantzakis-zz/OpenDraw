import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class myDialog extends JDialog implements ActionListener,ItemListener,ChangeListener 
{
	JButton color, ok, cancel;
	JSlider widthSlider;
	JRadioButton joinBevelBtn, joinMiterBtn, joinRoundBtn , endButtBtn, endRoundBtn, endSquareBtn, solidBtn, dashedBtn;
	JCheckBox isBehindFillBtn;
	ButtonGroup group1,group2,group3;
	JPanel mainPanel,buttonsPanel,northPanel,southPanel,leftPanel,rightPanel,panel1,panel2,panel3,joinStylePanel, endCapStylePanel;
	Icon bevelImage,miterImage,roundImage,cap_buttImage,cap_roundImage,cap_squareImage;
	myPreviewPanel previewPanel;
	
	//Stroke properties
	float width = myShape.defaultStroke.getLineWidth();
	int cap = myShape.defaultStroke.getEndCap();
	int join = myShape.defaultStroke.getLineJoin();
	float dashPhase = myShape.defaultStroke.getDashPhase();
	boolean behindFill = myShape.defaultIsStrokeBehindFill;
		
	public myDialog(JFrame frm,String title,boolean mdl) { 
		super(frm,title,mdl);
		buibGUI();
	}
	
	private void buibGUI()	{
		Container dcp = getContentPane();
		dcp.setLayout(new BorderLayout());
		
		//add the main Panel into the content pain
		mainPanel = new JPanel(new GridLayout(1,2));
		dcp.add(mainPanel,BorderLayout.CENTER);
		
		//add the buttons Panen into the content pane
		buttonsPanel = new JPanel();
		dcp.add(buttonsPanel,BorderLayout.SOUTH);
		
		//add the left & right panels into the main panel
		leftPanel = new JPanel(new GridLayout(2,1));
		rightPanel = new JPanel(new BorderLayout());
		rightPanel.setBorder(BorderFactory.createTitledBorder("Preview"));
		mainPanel.add(leftPanel);
		mainPanel.add(rightPanel,BorderLayout.CENTER);

		//add the preview Panel into the right Panel
		previewPanel = new myPreviewPanel();
		rightPanel.add(previewPanel);
		
		//add the north & south Panels into the left Panel
		northPanel = new JPanel(new GridLayout(3,1));
		southPanel = new JPanel(new GridLayout(1,2));
		leftPanel.add(northPanel);
		leftPanel.add(southPanel);
		
		//add four panels into the north panel of the left panel		
		panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel1.setBorder(BorderFactory.createTitledBorder("Color"));
		panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel2.setBorder(BorderFactory.createTitledBorder("Width"));
		panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel3.setBorder(BorderFactory.createTitledBorder("Style"));
		northPanel.add(panel1);
		northPanel.add(panel2);
		northPanel.add(panel3);
			
		//add some components into the four panels...
		color = new JButton("Choose color...");
		color.addActionListener(this);
		panel1.add(color);
		
		//...the slider
		widthSlider = new JSlider(JSlider.HORIZONTAL,1,50,(int)myShape.defaultStroke.getLineWidth());
		widthSlider.addChangeListener(this);
		widthSlider.setMajorTickSpacing(10);
		widthSlider.setMinorTickSpacing(1);
		widthSlider.setPaintTicks(true);
		widthSlider.setPaintLabels(true);
		panel2.add(widthSlider);
		
		//...The style components
		solidBtn = new JRadioButton("Solid");
		solidBtn.addItemListener(this);
		dashedBtn = new JRadioButton("Dashed");
		dashedBtn.addItemListener(this);
		
		if(myShape.defaultStroke.getDashPhase() == 0.0)
			solidBtn.setSelected(true);
		else
			dashedBtn.setSelected(true);
		
		group3 = new ButtonGroup();
		group3.add(solidBtn);
		group3.add(dashedBtn);
		panel3.add(solidBtn);
		panel3.add(dashedBtn);
		isBehindFillBtn = new JCheckBox("Behind fill");
		isBehindFillBtn.setSelected(behindFill);
		isBehindFillBtn.addItemListener(this);
		panel3.add(isBehindFillBtn);
		
		//add the join Style Panel into the South Panel of the feft panel
		joinStylePanel = new JPanel(new GridLayout(3,2));
		joinStylePanel.setBorder(BorderFactory.createTitledBorder("Join style"));
		bevelImage = new ImageIcon("icons/bevel.gif");
		miterImage = new ImageIcon("icons/miter.gif");
		roundImage = new ImageIcon("icons/round.gif");
		joinBevelBtn = new JRadioButton();
		joinBevelBtn.setToolTipText("Bevel");
		joinBevelBtn.addItemListener(this);
		joinMiterBtn = new JRadioButton();
		joinMiterBtn.setToolTipText("Miter");
		joinMiterBtn.addItemListener(this);
		joinRoundBtn = new JRadioButton();
		joinRoundBtn.setToolTipText("Round");
		joinRoundBtn.addItemListener(this);
		
		if(myShape.defaultStroke.getLineJoin() == BasicStroke.JOIN_BEVEL)
			joinBevelBtn.setSelected(true);
		else if(myShape.defaultStroke.getLineJoin() == BasicStroke.JOIN_MITER)
			joinMiterBtn.setSelected(true);
		else if(myShape.defaultStroke.getLineJoin() == BasicStroke.JOIN_ROUND)
			joinRoundBtn.setSelected(true);
		
		group1 = new ButtonGroup();
		group1.add(joinBevelBtn);
		group1.add(joinMiterBtn);
		group1.add(joinRoundBtn);
		joinStylePanel.add(joinBevelBtn);
		joinStylePanel.add(new JLabel(bevelImage));
		joinStylePanel.add(joinMiterBtn);
		joinStylePanel.add(new JLabel(miterImage));
		joinStylePanel.add(joinRoundBtn);
		joinStylePanel.add(new JLabel(roundImage));
		southPanel.add(joinStylePanel);
		
		//add the end-cap Style Panel into the South Panel of the feft panel
		endCapStylePanel = new JPanel(new GridLayout(3,1));
		endCapStylePanel.setBorder(BorderFactory.createTitledBorder("End-cap Style"));
		cap_buttImage = new ImageIcon("icons/cap_butt.gif");
		cap_roundImage = new ImageIcon("icons/cap_round.gif");
		cap_squareImage = new ImageIcon("icons/cap_square.gif");
		endButtBtn = new JRadioButton();
		endButtBtn.setToolTipText("Butt");
		endButtBtn.addItemListener(this);
		endRoundBtn = new JRadioButton();
		endRoundBtn.setToolTipText("Round");
		endRoundBtn.addItemListener(this);
		endSquareBtn = new JRadioButton();
		endSquareBtn.setToolTipText("Square");
		endSquareBtn.addItemListener(this);
		
		if(myShape.defaultStroke.getEndCap() == BasicStroke.CAP_BUTT)
			endButtBtn.setSelected(true);
		else if(myShape.defaultStroke.getEndCap() == BasicStroke.CAP_ROUND)
			endRoundBtn.setSelected(true);
		else if(myShape.defaultStroke.getEndCap() == BasicStroke.CAP_SQUARE)
			endSquareBtn.setSelected(true);
			
		group2 = new ButtonGroup();
		group2.add(endButtBtn);
		group2.add(endRoundBtn);
		group2.add(endSquareBtn);
		endCapStylePanel.add(endButtBtn);
		endCapStylePanel.add(new JLabel(cap_buttImage));
		endCapStylePanel.add(endRoundBtn);
		endCapStylePanel.add(new JLabel(cap_roundImage));
		endCapStylePanel.add(endSquareBtn);
		endCapStylePanel.add(new JLabel(cap_squareImage));	
		southPanel.add(endCapStylePanel);
		
		//add the Ok & cancel buttons into the 	buttons Panel
		ok = new JButton("OK");
		ok.addActionListener(this);
		cancel = new JButton("Cancel");
		cancel.addActionListener(this);
		buttonsPanel.add(ok);
		buttonsPanel.add(cancel);
	
	}
	
	//Event Handling...
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == ok) {
			myShape.defaultStroke = (BasicStroke)myPreviewPanel.previewStroke;
			myShape.defaultIsStrokeBehindFill = myPreviewPanel.previewIsStrokeBehindFill;
			this.setVisible(false);
		}
		else if(e.getSource() == cancel) {
			this.setVisible(false);
		}
	}
	
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == widthSlider) {
			width = (float)widthSlider.getValue();
		}
		createPreviewStroke();
	}
	
	public void itemStateChanged(ItemEvent e) {
		
		if (e.getSource() == solidBtn) {
			dashPhase = 0.0f;
		}
		else if (e.getSource() == dashedBtn) {
			dashPhase = 10.0f;
		}
		else if (e.getSource() == isBehindFillBtn) {
			if (e.getStateChange() == ItemEvent.SELECTED)
				myPreviewPanel.previewIsStrokeBehindFill = true;
			else
				myPreviewPanel.previewIsStrokeBehindFill = false;
		}
		else if (e.getSource() == joinBevelBtn) {
			join = BasicStroke.JOIN_BEVEL;
		}
		else if (e.getSource() == joinMiterBtn) {
			join = BasicStroke.JOIN_MITER;
		}
		else if (e.getSource() == joinRoundBtn) {
			join = BasicStroke.JOIN_ROUND;
		}
		
		else if (e.getSource() == endButtBtn) {
			cap = BasicStroke.CAP_BUTT;
		}
		else if (e.getSource() == endRoundBtn) {
			cap = BasicStroke.CAP_ROUND;
		}
		else if (e.getSource() == endSquareBtn) {
			cap = BasicStroke.CAP_SQUARE;
		}
		createPreviewStroke();
	}
	
	private void createPreviewStroke() {
		if (dashPhase == 10.0f){
			float dash[] = {5*(float)widthSlider.getValue()};
			myPreviewPanel.previewStroke = new BasicStroke(width, cap, join, 10.0f, dash, dashPhase);
		}			
		else {
			myPreviewPanel.previewStroke = new BasicStroke(width, cap, join);
		}
			
		
		previewPanel.repaint();
	}
}

	
	