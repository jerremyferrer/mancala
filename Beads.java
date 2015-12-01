package mancala;

import java.awt.Graphics2D;

public class Beads 
{
	private final int width = 5;
	private final int height = 5;
	private int i = 0;
	private int x = 5;
	private int y = 5;
	public Beads(int x1, int y1)
	{
		x = x1;
		y = y1;
	}
	public void draw(Graphics2D g2)
	{
		Ellipse2D bead = new Ellipse(x, y, width, height);
		//This next portion will probably have to be done in the pit
		//portion of our code or wherever a pit is created. 
		//Beads should ask to input x1 and y1 so it can vary from
		//pit to pit.
		i+=1;
		if(i%2 != 0)
			x += width;
		else
			y += height;
		g2.draw(Bead);
	}
}
