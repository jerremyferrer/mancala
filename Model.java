import java.awt.geom.Point2D;
import java.util.*;
/**
 * Model for the Mancalla game
 * @author Sydney Snyder, Jerremy Ferrer, Royce Florence Rocco
 *
 */
public class Model 
{
	private ArrayList<Pit> playerApits;
	private ArrayList<Pit> playerBpits;
	private ArrayList<Pit> allPits;
	private int initialBeadAmount;
	private Player playerA;
	private Player playerB;
	private Player current;
	/**
	 * Initiates the arrays for Player A and Player B
	 */
	public Model() 
	{
		playerA = new Player();
		playerB = new Player();
		current = playerA; 
		allPits = new ArrayList<Pit>();
		playerApits = new ArrayList<Pit>();
		playerBpits = new ArrayList<Pit>();
	}
	/**
	 * ALL BELOW METHODS ARE SO THAT THE CONTROLLER CAN ACCESS
	 * ONLY ONE MODEL IN TOTAL. WORK DIRECTLY THROUGH CONTROLLER
	 * IF YOU WORK THROUGH MODEL YOU END UP WITH MULTIPLE 
	 * DIFFERENT SETS OF DATA
	 */
	/**
	 * Sets the initial amount of beads
	 * @param beads - the inital bead amount
	 */
	public void setInitialBeadAmount(int beads) 
	{
		this.initialBeadAmount = beads;
	}
	/**
	 * Returns the initial amount of beads
	 * so that the board can be set up
	 * @return initalBeadAmount
	 */
	public int getBeadAmount()
	{
		return initialBeadAmount; //allows controller to access
	}
	/**
	 * Returns playerApits array
	 * @return playerApits
	 */
	public ArrayList<Pit> getPlayerAPits()
	{
		return playerApits;
	}
	/**
	 * Returns playerBpits array
	 * @return playerBpits
	 */
	public ArrayList<Pit> getPlayerBPits()
	{
		return playerBpits;
	}
	public Player getPlayerA()
	{
		return playerA;
	}
	public Player getPlayerB()
	{
		return playerB;
	}
	/**
	 * Adds pits to A pits
	 * @param p - pit to add
	 */
	public int addPitsA()
	{
		int j = 0;
		for(int i = 0; i < 6; i++)
		{
			j += allPits.get(i).getBeadSize();
		}
		return j;
	}
	/**
	 * Add pits to playerApits
	 * @param p
	 */
	public void addPitA(Pit p)
	{
		playerApits.add(p);
	}
	/**
	 * Add pits to playerBpits
	 * @param p
	 */
	public void addPitB(Pit p)
	{
		playerBpits.add(p);
	}
	/**
	 * Adds pits to B pits
	 * @param p - pit to add
	 */
	public int addPitsB()
	{
		int j = 0;
		for(int i = 7; i < 13; i++)
		{
			j += allPits.get(i).getBeadSize();
		}
		return j;
	}
	/**
	 * Add bead to pit inside the arraylist of all pits
	 * (The reason we need this is to ensure the arraylist
	 * item of pit is up to date on beads for each pit 
	 * within the arraylist)
	 * @param p - pit
	 */
	public void addBead(Pit p)
	{
		findPit(p).addBead();
	}
	/**
	 * Remove bead. (follow above explanation)
	 * @param p - pit
	 */
	public void removeBead(Pit p)
	{
		findPit(p).removeBead();
	}
	/**
	 * Returns a pit found in the allPits array
	 * @param p - pit
	 * @return q - the pit found
	 */
	public Pit findPit(Pit p)
	{
		Pit q = null;
		for(int i = 0; i < allPits.size(); i++)
		{
			if(allPits.get(i).equals(p))
				q = allPits.get(i);
		}
		return q;
	}
	/**
	 * See if a specific pit contains the point
	 * (Need this to find where mouse click is 
	 * with the mouse listener)
	 * @param po - the point
	 * @param p - pit
	 * @return pit that contains po
	 */
	public boolean contains(Point2D po, Pit p)
	{
		return p.contains(po);
	}
	/**
	 * Returns the current player
	 * @return current player
	 */
	public Player getCurrentPlayer()
	{
		return current;
	}
	/**
	 * Returns all pits arraylist
	 * @return allPits
	 */
	public ArrayList<Pit> getAllPits()
	{
		return allPits;
	}
	/**
	 * Adds pit to all pits
	 * @param p - pit
	 */
	public void addPitAll(Pit p)
	{
		allPits.add(p);
	}
	/**
	 * Switches current to opposite player
	 */
	public void switchTurns()
	{
		if(current.equals(playerA))
			current = playerB;
		else
			current = playerA;
	}
	
}
