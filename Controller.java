import java.util.*;
/**
 * Controller of Mancalla game
 * @author Sydney Snyder
 *
 */
public class Controller 
{
	private Model m;
	/**
	 * Initiate model
	 */
	public Controller()
	{
		m = new Model();
	}
	/**
	 * Set amount of beads
	 * @param beads - amount to add
	 */
	public void setInitialBeadAmount(int beads)
	{
		m.setInitialBeadAmount(beads);
	}
	/**
	 * Get amount of beads
	 * @return Amount of beads
	 */
	public int getBeadAmount()
	{
		return m.getBeadAmount();
	}
	/**
	 * Get pits for Player A
	 * @return Player A pits
	 */
	public ArrayList<Pit> getPlayerA()
	{
		return m.getPlayerA();
	}
	/**
	 * Get pits for Player B
	 * @return Player B pits
	 */
	public ArrayList<Pit> getPlayerB()
	{
		return m.getPlayerB();
	}
	/**
	 * Adds pits to A pits
	 * @param p - pit to add
	 */
	public void addPitsA(Pit p)
	{
		m.addPitsA(p);
	}
	/**
	 * Adds pits to B pits
	 * @param p - pit to add
	 */
	public void addPitsB(Pit p)
	{
		m.addPitsB(p);
	}
	/**
	 * Find a specific pit in Player A pits
	 * @param p - the pit
	 * @return boolean (whether or not Player A has this pit)
	 */
	public boolean findPitA(Pit p)
	{
		return m.findPitA(p);
	}
	/**
	 * Find a specific pit in Player B pits
	 * @param p - the pit
	 * @return boolean (whether or not Player B has this pit)
	 */
	public boolean findPitB(Pit p)
	{
		return m.findPitB(p);
	}
	/**
	 * Returns the current player whose turn it is
	 * @return - the current player
	 */
	public Player getCurrentPlayer()
	{
		return m.getCurrentPlayer();
	}
	/**
	 * Switches player's turns
	 */
	public void switchTurns()
	{
		m.switchTurns();
	}
}
