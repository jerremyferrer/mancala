import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class Beads extends JComponent
{
	private final int width = 10;
	private final int height = 10;
	private int x;
	private int y;
	private Ellipse2D bead;
	public Beads(int x1, int y1)
	{
		x = x1;
		y = y1;
		bead = new Ellipse2D.Float(x,y,width,height);
	}
	public void draw(Graphics2D g2)
	{
		g2.draw(bead);
	}
}
