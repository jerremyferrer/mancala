package mancala;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.Icon;

public class Pit implements Icon {
	private Ellipse2D shape;
	private int height;
	private int width;

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		// TODO Complete third line
		Graphics2D g2 = (Graphics2D) g;
		g2.draw(new Ellipse2D.Double(x, y, width, height));
		//Bead.draw........ 
	}
	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return height;
	}
}
