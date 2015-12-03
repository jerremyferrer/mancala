import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class BigPit extends Pit 
{
	/**
	 * Initiates variables
	 */
	public BigPit() 
	{
		width = 70;
		height = 130;
		shape = new Ellipse2D.Float(0,0,width,height);
		bead = new ArrayList<Beads>();
	}
	/**
	 * Adds beads into paint
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
