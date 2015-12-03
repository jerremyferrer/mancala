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
		current = playerA;
		playerApits = new ArrayList<Pit>();
		playerBpits = new ArrayList<Pit>();
	}
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
	public void addPitsA(Pit p)
	{
		playerApits.add(p);
	}
	/**
	 * Adds pits to B pits
	 * @param p - pit to add
	 */
	public void addPitsB(Pit p)
	{
		playerBpits.add(p);
	}
	/**
	 * Sees if Player A pits contain a specific pit
	 * @param p - the pit
	 * @return boolean true or false
	 */
	public boolean findPitA(Pit p)
	{
		if(playerApits.contains(p))
			return true;
		else
			return false;
	}
	/**
	 * Sees if Player B pits contain a specific pit
	 * @param p - the pit
	 * @return boolean true or false
	 */
	public boolean findPitB(Pit p)
	{
		if(playerBpits.contains(p))
			return true;
		else
			return false;
	}
	/**
	 * Returns the current player
	 * @return current player
	 */
	public Player getCurrentPlayer()
	{
		return current;
	}
	public ArrayList<Pit> getAllPits()
	{
		return allPits;
	}
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
