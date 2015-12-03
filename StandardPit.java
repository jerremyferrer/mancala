

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JPanel;
/**
 * Creates Pit ellipse
 * @author Sydney Snyder, Jerremy Ferrer
 *
 */
public class StandardPit extends Pit 
{
	public StandardPit(Controller con) 
	{
		c = con;
		width = 70;
		height = 70;
		x = 30;
		y = 30;
		shape = new Ellipse2D.Float(0, 0, width, height);
		bead = new ArrayList<Beads>();
	}
	public void addInitialBeads()
	{
		int j = 0;
		while(j < c.getBeadAmount())
		{
			this.addBead();
			j++;
		}
	}
	/**
	 * Paints Pit with beads inside
	 */
	public void paintIcon(Component c, Graphics g, int x, int y) 
	{
		super.paintIcon(c, g, x, y);
		for(int k = 0; k < bead.size(); k++)
		{
			bead.get(k).draw((Graphics2D) g);
		}
	}
}
