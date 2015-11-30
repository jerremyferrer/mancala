package mancala;

import java.awt.geom.Ellipse2D;

public class StandardPit extends Pit {
	public StandardPit() {
		width = 70;
		height = 70;
		shape = new Ellipse2D.Float(0,0,width,height);
	}
}
