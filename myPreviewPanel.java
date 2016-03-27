import javax.swing.*;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Stroke;
import java.awt.geom.*;

public class myPreviewPanel extends JPanel
{
  	static Stroke previewStroke=myShape.defaultStroke;
	static Color previewOutlineColor=myShape.defaultOutlineColor;
	static boolean previewIsStrokeBehindFill=myShape.defaultIsStrokeBehindFill;
	
	protected void paintComponent(Graphics g) {
  	
  	Graphics2D g2 = (Graphics2D)g.create();
	g2.setColor(Color.WHITE);
	g2.fillRect(0,0,getWidth(),getHeight());
	
	if (myShape.defaultFillColor!=null) {
		
		if (previewIsStrokeBehindFill) {
			g2.setStroke(previewStroke);
			g2.setColor(myShape.defaultOutlineColor);
			g2.draw(new Rectangle2D.Double(30,30,150,150));
			g2.draw(new Line2D.Double(30,250,150,250));
			g2.setPaint(myShape.defaultFillColor);
			g2.fill(new Rectangle2D.Double(30,30,150,150));	
	}
		else {
			g2.setPaint(myShape.defaultFillColor);
			g2.fill(new Rectangle2D.Double(30,30,150,150));
			g2.setStroke(previewStroke);
			g2.setColor(myShape.defaultOutlineColor);
			g2.draw(new Rectangle2D.Double(30,30,150,150));
			g2.draw(new Line2D.Double(30,250,150,250));		
		}	
	}
	else {
		g2.setStroke(previewStroke);
		g2.setColor(myShape.defaultOutlineColor);
		g2.draw(new Rectangle2D.Double(30,30,150,150));
		g2.draw(new Line2D.Double(30,250,150,250));
	}
  }  	
}