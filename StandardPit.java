package mancala;

import java.awt.geom.Ellipse2D;

public class StandardPit extends Pit 
{
	public StandardPit() 
	{
		width = 70;
		height = 70;
		shape = new Ellipse2D.Float(0, 0, width, height);
		bead = new ArrayList<Beads>();
		//if controller get bead amount picked = 4 then 
		//do addBead() 4 times else 3 times
	}
	/**
	 * Adds one new bead
	 */
	public void addBead()
	{
		bead.add(new beads);
	}
	/**
	 * Removes last bead
	 */
	public void removeBead()
	{
		bead.remove(bead.size());
	}
}
