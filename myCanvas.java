import javax.swing.*;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.event.*;
import java.awt.geom.*;

import java.util.Vector;

public class myCanvas extends JPanel implements MouseListener, MouseMotionListener, KeyListener
{
	//some variables...
  	int startx,starty,endx,endy,x,y,width = 0,height = 0;
  	int selectionMinX,selectionMinY,selectionMaxX,selectionMaxY;
  	String s1,s2,s3,s4;
 	boolean dragging = false;
  	boolean selecting = false;
  	boolean foundShape = false;
  	boolean itIsSelected = false;
  	boolean shiftPressed = false;
  	Vector<myShape> myShapes = new Vector<myShape>();
  	Vector<Integer> selectedObjectsIDs = new Vector<Integer>();
  	int selectedObjectID;
  	int selectedObjectIndex;
  	
  	//The PopUpMenu
  	myCanvasPopUpMenu popUpMenu;
  	
  	myFrame myframehandle;
  	
  	public myCanvas(myFrame myframehandle) {
  		
  		this.myframehandle = myframehandle;
  		
  		setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		setFocusable(true);
		requestFocus();
		
		popUpMenu = new myCanvasPopUpMenu(this);
  	}

	protected void paintComponent(Graphics g) {
		
  	Graphics2D g2 = (Graphics2D)g.create();
	g2.setColor(getBackground());
	g2.fillRect(0,0,getWidth(),getHeight());
	g2.setColor(Color.BLACK);
	g2.draw(new Rectangle2D.Double(100.0,100.0,400.0,500.0));
	
	requestFocus();
	/*
	AffineTransform testTransform =new AffineTransform();
	testTransform.rotate(Math.toRadians(45));
	g2.setTransform(testTransform);
	
	g2.setColor(Color.BLUE);
	g2.draw(new Rectangle2D.Double(100.0,100.0,100.0,100.0));	
	
	*/
   	if(myShapes != null) {
   		drawObjects(g2);
	}

	if(dragging) {
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(1.0f));
		g2.setXORMode(Color.GRAY);
		
		if(myFrame.ActiveTool == "Rectangle") {
        	g2.draw(new Rectangle2D.Double(x,y,width,height));
    	}
    	else if(myFrame.ActiveTool == "Oval") {
    		g2.draw(new Ellipse2D.Double(x,y,width,height));
    	}
    	else if(myFrame.ActiveTool == "Freehand") {
    		g2.draw(new Line2D.Double(startx,starty,endx,endy));
    	}
    	else if(myFrame.ActiveTool == "Pick") {
    			g2.draw(new Rectangle2D.Double(x,y,width,height));
    	}
    }
    
    if (selecting) {
		showBrackets(g2);
    }
    
    g2.dispose();
  }

	public void mouseClicked(MouseEvent e) {
    	
    }
    
    public void mouseMoved(MouseEvent e) {
       	//Show coordinates on the StatusBar
       	myFrame.statusBar.setMessage4("Mouse Position (now moving): ("+String.valueOf(e.getX())+","+String.valueOf(e.getY())+")");
    }
    
    public void mousePressed(MouseEvent e) {
    		
    	//Show coordinates on the StatusBar
    	myFrame.statusBar.setMessage4("Mouse Position (now pressed): ("+String.valueOf(e.getX())+","+String.valueOf(e.getY())+")");
		calculateStart(e);
		
      	if(myFrame.ActiveTool == "Pick" && SwingUtilities.isLeftMouseButton(e)) {
      		
      		if (isThereAnyShape(e))
      			createSelection(selectedObjectID);
      		else
      			destroySelection();
    	}
    	
    	else if(myFrame.ActiveTool == "EyeDropper") {
    		
    		for(int k = myShapes.size()-1;k >= 0;k--) {
				if (myShapes.elementAt(k).shapeType.contains(e.getX(),e.getY())) {
					if (SwingUtilities.isLeftMouseButton(e)) {
						myShape.defaultFillColor = myShapes.elementAt(k).fillColor;
						myFrame.statusBar.setMessage2("");
						myFrame.statusBar.setMessage5("Default fill color changed");						 			
    				}
    				else if (SwingUtilities.isRightMouseButton(e)) {
						myShape.defaultOutlineColor = myShapes.elementAt(k).fillColor; 			
						myFrame.statusBar.setMessage2("");
						myFrame.statusBar.setMessage5("Default outline color changed");
    				}
    				break;
				}
				else {
					myFrame.statusBar.setMessage2("");
					myFrame.statusBar.setMessage5("No object");					
				}
    		}
    	}
    	
    	else if(SwingUtilities.isLeftMouseButton(e) && (myFrame.ActiveTool == "Rectangle" || myFrame.ActiveTool == "Oval" || myFrame.ActiveTool == "Freehand")) {
    		destroySelection();
    	}
    }
    
    public void mouseDragged(MouseEvent e) {
    	
    	if (SwingUtilities.isLeftMouseButton(e)) {
    		
    		if (myFrame.ActiveTool == "Pick" && foundShape == true) {
    			moveObjects(e,selectedObjectsIDs);
    		}
    		else {
    			dragging = true;
    			endx = e.getX();
      			endy = e.getY();
      			s3 = String.valueOf(e.getX());
      			s4 = String.valueOf(e.getY());
      			myFrame.statusBar.setMessage4("Mouse Position (now dragging): ("+s3+","+s4+")");
      			calculateCoordinates();
      			myFrame.statusBar.setMessage2("Start: (x="+String.valueOf(x)+", y="+String.valueOf(y)+") Width: "+String.valueOf(width)+", Height: "+String.valueOf(height));
    		}
    		repaint();
    		//repaint(x-10,y-10,x+width,y+height);
    	}
    }
    
    public void mouseReleased(MouseEvent e) {
    	
		if (SwingUtilities.isLeftMouseButton(e) && e.getX() != startx && e.getY() != starty) {
    		
    		if(myFrame.ActiveTool == "Rectangle") {
            	myShapes.addElement(
            		new myShape(
            			new Rectangle2D.Double(x,y,width,height),
            			"Rectangle",
            			myShape.defaultStroke,
            			myShape.defaultOutlineColor,
            			myShape.defaultFillColor,
            			myShape.defaultGradientFill,
            			myShape.defaultIsStrokeBehindFill));
            	myFrame.statusBar.setMessage5(String.valueOf(myShapes.size())+" Object(s) on stage");
    		}
    		else if(myFrame.ActiveTool == "Oval") {
            	myShapes.addElement(
            		new myShape(
            			new Ellipse2D.Double(x,y,width,height),
            			"Oval",
            			myShape.defaultStroke,
            			myShape.defaultOutlineColor,
            			myShape.defaultFillColor,
            			myShape.defaultGradientFill,
            			myShape.defaultIsStrokeBehindFill));
            	myFrame.statusBar.setMessage5(String.valueOf(myShapes.size())+" Object(s) on stage");
    		}
    		else if(myFrame.ActiveTool == "Freehand") {
            	myShapes.addElement(
            		new myShape(
            			new Line2D.Double(startx,starty,endx,endy),
            			"Line",
            			myShape.defaultStroke,
            			myShape.defaultOutlineColor,
            			myShape.defaultFillColor,
            			myShape.defaultGradientFill,
            			myShape.defaultIsStrokeBehindFill));
            	myFrame.statusBar.setMessage5(String.valueOf(myShapes.size())+" Object(s) on stage");
    		}
    		else if(myFrame.ActiveTool == "Pick") {
				
    		}
			dragging = false;
			if(!selecting)
				myFrame.statusBar.setMessage2("");	
		}
		else if (SwingUtilities.isRightMouseButton(e)) {
			if(myFrame.ActiveTool == "Pick" || myFrame.ActiveTool == "Rectangle" || myFrame.ActiveTool == "Oval")
			if (isThereAnyShape(e))
				showPopUpMenu(e);
		}
		if (selectedObjectsIDs.size() == 1) {
			selecting = true;
			calculateSelectionCoordinates(selectedObjectsIDs);
		}
		repaint();
    }
    
    public void mouseEntered(MouseEvent e) {
    	
    }
    
    public void mouseExited(MouseEvent e) {

    }
    
    public void keyPressed(KeyEvent e) {
    	if (e.getKeyCode() == 16) {
    	myFrame.statusBar.setMessage1(myFrame.ActiveTool+" +Shift pressed");
    		shiftPressed = true;	
    	}
    }
       
    public void keyReleased(KeyEvent e) {
    	myFrame.statusBar.setMessage1(myFrame.ActiveTool);
    	shiftPressed = false;
    }
    
    public void keyTyped(KeyEvent e) {
    }
    
    public void deleteObjects(int i) {
    	if (!myShapes.isEmpty()) {
    		myShapes.remove(i);
    		destroySelection();
    		repaint();
    	}
    }
    
    public void orderObject(int location, int i) {
    	if (myShapes.size() > 1) {
    		if (location == 0) {
    			myShapes.add(0,myShapes.elementAt(i)); 
    			myShapes.remove(i+1);
    			selectedObjectID = 0;
    			myFrame.statusBar.setMessage2("shape Ordered to back");
    			repaint();
    		}
    		else if (location == 1) {
    			myShapes.addElement(myShapes.elementAt(i)); 
    			myShapes.remove(i);
    			selectedObjectID = myShapes.size()-1;
    			myFrame.statusBar.setMessage2("shape Ordered to front");
    			repaint();
    		}
    	}
    }
    
    private void createSelection(int i) {
    	
    	if (shiftPressed && selectedObjectsIDs.size() >0) {
    		if(isThisShapeSelected(i)) {
    			selectedObjectsIDs.remove(selectedObjectIndex);
    			if (selectedObjectsIDs.isEmpty())
    				selecting = false;
    			else
    				selecting = true;
    		}
    		else {
				selectedObjectsIDs.addElement(i);
    			selecting = true;    			
    		}
    	}
    	else {
    		selecting = false;
    		if (selectedObjectsIDs.isEmpty()) {
    			selectedObjectsIDs.addElement(i);
    		}
    		else {
    			if(!isThisShapeSelected(i)) {
    				selectedObjectsIDs.clear();
    				selectedObjectsIDs.addElement(i);
    			}
    		}
    	}
    	calculateSelectionCoordinates(selectedObjectsIDs);
    	myFrame.statusBar.setMessage5(selectedObjectsIDs.size()+" object(s) selected");
    	enableActions();
    	repaint();
    	/*
    	selectedObjectsIDs.clear();
    	selectedObjectsIDs.add(0,i);
    	calculateSelectionCoordinates(selectedObjectsIDs);
    	myFrame.statusBar.setMessage5(selectedObjectsIDs.size()+" object(s) selected");
    	*/
    }
    
    private void destroySelection() {
    	selectedObjectsIDs.clear();
    	selecting = false;
    	myframehandle.menuBar.cutAction.setEnabled(false);
      	myframehandle.menuBar.copyAction.setEnabled(false);
      	myframehandle.menuBar.tofrontAction.setEnabled(false);
      	myframehandle.menuBar.toBackAction.setEnabled(false);
		repaint();
		myFrame.statusBar.setMessage2("");
		//myFrame.statusBar.setMessage5(selectedObjectsIDs.size()+" objects selected");
    }
    
    private void moveObjects(MouseEvent e, Vector<Integer> v) {	    
    	
    	myFrame.statusBar.setMessage4("Mouse Position (now dragging a shape): ("+e.getX()+","+e.getY()+")");
    	
    	for(int k = 0, j = v.size();k < j;k++) {
    	 		
    		RectangularShape selectedShape = (RectangularShape)myShapes.elementAt(v.elementAt(k)).shapeType;
    		selectedShape.setFrame(selectionMinX+(e.getX()-startx),selectionMinY+(e.getY()-starty),myShapes.elementAt(v.elementAt(k)).shapeType.getBounds2D().getWidth(),myShapes.elementAt(v.elementAt(k)).shapeType.getBounds2D().getHeight());
    		myShapes.elementAt(v.elementAt(k)).shapeType = selectedShape;
    		//myFrame.statusBar.setMessage2("Start: (x="+String.valueOf(myShapes.elementAt(selectedShapeID).shapeType.getBounds2D().getX())+", y="+String.valueOf(myShapes.elementAt(selectedShapeID).shapeType.getBounds2D().getY())+") Width: "+myShapes.elementAt(selectedShapeID).shapeType.getBounds2D().getWidth()+", Height: "+myShapes.elementAt(selectedShapeID).shapeType.getBounds2D().getHeight());
    		repaint();	
    	}
    }
    
    private boolean isThereAnyShape(MouseEvent e) {
    	if (myShapes.size() > 0) {
    		for(int k = myShapes.size()-1;k >= 0;k--) {
    			if (myShapes.elementAt(k).shapeType.contains(e.getX(),e.getY())) {
    				foundShape = true;
    				selectedObjectID = k;
    				break;
    			}
				else {
					foundShape = false;
					myFrame.statusBar.setMessage5("Nothing here");
				}
			}
		}
		else {
			foundShape = false;
			myFrame.statusBar.setMessage5("No objects on stage");
		}
    	return foundShape;
    }
    
    private boolean isThisShapeSelected(int i) {
    	
    	if (!selectedObjectsIDs.isEmpty()) {	
    		for(int k = 0;k < selectedObjectsIDs.size();k++) {
    			if (selectedObjectsIDs.elementAt(k) == i) {
    				itIsSelected = true;
    				selectedObjectIndex = k;
					break;
    			}
				else {
					itIsSelected = false;
				}
			}
		}
    	return itIsSelected;
    }
    
    private void calculateSelectionCoordinates(Vector<Integer> v) {
    	if (!v.isEmpty()) {
    		selectionMinX = (int)myShapes.elementAt(v.elementAt(0)).shapeType.getBounds2D().getX();
    		selectionMinY = (int)myShapes.elementAt(v.elementAt(0)).shapeType.getBounds2D().getY();
    		selectionMaxX = (int)myShapes.elementAt(v.elementAt(0)).shapeType.getBounds2D().getX()+(int)myShapes.elementAt(v.elementAt(0)).shapeType.getBounds2D().getWidth();
    		selectionMaxY = (int)myShapes.elementAt(v.elementAt(0)).shapeType.getBounds2D().getY()+(int)myShapes.elementAt(v.elementAt(0)).shapeType.getBounds2D().getHeight();
    	
	    	for(int k = 1, j = v.size();k < j;k++) {
    		
    			if (myShapes.elementAt(v.elementAt(k)).shapeType.getBounds2D().getX() < selectionMinX)
    				selectionMinX = (int)myShapes.elementAt(v.elementAt(k)).shapeType.getBounds2D().getX();
			
				if (myShapes.elementAt(v.elementAt(k)).shapeType.getBounds2D().getY() < selectionMinY)
    				selectionMinY = (int)myShapes.elementAt(v.elementAt(k)).shapeType.getBounds2D().getY();
    		
    			if ((myShapes.elementAt(v.elementAt(k)).shapeType.getBounds2D().getX()+myShapes.elementAt(v.elementAt(k)).shapeType.getBounds2D().getWidth()) > selectionMaxX)
    				selectionMaxX = (int)myShapes.elementAt(v.elementAt(k)).shapeType.getBounds2D().getX()+(int)myShapes.elementAt(v.elementAt(k)).shapeType.getBounds2D().getWidth();
    		
    			if ((myShapes.elementAt(v.elementAt(k)).shapeType.getBounds2D().getY()+myShapes.elementAt(v.elementAt(k)).shapeType.getBounds2D().getHeight()) > selectionMaxY)
    				selectionMaxY = (int)myShapes.elementAt(v.elementAt(k)).shapeType.getBounds2D().getY()+(int)myShapes.elementAt(v.elementAt(k)).shapeType.getBounds2D().getHeight();
    			    		
    		}
    	}
    }

   	private void calculateCoordinates() {
   		if (endx >= startx && endy >= starty){
        	x = startx; y = starty; width = endx-startx; height = endy-starty;
        }
        else if (endx >= startx && endy <= starty){
            x = startx; y = endy; width = endx-startx; height = starty-endy;
        }
        else if (endx <= startx && endy <= starty){
            x = endx; y = endy; width = startx-endx; height = starty-endy;
        }
        else if (endx <= startx && endy >= starty){
            x = endx; y = starty; width = startx-endx; height = endy-starty;
        }
   	}
	
	private void calculateStart(MouseEvent e) {
		startx = e.getX();
		starty = e.getY();	
	}
	
	protected void showBrackets(Graphics2D g2) {
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(1.0f));
		g2.setXORMode(Color.CYAN);
		
		//g2.fill(new Rectangle2D.Double(x-10,y-10,5,5));
		
		//uperLeft Bracket
		g2.fill(new Rectangle2D.Double(selectionMinX-10,selectionMinY-10,5,5));
		//uperRight Bracket
		g2.fill(new Rectangle2D.Double(selectionMaxX+5,selectionMinY-10,5,5));
		//downLeft Bracket
		g2.fill(new Rectangle2D.Double(selectionMinX-10,selectionMaxY+5,5,5));
		//downRight Bracket
		g2.fill(new Rectangle2D.Double(selectionMaxX+5,selectionMaxY+5,5,5));
		
		//left middle Bracket
		g2.fill(new Rectangle2D.Double(selectionMinX-10,selectionMinY+((selectionMaxY-selectionMinY)/2)-2.5,5,5));
		//right middle Bracket
		g2.fill(new Rectangle2D.Double(selectionMinX+(selectionMaxX-selectionMinX)+5,selectionMinY+((selectionMaxY-selectionMinY)/2)-2.5,5,5));
		//uper middle Bracket
		g2.fill(new Rectangle2D.Double(selectionMinX+((selectionMaxX-selectionMinX)/2)-2.5,selectionMinY-10,5,5));
		//down middle Bracket
		g2.fill(new Rectangle2D.Double(selectionMinX+((selectionMaxX-selectionMinX)/2)-2.5,selectionMaxY+5,5,5));
		
	}
	
	protected void drawObjects(Graphics2D g2) {
		
		//AffineTransform previousTransform = g2.getTransform();
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		for(int k = 0, j = myShapes.size();k < j;k++) {
			//myShape tempObject= myShapes.elementAt(k);
			//Shape tempShape=tempObject.shapeType;
			//Stroke tempStroke=tempObject.shapeStroke;
			//Color tempColor1=tempObject.outlineColor;
			//Color tempColor2=tempObject.fillColor;
			
			//AffineTransform tempTransform = myShapes.elementAt(k).shapeTransform;
			//tempTransform.rotate(Math.toRadians(45));
			//g2.setTransform(tempTransform);
			
			if (myShapes.elementAt(k).fillColor != null) {
				
				if (myShapes.elementAt(k).isStrokeBehindFill) {
					g2.setStroke(myShapes.elementAt(k).shapeStroke);
					g2.setColor(myShapes.elementAt(k).outlineColor);
					g2.draw(myShapes.elementAt(k).shapeType);
					g2.setPaint(myShapes.elementAt(k).fillColor);
					g2.fill(myShapes.elementAt(k).shapeType);
				}
				else {
					g2.setPaint(myShapes.elementAt(k).fillColor);
					g2.fill(myShapes.elementAt(k).shapeType);
					g2.setStroke(myShapes.elementAt(k).shapeStroke);
					g2.setColor(myShapes.elementAt(k).outlineColor);
					g2.draw(myShapes.elementAt(k).shapeType);
				}
			}
			
			else {
				g2.setStroke(myShapes.elementAt(k).shapeStroke);
				g2.setColor(myShapes.elementAt(k).outlineColor);
				g2.draw(myShapes.elementAt(k).shapeType);
			}
			/*
			if (tempColor2!=null)
			{
				if (tempObject.isStrokeBehindFill) {
					g2.setStroke(tempStroke);
					g2.setColor(tempColor1);
					g2.draw(tempShape);
					g2.setPaint(tempColor2);
					g2.fill(tempShape);				
				}
				else {
					g2.setPaint(tempColor2);
					g2.fill(tempShape);
					g2.setStroke(tempStroke);
					g2.setColor(tempColor1);
					g2.draw(tempShape);					
				}
			}
			else {
				g2.setStroke(tempStroke);
				g2.setColor(tempColor1);
				g2.draw(tempShape);				
			}
			*/
			//g2.setTransform(previousTransform);
		}
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
	}
	
	protected void showPopUpMenu(MouseEvent e) {
		popUpMenu.show(e.getComponent(),e.getX(),e.getY());
	}
	
	private void enableActions() {
		
  		myframehandle.menuBar.cutAction.setEnabled(true);
  		myframehandle.menuBar.copyAction.setEnabled(true);
  		myframehandle.menuBar.tofrontAction.setEnabled(true);
  		myframehandle.menuBar.toBackAction.setEnabled(true);
  		
  		if (selectedObjectsIDs.size()>1) {
  			myframehandle.menuBar.groupAction.setEnabled(true);
  			myframehandle.menuBar.weldAction.setEnabled(true);
  			myframehandle.menuBar.trimAction.setEnabled(true);
  			myframehandle.menuBar.intersectAction.setEnabled(true);
  			myframehandle.menuBar.simplifyAction.setEnabled(true);  			
  		}
		
	}
}
