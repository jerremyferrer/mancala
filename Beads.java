import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;
/**
 * Establishes beads for Mancala game
 * @author Sydney Snyder, Jerremy Ferrer, & Royce Florence Rocco
 *
 */
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
		g2.fill(bead);
		g2.draw(bead);
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
}
