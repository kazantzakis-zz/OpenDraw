import java.awt.Shape;
import java.awt.Color;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.GradientPaint;
import java.awt.geom.AffineTransform;


public class myShape {
	
	static Color defaultOutlineColor = Color.BLACK;
	static Color defaultFillColor = null;
	static BasicStroke defaultStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
	static GradientPaint defaultGradientFill = null;
	static boolean defaultIsStrokeBehindFill = false;
	
		
	Shape shapeType;
	Stroke shapeStroke;
	Color outlineColor,fillColor;
	GradientPaint fillGradient;
	AffineTransform shapeTransform;
	boolean isStrokeBehindFill;
	String shapeName;
  
  public myShape(Shape shp,String shpName,
  							BasicStroke strk,
  							Color clr1,Color clr2,
  							GradientPaint grad,
  							boolean strkPos) {
  	shapeType = shp;
  	shapeName = shpName;
  	shapeStroke = strk;
  	outlineColor = clr1;
  	fillColor = clr2;
  	fillGradient = grad;
  	shapeTransform =new AffineTransform();
  	isStrokeBehindFill = strkPos;
  }
}













