
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
/**
 * Creates abstract class Pit
 * @author Sydney Snyder, Jerremy Ferrer, & Royce Florence Rocco
 *
 */
public abstract class Pit implements Icon, ChangeListener 
{
	protected Ellipse2D shape;
	protected Player p;
	protected final int BEADSIZE = 10;
	protected boolean ifXagain = false;
	protected int x, y, x1, y1, width, height;
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
		for(int k = 0; k < bead.size(); k++)
		{
			bead.get(k).draw(g2);
		}
	}
	/**
	 * Adds bead and updates x
	 * (x is updated so that beads 
	 * are put in the proper place inside
	 * the pit)
	 */
	public void addBead()
	{
		if(ifXagain == true)
		{
			x = x1;
			y = y1;
			bead.add(new Beads(x, y));
			ifXagain = false;
		}
		else if(x < width)
		{
			bead.add(new Beads(x, y));
			x += BEADSIZE+2;
		}
		else
		{
			bead.add(new Beads(x, y));
			y += BEADSIZE+2;
			x = x1;//how far in it needs to be from edge to be visible
		}
	}
	/**
	 * Removes last bead
	 * (x is updated backwards of add method 
	 * so beads are put in proper place)
	 */
	public void removeBead()
	{
		if(bead.size() == 1)
		{
			ifXagain = true;
			bead.remove(bead.size()-1);
		}
		else if(bead.size() == 0)
		{
			x = x1;
			y = y1;
		}
		else
		{
			bead.remove(bead.size() - 1);
			if(x > x1)
				x -= BEADSIZE + 2;
			else if(x != x1)
				y -= BEADSIZE + 2;
		}
	}
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	public Player getPlayer()
	{
		return p;
	}
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return height;
	}
	public Ellipse2D getShape()
	{
		return shape;
	}
	@Override
	public void stateChanged(ChangeEvent e) 
	{
	//probably didn't need this	
	}
	/**
	 * Checks to see if the ellipse contains the 
	 * clicked point)
	 * @param p - point
	 * @return true or false
	 */
	public boolean contains(Point2D p)
	{
		return shape.contains(p);
	}
	public int getBeadSize()
	{
		return bead.size();
	}
	public String toString()
	{
		return "Pit[bead size = " + bead.size() + ", Location =" + x +", " + y + "]";
	}
}
