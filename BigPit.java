package mancala;

import java.awt.geom.Ellipse2D;

public class BigPit extends Pit {
	public BigPit() {
		width = 70;
		height = 130;
		shape = new Ellipse2D.Float(0,0,width,height);
	}
}
