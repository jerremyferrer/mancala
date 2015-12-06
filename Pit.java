
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
public abstract class Pit implements Icon 
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
	 * Returns icon width
	 * @return width
	 */
	public int getIconWidth()
	{
		return width;
	}
	/**
	 * Returns icon height
	 * @return height
	 */
	public int getIconHeight()
	{
		return height;
	}
	/**
	 * Adds bead and updates x
	 * (x is updated so that beads 
	 * are put in the proper place inside
	 * the pit)
	 */
	public void addBead()
	{
		bead.add(new Beads(x,y));
		if(x < width - x1 + 10) //these numbers are chosen so that the beads don't fall out of the panel
		{
			x += BEADSIZE+2;//bead width + a 2 pixel gap between beads
		}
		else
		{
			y += BEADSIZE+2;//bead height + a 2 pixel gap between beads
			x = x1;//the original x
		}
	}
	/**
	 * Removes last bead
	 * (x is updated backwards of add method 
	 * so beads are put in proper place)
	 */
	public void removeBead()
	{
		if(bead.size() != 0)
		{
			Beads b = bead.get(bead.size() - 1);//get last bead
			x = b.getX();//since we are removing the last bead we make x&y for the next bead
			y = b.getY();//to be the bead we removes x & y so that it will take its place
			bead.remove(bead.size() - 1);//remove last bead
		}
		else
		{
			x = x1; y = y1;//x and y stay how they were originally if there are no beads
		}
	}
	/**
	 * Returns amount of beads in pit
	 * @return beads in pit
	 */
	public int getBeadSize()
	{
		return bead.size();
	}
}
