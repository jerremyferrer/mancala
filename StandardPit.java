

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JPanel;
/**
 * Creates Pit ellipse
 * @author Sydney Snyder, Jerremy Ferrer, & Royce Florence Rocco
 *
 */
public class StandardPit extends Pit 
{
	public StandardPit(Controller con) //need to be sure controller&model are same throughout code
	{
		c = con;
		width = 70;
		height = 70;
		x1 = 30;
		y1 = 10;
		x = 30;
		y = 10;
		shape = new Ellipse2D.Float(0, 0, width, height);
		bead = new ArrayList<Beads>();
	}
}
