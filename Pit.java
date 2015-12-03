
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public abstract class Pit implements Icon, ChangeListener {
	protected Ellipse2D shape;
	protected final int BEADSIZE = 10;
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected Controller c;
	protected ArrayList<Beads> bead;
	
	//no constructor b/c abstract class
	
	@ Override
	public void paintIcon(Component c, Graphics g, int x, int y) 
	{
		// TODO Complete third line
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		g2.draw(new Ellipse2D.Float(x, y, width, height));
	}

	public int getIconWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	public void stateChanged(ChangeEvent e) 
	{
		//repaint
	}
	public boolean contains(Point2D p)
	{
		return shape.contains(p);
	}
}
