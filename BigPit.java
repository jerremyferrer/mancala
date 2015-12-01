package mancala;

import java.awt.geom.Ellipse2D;

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
	 * Adds a new bead to the pit
	 */
	public void addBead()
	{
			bead.add(new bead);
	}
	/**
	 * Removes last bead from pit
	 */
	public void removeBead()
	{
		bead.remove(bead.size());
	}
}
