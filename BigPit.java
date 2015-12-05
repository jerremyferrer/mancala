import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
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
		x1 = 20;
		y1 = 10;
		x = 20;
		y = 10;
		shape = new Ellipse2D.Float(0,0,width,height);
		bead = new ArrayList<Beads>();
	}
}
